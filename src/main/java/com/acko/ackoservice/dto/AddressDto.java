package com.acko.ackoservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    private String line1;
    private String line2;
    private String line3;
    private String city;
    private String state;
    private String postalcode;
    private String country;
    private String addressType;
}
