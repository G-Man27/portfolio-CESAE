/*import Classes.Entidades.Cavaleiro;
import Classes.Entidades.Heroi;
import Classes.Entidades.NPC;
import Classes.Entidades.Vendedor;
import Classes.Items.Arma;
import Classes.Items.Pocao;
import Enums.Enimigos_classe;
import Enums.HeroisPermitidos;
import Enums.Sala;

public class RPG {
    public static void main(String[] args) {
        Arma arma=new Arma("arco",10,10,20);
        arma.addHeroi(HeroisPermitidos.ARQUEIRO);
        arma.addHeroi(HeroisPermitidos.CAVALEIRO);
        Cavaleiro cavaleiro=new Cavaleiro("cavaleiro",100,20,200,arma);
        Pocao pocao=new Pocao("vida",10,10,0);
        pocao.addHeroi(HeroisPermitidos.CAVALEIRO);
        cavaleiro.addItem(pocao);
        cavaleiro.mostrarDetalhes();
        Vendedor.mostrarInventario();
        Vendedor.removeItem(pocao);
        Vendedor.mostrarInventario();
        Vendedor.addItem(pocao);
        Sala[] salas= Sala.values();
        salas[1].name();
        System.out.println(Sala.index.length);
        Sala.index[3].entrar(cavaleiro);
        cavaleiro.mostrarDetalhes();

        Heroi heroi=new Cavaleiro("ca",10,10,10,arma);
        heroi.mostrarDetalhes();
        NPC npc=new NPC("t",10,5,5, Enimigos_classe.NORMAL);
        heroi.Combate(npc);
    }
}*/
