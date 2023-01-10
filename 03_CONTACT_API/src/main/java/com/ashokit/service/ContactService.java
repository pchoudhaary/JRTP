package com.ashokit.service;

import java.util.List;

import com.ashokit.entity.ContactEntity;

public interface ContactService {

	 String upsert(ContactEntity contact);
	 List<ContactEntity> getAllContact();
	 String deleteContact(Integer cid);
	 ContactEntity getContact(Integer cid);
	

}
