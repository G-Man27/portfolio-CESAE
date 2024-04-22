package Classes;

import Enums.HeroisPermitidos;

import java.util.ArrayList;

public class Pocao extends Consumivel {
    private int incrementoHp; //cura x Hp não ultrapassando maxHp
    private int incrementoForca;

    public Pocao(String nome, int preco, ArrayList<HeroisPermitidos> heroisPermitidos, int incrementoHp, int incrementoForca) {
        super(nome, preco, heroisPermitidos);
        this.incrementoHp = incrementoHp;
        this.incrementoForca = incrementoForca;
        Vendedor.addItem(this);
    }

    public Pocao(String nome, int preco, int incrementoHp, int incrementoForca) {
        super(nome, preco);
        this.incrementoHp = incrementoHp;
        this.incrementoForca = incrementoForca;
        Vendedor.addItem(this);
    }

    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.print("\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        System.out.println("\rCura: " + this.incrementoHp + " Hp");
        System.out.println("Aumento de Forca: " + incrementoForca);
        System.out.println("----------------------------------------------------------------------");
    }
}
