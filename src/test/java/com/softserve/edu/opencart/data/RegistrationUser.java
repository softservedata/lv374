package com.softserve.edu.opencart.data;

import com.softserve.edu.EmailRandomizer;

public class RegistrationUser {
    private String firstName;
    private String lastName;
    private EmailRandomizer email;
    private String telephone;
    private String fax;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String postCode;
    //country TODO
    //region TODO
    private String password;
    private String passwordConfirm;
    //private String privacyPolicyCheckBox; TODO
    //private String confirmButton; TODO

    public RegistrationUser(String firstName, String lastName, EmailRandomizer email,
                            String telephone, String fax, String company,
                            String address1, String address2, String city,
                            String postCode, String password, String passwordConfirm) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.fax = fax;
        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.postCode = postCode;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void setEmail(EmailRandomizer email) {
        this.email = email;
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public EmailRandomizer getEmail(){
        return email;
    }

    public void setTelephone() {
        this.telephone = telephone;
    }

    public String getTelephone(){
        return telephone;
    }

    public void setFax() {
        this.fax = fax;
    }

    public String getFax(){
        return fax;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany(){
        return company;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress1(){
        return address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress2(){
        return address2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity(){
        return city;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostCode(){
        return postCode;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getPasswordConfirm(){
        return passwordConfirm;
    }
}
