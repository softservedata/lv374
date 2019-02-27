package com.softserve.edu.opencart.tests.Voluikevych;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.shop.ShoppingCartPage;
import com.softserve.edu.opencart.tools.PriceUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class TotalPriceTableTest extends TestRunnerVoluikevych {

    @DataProvider
    public Object[][] totalPrice() {
        return new Object[][] {{
                Currencies.EURO,
                Currencies.US_DOLLAR
        }};
    }

    @Test(dataProvider = "totalPrice")
    public void totalPriceTest(Currencies euro, Currencies usd){
        ShoppingCartPage shoppingCartPage = loadApplication()
                .gotoShoppingCart();
        BigDecimal totalUSD = shoppingCartPage.getTableTotalByCurrency(usd);
        BigDecimal totalEuro = shoppingCartPage.gotoShoppingCart().getTableTotalByCurrency(euro);
        Assert.assertEquals(totalEuro, PriceUtils.getExpectedEURO(totalUSD));
    }

    @DataProvider
    public Object[][] euroSymbolTotalPrice(){
        return new Object[][] {{
                ProductRepository.getIPhone(),
                ProductRepository.getMacBook(),
                Currencies.EURO,
                "€"
        }};
    }

    @Test(dataProvider = "euroSymbolTotalPrice")
    public void checkTableEuroSymbol(Product iphone, Product macBook, Currencies currency, String currencySymbol){
        String symbol = loadApplication()
                .addToShoppingCart(iphone)
                .addToShoppingCart(macBook)
                .gotoShoppingCart()
                .chooseCurrency(currency)
                .getTotalPriceTableComponent()
                .getTableTotalSymbol();
        Assert.assertEquals(symbol,currencySymbol,"Currency is not equals");
    }
}
