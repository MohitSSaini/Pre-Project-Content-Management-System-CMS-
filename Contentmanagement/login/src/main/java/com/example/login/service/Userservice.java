package com.example.login.service;

import com.example.login.exception.UserAlreadyExistsException;
import com.example.login.exception.UserNotFoundException;
import com.example.login.model.User;

public interface Userservice {


    User addUser(User user) throws UserAlreadyExistsException;
//    User addUser(User user);

    User loginUser(User user) throws UserNotFoundException;
//    User loginUser(String emailId, String password)throws UserNotFoundException;
}
