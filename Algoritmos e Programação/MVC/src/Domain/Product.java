package Domain;

public class Product {
    private String productType;
    private String product;
    private double unitPrice;

    public Product(String productType, String product, double unitPrice) {
        this.productType = productType;
        this.product = product;
        this.unitPrice = unitPrice;
    }

    public String getProductType() {
        return productType;
    }

    public String getProduct() {
        return product;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "Product Type: "+this.productType + "\t| Product: "+product+"\t| Unit Price: "+unitPrice;
    }
}
