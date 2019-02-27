package com.softserve.edu.opencart.pages.shop;

import com.softserve.edu.opencart.tools.AccidentalUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

public class TotalPriceTableComponent {

    WebElement totalTable;


    public TotalPriceTableComponent(WebElement totalTable){
        this.totalTable = totalTable;
    }

    public WebElement getTableSubTotal(){
        return totalTable.findElement(By.cssSelector("tr:first-child>td+td"));
    }

    public WebElement getTableEcoTax(){
        return totalTable.findElement(By.cssSelector("tr:first-child+tr>td+td"));
    }

    public WebElement getTableVAT(){
        return totalTable.findElement(By.cssSelector("tr:first-child+tr+tr>td+td"));
    }

    public WebElement getTableTotal(){
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
        return AccidentalUtils.getPrice(getTableSubTotalText());
    }

    public BigDecimal getTableEcoTaxPrice(){
        return AccidentalUtils.getPrice(getTableEcoTaxText());
    }

    public BigDecimal getTableVATPrice(){
        return AccidentalUtils.getPrice(getTableVATText());
    }

    public BigDecimal getTablTotalPrice(){
        return AccidentalUtils.getPrice(getTableTotalText());
    }

}
