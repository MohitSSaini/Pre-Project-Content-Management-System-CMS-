package com.example.login.controlers;

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
    //http://localhost:8888/authentication-app/v1/register

//    {
//        "userId":1,
//            "password":"1234",
//            "userName":"sipra",
//            "emailId":"si@gmail.com"
//
//    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        user.setRole("ROLE_USER");
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }
    //http://localhost:8888/authentication-app/v1/authenticate
    @PostMapping("/authenticate")
    public ResponseEntity<?> loginCheck(@RequestBody User user) {
        User result = userService.loginCheck(user.getUserId(), user.getPassword());
        if (result != null) {
            Map<String, String> key = securityTokenGenerator.generateToken(result);
            return new ResponseEntity<>(key, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Authentication failed", HttpStatus.NOT_FOUND);

        }

    }
}
