package Classes;

import Enums.HeroisPermitidos;

import java.util.ArrayList;

public class ConsumivelCombate extends Consumivel {
    private int ataqueInstantaneo;

    public ConsumivelCombate(String nome, int preco, ArrayList<HeroisPermitidos> heroisPermitidos, int ataqueInstantaneo) {
        super(nome, preco, heroisPermitidos);
        this.ataqueInstantaneo = ataqueInstantaneo;
        Vendedor.addItem(this);
    }

    public ConsumivelCombate(String nome, int preco, int ataqueInstantaneo) {
        super(nome, preco);
        this.ataqueInstantaneo = ataqueInstantaneo;
        Vendedor.addItem(this);
    }

    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.print("\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        System.out.println("\rAtaque Instantâneo: " + ataqueInstantaneo);
        System.out.println("----------------------------------------------------------------------");
    }
}
