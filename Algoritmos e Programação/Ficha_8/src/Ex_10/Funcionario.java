package Ex_10;

public class Funcionario {
    private String nome;
    private double salario;
    private String departamento;

    public Funcionario(String nome, double salario, String departamento) {
        this.nome = nome;
        this.salario = salario;
        this.departamento = departamento;
    }

    public void aumentarSalario(double aumento) {
        this.salario += aumento*this.salario;
    }

    public void exibiDados(){
        System.out.println("nome : " + this.nome);
        System.out.println("departamento : " + this.departamento);
        System.out.println("salario : " + this.salario);
    }
}
