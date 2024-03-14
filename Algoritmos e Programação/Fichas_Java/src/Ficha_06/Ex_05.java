package Ficha_06;

public class Ex_05 {
    /**
     * Encontra o maior número de um vetor
     * @param vetor int[] Vetor
     * @return int maior
     */
    public static int Maior(int[] vetor){
        int maior=vetor[0];

        //Encontra o maior
        for (int i = 0; i < vetor.length; i++) if (maior < vetor[i]) maior = vetor[i];
        return maior;
    }

    /**
     * Encontra o menor número de um vetor
     * @param vetor int[] Vetor
     * @return int menor
     */
    public static int Menor(int[] vetor){
        int menor=vetor[0];

        //Encontra o maior
        for (int i = 0; i < vetor.length; i++) if (menor > vetor[i]) menor = vetor[i];
        return menor;
    }
    /**
     * Verifica se um vetor é crescente
     * @param vetor int[] Vetor
     * @return True: Crescente || False: Não é Crescente
     */
    public static boolean IsCrescente(int[] vetor){
        for (int i = 1; i < vetor.length ; i++) if (vetor[i] < vetor[i - 1]) return false;
        return true;
    }

    /*
     * Verifica se um vetor é crescente
     * @param vetor int[] Vetor
     * @return String: "É Crescente" || "Não é Crescente"
     */
/*
    public static String IsCrescente(int[] vetor){
        boolean crescente=true;
        for (int i = 1; i < vetor.length ; i++)
            if (vetor[i] < vetor[i - 1]) {
                crescente = false;
                break;
            }
        if (crescente) return "É Crescente";
        else return "Não é Crescente";
    }
*/
}
