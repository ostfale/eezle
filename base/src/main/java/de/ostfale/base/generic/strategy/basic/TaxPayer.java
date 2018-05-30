package de.ostfale.base.generic.strategy.basic;

/**
 * Abstract domain class
 * Created : 25.05.2018
 *
 * @author : usauerbrei
 */
public abstract class TaxPayer {

	private long income;  // in cents

	TaxPayer(long income) {
		this.income = income;
	}

	public long getIncome() {
		return income;
	}
}
