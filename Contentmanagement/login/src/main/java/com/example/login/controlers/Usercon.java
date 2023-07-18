package com.example.login.controlers;

import com.example.login.exception.UserAlreadyExistsException;
import com.example.login.exception.UserNotFoundException;
import com.example.login.model.User;
import com.example.login.service.SecurityTokenGenerator;
import com.example.login.service.Userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@CrossOrigin("*")
@RestController
@RequestMapping("/authentication-app/v1")
public class Usercon {
    @Autowired
    private Userservice userService;
    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        {
            try {
                user.setRole("ROLE_USER");
                User registerUser=userService.addUser(user);
                return new ResponseEntity<>(registerUser, HttpStatus.ACCEPTED);
            } catch (UserAlreadyExistsException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
            }
        }

    }
//        user.setRole("ROLE_USER");
//        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
//    }

    @PostMapping("authenticate")
    public ResponseEntity<?> loginUser(@RequestBody User user)
    {
        try {
            User loggedInUser=userService.loginUser(user);
            Map<String ,String> tokenGenerated;
            tokenGenerated = securityTokenGenerator.generateToken(loggedInUser);
            return new ResponseEntity<>(tokenGenerated, HttpStatus.CREATED);
        }
        catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);

        }
    }
}


//    @PostMapping("/authenticate")
//    public ResponseEntity<?> loginCheck(@RequestBody User user) {
//        try {
//            User loginDetail = userService.loginUser(user.getEmailId(), user.getPassword());
//            Map<String, String> tokenGenerator = securityTokenGenerator.generateToken(loginDetail);
//            return new ResponseEntity<>(tokenGenerator, HttpStatus.FOUND);
//        } catch (UserNotFoundException e) {
//            return new ResponseEntity<>("UserName And Password is Wrong", HttpStatus.NOT_FOUND);
//        }
//    }




//        userService.loginUser(user.getEmailId(), user.getPassword());
//        User result = userService.loginUser(user.getEmailId(), user.getPassword());
//        if (result != null) {
//            Map<String, String> key = securityTokenGenerator.generateToken(result);
//            return new ResponseEntity<>(key, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Authentication failed", HttpStatus.NOT_FOUND);
//        }