package com.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.ContactEntity;
import com.ashokit.repo.ContactRepo;

@Service
public class ContactServcieImpl implements ContactService {

	@Autowired
	private ContactRepo contactrepo;
	
	
	
	@Override
	public String upsert(ContactEntity contact) {
        contactrepo.save(contact);
		return "Contact saved SuccesFully";
	}

	@Override
	public List<ContactEntity> getAllContact() {
        
	  return contactrepo.findAll();
	}

	@Override
	public String deleteContact(Integer cid) {
              
		 contactrepo.deleteById(cid);
		 return "Contact is Deleted..";
	}

	@Override
	public ContactEntity getContact(Integer cid) {
          
	      Optional<ContactEntity> find = contactrepo.findById(cid);	
		   
	      if(find.isPresent()) {
	    	 return find.get();
	      }
	      
	   return null;
	}

}
