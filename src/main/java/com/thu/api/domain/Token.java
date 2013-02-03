package com.thu.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Token")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "token")
public class Token {

	@Id
	@Column(name = "fb_id")
	private Long facebookId;
	
	@Column(name = "token_no")
	private String token;

	public Long getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(Long facebookId) {
		this.facebookId = facebookId;
	}

	
	
	// TODO time is not a easy type for handle, just mark
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}