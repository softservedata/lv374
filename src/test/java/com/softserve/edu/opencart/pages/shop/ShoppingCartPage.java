package com.softserve.edu.opencart.pages.shop;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.common.NavigationUnit;
import io.qameta.allure.Step;
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

    /**
     * Set products quantity in shopping cart
     * @param product
     * @param quantity
     * @return
     */
    public ShoppingCartPage setQuantityProductsByName(Product product, String quantity){
        getShoppingCartProductsContainer().quantityProductsByName(product, quantity);
        return new ShoppingCartPage(driver);
    }

    /**
     * Remove product from shopping cart
     * @param product
     * @return
     */
    public ShoppingCartPage removeProductByName(Product product){
        getShoppingCartProductsContainer().removeProductFromShoppingCartByName(product);
        return new ShoppingCartPage(driver);
    }

    /**
     * Change currency for USD, EURO or POUND STERLING
     * @param currency
     * @return
     */
    public ShoppingCartPage chooseCurrency(Currencies currency){
        clickCurrencyByPartialName(currency);
        return new ShoppingCartPage(driver);
    }

    /**
     * Change currency and get unit product price
     * @param currency
     * @param product
     * @return
     */
    public BigDecimal getUnitProductPriceByCurrency(Currencies currency, Product product){
       return chooseCurrency(currency).getShoppingCartProductsContainer().getUnitPriceByName(product);
    }

    /**
     * Change currency and get total product price
     * @param currency
     * @param product
     * @return
     */
    @Step("Get total product price")
    public BigDecimal getTotalProductPriceByCurrency(Currencies currency, Product product){
        return chooseCurrency(currency).getShoppingCartProductsContainer().getTotalPriceByName(product);
    }

    /**
     * Get currency symbol from product price
     * @param product
     * @return
     */
    public String getShoppingCartCurrencySymbol(Product product){
        return getShoppingCartProductsContainer().getCurrencyByProduct(product);
    }

    /**
     * Search table with total price information
     * @return
     */
    public TotalPriceTableComponent getTotalPriceTableComponent(){
        return new TotalPriceTableComponent(driver.findElement(By.cssSelector(PRICE_TABLE_CSSSELECTOR)));
    }

    /**
     * Change currency and get Sub-Total price from table with total price information
     * @param currency
     * @return
     */
    public BigDecimal getTableSubTotalByCurrency(Currencies currency){
        return chooseCurrency(currency).getTotalPriceTableComponent().getTableSubTotalPrice();
    }

    /**
     * Change currency and get Eco Tax price from table with total price information
     * @param currency
     * @return
     */
    public BigDecimal getTableEcoTaxByCurrency(Currencies currency){
        return chooseCurrency(currency).getTotalPriceTableComponent().getTableEcoTaxPrice();
    }

    /**
     * Change currency and get VAT price from table with total price information
     * @param currency
     * @return
     */
    public BigDecimal getTableVATByCurrency(Currencies currency){
        return chooseCurrency(currency).getTotalPriceTableComponent().getTableVATPrice();
    }

    /**
     * Change currency and get Total price from table with total price information
     * @param currency
     * @return
     */
    @Step("Get Total Price")
    public BigDecimal getTableTotalByCurrency(Currencies currency){
        return chooseCurrency(currency).getTotalPriceTableComponent().getTableTotalPrice();
    }

}
