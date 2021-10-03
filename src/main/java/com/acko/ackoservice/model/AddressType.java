package com.acko.ackoservice.model;

public enum AddressType {
    HOME("HOME"),
    OFFICE("OFFICE");

    public String addressType;

    AddressType(String addressType) {
        this.addressType = addressType;
    }
}
