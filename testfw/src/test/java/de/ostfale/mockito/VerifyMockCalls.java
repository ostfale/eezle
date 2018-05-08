package de.ostfale.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Verify if a mock has been called
 * Created : 08.05.2018
 *
 * @author : usauerbrei
 */
@DisplayName("Verify mock calls")
public class VerifyMockCalls {

	@Test
	void testDeletTodosNotRelatedToSpring() {

		// given
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to fly");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoServiceImpl todoService = new TodoServiceImpl(todoServiceMock);

		//when
		todoService.deleteTodosNotRelatedToSpring("Dummy");

		//then
		verify(todoServiceMock).deleteTodo("Learn to fly");
		verify(todoServiceMock, atLeastOnce()).deleteTodo("Learn to fly");
		verify(todoServiceMock, times(1)).deleteTodo("Learn to fly");
		verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
		verify(todoServiceMock, never()).deleteTodo("Learn Spring");
	}
}
