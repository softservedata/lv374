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

public class DropdownCartCurrencyTest extends TestRunnerVoluikevych {

    public static final Logger logger = LoggerFactory.getLogger(DropdownCartCurrencyTest.class);

    private static final boolean withTax = true;

    @DataProvider
    public Object[][] totalPriceEuro(){
        return new Object[][]{{
                ProductRepository.getIPhone(),
                ProductRepository.getMacBook(),
                Currencies.EURO,
                withTax
        }};
    }

    /**
     * This test checks if total price at dropdown cart convert correctly to chosen currency
     * Used technique: Use case testing
     * @param iphone
     * @param macBook
     * @param currency chosen currency
     * @param withTax is price displayed with tax (true/false)
     */
    @Description("Test Description: class DropdownCartCurrencyTest, totalPriceEuroTest")
    @Test(dataProvider = "totalPriceEuro")
    public void totalPriceEuroTest(Product iphone, Product macBook, Currencies currency, boolean withTax){
        logger.info("totalPriceEuroTest START");
        BigDecimal actual = loadApplication()
                .addToShoppingCart(macBook)
                .refresh()
                .addToShoppingCart(iphone)
                .chooseCurrency(currency)
                .openDropdownCart()
                .getTotalPriceTableComponent()
                .getTableTotalPrice();
        BigDecimal expected = (PriceUtils.getExpectedEURO(iphone.getPriceDollar(),withTax))
                .add(PriceUtils.getExpectedEURO(macBook.getPriceDollar(),withTax));
        Assert.assertEquals(actual,expected);
        logger.info("totalPriceEuroTest DONE");
    }

}
