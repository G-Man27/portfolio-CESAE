package Ex_02;

public class Cao {
    //Atributos
    private String nome;
    private String raça;
    private String latido="Au au au";

    //Construtores
    public Cao(String nome, String raça){
        this.nome=nome;
        this.raça=raça;
    }

    //get methods

    public String getNome() {
        return this.nome;
    }

    public String getRaça() {
        return this.raça;
    }

    public String getLatido() {
        return this.latido;
    }

    //set methods


    public void setLatido(String latido) {
        this.latido = latido;
    }

    public void Ladrar() {
        System.out.println(this.latido);
    }

}
