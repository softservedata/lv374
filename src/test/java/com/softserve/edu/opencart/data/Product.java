package com.softserve.edu.opencart.data;

import java.math.BigDecimal;
import java.util.HashMap;

import com.softserve.edu.opencart.tools.AccidentalUtils;
import org.apache.poi.hpsf.Decimal;

public class Product {

	private String searchText;
	private String name;
	private String description;
	private BigDecimal priceDollar;


	public Product(String searchText, String name, String description, String priceDollar) {
		this.searchText = searchText;
		this.name = name;
		this.description = description;
		this.priceDollar = AccidentalUtils.getPrice(priceDollar);
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

	public void setPriceDollarExTax(BigDecimal priceDollar) {
		this.priceDollar = priceDollar;
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

	public BigDecimal getPriceDollar() {
		return priceDollar;
	}

}
