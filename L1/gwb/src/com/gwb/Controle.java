package com.gwb;

import java.util.Scanner;

public class Controle {
	private Scanner leitor;
	
	public synchronized int inteiro() {
		leitor = new Scanner(System.in);
		int inteiro = leitor.nextInt();
		leitor = leitor.reset();
		return inteiro;
	}
	
	public synchronized String texto() {
		leitor = new Scanner(System.in);
		String t = leitor.nextLine();
		leitor = leitor.reset();
		return t;
	}
	
	public synchronized long longo() {
		leitor = new Scanner(System.in);
		long longo = leitor.nextLong();
		leitor = leitor.reset();
		return longo;
	}
	
	// Método executao após a execução do GC.
	protected void finalize() throws Throwable {
		leitor.close();
	}
}
