package Ex_03.Pequena_Pizzaria.Pizza;

import Ex_03.Pequena_Pizzaria.Ingredientes.Ingredientes;

public class IngredientePizza {
    private Ingredientes ingrediente;
    private double quantidade;

    public IngredientePizza(Ingredientes ingrediente, double quantidade) {
        this.ingrediente = ingrediente;
        this.quantidade = quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Ingredientes getIngrediente() {
        return ingrediente;
    }

}
