package Classes.Items;

import Classes.Entidades.Vendedor;
import Enums.HeroisPermitidos;

import java.util.ArrayList;

public class Pocao extends Consumivel {
    protected int incrementoHp; //cura x Hp não ultrapassando maxHp
    protected int incrementoForca;

    /**
     * Método costrutor de uma Poção
     * @param nome Nome
     * @param preco Preço
     * @param heroisPermitidos ArrayList HeroisPermitidos
     * @param incrementoHp Valor de Hp que incrementa
     * @param incrementoForca Valor de Força que incrementa
     */
    public Pocao(String nome, int preco, ArrayList<HeroisPermitidos> heroisPermitidos, int incrementoHp, int incrementoForca) {
        super(nome, preco, heroisPermitidos);
        this.incrementoHp = incrementoHp;
        this.incrementoForca = incrementoForca;

        Vendedor.addItem(this);
    }

    /**
     * Método costrutor de uma Poção
     * @param nome Nome
     * @param preco Preço
     * @param incrementoHp Valor de Hp que incrementa
     * @param incrementoForca Valor de Força que incrementa
     */
    public Pocao(String nome, int preco, int incrementoHp, int incrementoForca) {
        super(nome, preco);
        this.incrementoHp = incrementoHp;
        this.incrementoForca = incrementoForca;
        this.addHeroi(HeroisPermitidos.CAVALEIRO);
        this.addHeroi(HeroisPermitidos.FEITICEIRO);
        this.addHeroi(HeroisPermitidos.ARQUEIRO);
        Vendedor.addItem(this);
    }

    /**
     * Método Override de mostrarDetalhes
     */
    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.print("\r\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
        System.out.println("\rCura: " + this.incrementoHp + " Hp");
        System.out.println("Aumento de Forca: " + incrementoForca);
        System.out.println("----------------------------------------------------------------------");
    }

    /**
     * Método getter valor de incremento de Hp da Poção
     * @return incrementoHp
     */
    public int getIncrementoHp() {
        return incrementoHp;
    }

    /**
     * Método getter valor de incremento de Hp da Poção
     * @return incrementoHp
     */
    public int getIncrementoForca() {
        return incrementoForca;
    }
}
