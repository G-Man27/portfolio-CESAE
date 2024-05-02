package Classes.Items;

import Enums.HeroisPermitidos;

import java.util.ArrayList;

public abstract class ItemHeroi {
    protected String nome;
    protected int preco; //em moedas de ouro
    protected ArrayList<HeroisPermitidos> heroisPermitidos;

    /**
     * Método construtor de um ItemHeroi
     * @param nome Nome
     * @param preco Preço
     * @param heroisPermitidos ArrayList de HeroisPermitidos
     */
    public ItemHeroi(String nome, int preco, ArrayList<HeroisPermitidos> heroisPermitidos) {
        this.nome = nome;
        this.preco = preco;
        this.heroisPermitidos = heroisPermitidos;
    }

    /**
     * Método construtor de um ItemHeroi
     * @param nome Nome
     * @param preco Preço
     */
    public ItemHeroi(String nome, int preco) {
        this.nome = nome;
        this.preco = preco;
        this.heroisPermitidos= new ArrayList<HeroisPermitidos>();
    }

    /**
     * Método para adicionar um HeroisPermitidos á lista de HeroisPermitidos, heroisPermitidos
     * @param element HeroisPermitidos
     */
    public void addHeroi(HeroisPermitidos element) {
        heroisPermitidos.add(element);
    }
    /**
     * Método para remover um HeroisPermitidos da lista de HeroisPermitidos, heroisPermitidos
     * @param element HeroisPermitidos
     */
    public void removeHeroi(HeroisPermitidos element) {
        heroisPermitidos.remove(element);
    }

    /**
     * Imprime a lista de HeroisPermitidos
     */
    public void imprimirHeroisPermitidos(){
        System.out.print("Classes de Heroi que a podem equipar: ");
        for (HeroisPermitidos classe: heroisPermitidos) {
            System.out.print("\t| " + classe + " |");
        }
        System.out.print("\n");
    }

    /**
     * Imprime os Detelhes(caracteristicas) de um ItemHeroi
     */
    public void mostrarDetalhes(){
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço: " + this.preco);
        this.imprimirHeroisPermitidos();
        System.out.print("----------------------------------------------------------------------");
    }

    /**
     * Método getter de nome do ItemHeroi
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método getter de preço do ItemHeroi
     * @return preco
     */
    public int getPreco() {
        return preco;
    }

    /**
     * Método getter do ArrayList HeroisPermitidos do ItemHeroi
     * @return heroisPermitidos
     */
    public ArrayList<HeroisPermitidos> getHeroisPermitidos() {
        return heroisPermitidos;
    }
}
