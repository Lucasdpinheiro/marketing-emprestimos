package models;

import java.time.LocalDate;

public class Cliente {
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String email;
    private Conta conta;
    private Agencia agencia;
    private boolean possuiEmprestimo;

    public Cliente(String nome, String email, Conta conta, Agencia agencia) {
        this.nomeCompleto = nome;
        this.email = email;
        this.conta = conta;
        this.agencia = agencia;
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return this.email;
    }

    public Conta getConta() {
        return this.conta;
    }

    public Agencia getAgencia() {
        return this.agencia;
    }

    public boolean isPossuiEmprestimo() {
        return this.possuiEmprestimo;
    }

    public void setPossuiEmprestimo(boolean possuiEmprestimo) {
        this.possuiEmprestimo = possuiEmprestimo;
    }

    @Override
    public String toString() {
        StringBuilder classRepresentation = new StringBuilder();
        classRepresentation
            .append("Cliente{\n")
            .append(String.format("nomeCompleto=%s\n", this.nomeCompleto))
            .append(String.format("dataNascimento=%s\n", this.dataNascimento))
            .append(String.format("email=%s\n", this.email))
            .append(String.format("conta=%d\n", this.conta.getNumero()))
            .append(String.format("agencia=%d\n", this.agencia.getNumero()))
            .append(String.format("possuiEmprestimo=%s\n", this.possuiEmprestimo))
            .append("}");

        return classRepresentation.toString();
    }
}