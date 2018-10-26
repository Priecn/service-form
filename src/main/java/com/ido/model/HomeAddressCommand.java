package com.ido.model;

public class HomeAddressCommand extends AddressCommand{
    private Long vendorId;

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }
}
