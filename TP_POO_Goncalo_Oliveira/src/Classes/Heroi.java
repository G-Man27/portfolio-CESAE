package Classes;

import Enums.HeroisPermitidos;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Heroi extends Entidade {
    protected HeroisPermitidos job;
    protected int nivel=1;
    protected int ouro;
    protected Arma armaPrincipal;
    protected ArrayList<Consumivel> inventario = new ArrayList<Consumivel>();

    public Heroi(String nome, int maxHp, int forca, int ouro, Arma armaPrincipal, HeroisPermitidos job) {
        super(nome, maxHp, forca);
        this.job = job;
        this.ouro = ouro;
        this.armaPrincipal = armaPrincipal;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
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

    public void setArmaPrincipal(Arma armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }

    public void usarPocao(){
        Scanner input = new Scanner(System.in);
        ArrayList<Pocao> pocoes=new ArrayList<>();
        int p=1;
        for (int i = 0; i < inventario.size(); i++) {
            Consumivel consumivel =  inventario.get(i);
            if (consumivel instanceof Pocao) {
                Pocao pocao = (Pocao) consumivel;
                pocoes.add(pocao);
                System.out.println(p+": ");
                pocao.mostrarDetalhes();
                p++;
            }
        }

        System.out.println();

        boolean usar=false;
        do {
            System.out.print("Quer usar uma poção? (1. Sim|2. Não): ");
            switch (input.nextInt()){
                case 1->usar=true;
                case 2->usar=false;
                default -> System.out.println("Opção inválida");
            }
            if (usar){
                System.out.println("Qual é a poção(nº da poção) a usar ? : ");
                Pocao pocao=pocoes.get(input.nextInt()-1);
                if(this.hp+pocao.incrementoHp>this.maxHp){
                    System.out.print("A poção excede "+(this.maxHp-this.hp+pocao.incrementoHp)+" hp do se Hp max ainda a quer usar uma ? (1. Sim|2. Não): ");
                    switch (input.nextInt()){
                        case 1->usar=true;
                        case 2 -> {break;}
                        default -> System.out.println("Opção inválida");
                    }
                    this.hp=this.maxHp;
                }else {
                    this.hp+=pocao.incrementoHp;
                }
                System.out.println("Hp: " + this.hp);
            }
        }while (usar);
    }
    public ConsumivelCombate usarConsumiveCombate() {
        Scanner input = new Scanner(System.in);
        ArrayList<ConsumivelCombate> consumivelCombates=new ArrayList<>();
        int p=1;
        for (int i = 0; i < inventario.size(); i++) {
            Consumivel consumivel =  inventario.get(i);
            if (consumivel instanceof ConsumivelCombate) {
                ConsumivelCombate consumivelCombate = (ConsumivelCombate) consumivel;
                consumivelCombates.add(consumivelCombate);
                System.out.println(p+": ");
                consumivelCombate.mostrarDetalhes();
                p++;
            }
        }
        if (consumivelCombates.size()<1){
            System.out.println("Não tem consumiveis de combate no seu inventário.");
            return null;
        }

        System.out.println();
        ConsumivelCombate consumivelCombate;
        boolean usar=false;
        System.out.print("Quer usar um consumivel de Combate? (1. Sim|2. Não): ");
        switch (input.nextInt()){
            case 1->usar=true;
            case 2->usar=false;
            default -> System.out.println("Opção inválida");
        }
        if (usar){
            System.out.println("Qual é o consumivel de Combate(nº) a usar ? : ");
            try {
                consumivelCombate=consumivelCombates.get(input.nextInt()-1);
            } catch (IndexOutOfBoundsException exc){
                System.out.println("O nº do iem não é válido");
                return null;
            }
        }else{
            consumivelCombate=null;
        }
        return consumivelCombate;
    }
    
    protected boolean Atacar(Entidade inimigo, boolean especial_usado) {
        Scanner input = new Scanner(System.in);
        boolean permitido=false;
        do {
            System.out.println("Ataque:");
            System.out.println("-1. Ataque Normal;");
            System.out.println("-2. Ataque Especial;");
            System.out.println("-3. Ataque Consumivel;");
            System.out.print("Escolha o método de ataque(nº): ");
            switch (input.nextInt()){
                case 1:
                    inimigo.hp-=(this.forca+this.armaPrincipal.ataque);
                    permitido=true;
                    System.out.println(this.nome + " ataca " + inimigo.nome + " com " + this.armaPrincipal + ", causando " + this.forca + " pontos de dano");
                    System.out.println(this.nome + " vida: " + this.hp + " | " + inimigo.nome + " vida: " + inimigo.hp);
                    break;
                case 2:
                    if (especial_usado){
                        System.out.println("O Ataque especial já foi usado neste combate, escolha outro ataque");
                    }else {
                        inimigo.hp-=(this.forca+this.armaPrincipal.ataqueEspecial);
                        especial_usado=true;
                        permitido=true;
                        System.out.println(this.nome + " ataca " + inimigo.nome + " com o Especial de " + this.armaPrincipal + ", causando " + (this.forca+this.armaPrincipal.ataqueEspecial) + " pontos de dano");
                        System.out.println(this.nome + " vida: " + this.hp + " | " + inimigo.nome + " vida: " + inimigo.hp);
                    }
                    break;
                case 3:
                    ConsumivelCombate consumivelCombate=this.usarConsumiveCombate();
                    if (consumivelCombate != null) {
                        inimigo.hp-=consumivelCombate.ataqueInstantaneo;
                        permitido=true;
                        System.out.println(this.nome + " usa "+ consumivelCombate.nome + " em " + inimigo.nome +  ", causando " + consumivelCombate.ataqueInstantaneo + " pontos de dano");
                        System.out.println(this.nome + " vida: " + this.hp + " | " + inimigo.nome + " vida: " + inimigo.hp);
                    }
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }while (!permitido);
        return especial_usado;
    }

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
                if (this.hp > 0) {
                    especial_usado=this.Atacar(inimigo,especial_usado);
                }
                if (inimigo.hp > 0) {
                    inimigo.Atacar(this);
                    System.out.println(inimigo.nome + " ataca " + this.nome + ", causando " + inimigo.forca + " pontos de dano");
                    System.out.println(this.nome + " vida: " + this.hp + " | " + inimigo.nome + " vida: " + inimigo.hp);
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
            inimigo.hp=inimigo.maxHp;
            System.out.println("****************************************************************************");
        }
        return resultado;
    }

    protected void subirNivel() {
        this.nivel += 1;
        this.maxHp += 10;
        this.forca += 1;
        this.hp += 10;
    }

    public HeroisPermitidos getJob() {
        return job;
    }

    public int getNivel() {
        return nivel;
    }

    public int getOuro() {
        return ouro;
    }

    public Arma getArmaPrincipal() {
        return armaPrincipal;
    }

    public ArrayList<Consumivel> getInventario() {
        return inventario;
    }
}
