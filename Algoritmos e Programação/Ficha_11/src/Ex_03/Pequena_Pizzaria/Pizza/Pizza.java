package Ex_03.Pequena_Pizzaria.Pizza;

import Ex_03.Pequena_Pizzaria.Enums.TamanhoPizza;
import Ex_03.Pequena_Pizzaria.Ingredientes.Base;
import Ex_03.Pequena_Pizzaria.Ingredientes.Ingredientes;
import Ex_03.Pequena_Pizzaria.Ingredientes.Topping;

import java.util.ArrayList;

public class Pizza {
    private final int MAX_INGREDIENTES=5;
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private TamanhoPizza tamanho;
    private ArrayList<IngredientePizza> ingredientes=new ArrayList<IngredientePizza>();

    public Pizza(int id, String nome, String descricao, double preco, TamanhoPizza tamanho) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tamanho = tamanho;
    }
    public void addIngrediente(Ingredientes ingrediente,double quantidade){
        IngredientePizza ingredientePizza=new IngredientePizza(ingrediente,quantidade);
        if (this.ingredientes.size()>=MAX_INGREDIENTES){
            System.out.println("Não pode adicionar mais ingredientes á pizza");
        }else {
            if (this.ingredientes.isEmpty()){
                if (ingrediente instanceof Base) {
                    this.ingredientes.add(ingredientePizza);
                } else if (ingrediente instanceof Topping) {
                    System.out.println("Necessita de ter uma base primeiro");
                }
            }else {
                if (this.ingredientes.contains(this.getIngredientePizza(ingrediente.getId()))) {
                    System.out.println("A pizza já tem este ingrediente");
                } else {
                    this.ingredientes.add(ingredientePizza);
                }
            }
        }
    }

    public IngredientePizza getIngredientePizza(int ingrediente_id) {
        for (IngredientePizza i : this.ingredientes) {
            if (i.getIngrediente().getId()==ingrediente_id) {
                return i;
            }
        }
        return null;
    }
    public void removerIngredientePizza(int ingrediente_id){
        this.ingredientes.remove(this.getIngredientePizza(ingrediente_id));
    }
    public double calcularCalorias(){
        double calorias=0;
        for (IngredientePizza ingrediente : ingredientes) {
            calorias+= ingrediente.getIngrediente().getCalorias();
        }
        return calorias;
    }

    public void exibirDetalhes(){
        System.out.println("---------------------------------------------------------------------------------------\n");
        System.out.println("*****" + nome + "*****");
    }
}
