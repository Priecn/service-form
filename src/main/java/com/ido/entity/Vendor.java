package com.ido.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="VENDOR")
public class Vendor implements Serializable {

    private static final Long serialversionUID  = 14578265834234L;

    @Id
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "GENDER")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name = "DOB")
    private LocalDate dateOfBirth;

    @Column(name = "VENDOR_REG_DATE")
    private LocalDate vendorRegDate;

    @Column(name = "MOBILE_NUMBER")
    private Long mobileNumber;

    @Column(name = "PHONE_NUMBER")
    private Long phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vendor")
    private HomeAddress address;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vendor")
    private Company company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(HomeAddress address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
