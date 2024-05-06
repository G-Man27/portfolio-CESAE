package Ex_02;

public class TacoFactory {

    public static Taco createTaco(String tipo) {
        switch (tipo) {
            case "vaca" -> {
                return new Taco_Vaca();
            }
            case "frango" -> {
                return new Taco_Frango();
            }
            case "vegetariano" -> {
                return new Taco_Vegetariano();
            }
            default -> throw new IllegalStateException("Unexpected value: " + tipo);
        }
    }
}
