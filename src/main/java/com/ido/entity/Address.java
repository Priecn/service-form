package com.ido.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Address implements Serializable {

    private static final Long serialversionUID  = 1457826234658L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "address_pk_table")
    @TableGenerator(name = "address_pk_table",
                    table = "ADDRESS_PK_TABLE",
                    pkColumnValue = "VALUE",
                    pkColumnName = "PK",
                    valueColumnName = "NEXT_PK",
                    allocationSize = 1)
    private Long id;

    @Column(name = "ADDRESS_LINE_1")
    private String addressLine1;

    @Column(name = "ADDRESS_LINE_2")
    private String addressLine2;

    @Column(name = "STATE", nullable = false)
    private String state;

    @Column(name = "CITY", nullable = false)
    private String city;

    @ManyToOne
    @JoinColumn(name = "PROVINCE_ID")
    private Province province;

    @Column(name = "PINCODE", nullable = false)
    private Integer pincode;


    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }
}
