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
	IRegion setCountry(User.Country country);
}

interface IRegion {
	IPassword setRegion(User.Region region);
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
	IUserBuild setConfirmPassword(String confirmPassword);

	// Use Dependency Inversion. Add IUser
	IUser build();
}

	// Use Dependency Inversion. Add IUser
	public class User implements IFirstname, ILastname, IEmail,
		ITelephone, IAddress1, ICity, IPostcode,
		ICountry, IRegion, IPassword,
		ISubscribe, IUserBuild, IUser {

	private String firstname;
	private String lastname;
	private String email;
	private String telephone;
	private String fax;                // not required
	private String company;            // not required
	private String address1;
	private String address2;            // not required
	private String city;
	private String postcode;
	private Country country;
	private Region region;
	private String password;
	private String confirmPassword;    // not required
	private boolean subscribe;

	// Use Builder
	public static IFirstname get() {
		return new User();
	}

	// setters
	// Use Builder
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

	public static enum Country {
		UKRAINE("Ukraine"),
		SWEDEN("Sweden");
		//
		private String country;

		private Country(String country) {
			this.country = country;
		}

		public String getCountryName() {
			return country;
		}
	}

	public ICountry setPostcode(String postcode) {
		this.postcode = postcode;
		return this;
	}

	public static enum Region {
		LVIV("L'vivs'ka Oblast'"),
		TERNOPIL("Ternopil's'ka Oblast'"),
		CHERKASY("Cherkas'ka Oblast'"),
		KYIV("Kyiv"),
		HALLAND("Halland");

		private String region;

		private Region(String region) {
			this.region = region;
		}

		public String getRegionName() {
			return region;
		}
	}

	public IRegion setCountry(Country country) {
		this.country = country;
		return this;
	}

	public IPassword setRegion(Region region) {
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

	public IUserBuild setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
		return this;
	}

	// Use Dependency Inversion. Add IUser
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

	public Country getCountry() {
		return country;
	}

	public Region getRegion() {
		return region;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public boolean isSubscribe() {
		return subscribe;
	}

}
