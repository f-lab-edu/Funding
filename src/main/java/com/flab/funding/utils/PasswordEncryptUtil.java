package com.flab.funding.utils;

import com.flab.funding.domain.user.exception.PasswordEncryptException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class PasswordEncryptUtil {
    public static String encryptSHA256(String password) {
        return encrypt(password, "SHA-256");
    }

    public static String encryptMD5(String password) {
        return encrypt(password, "MD5");
    }

    public static String encrypt(String inputData, String messageDigest) {
        try {
            MessageDigest md = MessageDigest.getInstance(messageDigest);
            md.update(inputData.getBytes());
            byte[] hashValue = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : hashValue) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new PasswordEncryptException(e.toString());
        }
    }
}