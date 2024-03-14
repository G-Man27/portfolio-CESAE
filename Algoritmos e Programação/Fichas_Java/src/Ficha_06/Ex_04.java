package Ficha_06;

import java.util.Scanner;

import static Ficha_06.Ex_03.*;

public class Ex_04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num, opcao;

        System.out.print("Insira um número: ");
        num = input.nextInt();

        do {

            // Apresentar as opções
            System.out.println("\n\n****** Análise de um Número: " + num + " ******\n");
            System.out.println("1. Par ou Impar");
            System.out.println("2. Positivo ou Negativo");
            System.out.println("3. Primo ou Não Primo");
            System.out.println("4. Perfeito ou Não Perfeito");
            System.out.println("5. Triangular ou Não Triangular");
            System.out.println("6. Trocar de Número");
            System.out.println("7. Sair");

            // Ler opcao
            System.out.print("Insira uma opção: ");
            opcao = input.nextInt();

            System.out.println();

            switch (opcao){

                case 1: // Par ou Impar

                    if(IsPar(num)){
                        System.out.println("*** Par ***");
                    }else{
                        System.out.println("*** Impar ***");
                    }

                    break;

                case 2: // Positivo ou Negativo

                    if(IsPositivo(num)){
                        System.out.println("*** Positivo ***");
                    }else{
                        System.out.println("*** Negativo ***");
                    }

                    break;

                case 3: // Primo ou Não Primo

                    if(IsPrimo(num)){
                        System.out.println("*** Primo ***");
                    }else{
                        System.out.println("*** Não Primo ***");
                    }

                    break;

                case 4: // Perfeito ou Não Perfeito
                    if(IsPerfeito(num)){
                        System.out.println("*** Perfeito ***");
                    }else{
                        System.out.println("*** Não Perfeito ***");
                    }
                    break;

                case 5: // Triangular ou Não Triangular
                    if(IsTriangular(num)){
                        System.out.println("*** Triangular ***");
                    }else{
                        System.out.println("*** Não Triangular ***");
                    }
                    break;

                case 6: // Trocar de Número

                    // Ler numero
                    System.out.print("Insira um novo numero: ");
                    num = input.nextInt();

                    break;

                case 7: // Sair

                    System.out.println("*** Até à Próxima! :D ***");
                    break;

                default:
                    System.out.println("Opção Inválida!\n");
            }


        } while (opcao != 7);
    }
}
