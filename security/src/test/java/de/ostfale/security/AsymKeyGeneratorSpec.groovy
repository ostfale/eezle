package de.ostfale.security

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

/**
 * Test creation of pubic / private key
 * Created by Uwe Sauerbrei on 02.01.2018
 */

@Title('Unit test for public key creation service')
@Subject(AsymKeyGenerator)
class AsymKeyGeneratorSpec extends Specification {

    def "Test creation of a asymmetric key pair"() {
        given: "Algorithm and key length"
        final String algorithm = "RSA"
        final int keyLength = 1024
        when: "New key pair has been generated"
        AsymKeyGenerator keyGenerator = new AsymKeyGenerator(algorithm, keyLength)
        then: "A private and a public key will be created"
        keyGenerator.getPublicKey()
        keyGenerator.getPrivateKey()
    }

    /* public static void main(String[] args) {
         GenerateKeys gk;
         try {
             gk = new GenerateKeys(1024);
             gk.createKeys();
             gk.writeToFile("KeyPair/privateKey", gk.getPrivateKey().getEncoded());
             gk.writeToFile("KeyPair/publicKey", gk.getPublicKey().getEncoded());
         } catch (NoSuchAlgorithmException | IOException e) {
             System.out.println(e.getMessage());
         }
     }*/
}
