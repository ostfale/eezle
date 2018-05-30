package de.ostfale.base.generic.strategy.advanced;

/**
 * Default strategy
 * Created : 25.05.2018
 *
 * @author : usauerbrei
 */
public class DefaultTaxStrategy<P extends TaxPayer<P>> implements TaxStrategy<P> {

	private static final double RATE = 0.40;

	@Override
	public long computeTax(P p) {
		return Math.round(p.getIncome() * RATE);
	}
}
