package com.softserve.edu.opencart.data;

import java.util.List;

import com.softserve.edu.opencart.tools.AccidentalUtils;
import com.softserve.edu.opencart.tools.CSVReader;
import com.softserve.edu.opencart.tools.ExcelReader;

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
			.setCountry("country")
			.setRegion("region")
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
				.setCountry("country")
				.setRegion("region")
				.setPassword("ytrewq")
				.setSubscribe(true)
				.setCompany("company")
				.build();
	}

	public static IUser generateNew() {
		return User.get()
				.setFirstname(AccidentalUtils.randomUsername())
				.setLastname("hahaha")
				.setEmail(AccidentalUtils.randomEmail())
				.setTelephone("1234567")
				.setAddress1("address1")
				.setCity("city")
				.setPostcode("postcode")
				.setCountry("Ukraine")
				.setRegion("Kyiv")
				.setPassword("qwerty")
				.setSubscribe(true)
				.setCompany("company")
				.build();
	}

	public static List<IUser> fromCsv(String filename) {
        return User.getByLists(new CSVReader(filename).getAllCells());
    }

    public static List<IUser> fromCsv() {
        return fromCsv("users.csv");
    }

    public static List<IUser> fromExcel(String filename) {
        return User.getByLists(new ExcelReader(filename).getAllCells());
    }

    public static List<IUser> fromExcel() {
        return fromExcel("users.xlsx");
    }

    // TODO Read data DB, etc.

}
