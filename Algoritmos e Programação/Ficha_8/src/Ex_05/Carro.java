package Ex_05;


public class Carro {
    private String marca;
    private String modelo;
    private int year;

    public Carro(String marca, String modelo, int year) {
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getYear() {
        return year;
    }

    public void Ligar(){
        System.out.println("O "+this.marca+" "+this.modelo+"("+this.year+") está ligado");
    }
}
