package com.example.Content.controller;

import com.example.Content.model.Commonuser;
import com.example.Content.model.ContentData;
import com.example.Content.service.Contentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content-management/c1")
public class Contentcon {
    @Autowired
    private Contentservice contentservice;
    @GetMapping("/getcontent")
    public ResponseEntity<?> getAllcontents( ){
        return new ResponseEntity<>(contentservice.getallcontents(), HttpStatus.OK);
    }
    //http://localhost:9999/content-management/c1/addcontent


    @PostMapping("/addcontent/{emailid}")
    public ResponseEntity<?> addcontent(@PathVariable String emailid ,@RequestBody ContentData contentData){
        return  new ResponseEntity<>(contentservice.addcontent(emailid,contentData),HttpStatus.OK);
    }
   // http://localhost:9999/content-management/c1/update
    @PutMapping("/update/{emailid}")
    public ResponseEntity<?> update(@PathVariable String emailid,@RequestBody  ContentData contentData) {
        return new ResponseEntity<>(contentservice.update(emailid,contentData), HttpStatus.OK);
    }
    //http://localhost:9999/content-management/c1/delete
    @DeleteMapping("/delete/{emailid}")
    public ResponseEntity<?> deletecontents(@PathVariable String emailid){
        return new ResponseEntity<>(contentservice.deletecontent(emailid),HttpStatus.OK);
    }
    //http://localhost:9999/content-management/c1/add-user1
    @PostMapping("add-user1")
    public ResponseEntity<?>addUser1(@RequestBody Commonuser commonuser){
        return new ResponseEntity<>(contentservice.adduser1(commonuser), HttpStatus.OK);
    }

    @GetMapping("/get-contentsby-email/{emailid}")
    public ResponseEntity<?> getbyid(@PathVariable String emailid){
        return new ResponseEntity<>(contentservice.getcontentsbyemailid(emailid),HttpStatus.OK);
    }
    @DeleteMapping("/delete-content/{emailid}/{cid}")
    public ResponseEntity<?> deletecontent(@PathVariable String emailid,@PathVariable int cid){
        return new ResponseEntity<>(contentservice.delete(emailid,cid),HttpStatus.OK);
    }
}
