package de.ostfale.base.generic.strategy.basic;

/**
 * //TODO INSERT DESCRIPTION
 * Created : 25.05.2018
 *
 * @author : usauerbrei
 */
public class TrustTaxStrategy extends DefaultTaxStrategy<Trust> {

	public long computeTax(Trust trust) {
		return trust.isNonProfit() ? 0 : super.computeTax(trust);
	}
}
