package de.ostfale.base.generic.strategy.advanced;

/**
 * //TODO INSERT DESCRIPTION
 * Created : 25.05.2018
 *
 * @author : usauerbrei
 */
public class Person extends TaxPayer<Person> {

	public Person(long income, TaxStrategy<Person> strategy) {
		super(income, strategy);
	}

	@Override
	protected Person getThis() {
		return this;
	}
}
