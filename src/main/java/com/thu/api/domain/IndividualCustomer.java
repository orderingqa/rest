/*
 * Proprietary information
 * 
 * Copyright 2008 Craig MacKay. All rights reserved.
 */

package com.thu.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Index;

/**
 *
 * @author liushuai
 */
@Entity
@Table(name = "IC")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "individualCustomer")
public class IndividualCustomer implements DomainObject<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ic_id")
    private Long id;
    
    @Column(name = "fb_id", nullable = false)
    @Index(name = "facebookIdIndex")
//    @XmlAttribute(required = true)
    private Long facebookId;
    
    @Column(name = "user_name")
//    @XmlAttribute(required = true)
    private String userName;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "phone")
    private String phone;
    
    @Column(name = "current_location_id")
    private String currentLocationId;
    

    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(Long facebookId) {
		this.facebookId = facebookId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCurrentLocationId() {
		return currentLocationId;
	}

	public void setCurrentLocationId(String currentLocationId) {
		this.currentLocationId = currentLocationId;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndividualCustomer)) {
            return false;
        }
        final IndividualCustomer other = (IndividualCustomer) obj;
        if (hashCode() != other.hashCode()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode;
        if (id != null) {
            hashCode = 29 * id.hashCode();
        } else {
            hashCode = super.hashCode();
        }
        return hashCode;
    }

    @Override
    public String toString() {
        return new StringBuilder("IndividualCustomer[")
            .append("id:").append(id).append(";")
            .append("]")
            .toString();
    }
    
}
