package com.example.Content.service;

import com.example.Content.model.Commonuser;
import com.example.Content.model.ContentData;
import com.example.Content.model.Userclass;

import java.util.List;

public interface Contentservice {

    public abstract List<Userclass> getallcontents();
    public abstract Userclass getcontentsbyemailid(String emailid);
    public abstract Userclass addcontent (String emailId,ContentData contentData );
   public abstract Userclass  update(String emailid,ContentData contentData );
    public abstract boolean deletecontent(String emailid);
    public abstract Userclass adduser1(Commonuser commonuser);

    public abstract boolean delete(String emailid,int cid);
}
