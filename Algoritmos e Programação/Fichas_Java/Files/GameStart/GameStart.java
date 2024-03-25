import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameStart {

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
     * @param path      Caminho do ficheiro
     * @param separador separador do ficheiro estruturado
     * @return String[][] matriz_csv
     * @throws FileNotFoundException File not found
     */
    public static String[][] TransformarCSVEmMatriz(String path, String separador) throws FileNotFoundException {
        String[][] matriz = new String[NumeroDeLinhasDoFicheiro(path)][NumeroDeColunasDoFicheiro(path)];
        Scanner FR = new Scanner(new File(path));
        int i = 0;

        while (FR.hasNextLine()) {
            String linha = FR.nextLine();
            matriz[i] = linha.split(separador);
            i++;
        }
        return matriz;
    }

    /**
     * @param path admins_path
     * @return Boolean True: Login successful || False: Login not successful
     * @throws FileNotFoundException
     */
    public static boolean LoginADMIN(String path) throws FileNotFoundException {
        boolean is_username = false, is_password = false, sucess = false;
        int i = 0;
        String username, password;
        Scanner input = new Scanner(System.in);
        //Tranformar o GameStart_Admins.csv numa matriz
        String[][] matriz = TransformarCSVEmMatriz(path, ";");

        //Verificar Username
        do {
            System.out.println("Username (escape para sair): ");
            username = input.next();
            if (username.equals("escape")) {
                break;
            }
            for (i = 0; i < matriz.length; i++) {
                if (username.equals(matriz[i][0])) {
                    is_username = true;
                    break;
                }
            }
        } while (!is_username);
        if (!is_username) return sucess;//se escape

        //Verificar Password
        do {
            System.out.println("Password (escape para sair): ");
            password = input.next();
            if (password.equals("escape")) break;
            if (password.equals(matriz[i][1])) {
                is_password = true;
                sucess = true;
            }
        } while (!is_password);
        if (!is_password) return sucess;//se escape

        return sucess;//Login successful
    }

    /**
     * Imprime o conteúdo do ficheiro na consola
     *
     * @param path caminho do ficheiro
     * @throws FileNotFoundException
     */
    public static void ImprimirFicheiro(String path) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File(path));
        while (fileReader.hasNextLine()) { //verifica se tem próxima linha
            System.out.println(fileReader.nextLine()); //Imprime próxima linha
        }
    }

    /**
     * Pesquisar
     *
     * @param valor valor a pesquisar
     * @param campo nome da coluna onde pesquisar
     * @param path  caminho do ficheiro onde pesquisar
     * @return matriz com os restultados da pesquisa
     * @throws FileNotFoundException
     */
    public static String[][] Pesquisa(String valor, String campo, String path) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File(path));
        String[][] matriz = TransformarCSVEmMatriz(path, ";");
        int i, n_resultados = 0, linha = 0;


        //encontrar o index da coluna(campo)
        for (i = 0; i < matriz[0].length; i++) {
            if (matriz[0][i].equals(campo)) {
                break;
            }
        }
        // contar nº ocorrencias do valor
        for (int j = 1; j < matriz.length; j++) {
            if (matriz[j][i].equals(valor)) {
                n_resultados++;
            }
        }
        //criar matriz de resultados
        String[][] resultados = new String[n_resultados][matriz[0].length];
        for (int j = 1; j < matriz.length; j++) {
            if (matriz[j][i].equals(valor)) {
                for (int k = 0; k < matriz[j].length; k++) {
                    resultados[linha][k] = matriz[j][k];
                    linha++;
                }
            }
        }

        return resultados;
    }



    /**
     * Cria um vetor com os valores distintos de um capo
     * @param campo nome do campo para o qual queremos os valores distintos
     * @param path caminho do ficheiro
     * @return
     * @throws FileNotFoundException
     */
    public static String[] Distintos(String campo, String path) throws FileNotFoundException {
        int i, contador = 0;
        Scanner fileReader = new Scanner(new File(path));
        String[][] matriz = TransformarCSVEmMatriz(path, ";");
        for (i = 0; i < matriz[0].length; i++) {
            if (matriz[0][i].equals(campo)) {
                break;
            }
        }

        for (int j = 1; j < matriz.length; j++) {
            boolean distinct= true;
            for (int k=j; k >1 ; k--) {
                if (matriz[k][i].equals(matriz[k-1][i])) distinct=false;
            }
            if (distinct) contador++;
        }
        String[] distintos=new String[contador];
        contador=0;
        for (int j = 1; j < matriz.length; j++) {
            boolean distinct= true;
            for (int k=j; k >1 ; k--) {
                if (matriz[k][i].equals(matriz[k-1][i])) distinct=false;
            }
            if (distinct) {
                distintos[contador]=matriz[j][i];
                contador++;
            }
        }
        return distintos;
    }

    /**
     * Calcular total
     * @param valor valor do filtro ("ALL" para calcular de todos)
     * @param campo campo do filtro ("ALL" para calcular de todos)
     * @param path caminho do ficheiro de vendas
     * @param path2 caminho do ficheiro categorias
     * @param percentagem True se for para calcular lucro
     * @return Total
     * @throws FileNotFoundException
     */
    public static double Total(String valor,String campo, String path, String path2, boolean percentagem) throws FileNotFoundException {
        String[][] matriz = TransformarCSVEmMatriz(path, ";");
        String[][] matriz2 = TransformarCSVEmMatriz(path, ";");//matriz a usar para percentagens
        double soma = 0;
        if (valor.equals("ALL")&&campo.equals("ALL")) {
            for (int i = 1; i < matriz.length; i++) {
                if (!percentagem) {//Total de vendas
                    soma += Double.parseDouble(matriz[i][5]);
                } else {//total lucro
                    String[][] linha = Pesquisa(matriz[i][3], matriz2[0][0], path2);//encontrar a categoria e margem correspondente
                    soma += Double.parseDouble(matriz[i][5]) * Double.parseDouble(linha[0][1]);
                }
            }
        }else {
            String [][] matriz3=Pesquisa(valor,campo, path);
            for (int i = 1; i < matriz3.length; i++) {
                if (!percentagem) {//Total de vendas de valor
                    soma += Double.parseDouble(matriz[i][5]);
                } else {//total lucro de valor
                    String[][] linha = Pesquisa(matriz[i][3], matriz2[0][0], path2);//encontrar a categoria e margem correspondente
                    soma += Double.parseDouble(matriz[i][5]) * Double.parseDouble(linha[0][1]);
                }
            }
        }

        return soma;
    }

    public static String Melhor(String campo, String path, String path2) throws FileNotFoundException {
        boolean percentagem=false;
        String [] distintos=Distintos(campo, path);
        String melhor=distintos[0];
        if (campo.equals("categoria")) percentagem=true;
        double maiorTotal=Total(distintos[0],campo,path,path2, percentagem);
        for (int i = 1; i < distintos.length; i++) {
            double atual=Total(distintos[0],campo,path,path2, percentagem);
            if (maiorTotal<atual){
                maiorTotal=atual;
                melhor=distintos[i];
            }
        }
        return melhor;
    }

    public static void main(String[] args) throws FileNotFoundException {
        boolean logged;
        String admins_path = "GameStart_Admins.csv";
        String categorias_path = "GameStart_Categorias.csv";
        String clientes_path = "GameStart_Clientes.csv";
        String copyright_path = "GameStart_Copyright.txt";
        String vendas_path = "GameStart_Vendas.csv";
        String user_type, menu = null;
        Scanner input = new Scanner(System.in);

        do {
            logged = false;

            //login
            do {
                //Tipo de utilizador
                do {
                    System.out.print("Tipo de Utilizador (ADMIN || CLIENTE): ");
                    user_type = input.next();
                } while (!(user_type.equals("ADMIN") || user_type.equals("CLIENTE")));

                switch (user_type) {
                    case "ADMIN":
                        logged = LoginADMIN(admins_path);
                        menu = user_type;
                        break;
                    case "CLIENTE":
                        menu = user_type;
                        logged = true;
                        break;
                }
            } while (!logged);

            //menu ADMIN
            if (menu.equals("ADMIN")) {
                int opcao;
                do {
                    System.out.println("Menu ADMIN:");
                    System.out.println(" 1. Consulta de Ficheiros");
                    System.out.println(" 2. Total de Vendas");
                    System.out.println(" 3. Total de Lucro");
                    System.out.println(" 4. Pesquisa de Cliente");
                    System.out.println(" 5. Jogo mais caro");
                    System.out.println(" 6. Melhores Clientes");
                    System.out.println(" 7. Melhor Categoria");
                    System.out.println(" 8. Pesquisa Vendas");
                    System.out.println(" 9. Top 5 Jogos");
                    System.out.println(" 10. Bottom 5 jogos");

                    System.out.print("Escolha uma opção: ");
                    opcao = input.nextInt();

                    switch (opcao) {
                        case 1://Consulta de Ficheiros
                            System.out.println("1. Vendas");
                            System.out.println("2. Clientes");
                            System.out.println("3. Categorias");
                            System.out.print("Que ficheiro deseja ver: ");
                            int opcao2=input.nextInt();
                            switch (opcao2){
                                case 1:
                                    ImprimirFicheiro(vendas_path);
                                    break;
                                case 2:
                                    ImprimirFicheiro(clientes_path);
                                    break;
                                case 3:
                                    ImprimirFicheiro(categorias_path);
                                    break;
                                default:
                                    System.out.println("opção inválida");
                                    break;
                            }
                            break;

                        case 2://Total de Vendas
                            System.out.println("Total de vendas: "+Total("ALL","All", vendas_path,categorias_path,false)+" €");
                            break;

                        case 3://Total de Lucro
                            System.out.println("Total de lucro: "+Total("ALL","All", vendas_path,categorias_path,true)+" €");
                            break;

                        case 4://Pesquisa de Cliente
                            System.out.print("ID do cliente a pesquisar: ");
                            String[][] cliente=Pesquisa(input.next(),"idCliente",clientes_path);
                            for (int i = 1; i < cliente[0].length; i++) {
                                System.out.print("\t"+cliente[0][i]);
                            }
                            break;

                        case 5://Jogo mais caro

                            break;

                        case 6://Melhores Clientes

                            break;

                        case 7://Melhor Categoria

                            break;

                        case 8://Pesquisa Vendas

                            break;

                        case 9://Top 5 Jogos

                            break;

                        case 10:// Bottom 5 jogos

                            break;
                        case 11:
                            System.out.println("A sair................");
                            break;

                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                } while (opcao != 11);

            }

            //menu Cliente
            if (menu.equals("CLIENTE")) {
                int opcao;
                do {
                    System.out.println("Menu Cliente:");
                    System.out.println(" 1. Novo Registo");
                    System.out.println(" 2. Procurar estacionamento");
                    System.out.println(" 3. Imprimir Catálogo");
                    System.out.println(" 4. Imprimir Catálogos Gráficos");
                    System.out.println(" 5. Imprimir Catálogo Editora");
                    System.out.println(" 6. Imprimir Catálogo Categoria");
                    System.out.println(" 7. Imprimir jogo mais recente");

                    System.out.print("Escolha uma opção: ");
                    opcao = input.nextInt();

                    switch (opcao) {
                        case 1://Novo Registo

                            break;

                        case 2://Procurar estacionamento

                            break;

                        case 3://Imprimir Catálogo

                            break;

                        case 4://Imprimir Catálogos Gráficos

                            break;

                        case 5://Imprimir Catálogo Editora

                            break;

                        case 6://Imprimir Catálogo Categoria

                            break;

                        case 7://Imprimir jogo mais recente

                            break;
                        case 8:
                            System.out.println("A sair................");
                            break;

                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                } while (opcao != 8);
            }


            System.out.print("Quer fazer um novo login(1:sim|2:não): ");
            switch (input.nextInt()) {
                case 1:
                    System.out.println("Logout....");
                    break;
                case 2:
                    logged = false;
                    break;
            }


        } while (logged);

    }
}
