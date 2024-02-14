package entities;

public class Conta {
    private Long id;
    private Double saldo;

    public Conta(){

    }
    public Conta(Long id, Double saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void deposito(double montante) {
        this.saldo = saldo + montante;
    }

    public void saque(double valor) {
        if(valor > saldo){
            throw new IllegalArgumentException();
        }
        saldo = saldo - valor;
    }
}
