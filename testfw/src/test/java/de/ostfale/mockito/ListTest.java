package de.ostfale.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Mockito tests for the List interface
 * Created : 07.05.2018
 *
 * @author : usauerbrei
 */
@DisplayName("Stubbing variations with Mockito")
public class ListTest {

	List listMock;

	@BeforeEach
	void setUp() {
		listMock = mock(List.class);
	}

	@Test
	@DisplayName("mock return test")
	void test_mockListSizeMethod() {
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}

	@Test
	@DisplayName("test return multiple values")
	void test_returnMultipleValues() {
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}

	@Test
	@DisplayName("test argument matcher")
	void test_mockListGet() {
		when(listMock.get(anyInt())).thenReturn("in 28minutes");
		assertEquals("in 28minutes", listMock.get(0));
		assertEquals("in 28minutes", listMock.get(666));
	}

	@Test
	@DisplayName("test throwing exception JUnit 5 style")
	void test_throwingException() {

		// argument matcher with anyInt()
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));

		assertThrows(RuntimeException.class,
				() -> {
					listMock.get(0);
				});
	}
}
