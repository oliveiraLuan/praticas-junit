package entities;

public class Financiamento {
    private Integer meses;
    private Double valor;
    private Double rendaCliente;

    public Financiamento(){

    }

    public Financiamento(Integer meses, Double valor, Double rendaCliente) {
        validarFinanciamento(meses, valor, rendaCliente);
        this.meses = meses;
        this.valor = valor;
        this.rendaCliente = rendaCliente;
    }

    private void validarFinanciamento(Integer meses, Double valor, Double rendaCliente) {
        Double valorPrestacao = calcularPrestacao(valor, meses);
        Double valorMaximoPrestacao = rendaCliente / 2.0;

        if(valorPrestacao > valorMaximoPrestacao){
            throw new IllegalArgumentException("O valor da parcela não pode ser maior do que 50% da renda do cliente");
        }
    }

    public Integer getMeses() {
        return meses;
    }

    public void setMeses(Integer meses) {
        this.meses = meses;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getRendaCliente() {
        return rendaCliente;
    }

    public void setRendaCliente(Double rendaCliente) {
        this.rendaCliente = rendaCliente;
    }

    public Double calcularEntrada() {
        return valor * 0.2;
    }

    public Double calcularPrestacao(Double valor, Integer meses) {
        return valor / meses;
    }
}
