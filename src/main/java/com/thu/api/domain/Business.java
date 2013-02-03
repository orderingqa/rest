package com.thu.api.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "business")
public class Business implements DomainObject<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "business_id")
	private Long id;

	@OneToMany(mappedBy="business")
	private Collection <BusinessAddress> businessAddresses = new ArrayList<BusinessAddress>();

	
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setId(Long id) {
		this.id = id;
		
	}
}