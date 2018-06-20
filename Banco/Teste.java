package lista06.ufc.com.emanoel;

import java.util.Scanner;

public class Teste {
	
	private static Scanner scan;
	
	public static void main(String[] args) {
		
		Banco banco1 = new Banco();
		scan = new Scanner(System.in);
		
		int op = -1, numeroConta = 0, numeroContaOrigem = 0, numeroContaDestino = 0;
		double valor = 0, saldo = 0, limite = 0;
		
		boolean contaEspecial;
		
		String nomeTitular;
		String input = "0";
		
		SystemPause system = new SystemPause();
		Limpar limpar = new Limpar();
		
		while(op != 0 ) {
			System.out.println("************Digite a operação que deseja realiza************");
			System.out.println("*                    1 - Criar conta                       *");
			System.out.println("*                    2 - Depositar                         *");
			System.out.println("*                    3 - Sacar                             *");
			System.out.println("*                    4 - Transferir                        *");
			System.out.println("*                    5 - Emitir saldo                      *");
			System.out.println("*                    6 - Emitir extrato                    *"); 
			System.out.println("*                    7 - Desativar conta                   *");
			System.out.println("*                    8 - Mostrar contas cadastradas        *");
			System.out.println("*                    0 - Para sair                         *");
			System.out.println("************************************************************");
			System.out.print("Digite uma opção: ");
			op = scan.nextInt();
			
			System.out.println();
			
			switch (op) {
			case 1:
				
				System.out.println("\n# CRIAR CONTA #\n");
				
				System.out.print("\nDigite o numero da conta: ");
				input = scan.next();		
				numeroConta = validarConta(input);
	
				System.out.print("Digite o nome do titular da conta: ");
				input = scan.next();
				nomeTitular = validarNome(input);
				
				System.out.print("Digite o saldo: ");
				input = scan.next();
				saldo = validarDouble(input);
				
				System.out.print("Digite o limite da conta: ");
				input = scan.next();
				limite = validarDouble(input);
				
				System.out.print("Conta especial (S/N): ");
				contaEspecial = verificarContaEspecial();
				
				Conta conta = new Conta(numeroConta, nomeTitular, saldo, true, contaEspecial, limite);
				banco1.criarConta(conta);
				
				System.out.println("\n- - Conta criada com sucesso! - - \n");
				
				system.pause();
				limpar.tela();
				
				break;
				
			case 2:
				
				System.out.println("\n# DEPOSITAR #\n");
				
				System.out.print("\nDigite o valor do deposito: ");
				input = scan.next();		
				valor = validarDouble(input);
				
				System.out.print("Digite o numero da conta: ");
				input = scan.next();		
				numeroConta = validarConta(input);
				
				banco1.depositar(valor, numeroConta);
				
				system.pause();
				limpar.tela();

				break;
			
			case 3:
				
				System.out.println("\n# SACAR #\n");
				
				System.out.print("\nDigite o valor do saque: ");
				input = scan.next();		
				valor = validarDouble(input);
				
				System.out.print("Digite o numero da conta: ");
				input = scan.next();		
				numeroConta = validarConta(input);
				
				banco1.sacar(valor, numeroConta);
				
				system.pause();
				limpar.tela();

				break;
				
			case 4:
				
				System.out.println("\n# TRANSFERIR #\n");
				
				System.out.print("\nDigite o numero da conta de origem: ");
				input = scan.next();		
				numeroContaOrigem = validarConta(input);
				
				System.out.print("Digite o numero da conta de destino: ");
				input = scan.next();		
				numeroContaDestino = validarConta(input);
				
				System.out.println("CO e CD = " + numeroContaOrigem + " e " + numeroContaDestino);
				
				System.out.print("Digite o valor: ");
				input = scan.next();		
				valor = validarDouble(input);
				
				banco1.transferir(numeroContaOrigem, numeroContaDestino, valor);
				
				system.pause();
				limpar.tela();

				break;
				
			case 5:
				
				System.out.print("\nDigite o numero da conta: ");
				input = scan.next();		
				numeroConta = validarConta(input);
				
				banco1.emitirSaldo(numeroConta);
				
				system.pause();
				limpar.tela();
				
				break;
			
			case 6:
				
				System.out.print("\nDigite o numero da conta: ");
				input = scan.next();		
				numeroConta = validarConta(input);
				
				banco1.emitirExtrato(numeroConta);
				
				system.pause();
				limpar.tela();

				break;
			
			case 7 :
				
				System.out.println("\n# DESATIVAR CONTA #\n");
				
				System.out.print("\nDigite o numero da conta: ");
				input = scan.next();		
				numeroConta = validarConta(input);
				
				banco1.excluirConta(numeroConta);
				
				system.pause();
				limpar.tela();
				
				break;
				
			case 8 :
				System.out.println("----------- CONTAS BANCÁRIAS -----------\n");
				System.out.println(banco1.toString());
				
				system.pause();
				limpar.tela();

				break;
				
			case 0 :
				limpar.tela();
				System.out.println("************************************************************");
				System.out.println("*                       /|         |\\                      *");
				System.out.println("*                      (_|_________|_)                     *");
				System.out.println("*                     |   ^        ^  |                    *");
				System.out.println("*                     |   O        O  |                    *");
				System.out.println("*                     |       o       |                    *");
				System.out.println("*                     |_\\  \\_____/ /_ | ---  TCHAU,        *");
				System.out.println("*                     | /   |_|_|  \\  |                    *");
				System.out.println("*                     |_______________|                    *");
				System.out.println("*                                                          *");
				System.out.println("************************************************************");
				
				op = 0;
				
			default:
				
				System.out.println("\nOpção inválida!\n");
				break;
			}
		}
	}
	
	
	public static boolean verificarContaEspecial() {
		
		String contaString = scan.next();
		char contaEspecial = contaString.charAt(0);
		
		while(contaString.length() > 1) {
			
			System.out.print("\nValor inválido\nDigite novamente: ");
			contaString = scan.next();
		}
		
		while(contaEspecial != 'S' && contaEspecial != 'N' && contaEspecial != 's' && contaEspecial != 'n') {
			
			System.out.print("\nValor inválido\nDigite novamente: ");
			contaString = scan.next();
			
			while(contaString.length() > 1) {
				
				System.out.print("\nValor inválido\nDigite novamente: ");
				contaString = scan.next();
			}
			
			contaEspecial = contaString.charAt(0);
		}
		
		if(contaEspecial == 's' || contaEspecial == 'S') {
			
			return true;
			
		}else {
			
			return false;
		}
	}
	
	
	public static boolean validarInt(String input) {
		
		for(int i=0; i<input.length(); i++) {
			
			if(!Character.isDigit(input.charAt(i))) {
				
				return false;
			}
		}
		
		return true;
	}
	
	
	public static boolean verificarDouble(String input) {
		
		for(int i=0; i<input.length(); i++) {
			
			if(input.charAt(i) == '.' || input.charAt(i) == ',') {
				
				continue;
			}
			
			if(!Character.isDigit(input.charAt(i))) {
				
				return false;
			}
		}
		
		return true;
	}
	

	public static double validarDouble(String input) {
		
		double valor = 0;
		
		if(verificarDouble(input)) {
			
			valor = Double.parseDouble(input);
		}
		
		while(!verificarDouble(input)) {
			
			try {
				
				double num = Double.parseDouble(input);
				
				while(num < 0) {
					
					System.out.print("\nNúmero inválido\nDigite novamente: ");
					input = scan.next();
					
					num = Double.parseDouble(input);
				}
			
				valor = Double.parseDouble(input);
			
			} catch (NumberFormatException e) {
				
				System.out.print("\nNúmero inválido\nDigite novamente: ");
				input = scan.next();
				
				if(verificarDouble(input)) {
					
					valor = Double.parseDouble(input);
				}				
			}
		}
		
		return valor;
	}	
	
	
	public static int validarConta(String input) {
		
		int numeroConta = 0;
		
		if(validarInt(input)) {
			
			numeroConta = Integer.parseInt(input);
		}
		
		while(!validarInt(input)) {
			
			try {
				
				int num = Integer.parseInt(input);
				
				while(num < 0) {
					
					System.out.print("\nNúmero inválido\nDigite novamente: ");
					input = scan.next();
					
					num = Integer.parseInt(input);
				}
			
				numeroConta = Integer.parseInt(input);
			
			} catch (NumberFormatException e) {
				
				System.out.print("\nNúmero inválido\nDigite novamente: ");
				input = scan.next();
				
				if(validarInt(input)) {
					System.out.println("ENTROU");
					numeroConta = Integer.parseInt(input);
				}
			}
		}
		
		return numeroConta;
	}
	
	
	public static boolean validarString(String input) {
		
		for(int i=0; i<input.length(); i++) {
			
			if(!Character.isLetter(input.charAt(i))) {
				
				return false;
			}
		}
		
		return true;
	}
	
	
	public static String validarNome(String input) {
		
		String nomeTitular = input;
		
		while(!validarString(input)) {
				
			System.out.println("Nome inválido\nDigite novamente: ");
			input = scan.next();
				
			nomeTitular = input;
		}
		
		return nomeTitular;		
	}
}
