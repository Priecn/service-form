package com.ido.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PROVINCE")
public class Province implements Serializable {

    private static final Long serialVersionUID  = 545578265834234L;

    @Id
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "province")
    @JsonIgnore
    private Set<Address> addresses = new HashSet<>();

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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}
