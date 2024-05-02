package Classes.Entidades;

import Enums.Enimigos_classe;

public class NPC extends Entidade {
    protected int ouro;
    protected Enimigos_classe classe;

    /**
     * Método construtor de um NPC
     * @param nome Nome
     * @param maxHp Máximo de Hp
     * @param forca Força
     * @param ouro Ouro
     * @param classe classe (Enimigos_classe (normal,mid_boss,boss))
     */
    public NPC(String nome, int maxHp, int forca, int ouro, Enimigos_classe classe) {
        super(nome, maxHp, forca);
        this.ouro = ouro;
        this.classe=classe;
        //Acicionar automáticamente o NPC á lista de enimigos da respetiva classe
        if (classe.equals(Enimigos_classe.NORMAL)) {
            Enimigos_classe.NORMAL.addNPC(this);
        }else if (classe.equals(Enimigos_classe.MID_BOSS)) {
            Enimigos_classe.MID_BOSS.addNPC(this);
        }else if (classe.equals(Enimigos_classe.BOSS)) {
            Enimigos_classe.BOSS.addNPC(this);
        }
    }

}
