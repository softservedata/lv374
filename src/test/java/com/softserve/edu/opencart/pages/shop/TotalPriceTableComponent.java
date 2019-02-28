package com.softserve.edu.opencart.pages.shop;

import com.softserve.edu.opencart.tools.PriceUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

public class TotalPriceTableComponent {

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

    public BigDecimal getTableSubTotalPrice(){
        return PriceUtils.getPrice(getTableSubTotalText());
    }

    public BigDecimal getTableEcoTaxPrice(){
        return PriceUtils.getPrice(getTableEcoTaxText());
    }

    public BigDecimal getTableVATPrice(){
        return PriceUtils.getPrice(getTableVATText());
    }

    public BigDecimal getTableTotalPrice(){
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

    public String getTableTotalSymbol(){
        return PriceUtils.getCurrencySymbol(getTableTotalText());
    }

}
