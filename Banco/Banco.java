package lista06.ufc.com.emanoel;

import java.util.ArrayList;

public class Banco {
	
	private ArrayList<Conta> listaDeContas = new ArrayList<>();
	
	public void criarConta(Conta conta) {

		listaDeContas.add(conta);
	}
	
	public void sacar(double valor, int numeroDaConta){
		
		int encontrou = 0;
		
		for(int i=0; i<listaDeContas.size(); i++) {
			
			if((listaDeContas.get(i).getNumeroDaConta() == numeroDaConta) && (listaDeContas.get(i).getStatus()!=false)) {
				
				if(valor > (listaDeContas.get(i).getSaldo() + listaDeContas.get(i).getLimite())) {
					
					encontrou = 1;
					System.out.println("Erro! O valor a ser sacado excede o saldo!\n");
				}
				else {
					
					listaDeContas.get(i).setSaldo(listaDeContas.get(i).getSaldo()-valor);
					
					System.out.println("Saque realizado com sucesso!\n");
					
					Movimentacoes m = new Movimentacoes("Saque", valor, "Débito");
					listaDeContas.get(i).setListaDeMovimentacoes(m);
					
					encontrou = 1;
				}
			}
		}
		
		if(encontrou==0) {
			
			System.out.println("Erro! A conta não existe!\n");
		}
	}
	
	public void depositar(double valor, int numeroDaConta) {
		

		int encontrou = 0;

		if(valor<0){

			System.out.println("\nErro! Não é possível depositar um valor negativo!\n");
		}
		else{
			
			for(int i=0; i<listaDeContas.size(); i++) {
				
				if((listaDeContas.get(i).getNumeroDaConta() == numeroDaConta) && (listaDeContas.get(i).getStatus()!=false)) {
					
					listaDeContas.get(i).setSaldo(listaDeContas.get(i).getSaldo()+valor);
					
					System.out.println("Depósito realizado com sucesso!\n");
					
					Movimentacoes m = new Movimentacoes("Depósito", valor, "Crédito");
					listaDeContas.get(i).setListaDeMovimentacoes(m);
					
					encontrou = 1;					
				}
			}
		}
		
		if(encontrou==0) {
			
			System.out.println("\nErro! A conta não existe!\n");
		}
	
	}
	
	public void transferir(int origem, int destino, double valor){
		
		int encontrouOrigem = 0;
		int encontrouDestino = 0;
		int erro = 0;
		
		if(valor<0){

			System.out.println("\nErro! Não é possível transferir um valor negativo!\n");
			
			encontrouOrigem = -1;
			encontrouDestino = -1;
		}
		else {
			
			for(int i=0; i<listaDeContas.size(); i++) {
			
				if((listaDeContas.get(i).getNumeroDaConta()==origem) && (listaDeContas.get(i).getStatus()!=false)) {
					
					encontrouOrigem = 1;
					
					for(int j=0; j<listaDeContas.size(); j++) {
						
						if((listaDeContas.get(j).getNumeroDaConta()==destino) && (listaDeContas.get(j).getStatus()!=false)) {
							
							encontrouDestino = 1;
							
							if(valor > (listaDeContas.get(i).getSaldo()+listaDeContas.get(i).getLimite())) {
								
								erro = 1;
							}
							else {
								
								listaDeContas.get(i).setSaldo(listaDeContas.get(i).getSaldo()-valor);
								listaDeContas.get(j).setSaldo(listaDeContas.get(j).getSaldo()+valor);
								
								Movimentacoes o = new Movimentacoes("Transferência", valor, "Débito");
								listaDeContas.get(i).setListaDeMovimentacoes(o);

								Movimentacoes d = new Movimentacoes("Transferência", valor, "Crédito");
								listaDeContas.get(j).setListaDeMovimentacoes(d);
								
								System.out.println("\nTransferência realizada com sucesso!\n");
							}
						}
					}
					
				}
				
				for(int j=0; j<listaDeContas.size(); j++) {
					
					if((listaDeContas.get(j).getNumeroDaConta()==destino) && (listaDeContas.get(j).getStatus()!=false)) {
						
						encontrouDestino = 1;
					}
				}
			}
		}
		
		if(encontrouOrigem==0) {
			
			System.out.println("\nErro! A conta origem não existe!\n");
		}
		
		if(encontrouDestino==0) {
			
			System.out.println("\nErro! A conta destino não existe!\n");
		}
		
		if(erro==1) {
			
			System.out.println("\nErro! O valor a ser transferido excede o saldo!\n");
		}
	}
	
	public void emitirSaldo(int numeroDaConta) {
		
		System.out.println("---------------------------------- SALDO ----------------------------------\n");

		for (int i = 0; i < listaDeContas.size(); i++) {
			
			if(listaDeContas.get(i).getNumeroDaConta() == numeroDaConta ) {
				
				System.out.println(listaDeContas.get(i).toString());
				
			}
		}	
	}
	
	public void emitirExtrato(int numeroDaConta) {
		
		System.out.println("---------------------------------- EXTRATO ---------------------------------\n");
		
		for (Conta conta : listaDeContas) {
			
			if(conta.getNumeroDaConta() == numeroDaConta) {

				System.out.println(conta.toString() + conta.getListaDeMovimentacoes());
			
			}
		}	
	}
	
	public void excluirConta(int numeroDaConta) {
		
		int cont = 0;
		
		for (Conta conta : listaDeContas) {
			
			if(conta.getNumeroDaConta() == numeroDaConta) {
				
				conta.setStatus(false);
				System.out.println("\nConta desativada com sucesso!\n");
				cont++;	
			}
		}
		
		if(cont == 0) {
			System.out.println("\nConta não encontrada\n");
		}
	}
	
	@Override
	public String toString() {
		
		String contasList = "\n";
		
		for (Conta conta : listaDeContas) {
		
			contasList += conta.toString() + "\n";
		
		}
		
		return contasList;
	}
}
