package com.softserve.edu.opencart.pages.shop;

import com.softserve.edu.opencart.data.Price;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
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
        System.out.println(productComponents);
    }

    // Page Object

    // productComponents
    public List<ShopingCartProductComponent> getShoppingCartComponents() {
        return productComponents;
    }

    // Functional

    // productComponents
    public ShopingCartProductComponent getShoppingCartComponentByName(String productName){
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

    public BigDecimal getUnitPriceByName(String productName){
        return Price.getPrice(getShoppingCartComponentByName(productName).getUnitPriceText());
    }

    public BigDecimal getTotalPriceByName(String productName){
        return Price.getPrice(getShoppingCartComponentByName(productName).getTotalPriceText());
    }

    public String getModelByName(String productName){
        return getShoppingCartComponentByName(productName).getProductModelText();
    }

    public void quantityProductsByName(String productName, String quantity){
        getShoppingCartComponentByName(productName).setQuantity(quantity);
    }

    public void removeProductFromShoppingCartByName(String productName){
        getShoppingCartComponentByName(productName).clickRemoveFromShoppingCartButton();
    }


}
