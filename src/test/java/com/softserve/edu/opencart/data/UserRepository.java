package com.softserve.edu.opencart.data;

import com.softserve.edu.opencart.tools.AccidentalUtils;

public final class UserRepository {

	private UserRepository() {
	}
	
	public static IUser getDefault() {
		return getValid();
	}
	
	public static IUser getValid() {
		return User.get()
			.setFirstname("hahaha")
			.setLastname("hahaha")
			.setEmail("hahaha@gmail.com")
			.setTelephone("1234567")
			.setAddress1("address1")
			.setCity("city")
			.setPostcode("postcode")
			.setCountry(User.Country.UKRAINE)
			.setRegion(User.Region.LVIV)
			.setPassword("qwerty")
			.setSubscribe(true)
			.setCompany("company")
			.build();
	}

	public static IUser getInvalid() {
		return User.get()
				.setFirstname("bebebe")
				.setLastname("hahaha")
				.setEmail("bebebe@gmail.com")
				.setTelephone("1234567")
				.setAddress1("address1")
				.setCity("city")
				.setPostcode("postcode")
				.setCountry(User.Country.UKRAINE)
				.setRegion(User.Region.CHERKASY)
				.setPassword("ytrewq")
				.setSubscribe(true)
				.setFax("2334")
				.build();
	}

	public static IUser generateNew() {
		return User.get()
				.setFirstname(AccidentalUtils.randomString(7))
				.setLastname("hahaha")
				.setEmail(AccidentalUtils.randomEmail())
				.setTelephone("1234567")
				.setAddress1("address1")
				.setCity("city")
				.setPostcode("postcode")
				.setCountry(User.Country.UKRAINE)
				.setRegion(User.Region.LVIV)
				.setPassword("qwerty")
				.setSubscribe(true)
				.setCompany("dbdfb")
				.build();
	}

	public static  IUser userBadEmail() {
		return User.get()
				.setFirstname("")
				.setLastname("")
				.setEmail("dvdfbd")
				.setTelephone("")
				.setAddress1("")
				.setCity("")
				.setPostcode("")
				.setCountry(User.Country.UKRAINE)
				.setRegion(User.Region.LVIV)
				.setPassword("")
				.setSubscribe(true)
				.setConfirmPassword("")
				.build();
	}

	public static IUser emptyUser(){
		return User.get()
				.setFirstname("")
				.setLastname("")
				.setEmail("")
				.setTelephone("")
				.setAddress1("")
				.setCity("")
				.setPostcode("")
				.setCountry(User.Country.UKRAINE)
				.setRegion(User.Region.LVIV)
				.setPassword("")
				.setSubscribe(false)
				.build();
	}

	public static IUser userLastName33Length(){
		return User.get()
				.setFirstname(AccidentalUtils.randomString(7))
				.setLastname(AccidentalUtils.randomString(33))
				.setEmail(AccidentalUtils.randomEmail())
				.setTelephone("1234567890")
				.setAddress1("dfbdfb")
				.setCity(AccidentalUtils.randomString(7))
				.setPostcode("123456")
				.setCountry(User.Country.UKRAINE)
				.setRegion(User.Region.CHERKASY)
				.setPassword("qwerty123")
				.setSubscribe(true)
				.build();
	}

	public static IUser userWithFirstNameConsistsDigits(){
		return User.get()
				.setFirstname("Ruslana123456")
				.setLastname("John")
				.setEmail(AccidentalUtils.randomEmail())
				.setTelephone("0987658125")
				.setAddress1("Ruska 87")
				.setCity("Kyiv")
				.setPostcode("12121")
				.setCountry(User.Country.UKRAINE)
				.setRegion(User.Region.KYIV)
				.setPassword("qwerty345")
				.setSubscribe(true)
				.build();
	}

	// TODO Read data from Excel, DB, etc.
	
}
