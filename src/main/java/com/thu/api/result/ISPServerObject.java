package com.thu.api.result;

import javax.xml.bind.annotation.XmlRootElement;

import com.thu.api.domain.BusinessAddress;

@XmlRootElement
public class ISPServerObject {
	private Long ispId;
	private String firstName;
	private String lastName;
	private String office;
	private String mobile;
	private String email;
	private String website;
	private String avatar;
	private String profession;
	private BusinessAddress address;
	private Integer ratingChange;
	private Double rating;
	private Integer clients;
	private Integer friendClients;
	private Integer recommends;
	private Integer friendRecommends;
	private Integer recommendStatus;

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

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Integer getRatingChange() {
		return ratingChange;
	}

	public void setRatingChange(Integer ratingChange) {
		this.ratingChange = ratingChange;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getClients() {
		return clients;
	}

	public void setClients(Integer clients) {
		this.clients = clients;
	}

	public Integer getFriendClients() {
		return friendClients;
	}

	public void setFriendClients(Integer friendClients) {
		this.friendClients = friendClients;
	}

	public Integer getRecommends() {
		return recommends;
	}

	public void setRecommends(Integer recommends) {
		this.recommends = recommends;
	}

	public Integer getFriendRecommends() {
		return friendRecommends;
	}

	public void setFriendRecommends(Integer friendRecommends) {
		this.friendRecommends = friendRecommends;
	}

	public Integer getRecommendStatus() {
		return recommendStatus;
	}

	public void setRecommendStatus(Integer recommendStatus) {
		this.recommendStatus = recommendStatus;
	}

	public Long getIspId() {
		return ispId;
	}

	public void setIspId(Long ispId) {
		this.ispId = ispId;
	}

	public BusinessAddress getAddress() {
		return address;
	}

	public void setAddress(BusinessAddress address) {
		this.address = address;
	}
}