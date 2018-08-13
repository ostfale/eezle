package de.ostfale.jackson.mixin;

/**
 * Consider you want serialize or deserialize a User POJO in a Spring Boot application. In the preceding code,
 * User is a typical POJO but is not designed to be used with data binding. The User class doesn’t have the default
 * constructor and neither any getter and setter methods.
 * Let’s assume that you don’t have access to the source code of the User POJO. Or there is some constraint disallowing
 * you to modify the existing POJO. In this scenario, you can’t serialize or deserialize a User object through annotations
 * or by defining your own custom serializer and deserializer.
 * Created : 13.08.2018
 *
 * @author : usauerbrei
 */
public class User {
	private long id;
	private String name;
	private int age;
	private String gender;
	private String email;
	private String phoneNo;

	public User(long id, String name, int age, String gender, String email, String phoneNo) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", gender='" + gender + '\'' +
				", email='" + email + '\'' +
				", phoneNo=" + phoneNo +
				'}';
	}
}
