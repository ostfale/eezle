package de.ostfale.ws;

import javax.xml.ws.Endpoint;

/**
 * Main class publishing web service
 * Created by Uwe Sauerbrei on 09.01.2018
 */
public class UCMain {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9901/UC", new UnitConverterImpl());
    }
}
