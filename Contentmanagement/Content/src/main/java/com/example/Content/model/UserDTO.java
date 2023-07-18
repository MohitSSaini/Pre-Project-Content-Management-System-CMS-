package com.example.Content.model;


import org.springframework.data.annotation.Id;

import java.util.Objects;

public class UserDTO {
    @Id
    private int userId;
    private String password, userName, role, emailId;

    public UserDTO() {
    }

    public UserDTO(int userId, String password, String userName, String role, String emailId) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.role = role;
        this.emailId = emailId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return userId == userDTO.userId && Objects.equals(password, userDTO.password) && Objects.equals(userName, userDTO.userName) && Objects.equals(role, userDTO.role) && Objects.equals(emailId, userDTO.emailId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, password, userName, role, emailId);
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userId=" + userId + ", password='" + password + '\'' + ", userName='" + userName + '\'' + ", role='" + role + '\'' + ", emailId='" + emailId + '\'' + '}';
    }
}
