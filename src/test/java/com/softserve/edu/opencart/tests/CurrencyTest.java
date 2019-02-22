package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Price;
import com.softserve.edu.opencart.pages.shop.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CurrencyTest extends TestRunner {

    @Test
    public void convertUSDToEURO() throws InterruptedException {
        ShoppingCartPage shop = loadApplication().addToShoppingCart("MacBook").refresh().addToShoppingCart("iPhone").refresh().gotoShoppingCart();
        BigDecimal usd = shop.getTotalPrice(Currencies.US_DOLLAR, "iPhone");
        BigDecimal euro = shop.gotoShoppingCart().getTotalPrice(Currencies.EURO, "iPhone");
        Assert.assertEquals(euro, Price.getExpectedEURO(usd));
    }

}
