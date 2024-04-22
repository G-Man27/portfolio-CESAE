package Classes;

import Enums.HeroisPermitidos;

import java.util.ArrayList;

public abstract class ItemHeroi {
    protected String nome;
    protected int preco; //em moedas de ouro
    protected ArrayList<HeroisPermitidos> heroisPermitidos;

    public ItemHeroi(String nome, int preco, ArrayList<HeroisPermitidos> heroisPermitidos) {
        this.nome = nome;
        this.preco = preco;
        this.heroisPermitidos = heroisPermitidos;
    }

    public ItemHeroi(String nome, int preco) {
        this.nome = nome;
        this.preco = preco;
        this.heroisPermitidos= new ArrayList<HeroisPermitidos>();
    }

    public void addHeroi(HeroisPermitidos element) {
        heroisPermitidos.add(element);
    }
    public void removeHeroi(HeroisPermitidos element) {
        heroisPermitidos.remove(element);
    }
    public void imprimirHeroisPermitidos(){
        System.out.print("Classes de Heroi que a podem equipar: ");
        for (HeroisPermitidos classe: heroisPermitidos) {
            System.out.print("\t| " + classe + " |");
        }
        System.out.print("\n");
    }

    public void mostrarDetalhes(){
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço: " + this.preco);
        this.imprimirHeroisPermitidos();
        System.out.print("----------------------------------------------------------------------");
    }
}
