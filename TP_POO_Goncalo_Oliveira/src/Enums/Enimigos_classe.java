package Enums;

import Classes.Entidades.NPC;

import java.util.ArrayList;

public enum Enimigos_classe {
    NORMAL(), MID_BOSS(), BOSS();
    public static Enimigos_classe[] index=Enimigos_classe.values();

    public ArrayList<NPC> enimigos_lista=new ArrayList<NPC>();

    /**
     * Método getter de ArrayList de NPC
     * @return enimigos_lista
     */
    public ArrayList<NPC> getEnimigos_lista() {
        return enimigos_lista;
    }

    /**
     * Método para adicionar um NPC á lista de inimigos da respetiva classe
     * @param npc NPC inimigo
     */
    public void addNPC(NPC npc){
        this.enimigos_lista.add(npc);
    }

    /**
     * Método para remover um NPC á lista de inimigos da respetiva classe
     * @param npc NPC inimigo
     */
    public void removeNPC(NPC npc){
        this.enimigos_lista.remove(npc);
    }
}
