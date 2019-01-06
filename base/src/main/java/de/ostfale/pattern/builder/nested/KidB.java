package de.ostfale.pattern.builder.nested;

/**
 * Example for child class
 * Created : 03.09.2018
 *
 * @author : usauerbrei
 */
public class KidB {

	private String note;

	private KidB(Builder builder) {
		note = builder.note;
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static final class Builder extends NestedBuilder<Parent.Builder, KidB> {

		private String note;

		private Builder() {
		}

		public Builder withNote(String note) {
			this.note = note;
			return this;
		}

		public KidB build() {
			return new KidB(this);
		}
	}

}
