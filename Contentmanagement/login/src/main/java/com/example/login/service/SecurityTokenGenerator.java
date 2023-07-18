package com.example.login.service;
import com.example.login.model.User;
import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);
}
