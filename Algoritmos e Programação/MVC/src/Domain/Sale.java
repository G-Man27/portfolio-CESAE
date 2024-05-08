package Domain;

public class Sale {

    private Product product;
    private double quantitySale;

    public Sale(Product product, double quantitySale) {
        this.product = product;
        this.quantitySale = quantitySale;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantitySale() {
        return quantitySale;
    }
}
