package com.acko.ackoservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "carts")
public class CartModel extends AbstractOrderModel{
}
