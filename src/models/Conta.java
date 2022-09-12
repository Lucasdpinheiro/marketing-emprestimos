package models;

public abstract class Conta {
    private int numero;

    public Conta(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return this.numero;
    }
}
