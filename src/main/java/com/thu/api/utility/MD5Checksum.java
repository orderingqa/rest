package com.thu.api.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.thu.api.mock.MockISPServerObject;
import com.thu.api.result.ISPServerObject;

public class MD5Checksum {

	public static void main(String[] args) {
		ISPServerObject iso = MockISPServerObject.getServerSideISP();
		String text = null;
		String firstName = iso.getFirstName() != null ? iso.getFirstName() : "";
		String lastName = iso.getLastName() != null ? iso.getLastName() : "";
		String office = iso.getOffice() != null ? iso.getOffice() : "";
		String mobile = iso.getMobile() != null ? iso.getMobile() : "";
		String email = iso.getEmail() != null ? iso.getEmail() : "";
		String website = iso.getWebsite() != null ? iso.getWebsite() : "";
		String avatar = iso.getAvatar() != null ? iso.getAvatar() : "";
		String profession = iso.getProfession() != null ? iso.getProfession()
				: "";
		text = firstName + lastName + office + mobile + email + website
				+ avatar + profession;
		if (iso.getAddress() != null) {
			String country = iso.getAddress().getCountry();
			String state = iso.getAddress().getState();
			String city = iso.getAddress().getCity();
			String line1 = iso.getAddress().getLine1();
			String zip = iso.getAddress().getZip();
			text += country + state + city + line1 + zip;
		}
		System.out
				.println("text:\n" + text + "\nmd5:\n" + getMD5Checksum(text));
	}

	// http://zhidao.baidu.com/question/70872207.html
	// http://wenku.baidu.com/view/3a76ef5477232f60ddcca121.html
	public static String getMD5Checksum(String text) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(text.getBytes());
			byte b[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，用字节表示就是 16 个字节
			return Authentication.byte2HexStr(b, 0, 32);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
