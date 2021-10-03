package com.acko.ackoservice.validator;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class PhoneValidator implements Predicate<String> {

    public boolean test(String phoneNumber) {
        return phoneNumber != null && phoneNumber.startsWith("+91") && phoneNumber.length() == 13;
    }
}
