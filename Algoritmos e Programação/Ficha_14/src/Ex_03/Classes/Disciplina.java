package Ex_03.Classes;

import Ex_03.Enums.AreaFormacao;

import java.util.Scanner;

public class Disciplina {
    private String nome;
    private AreaFormacao area;
    private int duracaoHoras;

    public Disciplina(String nome, AreaFormacao area, int duracaoHoras) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nome da disciplina: ");
        this.nome = input.nextLine();
        do {
            System.out.print("Area de formacao: ");
            String dis_are=input.next().toUpperCase();
            if (AreaFormacao.valueOf(dis_are))
        }while (area == null);
        this.area = area;
        this.duracaoHoras = duracaoHoras;
    }
}
