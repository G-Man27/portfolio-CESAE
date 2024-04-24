package Classes;

public abstract class Entidade {
    protected String nome;
    protected int maxHp;
    protected int hp =maxHp;
    protected int forca;

    public Entidade(String nome, int maxHp, int forca) {
        this.nome = nome;
        this.maxHp = maxHp;
        this.forca = forca;
    }
    public void mostrarDetalhes(){
        System.out.println("**********************************************************************");
        System.out.println("nome: " + nome);
        System.out.println("maxHp: " + maxHp);
        System.out.println("hp: " + hp);
        System.out.println("forca: " + forca);
        System.out.print("**********************************************************************");
    }
}
