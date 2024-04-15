package Ex_04;

public enum ImovelAcabamento {
    PARA_RESTAURO(50),USADA(10),NOVA(0),NOVA_COM_ALTO_ACABAMENTO(-25);

    private final int desconto; // in percentage
    ImovelAcabamento(int desconto) {
        this.desconto = desconto;
    }

    public double getPrecoFinal(double valor_imovel) {
        double precoFinal=valor_imovel-this.desconto/100*valor_imovel;
        return precoFinal;
    }
}
