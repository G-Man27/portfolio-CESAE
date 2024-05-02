package Classes.Entidades;

import Classes.Items.Arma;
import Enums.HeroisPermitidos;

public class Feiticeiro extends Heroi {
    /**
     * Método construtor de um Feiticeiro
     * @param nome Nome
     * @param maxHp Máximo de Hp
     * @param forca Força
     * @param ouro Ouro
     * @param armaPrincipal Arma Principal
     */
    public Feiticeiro(String nome, int maxHp, int forca, int ouro, Arma armaPrincipal) {
        super(nome, maxHp, forca, ouro,null, HeroisPermitidos.FEITICEIRO);
        //Verificar se a arma pode ser usada
        if (armaPrincipal.getHeroisPermitidos().contains(job)){
            this.armaPrincipal=armaPrincipal;
            Vendedor.removeItem(this.armaPrincipal);
        }else{
            throw new IllegalArgumentException();
        }
    }

}
