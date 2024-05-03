package com.example.synu.config;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Config {

//    public static void main(String[] args) {
//        String input = "bb";
//        String md5Hash = MD5Config.getMD5(input);
//        System.out.println("MD5 hash of \"" + input + "\" is: " + md5Hash);
//    }

    public static String getMD5(String input) {
        try {
            // 获取 MD5 MessageDigest 实例  
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 更新数据  
            md.update(input.getBytes());
            // 完成哈希计算  
            byte[] digest = md.digest();
            // 转换为16进制字符串  
            BigInteger number = new BigInteger(1, digest);
            String hashtext = number.toString(16);
            // 填充为32位  
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}