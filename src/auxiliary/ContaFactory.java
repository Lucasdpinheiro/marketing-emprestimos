package auxiliary;

import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;

public class ContaFactory {
    
    public static Conta criarConta(TipoConta tipoConta, int numero) {
        switch (tipoConta) {
            case CORRENTE:
                return new ContaCorrente(numero);
            case POUPANCA:
                return new ContaPoupanca(numero);
            default:
                return null;
        }
    }
}
