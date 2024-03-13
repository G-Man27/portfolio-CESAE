public class Ex_conjunto {
    /**
     * Calcula o somatório de cada mês, compara os meses e returna o indice do melhor mês
     * @param matriz Matriz[][size:13]
     * @return int indice do melhor mês
     */
    public static int melhorMes(int matriz[][]){
        int soma, melhor=0, melhorMes=1;

        //tomar o primeiro mes como o melhor inicial
        for (int linha = 0; linha < matriz.length; linha++) {
            melhor+=matriz[linha][1];
        }

        //achar melhor
        for (int coluna = 1; coluna < matriz[0].length; coluna++) {
            soma=0;
            //somatório do mes
            for (int linha = 0; linha < matriz.length; linha++) {
                soma+=matriz[linha][coluna];
            }
            //comparar mes com o mes anterior
            if (soma>melhor){
                melhor=soma;
                melhorMes=coluna;
            }
        }
        return melhorMes ;
    }

    /**
     * Calcula o somatório de cada mês, compara os meses e returna o indice do pior mês
     * @param matriz Matriz[][size:13]
     * @return int indice do pior mês
     */
    public static int piorMes(int matriz[][]){
        int soma, pior=0, piorMes=1;

        //tomar o primeiro mes como o pior inicial
        for (int linha = 0; linha < matriz.length; linha++) {
            pior+=matriz[linha][1];
        }
        //achar pior
        for (int coluna = 2; coluna < matriz[0].length; coluna++) {
            soma=0;
            //somatório do mes
            for (int linha = 0; linha < matriz.length; linha++) {
                soma+=matriz[linha][coluna];
            }
            //comparar mes com o mes anterior
            if (soma<pior){
                pior=soma;
                piorMes=coluna;
            }
        }
        return piorMes ;
    }

    /**
     * Traduz o indice do mes para o seu nome
     * @param m Mês
     */
    public static void traducaoMes(int m){
        switch (m){
            case 1 -> System.out.print("Janeiro");
            case 2 -> System.out.print("Fevereiro");
            case 3 -> System.out.print("Março");
            case 4 -> System.out.print("Abril");
            case 5 -> System.out.print("Maio");
            case 6 -> System.out.print("Junho");
            case 7 -> System.out.print("Julho");
            case 8 -> System.out.print("Agosto");
            case 9 -> System.out.print("Setembro");
            case 10 -> System.out.print("Outubro");
            case 11 -> System.out.print("Novembro");
            case 12 -> System.out.print("Dezembro");
            default -> System.out.print("inválido");
        }
    }

    public static void main(String[] args) {
        int[][] matriz= {{0,1905,3140,908},{1,2140,4412,1102},{2,420,1290,599}};
        System.out.println(melhorMes(matriz));
        System.out.println(piorMes(matriz));
        traducaoMes(melhorMes(matriz));
        System.out.println();
        traducaoMes(piorMes(matriz));
    }
}
