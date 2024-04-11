package Ex_08;

public class Main {
    public static void main(String[] args) {
        Aluno joao=new Aluno("João",27,"Softdev",9);
        Aluno ana=new Aluno("Ana",26,"Softdev",15.5);

        System.out.println("Main.main\n");
        System.out.println(joao.getNome()+":");
        System.out.print(joao.getCurso()+": ");
        System.out.println(joao.Situacao()+" com média de "+ joao.getMedia()+" valores");
        System.out.println("--------------------------------------------------------------------");
        System.out.println(ana.getNome()+":");
        System.out.print(ana.getCurso()+": ");
        System.out.println(ana.Situacao()+" com média de "+ ana.getMedia()+" valores");    }
}
