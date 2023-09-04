package tdd_processador_boletos;

public class ProcessadorBoletos {

    public static Pagamento[] processarBoletos(Boleto[] boletos, Fatura fatura) {
        double totalPago = 0.0;

        for (Boleto boleto : boletos) {
            totalPago += boleto.getValor();
            fatura.adicionarPagamento(boleto.getValor(), boleto.getData(), "BOLETO");

            if (totalPago >= fatura.getValorTotal()) {
                fatura.marcarComoPaga();
                break;
            }
        }

        return fatura.getPagamentos();
    }
}