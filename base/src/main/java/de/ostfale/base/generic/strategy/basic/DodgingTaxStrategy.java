package de.ostfale.base.generic.strategy.basic;

/**
 * //TODO INSERT DESCRIPTION
 * Created : 25.05.2018
 *
 * @author : usauerbrei
 */
public class DodgingTaxStrategy<P extends TaxPayer> implements TaxStrategy<P> {

	@Override
	public long computeTax(P p) {
		return 0;
	}
}
