package com.example.Content.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;


@Document
public class Userclass {
    @Id

    private String emailId;
    private String userName;
    private List<ContentData> contentData;

    public Userclass() {
    }

    public Userclass(String emailId, String userName, List<ContentData> contentData) {
        this.emailId = emailId;
        this.userName = userName;
        this.contentData = contentData;
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

    public List<ContentData> getContentData() {
        return contentData;
    }

    public void setContentData(List<ContentData> contentData) {
        this.contentData = contentData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Userclass userclass = (Userclass) o;
        return Objects.equals(emailId, userclass.emailId) && Objects.equals(userName, userclass.userName) && Objects.equals(contentData, userclass.contentData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailId, userName, contentData);
    }

    @Override
    public String toString() {
        return "Userclass{" +
                "emailId='" + emailId + '\'' +
                ", userName='" + userName + '\'' +
                ", contentData=" + contentData +
                '}';
    }
}
