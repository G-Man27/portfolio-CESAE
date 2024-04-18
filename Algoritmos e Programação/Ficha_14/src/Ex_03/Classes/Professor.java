package Ex_03.Classes;

import Ex_03.Enums.AreaFormacao;

import java.util.ArrayList;

public class Professor extends Pessoa {
    private ArrayList<AreaFormacao> areaFormacoes=new ArrayList<AreaFormacao>();
    private int nivelAcademico;
    public Professor(String nome, int anoNascimento, String email, String telemovel, int nivelAcademico) {
        super(nome, anoNascimento, email, telemovel);
        this.nivelAcademico = nivelAcademico;
    }

    @Override
    public String obterFuncao() {
        return null;
    }

    @Override
    public void imprimirHorario() {

    }
}
