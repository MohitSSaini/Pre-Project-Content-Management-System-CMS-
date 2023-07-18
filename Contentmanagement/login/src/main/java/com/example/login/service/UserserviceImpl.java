package com.example.login.service;

import com.example.login.exception.UserAlreadyExistsException;
import com.example.login.exception.UserNotFoundException;
import com.example.login.model.User;
import com.example.login.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserserviceImpl implements Userservice {
    private final Userrepository userrepository;

    @Autowired
    public UserserviceImpl(Userrepository userrepository) {
        this.userrepository = userrepository;
    }

    @Override
    public User addUser(User user) throws UserAlreadyExistsException {
        if (userrepository.findById(user.getEmailId()).isPresent())
            throw new UserAlreadyExistsException("User in the Given Email Aready Exists");
        return userrepository.save(user);
    }

//    @Override
//    public User addUser(User user) {
//        return userrepository.save(user);
//    }

    @Override
    public User loginUser(User user) throws UserNotFoundException {
        if (userrepository.findById(user.getEmailId()).isPresent()) {
            User loggedInUser = userrepository.findById(user.getEmailId()).get();
            if (loggedInUser.getPassword().equals(user.getPassword())) return loggedInUser;
            else throw new UserNotFoundException("Password given is not matching");
        } else throw new UserNotFoundException("User not present in database Please register");
    }
    }

//    @Override
//    public User loginUser(String emailId, String password) throws UserNotFoundException {
//        Optional<User> userOptional = userrepository.findByEmailIdAndPassword(emailId, password);
//        if (userOptional.isPresent()) {
//            return userOptional.get();
//        }else {
//            throw new UserNotFoundException("User Not Found");
//        }
//    }



//        if (userrepository.findById(emailId).isPresent()) {
//                User result = userrepository.findById(emailId).get();
//                if (result.getPassword().equals(password)) {
//                result.setPassword("");
//                return result;
//                } else {
//                return null;
//                }
//                } else {
//                return null;
//                }
