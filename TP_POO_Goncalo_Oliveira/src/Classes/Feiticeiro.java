package Classes;

import Enums.HeroisPermitidos;

public class Feiticeiro extends Heroi {
    public Feiticeiro(String nome, int maxHp, int forca, int ouro, Arma armaPrincipal) {
        super(nome, maxHp, forca, ouro,null, HeroisPermitidos.FEITICEIRO);
        if (armaPrincipal.heroisPermitidos.contains(job)){
            this.armaPrincipal=armaPrincipal;
            Vendedor.removeItem(this.armaPrincipal);
        }else{
            throw new IllegalArgumentException();
        }
    }

}
