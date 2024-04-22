package Classes;

import Enums.HeroisPermitidos;

public class Feiticeiro extends Heroi {
    protected final HeroisPermitidos job=HeroisPermitidos.FEITICEIRO;
    public Feiticeiro(String nome, int maxHp, int forca, int nivel, int ouro, Arma armaPrincipal) {
        super(nome, maxHp, forca, nivel, ouro,null);
        if (armaPrincipal.heroisPermitidos.contains(job)){
            this.armaPrincipal=armaPrincipal;
            Vendedor.removeItem(this.armaPrincipal);
        }else{
            throw new IllegalArgumentException();
        }
    }

}
