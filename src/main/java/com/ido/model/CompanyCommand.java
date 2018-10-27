package com.ido.model;

import java.util.HashSet;
import java.util.Set;

public class CompanyCommand {

    private Long vendorId;

    private String name;

    private OfficeAddressCommand address;

    private Set<Integer> subCategoryIds = new HashSet<>();

    private Integer businessCategoryId;

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OfficeAddressCommand getAddress() {
        return address;
    }

    public void setAddress(OfficeAddressCommand address) {
        this.address = address;
    }

    public Set<Integer> getSubCategoryIds() {
        return subCategoryIds;
    }

    public void setSubCategoryIds(Set<Integer> subCategoryIds) {
        this.subCategoryIds = subCategoryIds;
    }

    public Integer getBusinessCategoryId() {
        return businessCategoryId;
    }

    public void setBusinessCategoryId(Integer businessCategoryId) {
        this.businessCategoryId = businessCategoryId;
    }
}
