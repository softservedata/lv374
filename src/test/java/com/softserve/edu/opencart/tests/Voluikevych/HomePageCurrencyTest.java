package com.softserve.edu.opencart.tests.Voluikevych;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.tools.PriceUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class HomePageCurrencyTest extends TestRunnerVoluikevych {

    @DataProvider
    public Object[][] homePageEuro() {
        return new Object[][] {{
                ProductRepository.getIPhone(),
                Currencies.EURO,
                "€"
        }};
    }

    @Test(dataProvider = "homePageEuro")
    public void changeCurrencyToEURO(Product product, Currencies currency, String currencySymbol){
        String actualCurrency = loadApplication()
                .chooseCurrency(currency)
                .getHomePageCurrencySymbol(product);
        Assert.assertEquals(actualCurrency,currencySymbol, "Currency not equals");
    }

    @DataProvider
    public Object[][] homePagePound() {
        return new Object[][] {{
                ProductRepository.getIPhone(),
                Currencies.POUND_STERLING,
                "£"
        }};
    }

    @Test(dataProvider = "homePagePound")
    public void changeCurrencyToPound(Product product, Currencies currency, String currencySymbol){
        String actualCurrency = loadApplication()
                .chooseCurrency(currency)
                .getHomePageCurrencySymbol(product);
        Assert.assertEquals(actualCurrency,currencySymbol, "Currency not equals");
    }

    @Test(dataProvider = "homePageEuro")
    public void homePageConvertPriceToEuro(Product iphone, Currencies currency, String str){
        BigDecimal euro = loadApplication()
                .chooseCurrency(currency)
                .getProductComponentsContainer()
                .getProductComponentPriceByProduct(iphone);
        Assert.assertEquals(euro, PriceUtils.getExpectedEURO(iphone.getPriceDollar()));
    }

    @Test(dataProvider = "homePagePound")
    public void homePageConvertPriceToPound(Product iphone, Currencies currency, String str){
        BigDecimal pound = loadApplication()
                .chooseCurrency(currency)
                .getProductComponentsContainer()
                .getProductComponentPriceByProduct(iphone);
        Assert.assertEquals(pound, PriceUtils.getExpectedPOUND(iphone.getPriceDollar()));
    }

}
