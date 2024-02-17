package test.entities;

import entities.Conta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.factory.ContaFactory;

public class ContaTests {
    @Test
    public void depositoDeveIncrementarSaldoQuandoMontantePositivo(){
        Conta conta = ContaFactory.criarContaVazia();
        conta.deposito(500.00);

        Double saldoEsperado = 500.00;

        Assertions.assertEquals(conta.getSaldo(), saldoEsperado);
    }
    @Test
    public void saqueNaoDeveFazerNadaQuandoMontanteNegativo(){
        Conta conta = ContaFactory.criarConta(500.00);
        conta.deposito(-200.00);
        Double saldoEsperado = 500.00;

        Assertions.assertEquals(conta.getSaldo(), saldoEsperado);
    }
    @Test
    public void saqueDeveDecrementarSaldoQuandoSaldoSuficiente(){
        Conta conta = ContaFactory.criarConta(320.0);
        conta.saque(100.00);

        Double saldoEsperado = 220.00;

        Assertions.assertEquals(conta.getSaldo(), saldoEsperado);
    }

    @Test
    public void saqueDeveLancarIllegalArgumentExceptionQuandoSaldoInsuficiente(){
        Conta conta = ContaFactory.criarConta(1000.0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> conta.saque(2000.00));
    }

    @Test
    public void saqueTotalDeveZerarSaldoERetornarValorSacado(){
        Double valorInicial = 500.0;
        Double saldoEsperado = 0.0;

        Conta conta = ContaFactory.criarConta(valorInicial);

        Double valorSacado = conta.saqueTotal();

        Assertions.assertEquals(conta.getSaldo(), saldoEsperado);
        Assertions.assertEquals(valorInicial, valorSacado);
    }
}
