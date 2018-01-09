package de.ostfale.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Web service endpoint interface (SEI)
 * Created by Uwe Sauerbrei on 09.01.2018
 */
@WebService
public interface UnitConverter {

    @WebMethod
    double c2f(double degrees);

    @WebMethod
    double cm2in(double cm);

    @WebMethod
    double f2c(double fahrenheit);

    @WebMethod
    double in2cm(double in);
}
