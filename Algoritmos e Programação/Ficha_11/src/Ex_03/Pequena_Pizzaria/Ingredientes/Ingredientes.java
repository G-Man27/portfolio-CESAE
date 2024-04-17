package Ex_03.Pequena_Pizzaria.Ingredientes;

import Ex_03.Pequena_Pizzaria.Enums.UnidadeMedida;

public class Ingredientes {
    private int id;
    private String nome;
    private UnidadeMedida unidadeMedida;
    private double calorias;// kcal/UnidadeMedida


    public Ingredientes(int id, String nome, UnidadeMedida unidadeMedida, double calorias) {
        this.id = id;
        this.nome = nome;
        this.unidadeMedida = unidadeMedida;
        this.calorias = calorias;
    }

    public int getId() {
        return id;
    }

    public double getCalorias() {
        return calorias;
    }
}
