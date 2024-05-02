package Classes.Entidades;

public abstract class Entidade {
    protected String nome;
    protected int maxHp;
    protected int hp;
    protected int forca;

    /**
     * Método construtor de uma Entidade
     * @param nome Nome
     * @param maxHp Máximo de Hp
     * @param forca Força
     */
    public Entidade(String nome, int maxHp, int forca) {
        this.nome = nome;
        this.maxHp = maxHp;
        this.forca = forca;
        this.hp=this.maxHp;
    }

    /**
     * Método getter de nome da Entidade
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método getter de maxHp da Entidade
     * @return maxHp
     */
    public int getMaxHp() {
        return maxHp;
    }

    /**
     * Método getter de Hp da Entidade
     * @return hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * Método getter de Força da Entidade
     * @return forca
     */
    public int getForca() {
        return forca;
    }

    /**
     * Método setter de Hp da Entidade
     * @return hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Método setter de Força da Entidade
     * @return forca
     */
    public void setForca(int forca) {
        this.forca = forca;
    }

    /**
     * Imprime os Detelhes(caracteristicas) de uma Entidade
     */
    public void mostrarDetalhes(){
        System.out.println("**********************************************************************");
        System.out.println("nome: " + nome);
        System.out.println("maxHp: " + maxHp);
        System.out.println("hp: " + hp);
        System.out.println("forca: " + forca);
        System.out.print("**********************************************************************");
    }

    /**
     * Método de a Entidade atacar outra entidade
     * @param inimigo Entidade inimiga
     */
    protected void Atacar(Entidade inimigo){
        inimigo.hp-=this.forca;
    }
}
