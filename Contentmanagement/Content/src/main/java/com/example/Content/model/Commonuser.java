package com.example.Content.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commonuser {

    private int userId;
    private String emailId;
    private String userName;
    private String password;

}
