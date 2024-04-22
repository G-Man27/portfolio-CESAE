package Classes;

import Enums.HeroisPermitidos;

import java.util.ArrayList;

public class Arma extends ItemHeroi {
    private int ataque;
    private int ataqueEspecial;

    public Arma(String nome, int preco, ArrayList<HeroisPermitidos> heroisPermitidos, int ataque, int ataqueEspecial) {
        super(nome, preco, heroisPermitidos);
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
        Vendedor.addItem(this);
    }

    public Arma(String nome, int preco, int ataque, int ataqueEspecial) {
        super(nome, preco);
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
        Vendedor.addItem(this);
    }

    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.print("\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        System.out.println("\rAtaque: " + ataque);
        System.out.println("Ataque Especial: " + ataqueEspecial);
        System.out.println("----------------------------------------------------------------------");
    }
}
