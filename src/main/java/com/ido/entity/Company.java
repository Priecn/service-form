package com.ido.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Company")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Company implements Serializable {

    private static final Long serialVersionUID  = 1424325782658L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "company_pk_table")
    @TableGenerator(name = "company_pk_table",
            table = "COMPANY_PK_TABLE",
            pkColumnValue = "VALUE",
            pkColumnName = "PK",
            valueColumnName = "NEXT_PK",
            allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "VENDOR_ID", nullable = false)
    @JsonIgnore
    private Vendor vendor;

    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID",  nullable = false)
    private OfficeAddress address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "COMPANY_SUB_CATEGORY",
            joinColumns = {
                    @JoinColumn(name = "COMPANY_ID")
            }, inverseJoinColumns = {
            @JoinColumn(name = "SUB_CATEGORY_ID")
    })
    private Set<BusinessSubCategory> subCategories = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private BusinessCategory businessCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(OfficeAddress address) {
        this.address = address;
    }

    public Set<BusinessSubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<BusinessSubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    public BusinessCategory getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(BusinessCategory businessCategory) {
        this.businessCategory = businessCategory;
    }
}
