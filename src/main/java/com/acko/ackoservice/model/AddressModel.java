package com.acko.ackoservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class AddressModel extends AuditModel<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String line1;
    private String line2;
    private String line3;
    private String city;
    private String state;
    private String postalcode;
    private String country;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @ManyToOne
    @JoinColumn(name = "owner")
    private CustomerModel owner;
}
