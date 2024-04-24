package Classes;

import Enums.HeroisPermitidos;

public class Cavaleiro extends Heroi {
    protected final HeroisPermitidos job=HeroisPermitidos.CAVALEIRO;
    public Cavaleiro(String nome, int maxHp, int forca, int nivel, int ouro, Arma armaPrincipal) {
        super(nome, maxHp, forca, nivel, ouro,null);
        if (armaPrincipal.heroisPermitidos.contains(job)){
            this.armaPrincipal=armaPrincipal;
            Vendedor.removeItem(this.armaPrincipal);
        }else{
            throw new IllegalArgumentException();
        }
    }

}
