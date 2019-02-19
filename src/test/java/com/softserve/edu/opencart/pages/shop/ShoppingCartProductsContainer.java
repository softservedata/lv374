package com.softserve.edu.opencart.pages.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartProductsContainer {
    private static final String PRODUCT_COMPONENT_CSSSELECTOR = ".table-responsive>.table.table-bordered>tbody>tr";

    protected WebDriver driver;
    //
    private List<ShopingCartProductComponent> productComponents;

    public ShoppingCartProductsContainer(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        productComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(PRODUCT_COMPONENT_CSSSELECTOR))) {
            productComponents.add(new ShopingCartProductComponent(current));
        }
    }

    // Page Object

    // productComponents
    public List<ShopingCartProductComponent> getShoppingCartComponents() {
        return productComponents;
    }

    // Functional

    // productComponents
    public ShopingCartProductComponent getShoppingCartComponentByName(String productName) {
        ShopingCartProductComponent result = null;
        for (ShopingCartProductComponent current : getShoppingCartComponents()) {
            if (current.getProductNameText().toLowerCase()
                    .equals(productName.toLowerCase())) {
                result = current;
            }
        }
        if (result == null) {
            // TODO Develop Custom Exception
            throw new RuntimeException("ProductName: " + productName + " not Found.");
        }
        return result;
    }

    public String getUnitPriceByName(String productName) {
        return getShoppingCartComponentByName(productName).getUnitPriceText();
    }

    public String getTotalPriceByName(String productName) {
        return getShoppingCartComponentByName(productName).getTotalPriceText();
    }

    public String getModelByName(String productName) {
        return getShoppingCartComponentByName(productName).getProductModelText();
    }

    private void quantityProductsByName(String productName, String quantity){
        getShoppingCartComponentByName(productName).setQuantity(quantity);
    }

    private void removeProductFromShoppingCartByName(String productName){
        getShoppingCartComponentByName(productName).clickRemoveFromShoppingCartButton();
    }

    public ShoppingCartPage setQuantityProductsByName(String productName, String quantity){
        quantityProductsByName(productName,quantity);
        return new ShoppingCartPage(driver);
    }

    public ShoppingCartPage removeProductByName(String productName){
        removeProductFromShoppingCartByName(productName);
        return new ShoppingCartPage(driver);
    }

}
