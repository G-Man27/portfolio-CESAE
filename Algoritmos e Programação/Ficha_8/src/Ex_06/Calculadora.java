package Ex_06;

public class Calculadora {
    public void soma(double n1, double n2){
        double soma=Double.sum(n1,n2);
        System.out.println(soma);
    }

    public void diferenca(double n1, double n2){
        System.out.println(n1-n2);
    }

    public void divisao(double n1, double n2){
        System.out.println(n1/n2);
    }

    public void multiplicacao(double n1, double n2){
        System.out.println(n1*n2);
    }
}
