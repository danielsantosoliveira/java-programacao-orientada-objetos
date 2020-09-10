package org.fatec;


// Exemplo de Herança (generalização) com Polimorfismo.
public class Sistema {

	public static void main(String[] args) {
		// Não pode criar um objeto calculadora, mas com o polimorfismo, instancia ImpostoSP;
		Calculadora calcSP = new ImpostoSP(100);
		System.out.println("SP: "+calcSP.calcularImposto());
		
		
		// Polimorfismo significa "Varias Formas", tem vários comportamentos.
		Calculadora calcMG = new ImpostoMG(100);
		System.out.println("MG: "+calcMG.calcularImposto());

	}

}
