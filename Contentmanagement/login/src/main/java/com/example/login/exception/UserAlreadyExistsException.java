/*
 * Author Name: Mohit Saini
 * Date: 10-03-2023
 * Created With: IntelliJ IDEA Ultimate
 */
package com.example.login.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "User is Already Exists!!")
public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
