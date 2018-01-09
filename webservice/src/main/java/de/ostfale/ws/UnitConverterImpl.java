package de.ostfale.ws;

import javax.jws.WebService;

/**
 * Web service implementation bean (SIB)
 * Created by Uwe Sauerbrei on 09.01.2018
 */
@WebService(endpointInterface = "de.ostfale.ws.UnitConverter")
public class UnitConverterImpl implements UnitConverter {

    @Override
    public double c2f(double degrees) {
        return degrees * 9.0 / 5.0 + 32;
    }

    @Override
    public double cm2in(double cm) {
        return cm / 2.54;
    }

    @Override
    public double f2c(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    @Override
    public double in2cm(double in) {
        return in * 2.54;
    }
}
