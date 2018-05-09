package de.ostfale.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

/**
 * Using annotations with Mockito
 * Created : 09.05.2018
 *
 * @author : usauerbrei
 */
@DisplayName("Mockito with annotations")
public class InjectMocksExample {

	@Mock
	private TodoService todoServiceMock;

	@Captor
	private ArgumentCaptor<String> stringArgumentCaptor;


	@InjectMocks
	private TodoServiceImpl todoService;

	private List<String> todos;


	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to fly");
	}

	@Test
	void testRetrieveTodosUsingMock() {
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		//When
		List<String> filteredTodos = todoService.retrieveTodosRelatedToSpring("Dummy");

		//Then
		assertEquals(2, filteredTodos.size());
	}

	@Test
	@DisplayName("Capture argument in  BDD syntax")
	void testDeletTodosNotRelatedToSpringBDDStyle_CaptureArg() {

		// given
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoServiceImpl todoService = new TodoServiceImpl(todoServiceMock);

		//when
		todoService.deleteTodosNotRelatedToSpring("Dummy");

		//then
		then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
		assertEquals(stringArgumentCaptor.getValue(), "Learn to fly");
	}
}
