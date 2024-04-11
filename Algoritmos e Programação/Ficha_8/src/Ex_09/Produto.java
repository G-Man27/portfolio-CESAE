package Ex_09;

public class Produto {
    private String nome;
    private double preco;
    private int stock =0;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void Comprar(int quantidade) {
        this.stock += quantidade;
    }

    public void Vender(int quantidade) {
        if (this.stock >= quantidade) {
            this.stock -= quantidade;
        }else {
            System.out.println("Stock insuficiente");
        }
    }

    public void exibirDetalhes(){
        System.out.println("nome : " + nome);
        System.out.println("preco : " + preco);
        System.out.println("stock : " + stock);
    }

}
