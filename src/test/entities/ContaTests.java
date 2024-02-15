package test.entities;

import entities.Conta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTests {
    @Test
    public void depositoDeveIncrementarSaldoQuandoMontantePositivo(){
        Conta conta = new Conta(1L, 0.0);
        conta.deposito(500.00);

        Double saldoEsperado = 500.00;

        Assertions.assertEquals(conta.getSaldo(), saldoEsperado);
    }
    @Test
    public void saqueNaoDeveFazerNadaQuandoMontanteNegativo(){
        Conta conta = new Conta(1L, 500.00);
        conta.deposito(-200.00);
        Double saldoEsperado = 500.00;

        Assertions.assertEquals(conta.getSaldo(), saldoEsperado);
    }
    @Test
    public void saqueDeveDecrementarSaldoQuandoSaldoSuficiente(){
        Conta conta = new Conta(2L, 320.00);
        conta.saque(100.00);

        Double saldoEsperado = 220.00;

        Assertions.assertEquals(conta.getSaldo(), saldoEsperado);
    }

    @Test
    public void saqueDeveLancarIllegalArgumentExceptionQuandoSaldoInsuficiente(){
        Conta conta = new Conta(3L, 1000.00);
        Assertions.assertThrows(IllegalArgumentException.class, () -> conta.saque(2000.00));
    }
}
