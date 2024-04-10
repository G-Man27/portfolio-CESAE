package Ex_04;

import static java.lang.Math.PI;

public class Circulo {
    private double raio;

    public Circulo(double raio){
        this.raio=raio;
    }

    public double getRaio() {
        return raio;
    }

    public double area(){
        double area=PI*Math.pow(this.raio,2);
        return area;
    }

    public double perimetro(){
        double perimetro=2*PI*this.raio;
        return perimetro;
    }
}
