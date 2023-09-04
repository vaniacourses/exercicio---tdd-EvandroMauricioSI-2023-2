package tdd_processador_boletos;

import java.util.ArrayList;
import java.util.List;

public class Fatura {
    private double valorTotal;
    private String cliente;
    private List<Pagamento> pagamentos;
    private boolean paga;

    public Fatura(double valorTotal, String cliente) {
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.pagamentos = new ArrayList<>();
        this.paga = false;
    }

    public void adicionarPagamento(double valor, String data, String tipo) {
        pagamentos.add(new Pagamento(valor, data, tipo));
    }

    public boolean estaPaga() {
        return paga;
    }

    public void marcarComoPaga() {
        paga = true;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }
}
