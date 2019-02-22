package com.softserve.edu.opencart.data;

public interface IUser {

	String getFirstname();

	String getLastname();

	String getEmail();

	String getTelephone();

	String getFax();

	String getCompany();

	String getAddress1();

	String getAddress2();

	String getCity();

	String getPostcode();

	User.Country getCountry();

	User.Region getRegion();

	String getPassword();

	String getConfirmPassword();

	boolean isSubscribe();

}
