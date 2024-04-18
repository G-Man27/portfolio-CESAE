package Ex_03.Classes;

public abstract class Pessoa {
    protected String nome;
    protected int anoNascimento;
    protected String email;
    protected String telemovel;

    public Pessoa(String nome, int anoNascimento, String email, String telemovel) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.email = email;
        this.telemovel = telemovel;
    }

    public abstract String obterFuncao();
    public void exibirDetalhes(){
        System.out.println("-----------------------------------------");
        System.out.println("nome: " + nome);
        System.out.println("anoNascimento: " + anoNascimento);
        System.out.println("email: " + email);
        System.out.println("telemovel: " + telemovel);
        System.out.println("-----------------------------------------");
    }
    public abstract void imprimirHorario();
}
