package Ficha_06;

public class Ex_01 {
    public static String _FazerBarulho(String animal) {        
        switch (animal) {
            case "cão":
            case "Cão":
                return "Au au au";

            case "Gato":
            case "gato":
                return "Miau";

            case "Peixe":
            case "peixe":
                return "Glub Glub";

            case "Vaca":
            case "vaca":
                return "Muuuu";

            case "Porco":
            case "porco":
                return "Oinc Oinc";

            default:
                System.out.println("nome inválido");
        }
    }
}
