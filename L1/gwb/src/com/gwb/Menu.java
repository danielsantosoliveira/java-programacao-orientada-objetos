package com.gwb;

public class Menu {
	
	public static void menuPrincipal() {
		System.out.println("\n========== MENU ==========");
		System.out.println("= 1 - Castrar cliente    =");
		System.out.println("= 2 - Editar cliente     =");
		System.out.println("= 3 - Excluir cliente    =");
		System.out.println("= 4 - Listar Clientes    =");
		System.out.println("= 5 - Relatórios         =");
		System.out.println("= 6 - Persistir          =");
		System.out.println("= 7 - Carregar           =");
		System.out.println("= 0 - Sair               =");
		System.out.println("==========================\n");
		System.out.print("==========DIGITE UM OPÇÃO:");
	}
	
	public static void menuListarClientes() {
		System.out.println("\n======== RELATÓRIO ========");
		System.out.println("= 1 - Todos os clientes   =");
		System.out.println("= 2 - Todos Masculino     =");
		System.out.println("= 3 - Todos Feminino      =");
		System.out.println("= 0 - Cancelar            =");
		System.out.println("===========================\n");
		System.out.print("==========DIGITE UM OPÇÃO:");
	}
	
	public static void menuEditarCliente() {
		System.out.println("\n======== EDITAR ===========");
		System.out.println("= 1 - Todos os dados      =");
		System.out.println("= 2 - Nome                =");
		System.out.println("= 3 - Telefone            =");
		System.out.println("= 4 - Data de Nascimento  =");
		System.out.println("= 5 - Gênero              =");
		System.out.println("= 0 - Cancelar            =");
		System.out.println("===========================\n");
		System.out.print("==========DIGITE UM OPÇÃO:");
	}
	
	public static void menuOpcao() {
		System.out.println("\n========= OPÇÃO ===========");
		System.out.println("= 1 - Continuar           =");
		System.out.println("= 0 - Cancelar            =");
		System.out.println("===========================\n");
		System.out.print("==========DIGITE UM OPÇÃO:");
	}
}