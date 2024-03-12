package Ficha_06;

import java.util.Scanner;

public class Ex_02 {
    /**
     * Cria uma linha ,com o numero inteiro recebido, de asteriscos
     * @param Numero_de_Asteriscos Número de Asteriscos
     */
    public static void  _LinhaAsteriscos(int Numero_de_Asteriscos){
        for (int i = 0; i < Numero_de_Asteriscos; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
     * Pede ao utilizador números até que seja introduzido um número inteiro positivo
     * @return O primeiro número inteiro introduzido
     */
    public static int _LerInteiroPositivo(){
        int Numero;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Introduza um número inteiro positvo:");
            Numero= input.nextInt();
        }while (!(Numero>0));
        return Numero;
    }

    public static void main(String[] args) {
        int ast;

        ast=_LerInteiroPositivo();
        _LinhaAsteriscos(ast);
        //ou _LinhaAsteriscos(_LerInteiroPositivo());
    }
}
