package com.acko.ackoservice.controller;


import com.acko.ackoservice.dto.UserCredentialDto;
import com.acko.ackoservice.services.authentication.AuthenticationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthenticationController extends BaseController {

    @Autowired
    AuthenticationService authenticationService;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @PostMapping("/token")
    public String getToken(@RequestBody UserCredentialDto userCredentialDto) {
        log.info("usercredentials dto  = {} ",gson.toJson(userCredentialDto));
        return authenticationService.getToken(userCredentialDto.getUserID(), userCredentialDto.getPassword());

    }
}
