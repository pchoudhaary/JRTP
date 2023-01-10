package com.ashokit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="CONTACT_MASTER")
public class ContactEntity {

    @Id
    @GeneratedValue
	@Column(name="CID")
	private Integer cid;
	@Column(name="CNAME")
	private String cname;
	@Column(name="CEMAIL")
	private String cemail;
	@Column(name="CNO")
	private String cno;
	@Column(name="ACTIVESWT")
	private String activeswt;
	
	
	
}
