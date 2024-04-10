package Ex_03;

public class Main {
    public static void main(String[] args) {
        Retângulo retângulo=new Retângulo(20,10);
        System.out.println(retângulo.area());
        System.out.println(retângulo.perimetro());
        System.out.println();
        retângulo.Imprimir_area();
        retângulo.Imprimir_perimetro();
    }
}
