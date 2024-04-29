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

    public String getNome() {
        return nome;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getForca() {
        return forca;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void mostrarDetalhes(){
        System.out.println("**********************************************************************");
        System.out.println("nome: " + nome);
        System.out.println("maxHp: " + maxHp);
        System.out.println("hp: " + hp);
        System.out.println("forca: " + forca);
        System.out.print("**********************************************************************");
    }
    protected void Atacar(Entidade inimigo){
        inimigo.hp-=this.forca;
    }
}
