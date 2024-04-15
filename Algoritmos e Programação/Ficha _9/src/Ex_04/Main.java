package Ex_04;

import java.math.BigDecimal;

public class Main {
    public static void Imprimir(Imovel imovel) {
        if (imovel == null) {
            System.out.println("Valem o mesmo");
        }else {
            imovel.exibirDetalhes();
        }
    }
    public static void main(String[] args) {
        Imovel imovel1=new Imovel("R. Almeida Garrett",153,"2ªDT","Vila do Conde",ImovelTipo.APARTAMENTO,ImovelAcabamento.USADA,300,3,3,0);
        Imovel imovel2=new Imovel("R. Almeida Garrett",153,"3ªDT","Vila do Conde",ImovelTipo.APARTAMENTO,ImovelAcabamento.PARA_RESTAURO,300,3,3,0);
        Imovel imovel3=new Imovel("R. Joaquim de Almeida",123,"Paços de Ferreira",ImovelTipo.MANSAO,ImovelAcabamento.NOVA_COM_ALTO_ACABAMENTO,2000,10,11,100);
        Imovel imovel4=new Imovel("Av. Dr.Fernado Aroso",1235,"Leça de Palmeira,",ImovelTipo.CASA,ImovelAcabamento.NOVA,700,5,4,20);

        imovel2.exibirDetalhes();
        imovel2.setImovelAcabamento(ImovelAcabamento.USADA);
        imovel2.exibirDetalhes();

        System.out.println();
        System.out.println(BigDecimal.valueOf(imovel3.getValorImovel()).toPlainString());
        System.out.printf("%.0f",imovel3.getValorImovel());
        System.out.println();



        Imprimir(imovel1.compararImoveis(imovel2));
        Imprimir(imovel4.compararImoveis(imovel3));
    }


}