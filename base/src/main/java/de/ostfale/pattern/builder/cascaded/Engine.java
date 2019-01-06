package de.ostfale.pattern.builder.cascaded;

/**
 * Domain object for builder pattern
 * Created : 03.09.2018
 *
 * @author : usauerbrei
 */
	public class Engine {

	private int power;
	private int type;

	private Engine(Builder builder) {
		setPower(builder.power);
		setType(builder.type);
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static Builder newBuilder(Engine copy) {
		Builder builder = new Builder();
		builder.power = copy.power;
		builder.type = copy.type;
		return builder;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Engine{" +
				"power=" + power +
				", type=" + type +
				'}';
	}

	public static class Builder {

		private int power;
		private int type;

		private Builder() {

		}

		public Builder withPower(int power) {
			this.power = power;
			return this;
		}

		public Builder withType(int type) {
			this.type = type;
			return this;
		}

		public Engine build() {
			return new Engine(this);
		}
	}
}
