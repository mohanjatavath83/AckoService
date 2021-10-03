package com.acko.ackoservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CustomerDto {
    private String name;
    private String mobileNumber;
    private String email;
    private String password;
    Set<AddressDto> addresses;

}
