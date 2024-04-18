package Ex_03.Classes;

public class Aluno extends Pessoa {
        private Curso curso;
        private double mediaNotas;
        private String[][] pauta;
    public Aluno(String nome, int anoNascimento, String email, String telemovel) {
        super(nome, anoNascimento, email, telemovel);
    }

    @Override
    public String obterFuncao() {
        return null;
    }

    @Override
    public void imprimirHorario() {

    }
}
