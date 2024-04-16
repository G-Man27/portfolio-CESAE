package Ex_02;

public class Pessoa {
    private String nome;
    private int idade;
    private String telemovel;
    private String email;

    public Pessoa(String nome, int idade, String telemovel, String email) {
        this.nome = nome;
        this.idade = idade;
        this.telemovel = telemovel;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void exibirDetalhes() {
        System.out.printf("%s | %d | %s | %s%n",this.getNome(),this.getIdade(),this.getTelemovel(),this.getEmail());
    }
}
