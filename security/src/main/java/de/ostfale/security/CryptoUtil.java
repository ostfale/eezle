package de.ostfale.security;

import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * some cryptography utility functions
 * Created by Uwe Sauerbrei on 31.12.2017
 */
public class CryptoUtil {

    public static final String ALG_SHA1 = "SHA-1";
    public static final String ALG_SHA256 = "SHA-256";
    public static final String CHAR_SET = "UTF-8";
    public static final String ALGORITHM = "RSA";
    public static final Integer KEY_LENGTH = 1024;

    public PrivateKey getStoredPrivateKey(String filePath) {
        byte[] keydata = getKeyData(filePath);
        PKCS8EncodedKeySpec encodedPrivateKey = new PKCS8EncodedKeySpec(keydata);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePrivate(encodedPrivateKey);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PublicKey getStoredPublicKey(String filePath) {
        byte[] keydata = getKeyData(filePath);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec encodedPublicKey = new X509EncodedKeySpec(keydata);
            return keyFactory.generatePublic(encodedPublicKey);
        } catch (NoSuchAlgorithmException | NullPointerException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void storeKeyPairs(String dirPath) {
        KeyPair keyPair = generateKeyPairs();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        storeKeys(dirPath + File.separator + "publickey.key", publicKey);
        storeKeys(dirPath + File.separator + "privatekey.key", privateKey);
    }

    private KeyPair generateKeyPairs() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
            keyGen.initialize(KEY_LENGTH);
            return keyGen.generateKeyPair();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void storeKeys(String filePath, Key key) {
        byte[] keyBytes = key.getEncoded();
        OutputStream outStream = null;
        try {
            outStream = new FileOutputStream(filePath);
            outStream.write(keyBytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outStream != null) {
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private byte[] getKeyData(String filePath) {
        File file = new File(filePath);
        byte[] buffer = new byte[(int) file.length()];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer;
    }

}
