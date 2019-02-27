package com.softserve.edu.opencart.pages.shop;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.common.NavigationUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public class ShoppingCartPage extends NavigationUnit {

    private static final String  PRICE_TABLE_CSSSELECTOR = (".col-sm-4.col-sm-offset-8 .table.table-bordered");

    private ShoppingCartProductsContainer shoppingCartProductsContainer;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        shoppingCartProductsContainer = new ShoppingCartProductsContainer(driver);
    }

    public ShoppingCartProductsContainer getShoppingCartProductsContainer(){
        return shoppingCartProductsContainer;
    }

    public ShoppingCartPage setQuantityProductsByName(Product product, String quantity){
        getShoppingCartProductsContainer().quantityProductsByName(product, quantity);
        return new ShoppingCartPage(driver);
    }

    public ShoppingCartPage removeProductByName(Product product){
        getShoppingCartProductsContainer().removeProductFromShoppingCartByName(product);
        return new ShoppingCartPage(driver);
    }

    public ShoppingCartPage chooseCurrency(Currencies currency){
        clickCurrencyByPartialName(currency);
        return new ShoppingCartPage(driver);
    }

    public BigDecimal getUnitProductPriceByCurrency(Currencies currency, Product product){
       return chooseCurrency(currency).getShoppingCartProductsContainer().getUnitPriceByName(product);
    }

    public BigDecimal getTotalProductPriceByCurrency(Currencies currency, Product product){
        return chooseCurrency(currency).getShoppingCartProductsContainer().getTotalPriceByName(product);
    }

    public String getShoppingCartCurrencySymbol(Product product){
        return getShoppingCartProductsContainer().getCurrencyByProduct(product);
    }

    public TotalPriceTableComponent getTotalPriceTableComponent(){
        return new TotalPriceTableComponent(driver.findElement(By.cssSelector(PRICE_TABLE_CSSSELECTOR)));
    }

    public BigDecimal getTableSubTotalByCurrency(Currencies currency){
        return chooseCurrency(currency).getTotalPriceTableComponent().getTableSubTotalPrice();
    }

    public BigDecimal getTableEcoTaxByCurrency(Currencies currency){
        return chooseCurrency(currency).getTotalPriceTableComponent().getTableEcoTaxPrice();
    }

    public BigDecimal getTableVATByCurrency(Currencies currency){
        return chooseCurrency(currency).getTotalPriceTableComponent().getTableVATPrice();
    }

    public BigDecimal getTableTotalByCurrency(Currencies currency){
        return chooseCurrency(currency).getTotalPriceTableComponent().getTableTotalPrice();
    }

}
