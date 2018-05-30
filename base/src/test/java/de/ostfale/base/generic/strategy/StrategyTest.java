package de.ostfale.base.generic.strategy;

import de.ostfale.base.generic.strategy.basic.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * //TODO INSERT DESCRIPTION
 * Created : 25.05.2018
 *
 * @author : usauerbrei
 */
@DisplayName("Test Generic Strategy pattern")
class StrategyTest {

	private Person person;
	private Trust nonProfit;
	private Trust forProfit;

	@BeforeEach
	void setUp() {
		person = new Person(10000000);
		nonProfit = new Trust(10000000, true);
		forProfit = new Trust(10000000, false);
	}

	@Test
	void testTayStrategies() {
		TaxStrategy<Person> defaultStrategy = new DefaultTaxStrategy<>();
		TaxStrategy<Person> dodgingStrategy = new DodgingTaxStrategy<>();
		assertEquals(4000000, defaultStrategy.computeTax(person));
		assertEquals(0, dodgingStrategy.computeTax(person));


	}

	@Test
	void testTrustStrategies() {
		TaxStrategy<Trust> trustStrategy = new TrustTaxStrategy();
		assertEquals(0, trustStrategy.computeTax(nonProfit));
		assertEquals(4000000, trustStrategy.computeTax(forProfit));
	}
}