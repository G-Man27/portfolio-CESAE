package Ex_02.Enum;

public enum TipoCombustivel {
    GASOLINA(2.10),DIESEL(1.95),GPL(1.15),ELETRICO(0.12);
    private final double valor;

    TipoCombustivel(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
