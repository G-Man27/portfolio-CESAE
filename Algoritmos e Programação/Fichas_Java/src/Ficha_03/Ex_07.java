package Ficha_03;

public class Ex_07 {
    public static void main(String[] args) {
        int n=1, s=0;


        while (n<=100){
            System.out.println(n);
            s+=n;
            n++;
        }
        System.out.println("somatório: " + s);
    }
}
