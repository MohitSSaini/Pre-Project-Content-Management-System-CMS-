package com.example.login.service;


import com.example.login.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    public abstract Map<String,String> generateToken(User user);
}
