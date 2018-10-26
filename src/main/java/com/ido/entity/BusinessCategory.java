package com.ido.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BUSINESS_CATEGORY")
public class BusinessCategory implements Serializable {

    private static final Long serialVersionUID  = 145782658L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "category_pk_table")
    @TableGenerator(name = "category_pk_table",
            table = "CATEGORY_PK_TABLE",
            pkColumnValue = "VALUE",
            pkColumnName = "PK",
            valueColumnName = "NEXT_PK",
            allocationSize = 1)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<BusinessSubCategory> subCategories;

    @OneToMany(mappedBy = "businessCategory")
    @JsonIgnore
    private Set<Company> companies = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BusinessSubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<BusinessSubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }
}
