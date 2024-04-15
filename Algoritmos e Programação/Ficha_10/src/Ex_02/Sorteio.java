package Ex_02;
import java.util.ArrayList;
public class Sorteio {
    private double premio;
    private ArrayList<Pessoa> participantes;

    public Sorteio(double premio) {
        this.premio = premio;
        this.participantes = new ArrayList<Pessoa>();
    }

    public void addParticipante(Pessoa novoParticipante) {
        if (novoParticipante.getIdade()<=18) {
            this.participantes.add(novoParticipante);
            System.out.println("Inscrição aceite: " + novoParticipante.getNome());
        }else {
            System.out.println("Inscrição Recusada!: " + novoParticipante.getNome());
        }
    }
    public void imprimirParticipante(){
        int i=0;
        for (Pessoa p : participantes) {
            System.out.printf("Participante %i: %s | %d | %s | %s",i++,p.getNome(),p.getIdade(),p.getTelemovel(),p.getEmail());
        }
    }
}
