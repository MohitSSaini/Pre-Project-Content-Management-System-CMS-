package com.example.Content.service;

import com.example.Content.model.Commonuser;
import com.example.Content.model.ContentData;
import com.example.Content.model.Userclass;

import java.util.List;

public interface Contentservice {

    List<Userclass> getallcontents();
    Userclass getcontentsbyemailid(String emailid);
    Userclass addcontent (String emailId, ContentData contentData );
   Userclass  update(String emailid, ContentData contentData );
    boolean deletecontent(String emailid);
    Userclass adduser1(Commonuser commonuser);
    boolean delete(String emailid, int cid);
}
