package com.example.login.service;

import com.example.login.model.User;
import com.example.login.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserserviceImpl implements Userservice{
    @Autowired
    private Userrepository userrepository;
    @Override
    public User addUser(User user) {
        return userrepository.save(user);
    }

    @Override
    public User loginCheck(int uId, String password) {
        if(userrepository.findById(uId).isPresent()) {
            User result = userrepository.findById(uId).get();
            if (result.getPassword().equals(password)) {
                result.setPassword("");//to hide the password in object
                return result;
            } else {
                return null;
            }
        }
        else {
            return null;
        }
    }
    }

