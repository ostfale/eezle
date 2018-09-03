package de.ostfale.pattern.builder.cascaded;

import java.util.List;

/**
 * Domain object for builder pattern
 * Created : 03.09.2018
 *
 * @author : usauerbrei
 */
public class Car {

	private Engine engine;
	private List<Wheel> wheelList;

	private Car(Builder builder) {
		setEngine(builder.engine);
		setWheelList(builder.wheelList);
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static Builder newBuilder(Car copy) {
		Builder builder = new Builder();
		builder.engine = copy.engine;
		builder.wheelList = copy.wheelList;
		return builder;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public List<Wheel> getWheelList() {
		return wheelList;
	}

	public void setWheelList(List<Wheel> wheelList) {
		this.wheelList = wheelList;
	}

	@Override
	public String toString() {
		return "Car{" +
				"engine=" + engine +
				", wheelList=" + wheelList +
				'}';
	}

	public static final class Builder {
		private Engine engine;
		private List<Wheel> wheelList;

		private Builder() {

		}

		public Builder withEngine(Engine engine) {
			this.engine = engine;
			return this;
		}

		public Builder withWheelList(List<Wheel> wheelList) {
			this.wheelList = wheelList;
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}

}
