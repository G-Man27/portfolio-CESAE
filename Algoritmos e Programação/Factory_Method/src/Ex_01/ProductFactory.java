package Ex_01;

public class ProductFactory {
    public static Product createProduct(String type) {
        return switch (type) {
            case "book" -> new Book();
            case "electronics" -> new Electronics();
            case "clothing" -> new Clothing();
            default -> throw new IllegalArgumentException("Tipo de produto inválido: " + type);
        };
    }
}
