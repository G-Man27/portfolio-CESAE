package Ex_07;

public class LivroBuilder {
    private String titulo;
    private String autor;
    private String categoria;
    private int nPaginas;
    private String isbn;

    public LivroBuilder setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public LivroBuilder setAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public LivroBuilder setCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public LivroBuilder setN_paginas(int nPaginas) {
        this.nPaginas = nPaginas;
        return this;
    }

    public LivroBuilder setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public Livro createLivro() {
        return new Livro(titulo, autor, categoria, nPaginas, isbn);
    }
}