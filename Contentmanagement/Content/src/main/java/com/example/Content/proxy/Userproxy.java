package com.example.Content.proxy;

import com.example.Content.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="authentication-service",url="localhost:8888")
public interface Userproxy  {
    @PostMapping("/authentication-app/v1/register")
    public ResponseEntity<?> sendUserObjectUserAppJWT(@RequestBody UserDTO userDTO);
}
