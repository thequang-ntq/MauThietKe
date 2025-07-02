package com.nvtrung.dp.flyweight2;

import java.util.HashMap;

public class CircleFactory {

	private static final HashMap<String, Circle> cache 
		= new HashMap<String, Circle>();

	public static Circle getCircle(String color) {
		Circle circle = cache.get(color);

		if (circle == null) {
			circle = new Circle(color);
			cache.put(color, circle);
			System.out.println("Đã tạo xong đối tượng với màu " + color);
		} else {
			System.out.println("Dùng lại đối tượng với màu " + color);
		}
		return circle;
	}
}
