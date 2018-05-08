package de.ostfale.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Mockito test for service implementation
 * Created : 07.05.2018
 *
 * @author : usauerbrei
 */
@DisplayName("Test service using Mockito")
class TodoServiceImplTest {

	@Test
	void test_RetrieveTodosUsingMock() {

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Whistle");

		TodoService mockTodoService = mock(TodoService.class);
		when(mockTodoService.retrieveTodos("Dummy")).thenReturn(todos);

		TodoServiceImpl service = new TodoServiceImpl(mockTodoService);
		List<String> filteredTodos = service.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}


	@Test
	void test_RetrieveTodosUsingMockBDD_Style() {

		//Given
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Whistle");
		TodoService mockTodoService = mock(TodoService.class);
		given(mockTodoService.retrieveTodos("Dummy")).willReturn(allTodos);
		TodoServiceImpl service = new TodoServiceImpl(mockTodoService);

		//When
		List<String> filteredTodos = service.retrieveTodosRelatedToSpring("Dummy");

		//Then
		assertEquals(2, filteredTodos.size());
	}
}