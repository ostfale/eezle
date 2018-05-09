package de.ostfale.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

/**
 * Example for argument capturing
 * Created : 09.05.2018
 *
 * @author : usauerbrei
 */
@DisplayName("Example for argument capturing")
public class CaptureArguments {

	private TodoService todoServiceMock;
	private List<String> todos;

	@BeforeEach
	void setUp() {
		todoServiceMock = mock(TodoService.class);
		todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to fly");
	}

	@Test
	@DisplayName("Verify delete with BDD syntax")
	void testDeletTodosNotRelatedToSpringBDDStyle() {

		// given
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoServiceImpl todoService = new TodoServiceImpl(todoServiceMock);

		//when
		todoService.deleteTodosNotRelatedToSpring("Dummy");

		//then
		then(todoServiceMock).should().deleteTodo("Learn to fly");
		then(todoServiceMock).should(atLeastOnce()).deleteTodo("Learn to fly");
		then(todoServiceMock).should(times(1)).deleteTodo("Learn to fly");
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring");
	}

	@Test
	@DisplayName("Capture argument in  BDD syntax")
	void testDeletTodosNotRelatedToSpringBDDStyle_CaptureArg() {

		// Declare Argument Captor
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

		// given
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoServiceImpl todoService = new TodoServiceImpl(todoServiceMock);

		//when
		todoService.deleteTodosNotRelatedToSpring("Dummy");

		//then
		then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
		assertEquals(stringArgumentCaptor.getValue(), "Learn to fly");
	}

	@Test
	@DisplayName("Capture argument in  BDD syntax")
	void testDeletTodosNotRelatedToSpringBDDStyle_Capture_MultipleTimes() {

		// Declare Argument Captor
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

		// given
		todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to fly", "Learn to dive");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoServiceImpl todoService = new TodoServiceImpl(todoServiceMock);

		//when
		todoService.deleteTodosNotRelatedToSpring("Dummy");

		//then
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		assertEquals(stringArgumentCaptor.getAllValues().size(), 2);
	}
}
