package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import auxiliary.ContaFactory;
import auxiliary.TipoConta;
import models.Agencia;
import models.Cliente;
import models.Conta;

public class Desserializador {
    
    public static Cliente criarCliente(String dado) { 
        String[] atributos = dado.split("#");
        
        String nomeCompleto = gerarNome(atributos);
        LocalDate dataNascimento = gerarDatanascimento(atributos);
        String email = gerarEmail(atributos);
        Conta conta = gerarConta(atributos);
        Agencia agencia = gerarAgencia(atributos);
        boolean possuiEmprestimo = gerarPossuiEmprestimo(atributos);

        Cliente cliente = new Cliente(nomeCompleto, email, conta, agencia);
        cliente.setDataNascimento(dataNascimento);
        cliente.setPossuiEmprestimo(possuiEmprestimo);

        return cliente;
    }

    private static String gerarNome(String[] atributos) {
        StringBuilder nameBuilder = new StringBuilder();

        return nameBuilder
            .append(atributos[0])
            .append(" ")
            .append(atributos[1])
            .toString();
    }

    private static LocalDate gerarDatanascimento(String[] atributos) {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(atributos[2], formater);
    }

    private static String gerarEmail(String[] atributos) {
        return atributos[3];
    }

    private static Conta gerarConta(String[] atributos) {
        int numeroConta = Integer.parseInt(atributos[4]);
        TipoConta enumConta = TipoConta.valueOf(atributos[6].toUpperCase());
        return ContaFactory.criarConta(enumConta,  numeroConta);
    }

    private static Agencia gerarAgencia(String[] atributos) {
        int numeroAgencia = Integer.parseInt(atributos[5]);
        return new Agencia(numeroAgencia);
    }

    private static boolean gerarPossuiEmprestimo(String[] atributos) {
        return Boolean.parseBoolean(atributos[7].toLowerCase());
    }
}

