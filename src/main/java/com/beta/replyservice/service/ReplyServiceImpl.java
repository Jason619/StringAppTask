package com.beta.replyservice.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements IReplyService {
	
	/**
	 * Formats the response message based on the given input message.
	 *
	 * @param message The input message to be formatted.
	 * @return The formatted response message.
	 */
	@Override
	public String getFormattedResponse(String message) {
		String[] extract = message.split("-");
		String operationType = extract[0],messageToProcess = extract[1];

		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		for (char c : operationType.toCharArray()) {
			if (c == '1') {
				messageToProcess = getReverse(messageToProcess);
			} else {
				messageToProcess = getMd5(messageToProcess, messageDigest);
			}
		}
		return messageToProcess;
	}
	/**
	 * Computes the MD5 hash of the given string.
	 *
	 * @param str The input string to be hashed.
	 * @param messageDigest The MessageDigest instance for MD5 hashing.
	 * @return The MD5 hash of the input string.
	 */
	public String getMd5(String str, MessageDigest messageDigest) {
		byte[] outputMd5 = messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
		BigInteger bigInteger = new BigInteger(1, outputMd5);
		return String.format("%0" + (outputMd5.length << 1) + "x", bigInteger);
	}
	/**
	 * Reverses the characters of the given string.
	 *
	 * @param str The input string to be reversed.
	 * @return The reversed string.
	 */
	public String getReverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}
}