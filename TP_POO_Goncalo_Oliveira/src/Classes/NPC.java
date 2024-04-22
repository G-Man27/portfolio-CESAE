package Classes;

public class NPC extends Entidade {
    protected int ouro;
    public NPC(String nome, int maxHp, int forca, int ouro) {
        super(nome, maxHp, forca);
        this.ouro = ouro;
    }

}
