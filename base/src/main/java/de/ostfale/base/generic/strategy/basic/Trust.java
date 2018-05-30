package de.ostfale.base.generic.strategy.basic;

/**
 * //TODO INSERT DESCRIPTION
 * Created : 25.05.2018
 *
 * @author : usauerbrei
 */
public class Trust extends TaxPayer {

	private boolean nonProfit;

	public Trust(long income, boolean nonProfit) {
		super(income);
		this.nonProfit = nonProfit;
	}

	public boolean isNonProfit() {
		return nonProfit;
	}
}
