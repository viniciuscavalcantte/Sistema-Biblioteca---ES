package com.library.model;

import java.util.Date;

public class Emprestimo {
    private Livro livro;
    private Estudante estudante;
    private Date dataEmprestimo;

    public Emprestimo(Livro livro, Estudante estudante, Date dataEmprestimo) {
        this.livro = livro;
        this.estudante = estudante;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }
}
