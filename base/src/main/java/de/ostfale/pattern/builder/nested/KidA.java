package de.ostfale.pattern.builder.nested;


/**
 * Example class
 * Created : 03.09.2018
 *
 * @author : usauerbrei
 */
public class KidA {

	private String note;

	private KidA(Builder builder) {
		note = builder.note;
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static final class Builder extends NestedBuilder<Parent.Builder, KidA> {

		private String note;

		private Builder() {
		}

		public Builder withNote(String note) {
			this.note = note;
			return this;
		}

		public KidA build() {
			return new KidA(this);
		}
	}
}
