package de.ostfale.security.xml.digitalSignature;

import de.ostfale.security.CryptoUtil;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.util.Collections;

/**
 * This class is used to provide convenient methods to digitally sign an XML  document.
 * Created by Uwe Sauerbrei on 31.12.2017
 */
public class DigitalSignatureGenerator {

    public void generateXMLDigitalSignature(String originalXmlFilePath, String destnSignedXmlFilePath, String privateKeyFilePath, String publicKeyFilePath) {
        // get XML original document
        Document document = getXmlDocument(originalXmlFilePath);
        // create XML signature factory
        XMLSignatureFactory xmlSignatureFactory = XMLSignatureFactory.getInstance("DOM");
        PrivateKey privateKey = new CryptoUtil().getStoredPrivateKey(privateKeyFilePath);
        DOMSignContext domSignContext = new DOMSignContext(privateKey, document.getDocumentElement());
        try {
            Reference reference = xmlSignatureFactory.newReference("", xmlSignatureFactory.newDigestMethod(DigestMethod.SHA1, null),
                    Collections.singletonList(xmlSignatureFactory.newTransform(Transform.ENVELOPED,
                            (TransformParameterSpec) null)), null, null);
            SignedInfo signedInfo = xmlSignatureFactory.newSignedInfo(
                    xmlSignatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE,
                            (C14NMethodParameterSpec) null),
                    xmlSignatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                    Collections.singletonList(reference));
            // pass the public key file path
            KeyInfo keyInfo = getKeyInfo(xmlSignatureFactory, publicKeyFilePath);
            // create new xml signature
            XMLSignature xmlSignature = xmlSignatureFactory.newXMLSignature(signedInfo, keyInfo);
            // sign the document
            xmlSignature.sign(domSignContext);
            storeSignedDocument(document, destnSignedXmlFilePath);

        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException | XMLSignatureException | MarshalException e) {
            e.printStackTrace();
        }

    }

    private Document getXmlDocument(String xmlFilePath) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setNamespaceAware(true);
        try {
            return builderFactory.newDocumentBuilder().parse(new FileInputStream(xmlFilePath));
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    private KeyInfo getKeyInfo(XMLSignatureFactory xmlSignatureFactory, String publicKeyPath) {
        PublicKey publicKey = new CryptoUtil().getStoredPublicKey(publicKeyPath);
        KeyInfoFactory keyInfoFactory = xmlSignatureFactory.getKeyInfoFactory();
        try {
            KeyValue keyValue = keyInfoFactory.newKeyValue(publicKey);
            return keyInfoFactory.newKeyInfo(Collections.singletonList(keyValue));
        } catch (KeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void storeSignedDocument(Document document, String destnSignedXmlFilePath) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult streamResult = new StreamResult(new File(destnSignedXmlFilePath));
            transformer.transform(new DOMSource(document), streamResult);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
