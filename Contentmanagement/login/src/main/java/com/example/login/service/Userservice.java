package com.example.login.service;

import com.example.login.model.User;

public interface Userservice {
    public  abstract User addUser(User user);
    public  abstract User loginCheck(int uId, String password);
}
