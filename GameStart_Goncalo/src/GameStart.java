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
        String[][] matriz = TransformarCSVEmMatriz(path, ";");
        int i, n_resultados = 0, linha = 0,index=0;


        //encontrar o index da coluna(campo)
        for (i = 0; i < matriz[0].length; i++) {
            if (matriz[0][i].equals(campo)) {
                index=i;
                break;
            }
        }
        // contar nº ocorrencias do valor
        for (int j = 1; j < matriz.length; j++) {
            if (matriz[j][index].equals(valor)) {
                n_resultados++;
            }
        }
        //criar matriz de resultados
        String[][] resultados = new String[n_resultados][matriz[0].length];
        for (int j = 1; j < matriz.length; j++) {
            if (matriz[j][index].equals(valor)) {
                for (int k = 0; k < matriz[j].length; k++) {
                    resultados[linha][k] = matriz[j][k];

                }
                linha++;
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
        int l, contador = 0, i=-1;
        //encontrar index do campo
        String[][] matriz = TransformarCSVEmMatriz(path, ";");
        for (l = 0; l < matriz[0].length; l++) {
            if (matriz[0][l].equals(campo)) {
                i=l;
                break;
            }
        }

        //contar o número de resultados
        for (int j = 1; j < matriz.length; j++) {
            boolean distinct= true;
            for (int k=j; k >0 ; k--) {
                if (matriz[k-1][i].equals(matriz[j][i])) {
                    distinct = false;
                    break;
                }
            }
            if (distinct) contador++;
        }
        //criar o vetor com os resultados
        String[] distintos=new String[contador];
        contador=0;
        for (int j = 1; j < matriz.length; j++) {
            boolean distinct= true;
            for (int k=j; k >0 ; k--) {
                if (matriz[k-1][i].equals(matriz[j][i])) {
                    distinct = false;
                    break;
                }
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
        //System.out.println();
        //System.out.println("Inicio da função");
        if (valor.equals("ALL")&&campo.equals("ALL")) {
            for (int i = 1; i < matriz.length; i++) {
                if (!percentagem) {//Total de vendas
                    soma += Double.parseDouble(matriz[i][5]);
                } else {//total lucro
                    String[][] linha = Pesquisa(matriz[i][3], matriz2[0][0], path2);//encontrar a categoria e margem correspondente
                    //System.out.print("Valor do Jogo: "+matriz[i][5]+"\t");
                    //System.out.println("Margem: "+(Double.parseDouble(linha[0][1])/100));
                    soma += Double.parseDouble(matriz[i][5]) * (Double.parseDouble(linha[0][1])/100);
                    //System.out.println("Soma Atual: "+soma);
                }
            }
        }else {
            String [][] matriz3=Pesquisa(valor,campo, path);
            for (int i = 0; i < matriz3.length; i++) {
                if (!percentagem) {//Total de vendas de valor
                    soma += Double.parseDouble(matriz3[i][5]);
                } else {//total lucro de valor
                    String[][] linha = Pesquisa(matriz3[i][3], matriz2[0][0], path2);//encontrar a categoria e margem correspondente
                    //System.out.print("Valor do Jogo: "+matriz3[i][5]+"\t");
                    //System.out.println("Margem: "+(Double.parseDouble(linha[0][1])/100));
                    //System.out.println("Valor de Lucro deste jogo: "+Double.parseDouble(matriz3[i][5]) * (Double.parseDouble(linha[0][1])/100));
                    soma +=(Double.parseDouble(matriz3[i][5]) * (Double.parseDouble(linha[0][1])/100));
                    //System.out.println("Soma Atual: "+soma);
                    //System.out.println();
                }
            }
        }
        //System.out.println("Fim");
        //System.out.println("Retorno: "+soma);
        //System.out.println();
        return soma;
    }


    /**
     * Lista de Top(Best/Worst) n valores de uma coluna
     * @param np n valores(ex top 5: n=5)
     * @param campo nome da coluna
     * @param top Best==true || Worst==False
     * @param path caminho das vendas
     * @param path2 caminho das categorias
     * @return matriz com os valores do top do campo e o total respetivo
     * @throws FileNotFoundException
     */
    public static String[][] Melhores(int np, String campo, boolean top, boolean percentagem, String path, String path2) throws FileNotFoundException {
        int n_colunas=0,n=0;


        //criar uma matriz com o nº de linhas = nº valores distintos do campo
        String [][] distintos=new String[Distintos(campo, path).length][2] ;

        for (int i = 0; i < distintos.length; i++) {
            distintos[i][0]=Distintos(campo, path)[i];
            distintos[i][1]=Double.toString(Total(distintos[i][0],campo,path,path2, percentagem));
        }

        //criar vetor com top valores
        double[] valores=new double[np];

        //top==true maiores valores
        if (top){


            //iniciar a var melhor com o primeiro valor do vetor
            double maiorTotal=Double.parseDouble(distintos[0][1]);
            double maiorTotal_anterior=9999999;


            do {
                int n_resultados=0;
                for (int i = 0; i < distintos.length; i++) {
                    if ((Double.parseDouble(distintos[i][1]))<maiorTotal_anterior){
                        maiorTotal=Double.parseDouble(distintos[i][1]);
                        break;
                    }
                }

                //calcular o maior sumatório(maiorTotal)
                for (int i = 0; i < distintos.length; i++) {
                    double atual=Double.parseDouble(distintos[i][1]);
                    if ((maiorTotal<=atual)&&(atual<maiorTotal_anterior)){
                        if(maiorTotal==atual){
                            n_resultados++;//contar o nº de melhores
                        }else {
                            n_resultados=1;
                            maiorTotal=atual;
                        }
                    }
                }
                if (n_resultados>n_colunas){
                    n_colunas=n_resultados;
                }
                maiorTotal_anterior=maiorTotal;
                valores[n]=maiorTotal_anterior;
                n++;
            }while (np>n);
        }
        //top==false piores valores
        if (!top){

            //iniciar a var melhor com o primeiro valor do vetor
            double menorTotal=Double.parseDouble(distintos[0][1]);
            double menorTotal_anterior=-1;


            do {
                int n_resultados=0;
                for (int i = 0; i < distintos.length; i++) {
                    if ((Double.parseDouble(distintos[i][1]))>menorTotal_anterior){
                        menorTotal=Double.parseDouble(distintos[i][1]);
                        break;
                    }
                }

                //calcular o maior sumatório(maiorTotal)
                for (int i = 0; i < distintos.length; i++) {
                    double atual=Double.parseDouble(distintos[i][1]);
                    if ((menorTotal>=atual)&&(atual>menorTotal_anterior)){
                        if(menorTotal==atual){
                            n_resultados++;//contar o nº de melhores
                        }else {
                            n_resultados=1;
                            menorTotal=atual;
                        }
                    }
                }
                if (n_resultados>n_colunas){
                    n_colunas=n_resultados;
                }
                menorTotal_anterior=menorTotal;
                valores[n]=menorTotal_anterior;
                n++;
            }while (np>n);
        }



        //criar o vetor dos melhores
        String[][] melhores=new String[np][n_colunas+1];
        for (int i = 0; i < melhores.length; i++) {
            int j=0;

            for (int k = 0; k < distintos.length; k++) {
                if ((Double.parseDouble(distintos[k][1]))==valores[i]){
                    melhores[i][j]=distintos[k][0];
                    j++;
                }
            }
            melhores[i][n_colunas]=Double.toString(valores[i]);
        }

        return melhores;
    }

    /**
     * Encontra o(s) jogo(s) mais caro(s)
     * @param path caminho das vendas
     * @return String[] com o(s) nome(s) do(s) jogo(s) mais caro(s) e o respetivo valor
     * @throws FileNotFoundException
     */
    public static String[] MaisCaro(String path) throws FileNotFoundException {
        //criar matriz vendas
        String[][] vendas=TransformarCSVEmMatriz(path,";");
        //criar matriz com a lista de jogos e o respetivo valor
        String [][] distintos=new String[Distintos("jogo", path).length][2] ;
        for (int i = 0; i < distintos.length; i++) {
            distintos[i][0]=Distintos("jogo", path)[i];
            for (int j = 0; j < vendas.length; j++) {
                if (vendas[j][4].equals(distintos[i][0])) {
                    distintos[i][1]=vendas[j][5];
                    break;
                }
            }
        }
        //inicializar a var maior com o valor do 1º jogo na matriz distintos
        double maior=Double.parseDouble(distintos[0][1]);

        //contador de resultados
        int n_resultados=1;

        //Encontrar o valor do jogo mais caro
        for (int i = 1; i < distintos.length; i++) {
            if (maior<=Double.parseDouble(distintos[i][1])){
                if(maior==Double.parseDouble(distintos[i][1])){
                    n_resultados++;//contar o nº de maiores
                }else {
                    n_resultados=1;
                    maior=Double.parseDouble(distintos[i][1]);
                }
            }
        }
        String[] mais_caro=new String[n_resultados+1];
        mais_caro[n_resultados]=Double.toString(maior);
        n_resultados=0;
        for (int i = 0; i < (distintos.length); i++) {
            if (Double.parseDouble(distintos[i][1]) == maior){
                mais_caro[n_resultados]=distintos[i][0];
                n_resultados++;
            }
        }
        return mais_caro;
    }

    public static void main(String[] args) throws FileNotFoundException {
        boolean logged;
        String admins_path = "Files/GameStart_Admins.csv";
        String categorias_path = "Files/GameStart_Categorias.csv";
        String clientes_path = "Files/GameStart_Clientes.csv";
        String copyright_path = "Files/GameStart_Copyright.txt";
        String vendas_path = "Files/GameStart_Vendas.csv";
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
                    case "ADMIN" -> {
                        logged = LoginADMIN(admins_path);
                        menu = user_type;
                    }
                    case "CLIENTE" -> {
                        menu = user_type;
                        logged = true;
                    }
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
                    System.out.println(" 11. Sair");

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
                            System.out.println("\n");
                            break;

                        case 2://Total de Vendas
                            System.out.println("Total de vendas: "+Total("ALL","All", vendas_path,categorias_path,false)+" €");
                            System.out.println("\n");
                            break;

                        case 3://Total de Lucro
                            System.out.println("Total de lucro: "+Total("ALL","All", vendas_path,categorias_path,true)+" €");
                            System.out.println("\n");
                            break;

                        case 4://Pesquisa de Cliente
                            System.out.print("ID do cliente a pesquisar: ");
                            String[][] cliente=Pesquisa(input.next(),"idCliente",clientes_path);
                            for (int i = 1; i < cliente[0].length; i++) {
                                System.out.print("\t"+cliente[0][i]);
                            }
                            System.out.println("\n");
                            break;

                        case 5://Jogo mais caro
                            System.out.println("O(s) jogo(s) mais caro(s) custa "+MaisCaro(vendas_path)[MaisCaro(vendas_path).length-1]+" €");
                            System.out.print("O(s) jogo(s) mais caro(s): ");
                            for (int i = 0; i < (MaisCaro(vendas_path).length-1); i++) {
                                System.out.println(MaisCaro(vendas_path)[i]);
                                System.out.println("Clientes que o compraram:");
                                //imprime na consola os clientes que compraram o jogo
                                for (int j = 0; j < ((Pesquisa(MaisCaro(vendas_path)[i],"jogo",vendas_path)).length); j++) {
                                    String cliente_id=Pesquisa(MaisCaro(vendas_path)[i],"jogo",vendas_path)[j][1]; // vetor com os ids dos clientes que compraram o jogo

                                    for (int k = 0; k < Pesquisa(cliente_id,"idCliente",clientes_path).length; k++) {
                                        for (int l = 0; l < Pesquisa(cliente_id,"idCliente",clientes_path)[0].length; l++) {
                                            System.out.print("\t"+Pesquisa(cliente_id,"idCliente",clientes_path)[k][l]);
                                        }
                                        System.out.println();
                                    }
                                }
                            }
                            System.out.println("\n");
                            break;

                        case 6://Melhores Clientes
                            System.out.println();
                            String[][] top1=Melhores(1,"idCliente",true,false, vendas_path,categorias_path);
                            for (int i = 0; i < (top1[0].length-1); i++) {
                                String[][] pesquisa_case6_1=Pesquisa(top1[0][i],"idCliente",clientes_path);
                                for (int j = 0; j < pesquisa_case6_1[0].length; j++) {
                                    System.out.print("\t"+pesquisa_case6_1[0][j]);
                                }
                                System.out.println(": "+top1[0][top1[0].length-1]+" €");

                                String[][] pesquisa_case6_2=Pesquisa(top1[0][i],"idCliente",vendas_path);
                                System.out.println("Jogos:");
                                for (int j = 0; j < pesquisa_case6_2.length; j++) {
                                    System.out.print(" "+pesquisa_case6_2[i][4]);
                                    if (j==(pesquisa_case6_2.length-1)){
                                        System.out.print(".");
                                    }else {
                                        System.out.print(",");
                                    }
                                }
                            }
                            System.out.println("\n");
                            break;

                        case 7://Melhor Categoria
                            for (int i = 0; i < Melhores(1,"categoria",true,true,vendas_path,categorias_path)[0].length; i++) {
                                System.out.print("\t"+Melhores(1,"categoria",true,true,vendas_path,categorias_path)[0][i]);
                            }
                            System.out.println("€");
                            System.out.println("\n");
                            break;

                        case 8://Pesquisa Vendas
                            System.out.print("Insira o nome do jogo a pesquisar: ");
                            input.nextLine();
                            String pesquisa_case8=input.nextLine();

                            for (int j = 0; j < (Pesquisa(pesquisa_case8,"jogo",vendas_path)).length; j++) {
                                String cliente_id=Pesquisa(pesquisa_case8,"jogo",vendas_path)[j][1]; // vetor com os ids dos clientes que compraram o jogo

                                for (int k = 0; k < Pesquisa(cliente_id,"idCliente",clientes_path).length; k++) {
                                    for (int l = 0; l < Pesquisa(cliente_id,"idCliente",clientes_path)[0].length; l++) {
                                        System.out.print("\t"+Pesquisa(cliente_id,"idCliente",clientes_path)[k][l]);
                                    }
                                    System.out.println();
                                }
                            }
                            System.out.println("\n");
                            break;

                        case 9://Top 5 Jogos
                            for (int i = 0; i < Melhores(5,"jogo",true,true,vendas_path,categorias_path).length; i++) {
                                for (int j = 0; j < Melhores(5,"jogo",true,true,vendas_path,categorias_path)[i].length; j++) {
                                    System.out.print("\t"+Melhores(5,"jogo",true,true,vendas_path,categorias_path)[i][j]);
                                }
                                System.out.println("€");
                            }
                            System.out.println("\n");
                            break;

                        case 10:// Bottom 5 jogos
                            for (int i = 0; i < Melhores(5,"jogo",false,true,vendas_path,categorias_path).length; i++) {
                                for (int j = 0; j < Melhores(5,"jogo",false,true,vendas_path,categorias_path)[i].length; j++) {
                                    System.out.print("\t"+Melhores(5,"jogo",false,true,vendas_path,categorias_path)[i][j]);
                                }
                                System.out.println("€");
                            }
                            System.out.println("\n");
                            break;
                        case 11:
                            System.out.println("A sair................");
                            System.out.println("\n");
                            break;

                        default:
                            System.out.println("Opção inválida");
                            System.out.println("\n");
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
