package com.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.ContactEntity;
import com.ashokit.service.ContactService;

@RestController
public class ContactRestController {
     
	@Autowired
	private ContactService contactservice;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody ContactEntity contactentity){
		       
		     String upsert = contactservice.upsert(contactentity);
		    return new ResponseEntity<String>(upsert, HttpStatus.CREATED);
	 }
	
    @GetMapping("/contacts")	
	public ResponseEntity<List<ContactEntity>> getAllContact(){
		List<ContactEntity> allContact = contactservice.getAllContact();
	     return new ResponseEntity<>(allContact,HttpStatus.OK);
	}
    
    @PutMapping("/contact/{cid}")
    public ResponseEntity<ContactEntity> getContact(@PathVariable(value="cid") Integer cid){
    	ContactEntity contact = contactservice.getContact(cid);
    	return new ResponseEntity<ContactEntity>(contact, HttpStatus.OK);
    	}
    
    @DeleteMapping("/contacts/{cid}")
    public ResponseEntity<String> deleteContact(@PathVariable(value="cid") Integer cid){
    	String msg = contactservice.deleteContact(cid);
    	return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
     
                         
}
