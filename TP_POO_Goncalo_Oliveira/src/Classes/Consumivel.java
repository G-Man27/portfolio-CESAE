package Classes;

import Enums.HeroisPermitidos;

import java.util.ArrayList;

public abstract class Consumivel extends ItemHeroi {
    public Consumivel(String nome, int preco, ArrayList<HeroisPermitidos> heroisPermitidos) {
        super(nome, preco, heroisPermitidos);
    }

    public Consumivel(String nome, int preco) {
        super(nome, preco);
    }
}
