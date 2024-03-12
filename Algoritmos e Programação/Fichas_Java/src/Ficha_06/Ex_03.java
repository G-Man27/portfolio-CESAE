package Ficha_06;

public class Ex_03 {
    /**
     * Verifica se o número é par
     *
     * @param numero número inteiro
     * @return Boolean
     */
    public static boolean IsPar(int numero) {
        if (numero % 2 == 0) return true;
        else return false;
    }

    /**
     * Verifica se o número é positivo
     *
     * @param n int Número
     * @return Boolean: true((n>=0): positivo);
     * false((n<0): negativo)
     */
    public static boolean IsPositivo(int n) {
        if (n >= 0) return true;
        else return false;
    }

    /**
     *Verifica se o número é primo
     * @param n int Número
     * @return Boolean: true (é primo);
     * false (não é primo)
     */
    public static boolean IsPrimo(int n) {
        int d = 0;
        boolean primo = false;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                d++;
            }
        }
        if (d > 2 || n <= 0) {
            primo = false; //System.out.println("O número não é primo");
        } else if((n>0)&&((n==1)||(d==2))){
            primo=true; //System.out.println("O número é primo");
        }
        return primo;
    }

    /**
     * Verifica se o número é perfeito
     * (Um número perfeito é um número natural para o qual a soma de todos os seus divisores naturais próprios (excluindo ele mesmo) é igual ao próprio número)
     * @param n
     * @return Boolean: true (é perfeito); false (não é perfeito)
     */
    public static boolean IsPerfeito(int n) {
        int soma = 0;
        boolean primo = false;
        for (int i = 1; i < n; i++) if (n % i == 0) soma += i;
        if (soma==n) return true;
        else return false;
    }


}

