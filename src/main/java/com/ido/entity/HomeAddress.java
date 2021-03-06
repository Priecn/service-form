package com.ido.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HOME_ADDRESS")
public class HomeAddress extends Address {

    @OneToOne
    @JoinColumn(name = "VENDOR_ID", nullable = false)
    @JsonIgnore
    private Vendor vendor;

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
