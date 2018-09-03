package de.ostfale.pattern.builder.cascaded;

/**
 * Domain object for builder pattern
 * Created : 03.09.2018
 *
 * @author : usauerbrei
 */
public class Wheel {

	private int size;
	private int type;
	private int colour;

	private Wheel(Builder builder) {
		setSize(builder.size);
		setType(builder.type);
		setColour(builder.colour);
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static Builder newBuilder(Wheel copy) {
		Builder builder = new Builder();
		builder.size = copy.size;
		builder.type = copy.type;
		builder.colour = copy.colour;
		return builder;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getColour() {
		return colour;
	}

	public void setColour(int colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Wheel{" +
				"size=" + size +
				", type=" + type +
				", colour=" + colour +
				'}';
	}

	public static final class Builder {
		private int size;
		private int type;
		private int colour;

		private WheelListBuilder wheelListBuilder;

		public WheelListBuilder addWheelToList(){
			this.wheelListBuilder.addWheel(this.build());
			return this.wheelListBuilder;
		}

		private Builder() {
		}

		public Builder withSize(int size) {
			this.size = size;
			return this;
		}

		public Builder withType(int type) {
			this.type = type;
			return this;
		}

		public Builder withColour(int colour) {
			this.colour = colour;
			return this;
		}

		public Wheel build() {
			return new Wheel(this);
		}

		public void withWheelListBuilder(WheelListBuilder wheelListBuilder) {
			this.wheelListBuilder = wheelListBuilder;
		}
	}
}
