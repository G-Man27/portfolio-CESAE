package Ex_04;

import java.lang.invoke.VarHandle;

public class Imovel {
    private String rua;
    private int n_porta;
    private String andar_posicao=null;
    private String cidade;
    private ImovelTipo imovelTipo;
    private ImovelAcabamento imovelAcabamento;
    private double area;
    private int n_quartos;
    private int n_WC;
    private double area_piscina;

    public Imovel(String rua, int n_porta, String andar_posicao, String cidade, ImovelTipo imovelTipo, ImovelAcabamento imovelAcabamento, double area, int n_quartos, int n_WC, double area_piscina) {
        this.rua = rua;
        this.n_porta = n_porta;
        this.andar_posicao = andar_posicao;
        this.cidade = cidade;
        this.imovelTipo = imovelTipo;
        this.imovelAcabamento = imovelAcabamento;
        this.area = area;
        this.n_quartos = n_quartos;
        this.n_WC = n_WC;
        this.area_piscina = area_piscina;
    }

    public Imovel(String rua, int n_porta, String cidade, ImovelTipo imovelTipo, ImovelAcabamento imovelAcabamento, double area, int n_quartos, int n_WC, double area_piscina) {
        this.rua = rua;
        this.n_porta = n_porta;
        this.cidade = cidade;
        this.imovelTipo = imovelTipo;
        this.imovelAcabamento = imovelAcabamento;
        this.area = area;
        this.n_quartos = n_quartos;
        this.n_WC = n_WC;
        this.area_piscina = area_piscina;
    }

    public double getValorImovel(){
        double valor_imovel=0;

        /*switch (this.imovelTipo){
            case APARTAMENTO -> valor_imovel+=1000*this.area;
            case CASA -> valor_imovel+=3000*this.area;
            case MANSAO -> valor_imovel+=5000*this.area;
        }*/
        valor_imovel+=this.imovelTipo.value_m2()*this.area;

        valor_imovel+=this.n_quartos*7500;

        valor_imovel+=this.n_WC*10500;

        valor_imovel+=this.area_piscina*1000;

/*
        switch (this.imovelAcabamento){
            case PARA_RESTAURO -> valor_imovel=valor_imovel*0.5;
            case USADA -> valor_imovel-=valor_imovel*0.1;
            case NOVA -> valor_imovel=valor_imovel;
            case NOVA_COM_ALTO_ACABAMENTO -> valor_imovel+=0.25*valor_imovel;
        }
*/
        return this.imovelAcabamento.getPrecoFinal(valor_imovel);

        //return valor_imovel;
    }

    public void setImovelAcabamento(ImovelAcabamento imovelAcabamento) {
        this.imovelAcabamento = imovelAcabamento;
    }

    public void exibirDetalhes(){
        System.out.println("________________________________________________________");
        System.out.println("Detalhes do imóvel:");
        System.out.println("-Tipo : " + this.imovelTipo.name());
        System.out.println("-Área : " + this.area);
        System.out.println("-Nº de quartos : " + this.n_quartos);
        System.out.println("-Nº de WC : " + this.n_WC);
        if (area_piscina==0){
            System.out.println("-Área da piscina : Não tem piscina");
        }else System.out.println("-Área da piscina : " + this.area_piscina);
        System.out.println("-Acabamento : " + this.imovelAcabamento);
        System.out.println();
        System.out.println("Localização:");
        System.out.println("-Rua : " + this.rua);
        System.out.println("-Nº da porta : " + this.n_porta);
        System.out.println("-Cidade : " + this.cidade);
        System.out.println("-------------------------------------------------------");
    }

    public Imovel compararImoveis(Imovel outroImovel){
        if (this.getValorImovel()<outroImovel.getValorImovel()){
            return outroImovel;
        } else if (this.getValorImovel()>outroImovel.getValorImovel()) {
            return this;
        }else return null;
    }
}
