package com.thu.api.result;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ICISPUpdate {
    private long icId;
    private List<SimpleISPUpdate> ispList;
	public long getIcId() {
		return icId;
	}
	public void setIcId(long icId) {
		this.icId = icId;
	}
	public List<SimpleISPUpdate> getIspList() {
		return ispList;
	}
	public void setIspList(List<SimpleISPUpdate> ispList) {
		this.ispList = ispList;
	}
}
