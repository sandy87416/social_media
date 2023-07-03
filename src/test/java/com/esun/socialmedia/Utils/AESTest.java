package com.esun.socialmedia.Utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AESTest {

    @Test
    void encrypt() {
        String password = "testpassword";
        String encryptedString = AES.encrypt(password);
        assertEquals("/8nfKuSsHNamZFQDUeSIfA==", encryptedString);
    }

    @Test
    void decrypt() {
        String password = "testpassword";
        String encryptedString = AES.encrypt(password);
        assertEquals("/8nfKuSsHNamZFQDUeSIfA==", encryptedString);
        String decryptedString = AES.decrypt(encryptedString);
        assertEquals(password, decryptedString);
    }
}