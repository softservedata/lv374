package com.softserve.edu.opencart.pages.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.common.NavigationUnit;

public abstract class SearchUnit extends NavigationUnit {

	private WebElement searchLabel;
	private WebElement inputSearchField;
	private Select selectCategory;
	private WebElement subcategoriesSearchCheckBox;
	private WebElement productDescriptionsSearchCheckBox;
	private WebElement inputSearchButton;

	public SearchUnit(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		searchLabel = driver.findElement(By.cssSelector("#content h1"));
		inputSearchField = driver.findElement(By.id("input-search"));
		selectCategory = new Select(driver.findElement(By.name("category_id")));
		subcategoriesSearchCheckBox = driver.findElement(By.name("sub_category"));
		productDescriptionsSearchCheckBox = driver.findElement(By.name("description"));
		inputSearchButton = driver.findElement(By.id("button-search"));
	}

	// Page Object

	// searchLabel
	public WebElement getSearchLabel() {
		return searchLabel;
	}

	public String getSearchLabelText() {
		return getSearchLabel().getText();
	}

	// inputSearchField
	public WebElement getInputSearchField() {
		return inputSearchField;
	}

	public String getInputSearchFieldText() {
		return getInputSearchField().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void setInputSearchFieldField(String text) {
		getInputSearchField().sendKeys(text);
	}

	public void clearInputSearchField() {
		getInputSearchField().clear();
	}

	public void clickInputSearchField() {
		getInputSearchField().click();
	}

	// selectCategory
	public Select getSelectCategory() {
		return selectCategory;
	}

	public WebElement getSelectCategoryAsWebElement() {
		return getSelectCategory().getWrappedElement();
	}

	public WebElement getSelectCategorySelected() {
		return getSelectCategory().getFirstSelectedOption();
	}

	public String getSelectCategorySelectedText() {
		return getSelectCategorySelected().getText().trim();
	}

	public void setSelectCategoryField(String text) {
		getSelectCategory().selectByVisibleText(text);
	}

	public void clickSelectCategory() {
		getSelectCategoryAsWebElement().click();
	}

	// subcategoriesSearchCheckBox
	public WebElement getSubcategoriesSearchCheckBox() {
		return subcategoriesSearchCheckBox;
	}

	public boolean isSubcategoriesSearchCheckBoxChecked() {
		return getSubcategoriesSearchCheckBox().isSelected();
	}

	public boolean isSubcategoriesSearchCheckBoxClicable() {
		return getSubcategoriesSearchCheckBox().isEnabled()
			 && getSubcategoriesSearchCheckBox().isDisplayed();
	}

	public void clickSubcategoriesSearchCheckBox() {
		if (isSubcategoriesSearchCheckBoxClicable()) {
			getSubcategoriesSearchCheckBox().click();
		} else {
			// TODO Develop Custom Exception
			throw new RuntimeException("Element SubcategoriesSearchCheckBox not Clicable");
		}
	}

	// productDescriptionsSearchCheckBox
	public WebElement getProductDescriptionsSearchCheckBox() {
		return productDescriptionsSearchCheckBox;
	}

	public boolean isProductDescriptionsSearchCheckBoxChecked() {
		return getProductDescriptionsSearchCheckBox().isSelected();
	}

	public void clickProductDescriptionsSearchCheckBox() {
		getProductDescriptionsSearchCheckBox().click();
	}

	// inputSearchButton
	public WebElement getInputSearchButton() {
		return inputSearchButton;
	}

	public String getInputSearchButtonText() {
		return getInputSearchButton().getAttribute(TAG_ATTRIBUTE_VALUE);
	}

	public void clickInputSearchButton() {
		getInputSearchButton().click();
	}

	// Functional

	// subcategoriesSearchCheckBox
	public void setSubcategoriesSearchCheckBoxAsChecked() {
		if (!isSubcategoriesSearchCheckBoxChecked()) {
			clickSubcategoriesSearchCheckBox();
		}
	}

	public void setSubcategoriesSearchCheckBoxAsUnchecked() {
		if (isSubcategoriesSearchCheckBoxChecked()) {
			clickSubcategoriesSearchCheckBox();
		}
	}

	public void setProductDescriptionsSearchCheckBoxAsChecked() {
		if (!isProductDescriptionsSearchCheckBoxChecked()) {
			clickProductDescriptionsSearchCheckBox();
		}
	}

	public void setProductDescriptionsSearchCheckBoxAsUnchecked() {
		if (isProductDescriptionsSearchCheckBoxChecked()) {
			clickProductDescriptionsSearchCheckBox();
		}
	}

	protected void setSearchProductData(String searchText) {
		setInputSearchFieldField(searchText);
		clickInputSearchButton();
	}

	protected void setSearchProductData(String searchText, boolean productDescription) {
		if (productDescription) {
			setProductDescriptionsSearchCheckBoxAsChecked();
		} else {
			setProductDescriptionsSearchCheckBoxAsUnchecked();
		}
		setSearchProductData(searchText);
	}
	
	// TODO Develop Other setSearchProductData
	 
	// Business Logic
	
	public SuccessfulSearchPage successfulStructureSearch(Product product) {
		setSearchProductData(product.getSearchText());
		return new SuccessfulSearchPage(driver);
	}
	
	public UnsuccessfulSearchPage unsuccessfulStructureSearch(Product invalidProduct) {
		setSearchProductData(invalidProduct.getSearchText());
		return new UnsuccessfulSearchPage(driver);
	}
	
	// TODO Develop Other Method for setSearchProductData
}
