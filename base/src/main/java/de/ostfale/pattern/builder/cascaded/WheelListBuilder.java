package de.ostfale.pattern.builder.cascaded;

import java.util.ArrayList;
import java.util.List;

/**
 * Separate builder
 * Created : 03.09.2018
 *
 * @author : usauerbrei
 */
public class WheelListBuilder {

	public static WheelListBuilder newBuilder() {
		return new WheelListBuilder();
	}

	public Wheel.Builder addWheel() {
		Wheel.Builder builder = Wheel.newBuilder();
		builder.withWheelListBuilder(this);
		return builder;
	}

	private WheelListBuilder() {
	}

	private List<Wheel> wheelList;

	public WheelListBuilder withNewList() {
		this.wheelList = new ArrayList<>(4);
		return this;
	}

	public WheelListBuilder withList(List wheelList) {
		this.wheelList = wheelList;
		return this;
	}

	public WheelListBuilder addWheel(Wheel wheel) {
		if (wheelList.size() < 4) {
			this.wheelList.add(wheel);
		}
		return this;
	}

	public List<Wheel> build() {
		//test if there are 4 instances....
		return this.wheelList;
	}
}
