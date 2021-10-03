package com.acko.ackoservice.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PhoneNumberValidatorTest {



    private PhoneValidator phoneValidator;

    @BeforeEach
    void setup()
    {
        phoneValidator = new PhoneValidator();
    }


    @Test
    public void validatePhoneNumberTest()
    {

      boolean isValid =  phoneValidator.test("+919391488477");

       Assertions.assertThat(isValid).isTrue();

    }

    @ParameterizedTest
    @CsvSource({"+919391488477,true","+939391488477,false","+91939148847799,false"})
    public void validatePhoneNumberParameterizedTest(String phoneNumber,boolean expected)
    {

        boolean isValid =  phoneValidator.test(phoneNumber);

        //Assertions.assertThat(isValid).isTrue();

        Assertions.assertThat(isValid).isEqualTo(expected);

    }


}
