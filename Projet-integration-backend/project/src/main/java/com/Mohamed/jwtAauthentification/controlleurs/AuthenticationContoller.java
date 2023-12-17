package com.Mohamed.jwtAauthentification.controlleurs;

import com.Mohamed.jwtAauthentification.securityJwt.AuthentificationUserDetailsService;
import com.Mohamed.jwtAauthentification.securityJwt.JwtRequest;
import com.Mohamed.jwtAauthentification.securityJwt.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthenticationContoller {

    @Autowired
    AuthentificationUserDetailsService service;

    @PostMapping("/login")
    public JwtResponse createJwt(@RequestBody JwtRequest request)throws Exception{
        return service.createToken(request);
    }
}
