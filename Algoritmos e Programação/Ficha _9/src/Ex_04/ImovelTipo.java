package Ex_04;

public enum ImovelTipo {
    APARTAMENTO(1000),CASA(3000),MANSAO(5000);
    private final int valor_m2; // in euros
    ImovelTipo(int valor_m2) {
        this.valor_m2 = valor_m2;
    }
    public int value_m2() { return this.valor_m2; }
}
