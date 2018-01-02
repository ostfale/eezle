package de.ostfale.security;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

/**
 * Create an asymmetric key pair using RSA algorithm
 * Created by Uwe Sauerbrei on 02.01.2018
 */
public class AsymKeyGenerator {

    private final PrivateKey privateKey;
    private final PublicKey publicKey;

    public AsymKeyGenerator(String algorithm, int length) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        keyPairGenerator.initialize(length);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        this.publicKey = keyPair.getPublic();
        this.privateKey = keyPair.getPrivate();
    }

    public void writeKeysToFile(String path, byte[] key) throws IOException {
        File file = new File(path);
        file.getParentFile().mkdirs();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(key);
        fos.flush();
        fos.close();
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
}
