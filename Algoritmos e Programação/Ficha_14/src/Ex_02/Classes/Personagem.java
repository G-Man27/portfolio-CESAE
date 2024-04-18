package Ex_02.Classes;

public class Personagem extends Entidade {
    private int nivel;
    private Jobs categoria;
    private String arma;
    private int max_vida;

    public Personagem(String nome, int vida, int forca, Jobs categoria, String arma) {
        super(nome, vida, forca);
        this.nivel = 1;
        this.categoria = categoria;
        this.arma = arma;
        max_vida = vida;
    }

    private void subirNivel() {
        this.nivel += 1;
        this.max_vida += 0.1 * this.max_vida;
        this.forca += 0.1 * this.forca;
        this.vida = this.max_vida;
    }

    public void Combate(Entidade inimigo) {
        if (this.vida <= 0) {
            System.out.println("A personagem está morta, não pode combater.");
        } else {
            int turno = 1;
            System.out.println("****************************************************************************");
            System.out.println(this.nome + "(Lv." + this.nivel + ") VS " + inimigo.nome + ":");
            while (this.vida > 0 && inimigo.vida > 0) {
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Turno " + turno + ":");
                if (this.vida > 0) {
                    this.Atacar(inimigo);
                    System.out.println(this.nome + " ataca " + inimigo.nome + " com " + this.arma + ", causando " + this.forca + " pontos de dano");
                    System.out.println(this.nome + " vida: " + this.vida + " | " + inimigo.nome + " vida: " + inimigo.vida);
                }
                if (inimigo.vida > 0) {
                    inimigo.Atacar(this);
                    System.out.println(inimigo.nome + " ataca " + this.nome + ", causando " + inimigo.forca + " pontos de dano");
                    System.out.println(this.nome + " vida: " + this.vida + " | " + inimigo.nome + " vida: " + inimigo.vida);
                }
                turno++;
                System.out.println("--------------------------------------------------------------------");
            }
            System.out.println("Resultado do combate:");
            if (this.vida > 0 && inimigo.vida <= 0) {
                System.out.println("“Parabéns " + this.categoria + " " + this.nome + ", ganhou um combate contra um " + inimigo.nome + " com o uso de " + this.arma + ".”");
                this.subirNivel();
                System.out.println("Subiu de nivel:\n-" + this.nome + ": Lv." + this.nivel);
            } else {
                System.out.println("“Perdeu”");
            }
            System.out.println("****************************************************************************");
        }
    }
}
