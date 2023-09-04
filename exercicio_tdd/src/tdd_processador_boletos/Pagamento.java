package tdd_processador_boletos;

public class Pagamento {
    private double valor;
    private String data;
    private String tipo;

    public Pagamento(double valor, String data, String tipo) {
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }

    public String getTipo() {
        return tipo;
    }
}
