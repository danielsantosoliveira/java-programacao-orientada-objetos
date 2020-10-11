package com.gwb;

public class Menu {
	
	public static void menuPrincipal() {
		System.out.println("\n========== MENU ==========");
		System.out.println("= 1 - Castrar cliente    =");
		System.out.println("= 2 - Editar cliente     =");
		System.out.println("= 3 - Excluir cliente    =");
		System.out.println("= 4 - Listar Clientes    =");
		System.out.println("= 5 - Relat�rios         =");
		System.out.println("= 6 - Persistir          =");
		System.out.println("= 7 - Carregar           =");
		System.out.println("= 0 - Sair               =");
		System.out.println("==========================\n");
		System.out.print("==========DIGITE UM OP��O:");
	}
	
	public static void menuListarClientes() {
		System.out.println("\n======== RELAT�RIO ========");
		System.out.println("= 1 - Todos os clientes   =");
		System.out.println("= 2 - Todos Masculino     =");
		System.out.println("= 3 - Todos Feminino      =");
		System.out.println("= 0 - Cancelar            =");
		System.out.println("===========================\n");
		System.out.print("==========DIGITE UM OP��O:");
	}
	
	public static void menuEditarCliente() {
		System.out.println("\n======== EDITAR ===========");
		System.out.println("= 1 - Todos os dados      =");
		System.out.println("= 2 - Nome                =");
		System.out.println("= 3 - Telefone            =");
		System.out.println("= 4 - Data de Nascimento  =");
		System.out.println("= 5 - G�nero              =");
		System.out.println("= 0 - Cancelar            =");
		System.out.println("===========================\n");
		System.out.print("==========DIGITE UM OP��O:");
	}
	
	public static void menuOpcao() {
		System.out.println("\n========= OP��O ===========");
		System.out.println("= 1 - Continuar           =");
		System.out.println("= 0 - Cancelar            =");
		System.out.println("===========================\n");
		System.out.print("==========DIGITE UM OP��O:");
	}
}