package org.fatec;


// Exemplo de Heran�a (generaliza��o) com Polimorfismo.
public class Sistema {

	public static void main(String[] args) {
		// N�o pode criar um objeto calculadora, mas com o polimorfismo, instancia ImpostoSP;
		Calculadora calcSP = new ImpostoSP(100);
		System.out.println("SP: "+calcSP.calcularImposto());
		
		
		// Polimorfismo significa "Varias Formas", tem v�rios comportamentos.
		Calculadora calcMG = new ImpostoMG(100);
		System.out.println("MG: "+calcMG.calcularImposto());

	}

}
