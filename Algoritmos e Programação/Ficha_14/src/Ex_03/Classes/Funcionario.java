package Ex_03.Classes;

import Ex_03.Enums.Funcao;

public class Funcionario extends Pessoa {
    private Funcao funcao;
    public Funcionario(String nome, int anoNascimento, String email, String telemovel, Funcao funcao) {
        super(nome, anoNascimento, email, telemovel);
        this.funcao = funcao;
    }

    @Override
    public String obterFuncao() {
        return null;
    }

    @Override
    public void imprimirHorario() {

    }
}
