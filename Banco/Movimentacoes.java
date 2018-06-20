package lista06.ufc.com.emanoel;

public class Movimentacoes {
	
	private String descricao;
	private double valor;
	private String creditoOuDebito;
	
	public Movimentacoes(String descricao, double valor, String creditoOuDebito) {
		
		this.descricao = descricao;
		this.valor = valor;
		
		this.creditoOuDebito = creditoOuDebito;
	}
	
	
	@Override
	public String toString() {
		
		return  "\n\nDescrição: " + descricao + "\nValor: " + valor + 
				"\n" + creditoOuDebito;
		
	}	
}
