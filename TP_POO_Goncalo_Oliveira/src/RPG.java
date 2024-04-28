import Classes.Arma;
import Classes.Cavaleiro;
import Classes.Pocao;
import Classes.Vendedor;
import Enums.HeroisPermitidos;

public class RPG {
    public static void main(String[] args) {
        Arma arma=new Arma("arco",10,10,20);
        arma.addHeroi(HeroisPermitidos.ARQUEIRO);
        arma.addHeroi(HeroisPermitidos.CAVALEIRO);
        Cavaleiro cavaleiro=new Cavaleiro("cavaleiro",100,20,200,arma);
        Pocao pocao=new Pocao("vida",10,10,0);
        cavaleiro.addItem(pocao);
        cavaleiro.mostrarDetalhes();
        Vendedor.mostrarInventario();
        Vendedor.removeItem(pocao);
        Vendedor.mostrarInventario();
    }
}
