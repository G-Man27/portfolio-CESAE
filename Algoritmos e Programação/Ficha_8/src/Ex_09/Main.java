package Ex_09;

public class Main {
    public static void main(String[] args) {
        Produto canetas=new Produto("caneta",0.90);

        canetas.exibirDetalhes();
        System.out.println("____________________________________________________________________________________________________");
        canetas.Comprar(5);
        canetas.exibirDetalhes();
        System.out.println("____________________________________________________________________________________________________");
        canetas.Vender(2);
        canetas.exibirDetalhes();
        System.out.println("____________________________________________________________________________________________________");
        canetas.Comprar(10);
        canetas.exibirDetalhes();
        System.out.println("____________________________________________________________________________________________________");
        canetas.Vender(35);
        canetas.exibirDetalhes();
    }
}
