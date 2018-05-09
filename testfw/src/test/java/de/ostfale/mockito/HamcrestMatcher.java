package de.ostfale.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Example of Hamcrest matchers
 * Created : 09.05.2018
 *
 * @author : usauerbrei
 */
@DisplayName("Hamcrest matcher")
public class HamcrestMatcher {

	private List<Integer> scores;

	@BeforeEach
	void setUp() {
		scores = Arrays.asList(99, 100, 101, 666);
	}

	@Test
	@DisplayName("Test Hamcrest examples")
	void test_hamcrest_matcher() {

		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(99, 100));

		assertThat(scores, everyItem(greaterThan(90)));
		assertThat(scores, everyItem(lessThan(1000)));

	}

	@Test
	@DisplayName("Test Hamcrest string related examples")
	void test_hamcrest_matcher_string_related() {

		assertThat("", isEmptyString());
		assertThat(null, isEmptyOrNullString());

	}

	@Test
	@DisplayName("Test Hamcrest array related examples")
	void test_hamcrest_matcher_array_related() {

		Integer[] marks = {1, 2, 3, 4};

		assertThat(marks, arrayWithSize(4));
		assertThat(marks, arrayContaining(1, 2, 3, 4));
		assertThat(marks, arrayContainingInAnyOrder(4, 1, 2, 3));

	}
}
