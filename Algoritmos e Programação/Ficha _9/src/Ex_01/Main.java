package Ex_01;

public class Main {
    public static void main(String[] args) {


        Carro mercedesA45 = new Carro("Mercedes", "A45", 2023, 420, 2000, 15, TipoCombustivel.GASOLINA);
        Carro mataVelhos = new Carro("Mata", "Velhos", 1964, 80, 4000, 35, TipoCombustivel.DIESEL);
        Carro bolinhas = new Carro("Bolinhas", "Amarelas", 2020, 90, 200, 1.5, TipoCombustivel.GPL);
        Carro ferrari = new Carro("Ferrari", "SF90", 2020, 800, 5000, 30, TipoCombustivel.GASOLINA);
//        Carro ja=new Carro("ds","ds5",2015,5400,220,25,TipoCombustivel.DIESEL);

        Carro vencedor1 = mercedesA45.corrida(mataVelhos);
        Carro vencedor2 = bolinhas.corrida(ferrari);

        Carro vencedorTotal = vencedor1.corrida(vencedor2);

        if (vencedorTotal == null) {
            System.out.println("Empate");
        } else {
            System.out.println("*** Vencedor ***");
            vencedorTotal.exibirDetalhes();
        }
        System.out.println();

        ferrari.ligar();
        mataVelhos.ligar();
        System.out.println();
        ferrari.combustivelConsumido(100);
        ferrari.combustivelConsumido(50);

        System.out.println("Os dois carros gastaram "+(ferrari.combustivelConsumido(97)+mercedesA45.combustivelConsumido(97))+" litros");
        mercedesA45.imprimirCombustivelConsumido(97);
        ferrari.imprimirCombustivelConsumido(97);
        if (ferrari.combustivelConsumido(97)< mercedesA45.combustivelConsumido(97)){
            System.out.println("O Mercedes gastou mais");
        }else {
            System.out.println("O Ferrari gastou mais");

        }
    }
}
