package Ex_07;

public class Main {
    public static void main(String[] args) {
        Livro livro_1= new LivroBuilder().setTitulo("Java, Tips and Tricks to Programming Code with Java").setAutor("Charlie Masterson").setCategoria("programação").setN_paginas(60).setIsbn("9781542735537, 154273553X").createLivro();
        Livro livro_2=new Livro("Java, Tips and Tricks to Programming Code with Java","Charlie Masterson","programação",60,"9781542735537, 154273553X");
        System.out.println();
        livro_1.exibirDetalhes();
        System.out.println();
        livro_2.exibirDetalhes();
        System.out.println();
        Livro livro=new LivroBuilder().setTitulo("Java").createLivro();
        livro.exibirDetalhes();
    }
}
