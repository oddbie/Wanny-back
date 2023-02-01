package com.oddbie.wannyback;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;

public class JasyptConfigTest {
    @Test
    void contextLoads() {
    }

    private String jasyptPassword = "your-jasypt-password";

    @Test
    void jasypt() {
        String url = "jdbc:mysql:localhost:3306";
        String username = "your-id-as-string";
        String password = "your-password-as-string";

        System.out.println("url: " + jasyptEnc(url));
        System.out.println("username: " + jasyptEnc(username));
        System.out.println("password: " + jasyptEnc(password));
    }

    public String jasyptEnc(String value) {
        String key = jasyptPassword;
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }
}
