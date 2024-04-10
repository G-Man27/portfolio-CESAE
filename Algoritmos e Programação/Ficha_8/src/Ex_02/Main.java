package Ex_02;

public class Main {
    public static void main(String[] args) {
        Cao java=new Cao("Java","Cão da Pomerânia");
        Cao neo=new Cao("Neo","Akita");
        Cao storm=new Cao("Storm","Cão da Serra da Estrela");

        neo.setLatido("Ruff ruff ruff");
        storm.setLatido("Woof woof woof");

        System.out.print("O "+java.getRaça()+" "+java.getNome()+": ");
        java.Ladrar();
        System.out.print("O "+neo.getRaça()+" "+neo.getNome()+": ");
        neo.Ladrar();
        System.out.print("O "+storm.getRaça()+" "+storm.getNome()+": ");
        storm.Ladrar();

    }
}
