package com.softserve.edu.opencart.tests.Voluikevych;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.shop.ShoppingCartPage;
import com.softserve.edu.opencart.tools.AccidentalUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class TotalPriceTableTest extends TestRunnerVoluikevych {

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {{
                ProductRepository.getIPhone(),
                ProductRepository.getMacBook(),
                Currencies.EURO,
                Currencies.US_DOLLAR
        }};
    }

    @Test(dataProvider = "dataProvider")
    public void totalPriceTest(Product iphone, Product macBook, Currencies euro, Currencies usd){
        ShoppingCartPage shoppingCartPage = loadApplication()
                .addToShoppingCart(iphone.getName())
                .refresh()
                .addToShoppingCart(macBook.getName())
                .refresh()
                .gotoShoppingCart();
        BigDecimal totalUSD = shoppingCartPage.getTableTotalByCurrency(usd);
        BigDecimal totalEuro = shoppingCartPage.gotoShoppingCart().getTableTotalByCurrency(euro);
        Assert.assertEquals(totalEuro, AccidentalUtils.getExpectedEURO(totalUSD));
    }
}
