package de.ostfale.mockito;

import java.util.List;

/**
 * Simple service pojo
 * Created : 02.05.2018
 *
 * @author : usauerbrei
 */
public interface TodoService {

	List<String> retrieveTodos(String user);

	void deleteTodo(String todo);
}
