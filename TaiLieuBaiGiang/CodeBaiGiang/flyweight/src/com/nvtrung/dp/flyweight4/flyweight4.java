import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// Flyweight interface
interface Product {
    String getProductName();
    String getDescription();
    String getManufacturer();
    void displayProductDetails(); // Hiển thị thông tin sản phẩm bao gồm giá và số lượng
}

// ConcreteFlyweight
class ProductFlyweight implements Product {
    private String productName;
    private String description;
    private String manufacturer;

    // Thông tin không thay đổi
    public ProductFlyweight(String productName, String description, String manufacturer) {
        this.productName = productName;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Description: " + description);
        System.out.println("Manufacturer: " + manufacturer);
    }
}

// FlyweightFactory
class ProductFactory {
    private static final Map<String, Product> productCache = new HashMap<>();

    // Lấy một đối tượng Product từ cache hoặc tạo mới nếu chưa có
    public static Product getProduct(String productName, String description, String manufacturer) {
        String key = productName + manufacturer;  // Dựa vào tên sản phẩm và nhà sản xuất để làm key cho cache

        // Nếu đối tượng đã tồn tại trong cache, trả về đối tượng đã có
        if (!productCache.containsKey(key)) {
            System.out.println("Creating new ProductFlyweight for: " + productName);
            ProductFlyweight product = new ProductFlyweight(productName, description, manufacturer);
            productCache.put(key, product);
        }

        return productCache.get(key);
    }

    // Lấy kích thước bộ nhớ của các đối tượng hiện có trong cache
    public static int getCacheSize() {
        return productCache.size();
    }
}

// ProductDetails (Thông tin thay đổi)
class ProductDetails {
    private double price;
    private int quantity;

    public ProductDetails(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public void displayProductDetails() {
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

// Client
public class FlyweightMemoryExample {
    public static void main(String[] args) {
        // Giả sử chúng ta có 10000 sản phẩm với các thuộc tính không thay đổi giống nhau
        Random random = new Random();
        String[] productNames = {"Product A", "Product B", "Product C", "Product D"};
        String[] descriptions = {"Description A", "Description B", "Description C", "Description D"};
        String[] manufacturers = {"Manufacturer X", "Manufacturer Y", "Manufacturer Z"};

        // Biến để đếm số sản phẩm đã tạo
        int totalProducts = 10000;

        Product[] products = new Product[totalProducts];
        ProductDetails[] productDetails = new ProductDetails[totalProducts];

        // Tạo các đối tượng sản phẩm
        for (int i = 0; i < totalProducts; i++) {
            // Lấy ngẫu nhiên các giá trị từ mảng
            String productName = productNames[random.nextInt(productNames.length)];
            String description = descriptions[random.nextInt(descriptions.length)];
            String manufacturer = manufacturers[random.nextInt(manufacturers.length)];

            // Lấy đối tượng Flyweight từ Factory
            products[i] = ProductFactory.getProduct(productName, description, manufacturer);

            // Tạo các thông tin thay đổi ngẫu nhiên (giá và số lượng)
            double price = 50 + random.nextInt(100); // Giá từ 50 đến 150
            int quantity = 10 + random.nextInt(50);  // Số lượng từ 10 đến 60

            productDetails[i] = new ProductDetails(price, quantity);
        }

        // Hiển thị tổng số đối tượng Flyweight trong cache
        System.out.println("Number of unique product objects in cache: " + ProductFactory.getCacheSize());

        // Hiển thị một vài chi tiết sản phẩm
        products[0].displayProductDetails();
        productDetails[0].displayProductDetails();

        products[9999].displayProductDetails();
        productDetails[9999].displayProductDetails();
    }
}