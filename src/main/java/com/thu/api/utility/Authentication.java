package com.thu.api.utility;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.thu.api.domain.Token;
import com.thu.api.mock.MockISPServerObject;
import com.thu.api.result.ISPServerObject;

public class Authentication {
	// how to let rest "get" receive parameter like ticket
	// how to calcuate ticket based on token?

	@PersistenceContext
	protected EntityManager em;

	public boolean isValidateTicket(String ticket, Long facebookId) {
		try {
			Token thuToken = null; 
//			thuToken = em.find(Token.class, facebookId);
//			if (thuToken != null) {
				// validate the expireTime, if not expire
//				String ticketFromDB = calculateTicketByToken(thuToken.getToken());
				String ticketFromDB = calculateTicketByToken("f62d90d6-4856-49f2-a4ce-52fbdd316090");
				if (ticket.equals(ticketFromDB)) return true;
				return false;
				// if expire, goto else branch
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private String calculateTicketByToken(String token) {
		byte[] key = "thuencry".getBytes();
		SecretKey secretKey = new SecretKeySpec(key, "DES");
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] ticketArray = cipher.doFinal(token.getBytes());
			String ticket = byte2HexStr(ticketArray, 0, 32);
			return ticket;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		// String tokenFromDB = "f62d90d6-4856-49f2-a4ce-52fbdd316090";
		String ticket = "6003CAA2BBBECE6E72F00390A1687A8B";
		Authentication auth = new Authentication();
		System.out.println(auth.isValidateTicket(ticket, 1L));
		// String token = UUID.randomUUID().toString();
		// System.out.println(tokenFromDB);
		// byte[] key = "thuencry".getBytes();
		// SecretKey secretKey = new SecretKeySpec(key, "DES");
		// Cipher cipher = Cipher.getInstance("DES");
		// cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		// byte[] ticketArray = cipher.doFinal(tokenFromDB.getBytes());
		// // client side will generate ticket like below
		// System.out.println("ticket = "+byte2HexStr32fixed(ticketArray));

		// just a validate for the DES algorighms
		// cipher.init(Cipher.DECRYPT_MODE, secretKey);
		// System.out.println(new String(cipher.doFinal(ticketArray)));
	}

	/**
	 * 字节数组转化为大写16进制字符串
	 * 
	 * @param b
	 * @return
	 */
	public static String byte2HexStr(byte[] b, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < b.length; i++) {
			String s = Integer.toHexString(b[i] & 0xFF);
			if (s.length() == 1) {
				sb.append("0");
			}
			sb.append(s.toUpperCase());
		}

		return (sb.toString()).substring(start, end);
	}
}
