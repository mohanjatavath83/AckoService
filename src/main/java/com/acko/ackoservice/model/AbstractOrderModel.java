package com.acko.ackoservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@MappedSuperclass
public class AbstractOrderModel extends AuditModel<String> {


    @Id
    private String code;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "cart",orphanRemoval = true)
    List<AbstractOrderEntryModel> entries;

    @ManyToOne
    private CustomerModel customer;
}
