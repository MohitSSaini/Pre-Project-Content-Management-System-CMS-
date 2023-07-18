package com.example.Content.model;
import java.util.Objects;


public class Commonuser {

    private int userId;
    private String emailId;
    private String userName;
    private String password;

    public Commonuser() {
    }

    public Commonuser(int userId, String emailId, String userName, String password) {
        this.userId = userId;
        this.emailId = emailId;
        this.userName = userName;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commonuser that = (Commonuser) o;
        return userId == that.userId && Objects.equals(emailId, that.emailId) && Objects.equals(userName, that.userName) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, emailId, userName, password);
    }

    @Override
    public String toString() {
        return "Commonuser{" +
                "userId=" + userId +
                ", emailId='" + emailId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
