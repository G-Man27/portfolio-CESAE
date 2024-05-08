package Controllers;

import Domain.Product;
import Domain.Sale;
import Model.SalesRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ClientController {

    public ClientController() {
    }

    public ArrayList<Product> getProductOfCategory(String productTypeToFind) throws FileNotFoundException {

        System.out.println("Controller iniciado");
        ArrayList<Sale> salesArray = SalesRepository.getInstance().getSalesArray();
        ArrayList<Product> filteredProducts = new ArrayList<Product>();

        for(Sale actualSale : salesArray){
            if(actualSale.getProduct().getProductType().equals(productTypeToFind)){
                filteredProducts.add(actualSale.getProduct());
            }
        }

        return filteredProducts;

    }

}
