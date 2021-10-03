package com.acko.ackoservice.services.authentication;

import com.acko.ackoservice.exception.UserBadCredentialsException;
import com.acko.ackoservice.model.CustomerModel;
import com.acko.ackoservice.services.customer.CustomerService;
import com.acko.ackoservice.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthenticationServiceImpl implements UserDetailsService, AuthenticationService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public UserDetails loadUserByUsername(String userID) throws UsernameNotFoundException {

        System.out.println("second method is invoked");
        CustomerModel customer = customerService.getCustomerByUid(userID);
        User user = new User(customer.getUid(), customer.getPassword(), new ArrayList<>());
        System.out.println("user"+user);
        return user;
    }

    public String getToken(String userID, String password) {
        try {
            System.out.println("first method is invoked");
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userID, password));
        } catch (DisabledException ex) {
            ex.printStackTrace();
            throw new UserBadCredentialsException("USER_DISABLED");
        } catch (BadCredentialsException ex) {
            ex.printStackTrace();
            throw new UserBadCredentialsException("INVALID_CREDENTIALS");
        }

        return jwtTokenUtil.generateToken(userID);

    }

}
