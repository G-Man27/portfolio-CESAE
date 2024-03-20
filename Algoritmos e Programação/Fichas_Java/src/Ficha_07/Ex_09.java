package Ficha_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex_09 {
    /**
     * Calcula o número de linhas de um Ficheiro CSV.
     *
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
     *
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
     *
     * @param path Caminho do ficheiro
     * @return String[][] matriz_csv
     * @throws FileNotFoundException File not found
     */
    public static String[][] TransformarCSVEmMatriz(String path) throws FileNotFoundException {
        String[][] matriz = new String[NumeroDeLinhasDoFicheiro(path)][NumeroDeColunasDoFicheiro(path)];
        Scanner FR = new Scanner(new File(path));
        int i = 0;
        String separador = ",";

        while (FR.hasNextLine()) {
            String linha = FR.nextLine();
            matriz[i] = linha.split(separador);
            i++;
        }
        return matriz;
    }

    /**
     * Fitrar as musicas
     *
     * @param matriz      matriz
     * @param tipo_filtro Pesquisar por
     * @param filtro      termo a pesquisar
     */
    public static void PesquisarPor(String[][] matriz, String tipo_filtro, String filtro) {
        int i;
        boolean found = false;
        for (i = 0; i < matriz[0].length; i++) {
            if (matriz[0][i].equals(tipo_filtro)) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Não foi encontrado nenhum resultado.");
            return;
        }
        found = false;
        for (int j = 1; j < matriz.length; j++) {
            if (matriz[j][i].equals(filtro)) {
                found = true;
                for (int k = 0; k < matriz[j].length; k++) {
                    System.out.print("\t" + matriz[j][k]);
                }
                System.out.println(";");
            }
        }
        if (!found) System.out.println("Não foi encontrado nenhum resultado.");
    }

    public static void DuracaoMusicaMaiorQue(String[][] matriz, String S_duracao) {
        int i;
        for (i = 0; i < matriz[0].length; i++) {
            if (matriz[0][i].equals("Duracao")) break;
        }

        boolean maior = false;
        double musica_maior = 0;
        double duracao;
        if (S_duracao.equals("maior")) {
            maior = true;
            duracao = 0;
        } else {
            String[] time = S_duracao.split(":");
            if (time.length == 1) duracao = Double.parseDouble(time[0]);
            else duracao = Double.parseDouble(time[0]) * 60 + Double.parseDouble(time[1]);
        }

        for (int j = 1; j < matriz.length; j++) {
            String[] time = matriz[j][i].split(":");
            double segundos = Double.parseDouble(time[0]) * 60 + Double.parseDouble(time[1]);
            if (duracao < segundos) {
                if (maior) {
                    duracao = segundos;
                    musica_maior = duracao;
                } else {
                    for (int k = 0; k < matriz[j].length; k++) {
                        System.out.print("\t" + matriz[j][k]);

                    }
                    System.out.println(";");
                }
            }
        }
        if (maior) {
            DuracaoMusicaMaiorQue(matriz, String.valueOf(musica_maior - 1));
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        String[][] matriz_csv = null;
        String filtro;

        System.out.print("Escreva o nome do ficheiro:");
        String filename = input.nextLine(); //exercicio_03
        System.out.print("Qual é a extensão:");
        String ext = "." + input.nextLine(); //exercicio_03
        try {
            matriz_csv = TransformarCSVEmMatriz(("Files/" + filename + ext));
        } catch (FileNotFoundException e) {
            System.out.println("file not found...");
        }
        System.out.println();
        //menu
        int op;
        do {
            System.out.println("Menu:");
            System.out.println("1 Pesquisar musicas de um determinado género;");
            System.out.println("2 Pesquisar musicas de um determinado artista;");
            System.out.println("3 Pesquisar geral;");
            System.out.println("4 Pesquisar musica de maior duração;");
            System.out.println("5 Pesquisar musica com duração acima de um avlor especificado;");
            System.out.println("6 Número de musicas no ficheiro;");
            System.out.println("7 Sair;");
            System.out.println();

            System.out.print("Escolha uma das opções:");
            op = input.nextInt();

            System.out.println();
            switch (op) {
                case 1:
                    System.out.print("Pesquisar: ");
                    filtro = input.nextLine();
                    filtro = input.nextLine();
                    System.out.println();
                    PesquisarPor(matriz_csv, "Genero", filtro);
                    break;
                case 2:
                    System.out.print("Pesquisar: ");
                    filtro = input.nextLine();
                    filtro = input.nextLine();
                    PesquisarPor(matriz_csv, "Artista", filtro);
                    break;
                case 3:
                    for (int i = 0; i < matriz_csv[0].length; i++) {
                        System.out.print(matriz_csv[0][i] + ";\t");
                    }
                    System.out.println();
                    System.out.print("Quer pesquisar pelo quê: ");
                    String tipo_filtro = input.nextLine();
                    tipo_filtro = input.nextLine();
                    System.out.print("Pesquisar: ");
                    filtro = input.nextLine();
                    PesquisarPor(matriz_csv, tipo_filtro, filtro);
                    break;
                case 4:
                    System.out.println("A(s) musica(s) com maior duração: ");
                    DuracaoMusicaMaiorQue(matriz_csv, "maior");
                    break;
                case 5:
                    System.out.print("Introduza um valor para a duração(mm:ss|ss): ");
                    String duracao = input.nextLine();
                    duracao = input.nextLine();
                    System.out.println("A(s) musica(s) com duração maior que " + duracao + ": ");
                    DuracaoMusicaMaiorQue(matriz_csv, duracao);
                    break;
                case 6:
                    System.out.println("O Ficheiro " + filename + " tem " + (matriz_csv.length - 1) + " músicas.");
                    break;
                case 7:
                    System.out.println("A sair.............................");
                    break;
                default:
                    System.out.println("opção inválida");
                    break;

            }
            System.out.println("\n\n\n\n\n\n\n");
        } while (op != 7);


    }

}
