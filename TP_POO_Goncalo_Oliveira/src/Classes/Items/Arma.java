package Classes.Items;

import Classes.Entidades.Vendedor;
import Enums.HeroisPermitidos;

import java.util.ArrayList;

public class Arma extends ItemHeroi {
    protected int ataque;
    protected int ataqueEspecial;

    /**
     * Método construtor de uma Arma
     * @param nome Nome
     * @param preco Preço
     * @param heroisPermitidos ArrayList de HeroisPermitidos
     * @param ataque
     * @param ataqueEspecial
     */
    public Arma(String nome, int preco, ArrayList<HeroisPermitidos> heroisPermitidos, int ataque, int ataqueEspecial) {
        super(nome, preco, heroisPermitidos);
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
        Vendedor.addItem(this);
    }

    /**
     * Método construtor de uma Arma
     * @param nome Nome
     * @param preco Preço
     * @param ataque
     * @param ataqueEspecial
     */
    public Arma(String nome, int preco, int ataque, int ataqueEspecial) {
        super(nome, preco);
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
        Vendedor.addItem(this);
    }

    /**
     * Método Override de mostrarDetalhes
     */
    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.print("\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        System.out.println("\rAtaque: " + ataque);
        System.out.println("Ataque Especial: " + ataqueEspecial);
        System.out.println("----------------------------------------------------------------------");
    }

    /**
     * Método getter de ataque da Arma
     * @return ataque
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Método getter de ataque especial da Arma
     * @return ataqueEspecial
     */
    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }
}
