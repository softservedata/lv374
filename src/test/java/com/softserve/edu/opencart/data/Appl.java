package com.softserve.edu.opencart.data;

import com.softserve.edu.opencart.tools.AccidentalUtils;

public class Appl {

	public static void main(String[] args) {
		//
		// 1. Use Constructor
//		User user = new User("firstname1", "lastname",
//			"email", "telephone", "fax",
//			"company", "address1", "address2",
//			"city", "postcode", "country",
//			"region", "password", true);
//		System.out.println("firstname = " + user.getFirstname());
		//
		// 2. Default Constructor, Use Setters
//		User user = new User();
//		user.setFirstname("firstname2");
//		user.setLastname("lastname");
//		user.setEmail("email");
//		user.setTelephone("telephone");
//		user.setFax("fax");
//		user.setCompany("company");
//		user.setAddress1("address1");
//		user.setAddress2("address2");
//		user.setCity("city");
//		user.setPostcode("postcode");
//		user.setCompany("country");
//		user.setRegion("region");
//		user.setPassword("password");
//		user.setSubscribe(true);
//		System.out.println("firstname = " + user.getFirstname());
		//
		// 3. Use FluentInterface
//		User user = new User()
//			.setFirstname("firstname3")
//			.setLastname("lastname")
//			.setEmail("email")
//			.setTelephone("telephone")
//			.setFax("fax")
//			.setCompany("company")
//			.setAddress1("address1")
//			.setAddress2("address2")
//			.setCity("city")
//			.setPostcode("postcode")
//			.setCompany("country")
//			.setRegion("region")
//			.setPassword("password")
//			.setSubscribe(true);
//		System.out.println("firstname = " + user.getFirstname());
		//
		// 4. Use StaticFactory
//		User user = User.get()
//			.setFirstname("firstname4")
//			.setLastname("lastname")
//			.setEmail("email")
//			.setTelephone("telephone")
//			.setFax("fax")
//			.setCompany("company")
//			.setAddress1("address1")
//			.setAddress2("address2")
//			.setCity("city")
//			.setPostcode("postcode")
//			.setCompany("country")
//			.setRegion("region")
//			.setPassword("password")
//			.setSubscribe(true);
//		System.out.println("firstname = " + user.getFirstname());
		//
		// 5. Use Builder
//		User user = User.get()
//				.setFirstname("firstname5")
//				.setLastname("lastname")
//				.setEmail("email")
//				.setTelephone("telephone")
//				.setAddress1("address1")
//				.setCity("city")
//				.setPostcode("postcode")
//				.setCountry("country")
//				.setRegion("region")
//				.setPassword("password")
//				.setSubscribe(true)
//				.setCompany("company")
//				.build();
//		System.out.println("firstname = " + user.getFirstname());
//		System.out.println("firstname = " + user.setFirstname("")); // Destroy Object 
//		System.out.println("firstname = " + user.getFirstname());
		//
		// 6. Use Dependency Inversion
//		IUser user = User.get()
//				.setFirstname("firstname5")
//				.setLastname("lastname")
//				.setEmail("email")
//				.setTelephone("telephone")
//				.setAddress1("address1")
//				.setCity("city")
//				.setPostcode("postcode")
//				.setCountry("country")
//				.setRegion("region")
//				.setPassword("password")
//				.setSubscribe(true)
//				.setCompany("company")
//				.build();
		//((User) user).setFirstname("");
//		System.out.println("firstname = " + user.getFirstname());
		//System.out.println("firstname = " + user.setFirstname("")); // Compile Error
		//
		// 7. Use Repository
		IUser user = UserRepository.getValid();
		System.out.println("firstname = " + user.getFirstname());
		//
		//System.out.println(System.currentTimeMillis()%10000L);
		//AccidentalUtils.randomInt(10, 97, 122);
		//AccidentalUtils.randomChar(10);
		System.out.println("AccidentalUtils.randomString(10) = " + AccidentalUtils.randomString(10));
	} 
	
}
