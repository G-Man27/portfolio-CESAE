package Ex_11;

public class Main {
    public static void main(String[] args) {
        Conta conta_1=new Conta(1,"João",10);
        Conta conta_2=new Conta(302,"João");

//        System.out.println("conta_1: " + conta_1.getN_conta());
//        System.out.println("conta_2: " + conta_2.getN_conta());


        Conta conta_123 = new Conta(123, "Vitor");
        Conta conta_99 = new Conta(99, "Primo da Suiça");
        Conta conta_11 = new Conta(11, "Joaquim");

        // Contas começam todas a 0
        conta_123.exibirDetalhes();
        conta_99.exibirDetalhes();
        conta_11.exibirDetalhes();
        System.out.println();

        // Conta 123 deposita 100€
        conta_123.depositar(100);
        conta_123.exibirDetalhes();
        conta_99.exibirDetalhes();
        conta_11.exibirDetalhes();
        System.out.println();

        // Conta 123 tenta levantar 400€
        conta_123.levantar(400);
        conta_123.exibirDetalhes();
        conta_99.exibirDetalhes();
        conta_11.exibirDetalhes();
        System.out.println();

        // Conta123 levanta 10
        conta_123.levantar(10);
        conta_123.exibirDetalhes();
        conta_99.exibirDetalhes();
        conta_11.exibirDetalhes();
        System.out.println();

        // Conta 123 transfere 50€ para conta 99
        conta_123.transferir(50, conta_99);
        conta_123.exibirDetalhes();
        conta_99.exibirDetalhes();
        conta_11.exibirDetalhes();
        System.out.println();

        // Conta 99 deposita 10000€
        conta_99.depositar(10000);
        conta_123.exibirDetalhes();
        conta_99.exibirDetalhes();
        conta_11.exibirDetalhes();
        System.out.println();

        // Conta 99 transfere 9900€ para conta 11
        conta_99.transferir(9900, conta_11);
        conta_123.exibirDetalhes();
        conta_99.exibirDetalhes();
        conta_11.exibirDetalhes();
        System.out.println();
    }

}
