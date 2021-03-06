package com.ido.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BUSINESS_SUB_CATEGORY")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BusinessSubCategory implements Serializable {

    private static final Long serialVersionUID  = 1457826576558L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "sub_category_pk_table")
    @TableGenerator(name = "sub_category_pk_table",
            table = "SUB_CATEGORY_PK_TABLE",
            pkColumnValue = "VALUE",
            pkColumnName = "PK",
            valueColumnName = "NEXT_PK",
            allocationSize = 1,
            initialValue = 138)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    @JsonIgnore
    private BusinessCategory category;

    @ManyToMany(mappedBy = "subCategories")
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

    public BusinessCategory getCategory() {
        return category;
    }

    public void setCategory(BusinessCategory category) {
        this.category = category;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }
}