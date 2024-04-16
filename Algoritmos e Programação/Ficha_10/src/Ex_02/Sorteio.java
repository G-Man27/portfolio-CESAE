package Ex_02;
import java.util.ArrayList;
import java.util.Random;

public class Sorteio {
    private double premio;
    private ArrayList<Pessoa> participantes;

    public Sorteio(double premio) {
        this.premio = premio;
        this.participantes = new ArrayList<Pessoa>();
    }

    public double getPremio() {
        return premio;
    }

    public void addParticipante(Pessoa novoParticipante) {
        if (novoParticipante.getIdade()>=18) {
            this.participantes.add(novoParticipante);
            System.out.println("Inscrição aceite: " + novoParticipante.getNome());
        }else {
            System.out.println("Inscrição Recusada!: " + novoParticipante.getNome());
        }
    }
    public void imprimirParticipantes(){
        System.out.println("**** Lista de Participantes ****");
        int i=1;
        for (Pessoa p : participantes) {
            System.out.printf("Participante %d: ",i++);
            p.exibirDetalhes();
        }
        System.out.println("__________________________________");
    }

    public Pessoa fazerSorteio(){
        Random rd = new Random();

        int indexVencedor = rd.nextInt(this.participantes.size());

        return this.participantes.get(indexVencedor);

    }
}
