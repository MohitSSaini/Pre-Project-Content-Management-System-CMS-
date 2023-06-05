package com.example.login.service;

import com.example.login.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class SecurityTokenImpl implements  SecurityTokenGenerator{
    @Override
    public Map<String, String> generateToken(User user) {
        Map<String,String> result=new HashMap<>() ;

        Map<String, Object> data=new HashMap<>();
        data.put("userObject",user);
        String jwtToken= Jwts.builder()
                .setClaims(data)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,"mysecurekey").compact();
        result.put("token",jwtToken);
        result.put("message","User Successfully logged in");
        result.put("mail",user.getEmailId());
        return result;
    }
}
