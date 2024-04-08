package Ex_01;

public class Pessoa {
    private String nome;
    private double altura;
    private int idade;

    public Pessoa(String nome, double altura, int idade){
        this.nome=nome;
        this.altura=altura;
        this.idade=idade;
    }

    public String getNome(){
        return this.nome;
    }

    public double getAltura() {
        return this.altura;
    }

    public int getIdade() {
        return this.idade;
    }
}
