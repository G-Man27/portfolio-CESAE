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
     * @param path Caminho do ficheiro
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
     *
     * @param path admins_path
     * @return Boolean True: Login successful || False: Login not successful
     * @throws FileNotFoundException
     */
    public static boolean LoginADMIN(String path) throws FileNotFoundException {
        boolean is_username=false, is_password=false,sucess=false;
        int i=0;
        String username, password;
        Scanner input = new Scanner(System.in);
        //Tranformar o GameStart_Admins.csv numa matriz
        String[][] matriz = TransformarCSVEmMatriz(path,";");

        //Verificar Username
        do {
            System.out.println("Username (escape para sair): ");
            username=input.next();
            if (username.equals("escape")){
                break;
            }
            for (i = 0; i < matriz.length; i++) {
                if (username.equals(matriz[i][0])){
                    is_username=true;
                    break;
                }
            }
        }while (!is_username);
        if (!is_username) return sucess;//se escape

        //Verificar Password
        do {
            System.out.println("Password (escape para sair): ");
            password=input.next();
            if (password.equals("escape")) break;
            if (password.equals(matriz[i][1])){
                is_password=true;
                sucess=true;
            }
        }while (!is_password);
        if (!is_password) return sucess;//se escape

        return sucess;//Login successful
    }

    public static void main(String[] args) throws FileNotFoundException {
        boolean logged;
        String admins_path="GameStart_Admins.csv";
        String categorias_path="GameStart_Categorias.csv";
        String clientes_path="GameStart_Clientes.csv";
        String copyright_path="GameStart_Copyright.txt";
        String vendas_path="GameStart_Vendas.csv";
        String user_type, menu=null;
        Scanner input = new Scanner(System.in);

        do {
            logged=false;

            //login
            do {
                //Tipo de utilizador
                do {
                    System.out.print("Tipo de Utilizador (ADMIN || CLIENTE): ");
                    user_type=input.next();
                }while ( !( user_type.equals("ADMIN") || user_type.equals("CLIENTE") ));

                switch (user_type){
                    case "ADMIN":
                        logged=LoginADMIN(admins_path);
                        menu=user_type;
                        break;
                    case "CLIENTE":
                        menu=user_type;
                        logged=true;
                        break;
                }
            }while (!logged);

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
                    opcao=input.nextInt();

                    switch (opcao) {
                        case 1://Consulta de Ficheiros

                            break;

                        case 2://Total de Vendas

                            break;

                        case 3://Total de Lucro

                            break;

                        case 4://Pesquisa de Cliente

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
                }while (opcao!=11);

            }

            //menu Cliente
            if(menu.equals("CLIENTE")){
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
                    opcao=input.nextInt();

                    switch (opcao){
                        case  1://Novo Registo

                            break;

                        case  2://Procurar estacionamento

                            break;

                        case  3://Imprimir Catálogo

                            break;

                        case  4://Imprimir Catálogos Gráficos

                            break;

                        case  5://Imprimir Catálogo Editora

                            break;

                        case  6://Imprimir Catálogo Categoria

                            break;

                        case  7://Imprimir jogo mais recente

                            break;
                        case 8:
                            System.out.println("A sair................");
                            break;

                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                }while (opcao!=8);
            }


            System.out.print("Quer fazer um novo login(1:sim|2:não): ");
            switch (input.nextInt()){
                case 1:
                    System.out.println("Logout....");
                    break;
                case 2:
                    logged=false;
                    break;
            }


        }while (logged);

    }
}
