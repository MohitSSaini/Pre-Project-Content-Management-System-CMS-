package com.example.Content.service;

import com.example.Content.model.Commonuser;
import com.example.Content.model.ContentData;
import com.example.Content.model.UserDTO;
import com.example.Content.model.Userclass;
import com.example.Content.proxy.Userproxy;
import com.example.Content.repository.Contentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ContentserviceImpl implements Contentservice{
    @Autowired
    private Contentrepository contentrepository;
    @Autowired
private Userproxy userproxy;
    @Override
    public List<Userclass> getallcontents() {
        return contentrepository.findAll();
    }

    @Override
    public Userclass getcontentsbyemailid(String emailid) {
        return contentrepository.findById(emailid).get();
    }



    @Override
    public Userclass addcontent(String emailId,ContentData contentData) {
        Userclass user=contentrepository.findById(emailId).get();
        user.getContentData().add(contentData);
        return contentrepository.save(user);
    }

    @Override
    public Userclass update(String emailid,ContentData contentData) {
        Userclass user = contentrepository.findById(emailid).get();
        List<ContentData>cData=user.getContentData();
        for(int i=0;i<cData.size();i++) {
            if (contentData.getCid()==(cData.get(i).getCid())) {
                cData.remove(i);
            }
        }
        cData.add(contentData);
        user.setContentData(cData);
        return contentrepository.save(user);
    }


    @Override
    public boolean deletecontent(String emailid) {
        contentrepository.deleteById(emailid);
        return true;
    }

    @Override
    public Userclass adduser1(Commonuser commonuser) {
        UserDTO userDTO =new UserDTO();
        userDTO.setUserId(commonuser.getUserId());
        userDTO.setEmailId(commonuser.getEmailId());
        userDTO.setPassword(commonuser.getPassword());
        userDTO.setUserName(commonuser.getUserName());
        ResponseEntity<?> response= userproxy.sendUserObjectUserAppJWT(userDTO);
        Userclass user = new Userclass(commonuser.getEmailId(), commonuser.getUserName(),new ArrayList<>());
        return contentrepository.insert(user);
    }

    @Override
    public boolean delete(String emailid, int cid) {
        Userclass user = contentrepository.findById(emailid).get();
        List<ContentData>contentdata=user.getContentData();
        for(int i=0;i<contentdata.size();i++){
            System.out.println(i);
            if(cid==contentdata.get(i).getCid()){

                contentdata.remove(i);
//                user.setContentData(contentdata);
                contentrepository.save(user);
            }
        }
        return true;
    }

}
