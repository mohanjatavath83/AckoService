package com.acko.ackoservice.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="products")
public class ProductModel extends AuditModel<String> {
    @Id
    private String code;
    private String name;
    private double price;



}
