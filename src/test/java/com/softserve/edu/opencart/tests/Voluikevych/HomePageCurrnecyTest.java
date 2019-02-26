package com.softserve.edu.opencart.tests.Voluikevych;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageCurrnecyTest extends TestRunnerVoluikevych {

    @DataProvider
    public Object[][] euro() {
        return new Object[][] {{
                ProductRepository.getIPhone(),
                Currencies.EURO
        }};
    }

    @Test(dataProvider = "euro")
    public void changeCurrencyToEURO(Product product, Currencies currency){
        String actualCurrency = loadApplication()
                .chooseCurrency(currency)
                .getProductComponentsContainer()
                .getCurrencyByProduct(product);
        Assert.assertEquals(actualCurrency,"€", "Currency not equals");
    }

    @DataProvider
    public Object[][] pound() {
        return new Object[][] {{
                ProductRepository.getIPhone(),
                Currencies.POUND_STERLING
        }};
    }

    @Test(dataProvider = "pound")
    public void changeCurrencyToPound(Product product, Currencies currency){
        String actualCurrency = loadApplication()
                .chooseCurrency(currency)
                .getProductComponentsContainer()
                .getCurrencyByProduct(product);
        Assert.assertEquals(actualCurrency,"£", "Currency not equals");
    }

}
