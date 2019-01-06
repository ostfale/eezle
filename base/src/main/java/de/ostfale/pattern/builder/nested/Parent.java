package de.ostfale.pattern.builder.nested;

/**
 * Parent class example
 * Created : 03.09.2018
 *
 * @author : usauerbrei
 */
public class Parent {

	private KidA kidA;
	private KidB kidB;

	public Parent(Builder builder) {
		kidA = builder.kidA;
		kidB = builder.kidB;
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static final class Builder {
		private KidA kidA;
		private KidB kidB;

		private Builder() {
		}

		public Parent build() {
			return new Parent(this);
		}

		public Builder withKidA(KidA kidA) {
			this.kidA = kidA;
			return this;
		}

		public Builder withKidB(KidB kidB) {
			this.kidB = kidB;
			return this;
		}

		// to add manually
		private KidA.Builder builderKidA = KidA.newBuilder().withParentBuilder(this);
		private KidB.Builder builderKidB = KidB.newBuilder().withParentBuilder(this);

		public KidA.Builder addKidA() {
			return this.builderKidA;
		}

		public KidB.Builder addKidB() {
			return this.builderKidB;
		}
	}

}
