package Ex_03.Pequena_Pizzaria.Ingredientes;

import Ex_03.Pequena_Pizzaria.Enums.OrigemIngrediente;
import Ex_03.Pequena_Pizzaria.Enums.UnidadeMedida;

public class Topping extends Ingredientes {

    private OrigemIngrediente origem;

    public Topping(int id, String nome, UnidadeMedida unidadeMedida, double calorias, OrigemIngrediente origem) {
        super(id, nome, unidadeMedida, calorias);
        this.origem = origem;
    }
}
