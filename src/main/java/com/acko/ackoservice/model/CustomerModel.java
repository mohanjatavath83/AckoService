package com.acko.ackoservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "customers", uniqueConstraints = {@UniqueConstraint(columnNames = "mobileNumber")},
        indexes = {
                @Index(columnList = "uid", name = "user_id_hidx"),
                @Index(columnList = "name", name = "user_name_hidx")
        })
public class CustomerModel extends AuditModel<String> {

    @Id
    private String uid;
    private String name;
    @Column(nullable = false)
    private String mobileNumber;
    private String email;

    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
    List<CartModel> carts = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
    Set<OrderModel> orders = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "owner")
    Set<AddressModel> addresses = new HashSet<>();

}
