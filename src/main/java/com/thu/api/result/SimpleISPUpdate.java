package com.thu.api.result;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SimpleISPUpdate {
	private long ispId;
	private String basic; // fixed 16 bit
	private String reputation; // fixed 16 bit
	
	public long getIspId() {
		return ispId;
	}
	public void setIspId(long ispId) {
		this.ispId = ispId;
	}
	public String getBasic() {
		return basic;
	}
	public void setBasic(String basic) {
		this.basic = basic;
	}
	public String getReputation() {
		return reputation;
	}
	public void setReputation(String reputation) {
		this.reputation = reputation;
	}
	
}
