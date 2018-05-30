package de.ostfale.base.generic.strategy.basic;

/**
 * //TODO INSERT DESCRIPTION
 * Created : 25.05.2018
 *
 * @author : usauerbrei
 */
public class DefaultTaxStrategy<P extends TaxPayer> implements TaxStrategy<P> {

	private static final double RATE = 0.40;

	@Override
	public long computeTax(P taxPayer) {
		return Math.round(taxPayer.getIncome() * RATE);
	}
}
