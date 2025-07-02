package com.nvtrung.dp.flyweight2;

public class FlyweightPatternDemo {
	private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };

	public static void main(String[] args) {
		for (int i = 0; i < 20; ++i) {
			var màu = getRandomColor();
			var x = getRandomX();
			var y = getRandomY();
			var r = (int)(1 + 1000*Math.random());
			
			Circle circle = CircleFactory.getCircle(màu);
			
			circle.setX(x);
			circle.setY(y);
			circle.setRadius(r);
			
			circle.draw();
		}
	}

	private static String getRandomColor() {
		// 0 -> colors.length - 1
		return colors[(int) (Math.random() * colors.length)];
	}

	private static int getRandomX() {
		return (int) (Math.random() * 100);
	}

	private static int getRandomY() {
		return (int) (Math.random() * 100);
	}
}