package Ficha_06;

import java.util.Scanner;

public class Ex_01 {
    public static String _FazerBarulho(String animal) {
        String barulho = null;
        switch (animal) {
            case "cão", "Cão" -> barulho = "Au au au";
            case "Gato", "gato" -> barulho = "Miau";
            case "Peixe", "peixe" -> barulho = "Glub Glub";
            case "Vaca", "vaca" -> barulho = "Muuuu";
            case "Porco", "porco" -> barulho = "Oinc Oinc";
            default -> System.out.println("nome inválido");
        }
        return barulho;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String animal;

        System.out.println("introduza um animal:");
        animal=input.next();
        System.out.println(_FazerBarulho(animal));
    }
}
