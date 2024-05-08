package Views;

import Controllers.ClientController;
import Domain.Product;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClientView {

    private static ClientController clientController;

    public ClientView() {
        this.clientController = new ClientController();
    }

    public void menuCliente() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n***** CLIENTE *****\n");
            System.out.println("1. Consultar Produtos Disponíveis");
            System.out.println("2. Consultar Produto de uma Categoria");
            System.out.println("3. Consultar Produto Mais Caro/Barato");
            System.out.println("0. Sair");
            System.out.print("\nInsira uma opção: ");
            opcao = input.nextInt();

            System.out.println();

            switch (opcao) {
                case 1: // Consultar Produtos Disponíveis
                    break;

                case 2: // Consultar Produto de uma Categoria
                    System.out.print("Insira a Categoria a Pesquisar: ");
                    input.nextLine();
                    String productTypeToFind = input.nextLine();

                    showProductOfCategory(productTypeToFind);

                    break;

                case 3: // Consultar Produto Mais Caro/Barato
                    break;

                case 0: // Sair
                    break;

                default:
                    System.out.println("Opção Inválida!");
            }

        } while (opcao != 0);
    }

    public static void showProductOfCategory(String productTypeToFind) throws FileNotFoundException {

        System.out.println("Produtos da Categoria: "+productTypeToFind);

        for(Product actualProduct : clientController.getProductOfCategory(productTypeToFind)){
            System.out.println(actualProduct);
        }
    }
}
