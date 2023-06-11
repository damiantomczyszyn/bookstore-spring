package com.damiantomczyszyn.bookstorespring.security;

import com.damiantomczyszyn.bookstorespring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    UserRepository repository;
    public CustomAuthenticationProvider() {
        super();
    }


    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        System.out.println(name);
        System.out.println(password);
        if (shouldAuthenticateAgainstThirdPartySystem(name, password)) {




            // use the credentials
            // and authenticate against the third-party system
            return new UsernamePasswordAuthenticationToken(
                    name, password, new ArrayList<>());
        } else {
            throw  new BadCredentialsException("nie poprawne logowanie");
        }
    }

    private boolean shouldAuthenticateAgainstThirdPartySystem(String name, String password) {



        var userOptional = repository.findByEmail(name);


        if(userOptional.isPresent()){
            System.out.println("jest taki user");
            if(userOptional.get().getPassword().equals(password)){

                return true;
            }
        }
        System.out.println("nie jest taki user");
        return false;
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}