package com.acko.ackoservice.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "entries")
public class AbstractOrderEntryModel extends AuditModel<String> {

    @Id
    private String orderEntryCode;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "product")
    private ProductModel product;
    private Integer quantity;

    @ManyToOne
    private CartModel cart;
}
