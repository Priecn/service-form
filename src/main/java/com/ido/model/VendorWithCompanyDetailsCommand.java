package com.ido.model;

import java.time.LocalDate;
import java.util.Date;

public class VendorWithCompanyDetailsCommand {

    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private LocalDate vendorRegDate;
    private Long mobileNumber;
    private Long phoneNumber;
    private String email;
    private HomeAddressCommand address;
    private CompanyCommand company;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getVendorRegDate() {
        return vendorRegDate;
    }

    public void setVendorRegDate(LocalDate vendorRegDate) {
        this.vendorRegDate = vendorRegDate;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HomeAddressCommand getAddress() {
        return address;
    }

    public void setAddress(HomeAddressCommand address) {
        this.address = address;
    }

    public CompanyCommand getCompany() {
        return company;
    }

    public void setCompany(CompanyCommand company) {
        this.company = company;
    }
}
