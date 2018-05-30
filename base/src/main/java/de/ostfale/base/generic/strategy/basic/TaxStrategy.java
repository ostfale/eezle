package de.ostfale.base.generic.strategy.basic;

/**
 * //TODO INSERT DESCRIPTION
 * Created : 25.05.2018
 *
 * @author : usauerbrei
 */
public interface TaxStrategy<P extends TaxPayer> {

	long computeTax(P p);
}
