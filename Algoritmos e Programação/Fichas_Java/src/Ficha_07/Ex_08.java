package Ficha_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex_08 {
    /**
     * Calcula o número de linhas de um Ficheiro CSV.
     * @param path Caminho do ficheiro
     * @return int número de linhas
     * @throws FileNotFoundException File not found
     */
    public static int NumeroDeLinhasDoFicheiro(String path) throws FileNotFoundException {
        Scanner FR = new Scanner(new File(path));
        int n_linhas = 0;
        while (FR.hasNextLine()) {
            FR.nextLine();
            n_linhas++;
        }
        FR.close();
        return n_linhas;
    }

    /**
     * Calcula o número de colunas de um Ficheiro CSV.
     * @param path Caminho do ficheiro
     * @return int número de colunas
     * @throws FileNotFoundException File not found
     */
    public static int NumeroDeColunasDoFicheiro(String path) throws FileNotFoundException {
        Scanner FR = new Scanner(new File(path));
        int n_colunas = 0;
        while (FR.hasNextLine()) {
            String linha = FR.nextLine();
            String[] items_da_linha = linha.split(",");
            if (n_colunas < items_da_linha.length) {
                n_colunas = items_da_linha.length;
            }
        }
        return n_colunas;
    }

    /**
     * Lê um ficheiro CSV e tranforma o seu conteúdo numa matriz de Strings
     * @param path Caminho do ficheiro
     * @return String[][] matriz_csv
     * @throws FileNotFoundException File not found
     */
    public static String[][] TransformarCSVEmMatriz(String path) throws FileNotFoundException {
        String[][] matriz= new String[NumeroDeLinhasDoFicheiro(path)][NumeroDeColunasDoFicheiro(path)];
        Scanner FR = new Scanner(new File(path));
        int i=0;
        String separador=",";

        while (FR.hasNextLine()) {
            String linha = FR.nextLine();
            matriz[i] = linha.split(separador);
            i++;
        }
        return matriz;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        String[][] matriz_csv=null;
        double total_vendas=0;

        System.out.println("Vamos calcular o total das vendas num ficheiro csv");
        System.out.print("Escreva o nome do ficheiro:");
        String  filename = input.nextLine(); //exercicio_03
        System.out.print("Qual é a extensão:");
        String  ext = "."+input.nextLine(); //exercicio_03
        try {
            matriz_csv= TransformarCSVEmMatriz(("Files/"+filename+ext));
        } catch (FileNotFoundException e) {
            System.out.println("file not found...");
        }
        System.out.print("matriz_csv header: ");
        for (int i = 0; i < matriz_csv[0].length; i++) {
            System.out.print(matriz_csv[0][i]+";\t");
        }
        System.out.println();

        System.out.print("Qual o número da coluna da quantidade: ");
        int c_quant=input.nextInt()-1;
        System.out.print("Qual o número da coluna do preço: ");
        int c_preco=input.nextInt()-1;

        for (int i = 1; i < matriz_csv.length; i++) {
            total_vendas+=(Double.parseDouble(matriz_csv[i][c_quant])*Double.parseDouble(matriz_csv[i][c_preco]));
        }
        System.out.println("total_vendas = " + total_vendas);
    }

}
