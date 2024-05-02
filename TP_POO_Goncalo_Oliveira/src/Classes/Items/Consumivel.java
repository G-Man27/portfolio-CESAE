package Classes.Items;

import Enums.HeroisPermitidos;

import java.util.ArrayList;

public abstract class Consumivel extends ItemHeroi {
    /**
     * Método construtor de um Consumivel
     * @param nome Nome
     * @param preco Preço
     * @param heroisPermitidos ArrayList de HeroisPermitidos
     */
    public Consumivel(String nome, int preco, ArrayList<HeroisPermitidos> heroisPermitidos) {
        super(nome, preco, heroisPermitidos);
    }

    /**
     * Método construtor de um Consumivel
     * @param nome Nome
     * @param preco Preço
     */
    public Consumivel(String nome, int preco) {
        super(nome, preco);
    }
}
