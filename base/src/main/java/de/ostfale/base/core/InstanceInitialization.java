package de.ostfale.base.core;

import lombok.extern.slf4j.Slf4j;

/**
 * Shows different ways to initialize an instance
 * Created : 06.03.2018
 *
 * @author : usauerbrei
 */
@Slf4j
public class InstanceInitialization {

	public static void main(String[] args) {
		new InstanceInitialization().doIt();
	}

	private void doIt() {
		useInitialization();
		useStaticFactory();
	}

	private void useInitialization() {
		new FooInstanceInit();
	}

	private void useStaticFactory() {
		Foo foo = Foo.withName("myFoo");
		log.info(foo.toString());
	}
}

/**
 * In Java, as with most object-oriented programming languages, objects are exclusively instantiated using a constructor
 * (with some critical exceptions, such as Java object deserialization). Even when we create static factory methods to create objects,
 * we are simply wrapping a call to the constructor of an object to instantiate it.
 */
class Foo {
	private final String name;

	private Foo(String name) {
		this.name = name;
	}

	public static Foo withName(String name) {
		return new Foo(name);
	}

	@Override
	public String toString() {
		return "Created by factory : " + name;
	}
}

/**
 * Instance initializers are specified by adding initialization logic within a set of braces within the definition of a class.
 * When the object is instantiated, its instance initializers are called first, followed by its constructors.
 * Note that more than one instance initializer may be specified, in which case, each is called in the order it appears within
 * the class definition. Apart from instance initializers, we can also create static initializers, which are executed when the class
 * is loaded into memory.
 */
@Slf4j
class FooInstanceInit {
	{
		log.info("Foo::instance");
	}

	static {
		log.info("Foo:static");
	}

	FooInstanceInit() {
		log.info("Foo::constructor");
	}
}