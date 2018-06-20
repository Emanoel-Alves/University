package lista06.ufc.com.emanoel;

import java.util.ArrayList;

public class Conta {
	
	private int numeroDaConta;
	private double saldo;
	private boolean status;
	private boolean contaEspecial;
	private double limite;
	private String nomeTitular;
	private ArrayList <Movimentacoes> listaDeMovimentacoes = new ArrayList<>();
	
	public Conta(int numeroDaConta, String nomeTitular, double saldo, boolean status, boolean contaEspecial, double limite) {
		
		this.numeroDaConta = numeroDaConta;
		this.nomeTitular = nomeTitular;
		this.saldo = saldo;
		this.status = status;
		this.contaEspecial = contaEspecial;
		this.limite = limite;
	}
	
	@Override
	public String toString() {
		
		String ativadaDesativada;
		String tipoDaConta;
		
		if(status == true) {
			
			ativadaDesativada = "Ativada";
		
		}else {
		
			ativadaDesativada = "Desativada";
		
		}
		
		if(contaEspecial == true) {
		
			tipoDaConta = "Especial";
		
		}else {
		
			tipoDaConta = "Simples";
		
		}
		
		return  "Numero da conta: " + numeroDaConta + "\nSaldo: " + saldo + 
				"\nStatus da conta: " + ativadaDesativada + "\nTipo da conta: " + tipoDaConta + 
				"\nLimite: " + limite + "\n";
	}
	
	public int getNumeroDaConta() {
		
		return numeroDaConta;
	}
	
	public double getSaldo() {
	
		return saldo;
	}
	
	public double getLimite() {
		
		return limite;
	}
	
	public boolean getStatus(){
	
		return status;
	}
	
	public void setStatus(boolean status){
	
		this.status = status;
	}
	
	public void setSaldo(double saldo) {
	
		this.saldo = saldo;
	}
	
	public void setListaDeMovimentacoes(Movimentacoes mov) {
	
		listaDeMovimentacoes.add(mov);
	}
	
	public String getListaDeMovimentacoes() {
		
		String movimentacao = "";
		
		for (Movimentacoes movimentacoes : listaDeMovimentacoes) {
			
			movimentacao += movimentacoes.toString();
		}
		
		return movimentacao;
	}
}
