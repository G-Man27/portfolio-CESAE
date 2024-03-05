package Ficha_03;

import java.util.Scanner;

public class Ex_15_extra_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("f:" );
        int n=input.nextInt();
        int f=2;
        int sum=2;
        System.out.print("1*2");

        for(int i=2;i<n;i++){
            System.out.print("*" + (i+1));
            sum=f;
            for (int i2=1;i2<=i;i2++){
                f=f+sum;
            }
        }
        System.out.println("=" + f);
    }
}
/*
int n=input.nextInt();
sum=f=n;
for(int i=(n-1);i>1;i--){
        System.out.print("*" + (i+1));
        sum=f;
        for (int i2=i;i2>1;i2--){
        f=f+sum;
        }
        }*/