package com.softserve.edu.opencart.tests.Voluikevych;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.tools.PriceUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class DropdownCartCurrencyTest extends TestRunnerVoluikevych {

    @DataProvider
    public Object[][] totalPriceEuro(){
        return new Object[][]{{
                ProductRepository.getIPhone(),
                ProductRepository.getMacBook(),
                Currencies.EURO
        }};
    }

    @Test(dataProvider = "totalPriceEuro")
    public void totalPriceEuroTest(Product iphone, Product macBook, Currencies currency){
        BigDecimal actual = loadApplication()
                .addToShoppingCart(macBook)
                .addToShoppingCart(iphone)
                .chooseCurrency(currency)
                .openDropdownCart()
                .getTotalPriceTableComponent()
                .getTableTotalPrice();
        BigDecimal expected = PriceUtils.getExpectedEURO(iphone.getPriceDollar().add(macBook.getPriceDollar()));
        Assert.assertEquals(actual,expected);
    }

}
