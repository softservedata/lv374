package com.softserve.edu.opencart.data;

interface IFirstname {
	ILastname setFirstname(String firstname);
}

interface ILastname {
	IEmail setLastname(String lastname);
}

interface IEmail {
	ITelephone setEmail(String email);
}

interface ITelephone {
	IAddress1 setTelephone(String telephone);
}

interface IAddress1 {
	ICity setAddress1(String address1);
}

interface ICity {
	IPostcode setCity(String city);
}

interface IPostcode {
	ICountry setPostcode(String postcode);
}

interface ICountry {
	IRegion setCountry(String country);
}

interface IRegion {
	IPassword setRegion(String region);
}

interface IPassword {
	ISubscribe setPassword(String password);
}

interface ISubscribe {
	IUserBuild setSubscribe(boolean subscribe);
}

interface IUserBuild {
	IUserBuild setFax(String fax);

	IUserBuild setCompany(String company);

	IUserBuild setAddress2(String address2);

	// User build();
	// 6. Use Dependency Inversion. Add IUser
	IUser build();
}

// 6. Use Dependency Inversion. Add IUser
public class User implements IFirstname, ILastname, IEmail, ITelephone, IAddress1, ICity, IPostcode, ICountry, IRegion,
		IPassword, ISubscribe, IUserBuild, IUser {

	private String firstname;
	private String lastname;
	private String email;
	private String telephone;
	private String fax; // not required
	private String company; // not required
	private String address1;
	private String address2; // not required
	private String city;
	private String postcode;
	private String country;
	private String region;
	private String password;
	private boolean subscribe;

	// 1. Use Constructor
//	public User(String firstname, String lastname,
//			String email, String telephone, String fax,
//			String company, String address1, String address2,
//			String city, String postcode, String country,
//			String region, String password, boolean subscribe) {
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.email = email;
//		this.telephone = telephone;
//		this.fax = fax;
//		this.company = company;
//		this.address1 = address1;
//		this.address2 = address2;
//		this.city = city;
//		this.postcode = postcode;
//		this.country = country;
//		this.region = region;
//		this.password = password;
//		this.subscribe = subscribe;
//	}

	// 2. Default Constructor, Use Setters
//	public User() {
//	}

	// 4. Use StaticFactory
	private User() {
		// Default Parameters
		fax = "";
		company = "";
		address2 = "";
	}

	// 4. Use StaticFactory
	// public static User get() {
	// 5. Use Builder
	public static IFirstname get() {
		return new User();
	}

	// setters

	// 2. Default Constructor, Use Setters
	// public void setFirstname(String firstname) {
	// 3. Use FluentInterface
	// public User setFirstname(String firstname) {
	// 5. Use Builder
	public ILastname setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public IEmail setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public ITelephone setEmail(String email) {
		this.email = email;
		return this;
	}

	public IAddress1 setTelephone(String telephone) {
		this.telephone = telephone;
		return this;
	}

	public IUserBuild setFax(String fax) {
		this.fax = fax;
		return this;
	}

	public IUserBuild setCompany(String company) {
		this.company = company;
		return this;
	}

	public ICity setAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public IUserBuild setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public IPostcode setCity(String city) {
		this.city = city;
		return this;
	}

	public ICountry setPostcode(String postcode) {
		this.postcode = postcode;
		return this;
	}

	public IRegion setCountry(String country) {
		this.country = country;
		return this;
	}

	public IPassword setRegion(String region) {
		this.region = region;
		return this;
	}

	public ISubscribe setPassword(String password) {
		this.password = password;
		return this;
	}

	public IUserBuild setSubscribe(boolean subscribe) {
		this.subscribe = subscribe;
		return this;
	}

	// 5. Use Builder
	// public User build() {
	// 6. Use Dependency Inversion. Add IUser
	public IUser build() {
		return this;
	}

	// getters

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getFax() {
		return fax;
	}

	public String getCompany() {
		return company;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCity() {
		return city;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getCountry() {
		return country;
	}

	public String getRegion() {
		return region;
	}

	public String getPassword() {
		return password;
	}

	public boolean isSubscribe() {
		return subscribe;
	}

	@Override
	public String toString() {
		return "Firstname: " + getFirstname()
			+ " Lastname: " + getLastname()
			+ " Email: " + getEmail()
			+ " Telephone: " + getTelephone()
			+ " Fax: " + getFax()
			+ " Company: " + getCompany()
			+ " Address1: " + getAddress1()
			+ " Address2: " + getAddress2()
			+ " City: " + getCity()
			+ " Postcode: " + getPostcode()
			+ " Country: " + getCountry()
			+ " Region: " + getRegion()
			+ " Password: " + getPassword();
	}
}
