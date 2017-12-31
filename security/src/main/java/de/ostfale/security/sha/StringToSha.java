package de.ostfale.security.sha;

import de.ostfale.security.CryptoUtil;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Hashing a string with sha1
 * Created by Uwe Sauerbrei on 31.12.2017
 */
public class StringToSha {

    private static final String TEST_STRING = "This is a string for hashing";

    public static void main(String[] args) {
        new StringToSha().doIt();
    }

    private void doIt() {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(CryptoUtil.ALG_SHA1);
            messageDigest.update(TEST_STRING.getBytes(CryptoUtil.CHAR_SET), 0, TEST_STRING.length());
            String sha1 = DatatypeConverter.printHexBinary(messageDigest.digest());
            System.out.println("Original Text: " + TEST_STRING + "\nDigest: \n\t" + sha1);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
