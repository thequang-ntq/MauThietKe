package com.nvtrung.dp.flyweight2;

public class Circle implements Shape {
	private String color;
	
	private int x;
	private int y;
	private int radius;

	public Circle(String color) {
		System.out.printf("Tạo mới đối tượng màu [%s] trong khoảng thời gian 2000ms...", color);

		this.color = color;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.printf("Vẽ đường tròn bán kính %d, tọa độ tâm (%d, %d), màu %s\n", this.radius, this.x, this.y, this.color);
	}
}
