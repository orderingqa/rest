package com.thu.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FRIENDS")
public class Friends  implements DomainObject<Long> {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "friends_id")
private Long id;	
	
@OneToOne
@JoinColumn(name="ic_id1", nullable = false)
private IndividualCustomer ic1;

@OneToOne
@JoinColumn(name="ic_id2", nullable = false)
private IndividualCustomer ic2;

@Column(name="relationship")
private Integer relationship; 

public Long getId() {
	// TODO Auto-generated method stub
	return id;
}

public void setId(Long id) {
	this.id = id;
}
}
