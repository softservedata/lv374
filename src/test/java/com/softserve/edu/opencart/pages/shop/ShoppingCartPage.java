package com.softserve.edu.opencart.pages.shop;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
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

    public BigDecimal getUnitPriceByCurrency(Currencies currency, Product product){
       return chooseCurrency(currency).getShoppingCartProductsContainer().getUnitPriceByName(product);
    }

    public BigDecimal getTotalPriceByCurrency(Currencies currency, Product product){
        return chooseCurrency(currency).getShoppingCartProductsContainer().getTotalPriceByName(product);
    }

}
