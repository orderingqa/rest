package com.thu.api.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Index;


/**
*
* @author liushuai
*/
@Entity
@Table(name = "ISP")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "individualServiceProvider")
public class IndividualServiceProvider implements DomainObject<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "isp_id")
	private Long id;
	
	@Column(name = "fb_id", nullable = false)
    @Index(name = "facebookIdIndex")
    private Long facebookId;
	
//	@Column(name="nick_name")
//	private String nickName;
//	
//	@Column(name="first_name")
//	private String firstName;
//	
//	@Column(name="last_name")
//	private String lastName;
//	
//	@Column(name="email")
//	private String email;
	
	
//	@ManyToOne (cascade=CascadeType.ALL)
//	@Column(name="specialty_id")
//	private Long specialtyId;
	
//	@ManyToOne (cascade=CascadeType.ALL)
//	@Column(name="business_id")
//	private Long businessId;
//
//	
	@Column(name="confirmed")
	private Integer confirmed;
	
	
	@OneToOne
	@JoinColumn (name="business_id")
	private Business business;
	
	@OneToOne
	@JoinColumn (name="added_ic_id")
	private IndividualCustomer ic;

	
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}

	public Long getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(Long facebookId) {
		this.facebookId = facebookId;
	}

}
