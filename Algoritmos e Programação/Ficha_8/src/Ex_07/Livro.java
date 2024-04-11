package Ex_07;

public class Livro {
    private String titulo;
    private String autor;
    private String categoria;
    private int n_paginas;
    private String isbn;

    public Livro(String titulo, String autor, String categoria, int n_paginas, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.n_paginas = n_paginas;
        this.isbn = isbn;
    }

    public void exibirDetalhes(){
        System.out.println("titulo : " + titulo);
        System.out.println("autor : " + autor);
        System.out.println("categoria : " + categoria);
        System.out.println("n_paginas : " + n_paginas);
        System.out.println("isbn : " + isbn);
    }
}
