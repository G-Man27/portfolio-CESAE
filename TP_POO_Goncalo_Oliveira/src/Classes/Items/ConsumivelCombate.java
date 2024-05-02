package Classes.Items;

import Classes.Entidades.Vendedor;
import Enums.HeroisPermitidos;

import java.util.ArrayList;

public class ConsumivelCombate extends Consumivel {
    protected int ataqueInstantaneo;

    /**
     * Método construtor de um ConsumivelCombate
     * @param nome Nome
     * @param preco Preço
     * @param heroisPermitidos ArrayList de HeroisPermitidos
     * @param ataqueInstantaneo Ataque Instantâneo
     */
    public ConsumivelCombate(String nome, int preco, ArrayList<HeroisPermitidos> heroisPermitidos, int ataqueInstantaneo) {
        super(nome, preco, heroisPermitidos);
        this.ataqueInstantaneo = ataqueInstantaneo;
        Vendedor.addItem(this);
    }

    /**
     * Método construtor de um ConsumivelCombate
     * @param nome Nome
     * @param preco Preço
     * @param ataqueInstantaneo Ataque Instantâneo
     */
    public ConsumivelCombate(String nome, int preco, int ataqueInstantaneo) {
        super(nome, preco);
        this.ataqueInstantaneo = ataqueInstantaneo;
        Vendedor.addItem(this);
    }

    /**
     * Método getter de ataque instantâneo do ConsumivelCombate
     * @return ataqueInstantaneo
     */
    public int getAtaqueInstantaneo() {
        return this.ataqueInstantaneo;
    }

    /**
     * Método Override de mostrarDetalhes
     */
    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.print("\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        System.out.println("\rAtaque Instantâneo: " + ataqueInstantaneo);
        System.out.println("----------------------------------------------------------------------");
    }
}
