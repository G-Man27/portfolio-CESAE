package Ex_02;

import Ex_02.Classes.Jobs;
import Ex_02.Classes.NPC;
import Ex_02.Classes.Personagem;

public class Jogo {
    public static void main(String[] args) {
        Personagem player1= new Personagem("Gonçalo",100,20, Jobs.MAGO,"fireball");
        NPC npc_cavaleiro=  new NPC("Cavaleiro",100,10);
        NPC npc_arqueiro=  new NPC("Arqueiro",105,15);
        NPC npc_mago=  new NPC("Mago",110,20);
        NPC npc_boss=  new NPC("BOSS",200,25);

        player1.Combate(npc_cavaleiro);
        System.out.println();
        player1.Combate(npc_arqueiro);
        System.out.println();
        player1.Combate(npc_mago);
        System.out.println();
        player1.Combate(npc_boss);
        player1.Combate(npc_cavaleiro);
    }
}
