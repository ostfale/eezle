package de.ostfale.base.generic.strategy.advanced;


/**
 * //TODO INSERT DESCRIPTION
 * Created : 25.05.2018
 *
 * @author : usauerbrei
 */
public abstract class TaxPayer<P extends TaxPayer<P>> {

	public long income;
	private TaxStrategy<P> strategy;

	public TaxPayer(long income, TaxStrategy<P> strategy) {
		this.income = income;
		this.strategy = strategy;
	}

	protected abstract P getThis();

	public long getIncome() {
		return income;
	}
}
