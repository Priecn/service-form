package com.ido.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OFFICE_ADDRESS")
public class OfficeAddress extends Address {

    @OneToOne
    @JoinColumn(name = "COMPANY_ID", nullable = false)
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
