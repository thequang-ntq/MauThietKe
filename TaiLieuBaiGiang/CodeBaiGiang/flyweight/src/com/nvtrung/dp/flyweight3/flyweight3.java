// Flyweight interface
interface Shape {
    void draw(int x, int y);  // Vẽ hình tại vị trí (x, y)
    String getType();         // Lấy loại hình của đối tượng (Circle, Square, Triangle)
}

// ConcreteFlyweight cho Circle
class Circle implements Shape {
    private String color; // Trạng thái chia sẻ (không thay đổi)
    private int radius;   // Trạng thái chia sẻ (không thay đổi)

    public Circle(String color, int radius) {
        this.color = color;
        this.radius = radius;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing a " + color + " Circle at (" + x + ", " + y + ") with radius " + radius);
    }

    @Override
    public String getType() {
        return "Circle";
    }
}

// ConcreteFlyweight cho Square
class Square implements Shape {
    private String color;  // Trạng thái chia sẻ (không thay đổi)
    private int sideLength; // Trạng thái chia sẻ (không thay đổi)

    public Square(String color, int sideLength) {
        this.color = color;
        this.sideLength = sideLength;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing a " + color + " Square at (" + x + ", " + y + ") with side length " + sideLength);
    }

    @Override
    public String getType() {
        return "Square";
    }
}

// ConcreteFlyweight cho Triangle
class Triangle implements Shape {
    private String color;  // Trạng thái chia sẻ (không thay đổi)
    private int base;      // Trạng thái chia sẻ (không thay đổi)
    private int height;    // Trạng thái chia sẻ (không thay đổi)

    public Triangle(String color, int base, int height) {
        this.color = color;
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing a " + color + " Triangle at (" + x + ", " + y + ") with base " + base + " and height " + height);
    }

    @Override
    public String getType() {
        return "Triangle";
    }
}

// FlyweightFactory
class ShapeFactory {
    private static final Map<String, Shape> shapeMap = new HashMap<>();

    // Lấy một đối tượng Shape từ cache hoặc tạo mới nếu chưa có
    public static Shape getShape(String type, String color, int size1, int size2) {
        String key = type + color + size1 + size2;

        // Kiểm tra xem đối tượng có tồn tại trong map không
        if (!shapeMap.containsKey(key)) {
            System.out.println("Creating new " + type + ": " + color + " with size (" + size1 + ", " + size2 + ")");
            Shape shape = null;
            if (type.equalsIgnoreCase("Circle")) {
                shape = new Circle(color, size1);
            } else if (type.equalsIgnoreCase("Square")) {
                shape = new Square(color, size1);
            } else if (type.equalsIgnoreCase("Triangle")) {
                shape = new Triangle(color, size1, size2);
            }
            shapeMap.put(key, shape);
        }

        return shapeMap.get(key);
    }
}

// Client
public class FlyweightPatternExample {
    public static void main(String[] args) {
        // Sử dụng Factory để lấy các đối tượng Shape
        Shape circle1 = ShapeFactory.getShape("Circle", "Red", 10, 0);
        circle1.draw(1, 1);

        Shape square1 = ShapeFactory.getShape("Square", "Blue", 20, 0);
        square1.draw(2, 2);

        Shape triangle1 = ShapeFactory.getShape("Triangle", "Green", 10, 15);
        triangle1.draw(3, 3);

        // Chia sẻ đối tượng Circle với cùng màu sắc và bán kính
        Shape circle2 = ShapeFactory.getShape("Circle", "Red", 10, 0);
        circle2.draw(4, 4);

        Shape square2 = ShapeFactory.getShape("Square", "Blue", 20, 0);
        square2.draw(5, 5);

        // Kiểm tra chia sẻ đối tượng
        System.out.println("circle1 == circle2: " + (circle1 == circle2)); // true
        System.out.println("square1 == square2: " + (square1 == square2)); // true
    }
}
