package Ex_03.Pequena_Pizzaria.Ingredientes;

import Ex_03.Pequena_Pizzaria.Enums.BasePizza;
import Ex_03.Pequena_Pizzaria.Enums.UnidadeMedida;

public class Base extends Ingredientes {
    private BasePizza tipoBase;
    private String descricao;


    public Base(int id, String nome, double calorias, BasePizza tipoBase, String descricao) {
        super(id, nome, UnidadeMedida.GRAMAS, calorias);
        this.tipoBase = tipoBase;
        this.descricao = descricao;
    }
}
