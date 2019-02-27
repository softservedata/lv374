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

public class ShoppingCartPagePriceTest extends TestRunnerVoluikevych {

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {{
                ProductRepository.getIPhone(),
                ProductRepository.getMacBook(),
                Currencies.EURO
        }};
    }

    @Test(dataProvider = "dataProvider")
    public void convertUSDToEURO(Product iphone, Product macBook, Currencies currency) {
        ShoppingCartPage shop = loadApplication()
                .addToShoppingCart(iphone.getName())
                .refresh()
                .addToShoppingCart(macBook.getName())
                .refresh()
                .gotoShoppingCart();
        BigDecimal euro = shop.gotoShoppingCart().getTotalProductPriceByCurrency(currency, macBook);
        Assert.assertEquals(euro, AccidentalUtils.getExpectedEURO(macBook.getPriceDollar()));
    }

}
