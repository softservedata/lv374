package com.softserve.edu.opencart.pages.shop;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.pages.common.NavigationUnit;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public class ShoppingCartPage extends NavigationUnit {

    private ShoppingCartProductsContainer shoppingCartProductsContainer;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        shoppingCartProductsContainer = new ShoppingCartProductsContainer(driver);
    }

    public ShoppingCartProductsContainer getShoppingCartProductsContainer(){
        return shoppingCartProductsContainer;
    }

    public ShoppingCartPage setQuantityProductsByName(String productName, String quantity){
        getShoppingCartProductsContainer().quantityProductsByName(productName, quantity);
        return new ShoppingCartPage(driver);
    }

    public ShoppingCartPage removeProductByName(String productName){
        getShoppingCartProductsContainer().removeProductFromShoppingCartByName(productName);
        return new ShoppingCartPage(driver);
    }

    public ShoppingCartPage chooseCurrency(Currencies currency){
        clickCurrencyByPartialName(currency);
        return new ShoppingCartPage(driver);
    }

    public BigDecimal getUnitPrice(Currencies currency, String productName){
       return chooseCurrency(currency).getShoppingCartProductsContainer().getUnitPriceByName(productName);
    }

    public BigDecimal getTotalPrice(Currencies currency, String productName){
        return chooseCurrency(currency).getShoppingCartProductsContainer().getTotalPriceByName(productName);
    }

}
