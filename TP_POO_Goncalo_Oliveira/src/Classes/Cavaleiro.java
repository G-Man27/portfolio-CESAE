package Classes;

import Enums.HeroisPermitidos;

public class Cavaleiro extends Heroi {
    public Cavaleiro(String nome, int maxHp, int forca, int ouro, Arma armaPrincipal) {
        super(nome, maxHp, forca, ouro,null, HeroisPermitidos.CAVALEIRO);
        if (armaPrincipal.heroisPermitidos.contains(job)){
            this.armaPrincipal=armaPrincipal;
            Vendedor.removeItem(this.armaPrincipal);
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    protected void Atacar(Entidade inimigo) {
        inimigo.hp-=this.forca*0.8;
    }

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
