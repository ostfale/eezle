package de.ostfale.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Example for a Spy test which operates on real objects and allows to change the internal state
 * Created : 14.05.2018
 *
 * @author : usauerbrei
 */
@DisplayName("Mockito Spy test")
public class MockitoSpyTest {

	@Test
	void basicSpyTest() {
		List arrayListSpy = spy(ArrayList.class);
		// mocks return default values
		assertEquals(0, arrayListSpy.size());
		arrayListSpy.add("dummy");
		assertEquals(1, arrayListSpy.size());
	}

	@Test
	void verifySpyTest() {
		List arrayListSpy = spy(ArrayList.class);
		assertEquals(0, arrayListSpy.size());
		arrayListSpy.add("dummy");
		verify(arrayListSpy, never()).clear();
	}
}
