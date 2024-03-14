package Ficha_06;

import java.util.Arrays;
import java.util.Scanner;

import static Ficha_06.Ex_05.*;

public class Ex_06 {

    /**
     * Cria um vetor
     * @return Vetor
     */
    public static int[] CriarVetor(){
        Scanner input = new Scanner(System.in);
        int num;

        System.out.print("Introduza o tamanho do vetor a criar: ");
        num= input.nextInt();
        while (num<=0){
            System.out.println("Tamanho inválido.");
            System.out.print("Introduza o tamanho do vetor a criar: ");
            num= input.nextInt();
        }

        int[] vetor= new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("Introduza um número inteiro para vetor["+i+"]: ");
            vetor[i]=input.nextInt();
        }
        return vetor;
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao;

        //Criar Vetor
        int[] vetor=CriarVetor();

        do {
            System.out.println("\n\n****** Análise do Vetor: " + Arrays.toString(vetor) + " ******\n");
            System.out.println("1. Maior Elemento");
            System.out.println("2. Menor Elemento");
            System.out.println("3. Crescente ou Não Crescente");
            System.out.println("4. Trocar de Vetor");
            System.out.println("5. Sair");

            // Ler opcao
            System.out.print("Insira uma opção: ");
            opcao = input.nextInt();

            System.out.println("\n\n");

            switch (opcao) {
                case 1 -> //Maior elemento
                        System.out.println("O maior elemento é: " + Maior(vetor));
                case 2 -> //Menor elemento
                        System.out.println("O menor elemento é: " + Menor(vetor));
                case 3 -> { //Crescente ou não Crescente
                    if (IsCrescente(vetor)) System.out.println("É Crescente");
                    else System.out.println("Não é Crescente");
                }
                case 4 -> { // Trocar de vetor

                    // Criar Vetor
                    System.out.print("Insira um novo vetor: ");
                    vetor = CriarVetor();
                }
                case 5 -> // Sair

                        System.out.println("*** Até à Próxima! :D ***");
                default -> System.out.println("Opção Inválida!\n");
            }
        }while (opcao!=5);
    }
}
