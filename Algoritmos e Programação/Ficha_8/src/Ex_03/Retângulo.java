package Ex_03;

public class Retângulo {
    private double comprimento;
    private double largura;

    public Retângulo(double comprimento, double largura){
        this.comprimento=comprimento;
        this.largura=largura;
    }

    public double getLargura() {
        return largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public double area() {
        double area=this.comprimento*this.largura;
        return area;
    }
    public void Imprimir_area(){
        System.out.println(this.area());
    }

    public double perimetro() {
        double perimetro=2*this.comprimento+2*this.largura;
        return perimetro;
    }
    public void Imprimir_perimetro(){
        System.out.println(this.perimetro());
    }
}
