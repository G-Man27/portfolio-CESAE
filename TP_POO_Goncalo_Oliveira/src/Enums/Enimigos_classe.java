package Enums;

import Classes.NPC;

import java.util.ArrayList;

public enum Enimigos_classe {
    NORMAL(), MID_BOSS(), BOSS();
    public static Enimigos_classe[] index=Enimigos_classe.values();

    public ArrayList<NPC> enimigos_lista=new ArrayList<NPC>();

    public ArrayList<NPC> getEnimigos_lista() {
        return enimigos_lista;
    }
    public void addNPC(NPC npc){
        this.enimigos_lista.add(npc);
    }
    public void removeNPC(NPC npc){
        this.enimigos_lista.remove(npc);
    }
}
