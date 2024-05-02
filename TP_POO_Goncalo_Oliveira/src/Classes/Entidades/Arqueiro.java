package Classes.Entidades;

import Classes.Items.Arma;
import Enums.HeroisPermitidos;

public class Arqueiro extends Heroi {
    /**
     * Método construtor de um Arqueiro
     * @param nome Nome
     * @param maxHp Máximo de Hp
     * @param forca Força
     * @param ouro Ouro
     * @param armaPrincipal Arma Principal
     */
    public Arqueiro(String nome, int maxHp, int forca, int ouro, Arma armaPrincipal) {
        super(nome, maxHp, forca, ouro,null,HeroisPermitidos.ARQUEIRO);
        //Verificar se a arma pode ser usada
        if (armaPrincipal.getHeroisPermitidos().contains(job)){
            this.armaPrincipal=armaPrincipal;
            Vendedor.removeItem(this.armaPrincipal);
        }else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Overrride método de atacar
     * @param inimigo Personagem(Heroi)
     */
    @Override
    protected void Atacar(Entidade inimigo) {
        inimigo.hp-=(this.forca*0.1+this.forca);
    }
}
