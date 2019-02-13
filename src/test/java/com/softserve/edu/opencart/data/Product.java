package com.softserve.edu.opencart.data;

import java.util.HashMap;

import org.apache.poi.hpsf.Decimal;

public class Product {

	private String searchText;
	private String name;
	private String description;
	private String priceDollarExTax;
	// TODO
	// private Decimal priceDollarExTax;
	//
	// private HashMap<EnumCurrencies, Decimal> prices;

	public Product(String searchText, String name, String description, String priceDollarExTax) {
		this.searchText = searchText;
		this.name = name;
		this.description = description;
		this.priceDollarExTax = priceDollarExTax;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPriceDollarExTax(String priceDollarExTax) {
		this.priceDollarExTax = priceDollarExTax;
	}

	public String getSearchText() {
		return searchText;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getPriceDollarExTax() {
		return priceDollarExTax;
	}

}
