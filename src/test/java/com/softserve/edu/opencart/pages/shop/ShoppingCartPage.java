package com.softserve.edu.opencart.pages.shop;

import com.softserve.edu.opencart.pages.common.NavigationUnit;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends NavigationUnit {

    private ShoppingCartProductsContainer shoppingCartProductsContainer;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        shoppingCartProductsContainer = new ShoppingCartProductsContainer(driver);
    }

    public ShoppingCartProductsContainer getShoppingCartProductsContainer(){
        return shoppingCartProductsContainer;
    }


}
