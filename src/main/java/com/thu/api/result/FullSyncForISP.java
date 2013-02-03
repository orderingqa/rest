package com.thu.api.result;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class FullSyncForISP {
    private Long msgCode;
    private String msg;
    private Double version;
    private Long icId;
    private List <ISPServerObject> add;
    private List <ISPServerObject> update;
    private List <Long> delete;
    
	public List<ISPServerObject> getUpdate() {
		return update;
	}
	public void setUpdate(List<ISPServerObject> update) {
		this.update = update;
	}
	public List<Long> getDelete() {
		return delete;
	}
	public void setDelete(List<Long> delete) {
		this.delete = delete;
	}
	public Long getMsgCode() {
		return msgCode;
	}
	public void setMsgCode(Long msgCode) {
		this.msgCode = msgCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Double getVersion() {
		return version;
	}
	public void setVersion(Double d) {
		this.version = d;
	}
	public Long getIcId() {
		return icId;
	}
	public void setIcId(Long icId) {
		this.icId = icId;
	}
	public List<ISPServerObject> getAdd() {
		return add;
	}
	public void setAdd(List<ISPServerObject> add) {
		this.add = add;
	}
}
