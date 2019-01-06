package de.ostfale.pattern.builder.cascaded;

import java.util.List;

/**
 * Main class
 * Created : 03.09.2018
 *
 * @author : usauerbrei
 */
public class Main {

	public static void main(String[] args) {
		Engine engine = Engine.newBuilder().withPower(100).withType(5).build();

		List<Wheel> wheels = WheelListBuilder.newBuilder()
				.addWheel().withType(1).withSize(2).withColour(2).addWheelToList()
				.addWheel().withType(1).withSize(2).withColour(2).addWheelToList()
				.addWheel().withType(1).withSize(2).withColour(2).addWheelToList()
				.addWheel().withType(1).withSize(2).withColour(2).addWheelToList()
				.build();

		Car car = Car.newBuilder()
				.withEngine(engine)
				.withWheelList(wheels)
				.build();

		System.out.println("Car: " + car);
	}
}
