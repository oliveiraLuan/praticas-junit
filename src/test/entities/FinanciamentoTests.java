package test.entities;

import entities.Financiamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FinanciamentoTests {
    @Test
    public void construtorDeveCriarFinanciamentoQuandoDadosValidos(){
        Financiamento financiamento = new Financiamento(100, 100000.0, 2000.0);
        financiamento.setMeses(200);
        financiamento.setRendaCliente(3000.0);
        financiamento.setValor(50.000);

        Assertions.assertEquals(200, financiamento.getMeses());
        Assertions.assertEquals(3000.0, financiamento.getRendaCliente());
        Assertions.assertEquals(50.000, financiamento.getValor());
        Assertions.assertNotNull(financiamento);
    }

    @Test
    public void construtorDeveLancarIllegalArgumentExceptionQuandoDadosInvalidos(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financiamento financiamento = new Financiamento(20, 100000.0, 2000.0);
        });
    }
    @Test
    public void calcularEntradaDeveCalcularEntrada(){
        Financiamento financiamento = new Financiamento(100, 100000.0, 2000.0);
        Double entrada = financiamento.calcularEntrada();
        Assertions.assertEquals(20000.0, entrada);
    }
    @Test
    public void calcularPrestacaoDeveCalcularValorDaPrestacao(){
        Financiamento financiamento = new Financiamento(100, 100000.0, 2000.0);
        Double prestacao = financiamento.calcularPrestacao(financiamento.getValor(), financiamento.getMeses());
        Assertions.assertEquals(1000.0, prestacao);
    }

}
