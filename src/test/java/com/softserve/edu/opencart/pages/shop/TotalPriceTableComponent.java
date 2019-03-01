package com.softserve.edu.opencart.pages.shop;

import com.softserve.edu.opencart.tools.PriceUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class TotalPriceTableComponent {

    public static final Logger logger = LoggerFactory.getLogger(TotalPriceTableComponent.class);

    WebElement totalTable;


    public TotalPriceTableComponent(WebElement totalTable){
        this.totalTable = totalTable;
    }

    private WebElement getTableSubTotal(){
        return totalTable.findElement(By.cssSelector("tr:first-child>td+td"));
    }

    private WebElement getTableEcoTax(){
        return totalTable.findElement(By.cssSelector("tr:first-child+tr>td+td"));
    }

    private WebElement getTableVAT(){
        return totalTable.findElement(By.cssSelector("tr:first-child+tr+tr>td+td"));
    }

    private WebElement getTableTotal(){
        return totalTable.findElement(By.cssSelector("tr:last-child>td+td"));
    }

    private String getTableSubTotalText(){
        return getTableSubTotal().getText();
    }

    private String getTableEcoTaxText(){
        return getTableEcoTax().getText();
    }

    private String getTableVATText(){
        return getTableVAT().getText();
    }

    private String getTableTotalText(){
        return getTableTotal().getText();
    }

    /**
     * Get Sub-Total price from table with total price information
     * @return total price
     */
    public BigDecimal getTableSubTotalPrice(){
        return PriceUtils.getPrice(getTableSubTotalText());
    }

    /**
     * Get Eco-Tax price from table with total price information
     * @return total price
     */
    public BigDecimal getTableEcoTaxPrice(){
        return PriceUtils.getPrice(getTableEcoTaxText());
    }

    /**
     * Get VAT price from table with total price information
     * @return total price
     */
    public BigDecimal getTableVATPrice(){
        return PriceUtils.getPrice(getTableVATText());
    }

    /**
     * Get total price from table with total price information
     * @return total price
     */
    @Step("Get Total Price")
    public BigDecimal getTableTotalPrice(){
        logger.info("Total price = "+PriceUtils.getPrice(getTableTotalText()));
        return PriceUtils.getPrice(getTableTotalText());
    }

    public String getTableSubTotalSymbol(){
        return PriceUtils.getCurrencySymbol(getTableSubTotalText());
    }

    public String getTableEcoTaxSymbol(){
        return PriceUtils.getCurrencySymbol(getTableEcoTaxText());
    }

    public String getTableVATSymbol(){
        return PriceUtils.getCurrencySymbol(getTableVATText());
    }

    /**
     * Get currency symbol from table with total price information
     * @return currency symbol
     */
    @Step("Get currency symbol")
    public String getTableTotalSymbol(){
        return PriceUtils.getCurrencySymbol(getTableTotalText());
    }

}
