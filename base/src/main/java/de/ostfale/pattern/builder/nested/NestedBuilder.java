package de.ostfale.pattern.builder.nested;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Class enables complex builder hierarchies
 * Created : 03.09.2018
 *
 * @author : usauerbrei
 */
public abstract class NestedBuilder<T, V> {

	protected T parent;

	public abstract V build();

	/**
	 * Get the parent builder
	 *
	 * @return T instance of the parent builder
	 */
	public T done() {
		Class<?> parentClass = parent.getClass();
		try {
			V build = this.build();
			String methodName = "with" + build.getClass().getSimpleName();
			Method method = parentClass.getDeclaredMethod(methodName, build.getClass());
			method.invoke(parent, build);
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return parent;
	}

	/**
	 * Returns type specific builder
	 *
	 * @param parent builder object
	 * @param <P>    type of the parent builder
	 * @return builder object
	 */
	public <P extends NestedBuilder<T, V>> P withParentBuilder(T parent) {
		this.parent = parent;
		return (P) this;
	}
}
