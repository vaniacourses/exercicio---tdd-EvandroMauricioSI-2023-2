package tdd_processador_boletos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ProcessadorBoletoTest {

	    @Test
	    public void testFaturaPaga_BoletosSuficientes() {
	        Boleto[] boletos = {
	            new Boleto("123", "2023-08-01", 500.00),
	            new Boleto("124", "2023-08-02", 400.00),
	            new Boleto("125", "2023-08-03", 600.00)
	        };
	        Fatura fatura = new Fatura(1500.00, "Cliente");
	        Pagamento[] pagamentos = ProcessadorBoletos.processarBoletos(boletos, fatura);
	        assertTrue(fatura.estaPaga());
	        assertEquals(3, pagamentos.length);
	    }

	    @Test
	    public void testFaturaPaga_BoletosExcedentes() {
	        Boleto[] boletos = {
	            new Boleto("123", "2023-08-01", 1000.00),
	            new Boleto("124", "2023-08-02", 500.00),
	            new Boleto("125", "2023-08-03", 250.00)
	        };
	        Fatura fatura = new Fatura(1500.00, "Cliente");
	        Pagamento[] pagamentos = ProcessadorBoletos.processarBoletos(boletos, fatura);
	        assertTrue(fatura.estaPaga());
	        assertEquals(3, pagamentos.length);
	    }

	    @Test
	    public void testFaturaNaoPaga_BoletosInsuficientes() {
	        Boleto[] boletos = {
	            new Boleto("123", "2023-08-01", 500.00),
	            new Boleto("124", "2023-08-02", 400.00)
	        };
	        Fatura fatura = new Fatura(2000.00, "Cliente");
	        Pagamento[] pagamentos = ProcessadorBoletos.processarBoletos(boletos, fatura);
	        assertFalse(fatura.estaPaga());
	        assertEquals(2, pagamentos.length);
	    }	
}
