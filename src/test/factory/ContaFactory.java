package test.factory;

import entities.Conta;

public class ContaFactory {
    public static Conta criarContaVazia(){
        return new Conta(1L, 0.0);
    }

    public static Conta criarConta(Double valorInicial){
        return new Conta(1L, valorInicial);
    }
}
