package de.ostfale.base.generic.strategy.advanced;

/**
 * //TODO INSERT DESCRIPTION
 * Created : 25.05.2018
 *
 * @author : usauerbrei
 */
public class Trust extends TaxPayer<Trust> {

	private boolean nonProfit;

	public Trust(long income, boolean nonProfit,TaxStrategy<Trust> strategy) {
		super(income, strategy);
		this.nonProfit = nonProfit;
	}

	@Override
	protected Trust getThis() {
		return this;
	}

	public boolean isNonProfit() {
		return nonProfit;
	}
}
