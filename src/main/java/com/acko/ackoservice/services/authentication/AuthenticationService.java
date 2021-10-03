package com.acko.ackoservice.services.authentication;

public interface AuthenticationService {

    String getToken(String userID, String password);
}
