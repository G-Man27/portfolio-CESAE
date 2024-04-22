package Classes;

import java.util.ArrayList;

public abstract class Heroi extends Entidade {
    protected int nivel;
    protected int ouro;
    protected Arma armaPrincipal;
    protected ArrayList<Consumivel> inventario = new ArrayList<Consumivel>();
    public Heroi(String nome, int maxHp, int forca, int nivel, int ouro, Arma armaPrincipal) {
        super(nome, maxHp, forca);
        this.nivel = nivel;
        this.ouro = ouro;
        this.armaPrincipal = armaPrincipal;
    }

    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println("\rNivel = " + nivel);
        System.out.println("Ouro = " + ouro);
        System.out.println("Arma Principal = " + armaPrincipal.nome);
        System.out.println("Inventario: ");
        for (Consumivel item :
                inventario) {
            item.mostrarDetalhes();
        }
        System.out.println("**********************************************************************");

    }

    public void addItem(Consumivel element) {
        inventario.add(element);
    }
    public void removeItem(Consumivel element) {
        inventario.add(element);
    }
}
