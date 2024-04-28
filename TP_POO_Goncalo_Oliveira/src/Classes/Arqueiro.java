package Classes;

import Enums.HeroisPermitidos;

public class Arqueiro extends Heroi {
    public Arqueiro(String nome, int maxHp, int forca, int ouro, Arma armaPrincipal) {
        super(nome, maxHp, forca, ouro,null,HeroisPermitidos.ARQUEIRO);
        if (armaPrincipal.heroisPermitidos.contains(job)){
            this.armaPrincipal=armaPrincipal;
            Vendedor.removeItem(this.armaPrincipal);
        }else{
            throw new IllegalArgumentException();
        }
    }

}
