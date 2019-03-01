package com.softserve.edu.opencart.tests.Voluikevych;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.pages.shop.HomePage;
import com.softserve.edu.opencart.tools.PriceUtils;
import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class SearchPagePriceTest extends TestRunnerVoluikevych{

    public static final Logger logger = LoggerFactory.getLogger(SearchPagePriceTest.class);

    private static final boolean withTax = true;

    @DataProvider
    public Object[][] searchPagePound(){
        return new Object[][]{{
                ProductRepository.getMacBook().getSearchText(),
                ProductRepository.getMacBookAir(),
                Currencies.POUND_STERLING,
                withTax
        }};
    }

    /**
     * This test checks if product price convert correctly to Pound Sterling at Search Page
     * Used technique: Use case testing
     * @param searchText
     * @param macBookAir
     * @param pound
     * @param withTax
     */
    @Description("Test Description: class SearchPagePriceTest, searchPagePoundTest")
    @Test(dataProvider = "searchPagePound")
    public void searchPagePoundTest(String searchText, Product macBookAir, Currencies pound, boolean withTax){
        logger.info("searchPagePoundTest START");
        BigDecimal actual = loadApplication()
                .successfulSearch(searchText)
                .getPrice(pound, macBookAir);
        Assert.assertEquals(actual, PriceUtils.getExpectedPOUND(macBookAir.getPriceDollar(),withTax));
        logger.info("searchPagePoundTest DONE");
    }
}
