package com.softserve.edu.opencart.tests.Voluikevych;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.tools.PriceUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class SearchPagePriceTest extends TestRunnerVoluikevych{

    @DataProvider
    public Object[][] searchPagePound(){
        return new Object[][]{{
                ProductRepository.getMacBook().getSearchText(),
                ProductRepository.getMacBookPro(),
                Currencies.POUND_STERLING
        }};
    }

    @Test(dataProvider = "searchPagePound")
    public void searchPagePoundTest(String searchText, Product macBookPro, Currencies pound){
        BigDecimal actual = loadApplication()
                .successfulSearch(searchText)
                .getPrice(pound, macBookPro);
        Assert.assertEquals(actual, PriceUtils.getExpectedPOUND(macBookPro.getPriceDollar()));
    }
}
