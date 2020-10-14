package com.gwb;

public class Main {

	public static void main(String[] args) throws Exception {
		int op, opS;
		
		Controle controle = new Controle();
		ControleCliente cCliente = new ControleCliente();
		cCliente.carregar();
		
		do {
			Menu.menuPrincipal();
			op = controle.inteiro();

			switch (op) {
			case 1:
				cCliente.cadastrarCliente();
				break;
			case 2:
				cCliente.editarCliente();
				break;
			case 3:
				cCliente.excluirCliente();
				break;
			case 4:
				cCliente.listarClientes();
				break;
			case 5:
				cCliente.relatorio();
				break;
			case 6:
				cCliente.persistir();
				break;
			case 7:
				cCliente.carregar();
				break;
			case 0:
				System.out.println("Aplicação será encerrada.");
				System.out.println("Realizar persistência antes de encerrar o programa?");
				Menu.menuOpcao();
				opS = controle.inteiro();
				if (opS == 1) cCliente.persistir();			
				break;
			default:
				System.out.println("Opção não encontrada, a aplicalção será encerrada.");
				break;
			}
		} while (op > 0 && op < 8);
		System.out.println("\n============== FIM! ==============");
	}
}