/*
 * Author Name: Mohit Saini
 * Date: 10-03-2023
 * Created With: IntelliJ IDEA Ultimate
 */
package com.example.login.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User is Not_Found in DataBase!!")
public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}
