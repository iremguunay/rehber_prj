package com.bilgeadam.rehberprj.test;

import com.bilgeadam.rehberprj.sec.AES;

public class AESTest {

    public static void main(String[] args) {
        final String secretKey = "gizli_bahce";

        String originalString = "admin1234";
        String encryptedString = AES.encrypt(originalString, secretKey);
        String decryptedString = AES.decrypt(encryptedString, secretKey);

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }
}
