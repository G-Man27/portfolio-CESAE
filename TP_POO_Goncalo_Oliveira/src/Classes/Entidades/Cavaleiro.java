package Classes.Entidades;

import Classes.Items.Arma;
import Enums.HeroisPermitidos;

public class Cavaleiro extends Heroi {
    /**
     * Método construtor de um Cavaleiro
     * @param nome Nome
     * @param maxHp Máximo de Hp
     * @param forca Força
     * @param ouro Ouro
     * @param armaPrincipal Arma Principal
     */
    public Cavaleiro(String nome, int maxHp, int forca, int ouro, Arma armaPrincipal) {
        super(nome, maxHp, forca, ouro,null, HeroisPermitidos.CAVALEIRO);
        //Verificar se a arma pode ser usada
        if (armaPrincipal.getHeroisPermitidos().contains(job)){
            this.armaPrincipal=armaPrincipal;
            Vendedor.removeItem(this.armaPrincipal);
        }else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Overrride método de atacar
     * @param inimigo Personagem(Heroi)
     */
    @Override
    protected void Atacar(Entidade inimigo) {
        inimigo.hp-=this.forca*0.8;
    }

    /**
     * Overrride método de Combate
     * @param inimigo NPC inimigo
     * @return True- Ganhou( Heroi vivo) | False- Perdeu( Heroi morto)
     */
    @Override
    public boolean Combate(NPC inimigo) {
        boolean resultado=false;
        if (this.hp <= 0) {
            System.out.println("A personagem está morta, não pode combater.");
        } else {
            int turno = 1;
            boolean especial_usado=false;
            System.out.println("****************************************************************************");
            System.out.println(this.nome + "(Lv." + this.nivel + ") VS " + inimigo.nome + ":");
            while (this.hp > 0 && inimigo.hp > 0) {
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Turno " + turno + ":");
                if (inimigo.hp > 0) {
                    inimigo.Atacar(this);
                    System.out.println(inimigo.nome + " ataca " + this.nome + ", causando " + inimigo.forca + " pontos de dano");
                    System.out.println(this.nome + " vida: " + this.hp + " | " + inimigo.nome + " vida: " + inimigo.hp);
                }
                System.out.println();
                if (this.hp > 0) {
                    especial_usado=this.Atacar(inimigo,especial_usado);
                }
                turno++;
                System.out.println("--------------------------------------------------------------------");
            }
            System.out.println("Resultado do combate:");
            if (this.hp > 0 && inimigo.hp <= 0) {
                System.out.println("“Parabéns " + this.job + " " + this.nome + ", ganhou um combate contra um " + inimigo.nome + ", e coletou do corpo do inimigo  " + inimigo.ouro + " de ouro.”");
                this.subirNivel();
                System.out.println("Subiu de nivel:\n-" + this.nome + ": Lv." + this.nivel);
                this.ouro+=inimigo.ouro;
                resultado= true;
            } else {
                System.out.println("“Perdeu”");
                resultado= false;
            }
            System.out.println("****************************************************************************");
        }
        return resultado;
    }
}
