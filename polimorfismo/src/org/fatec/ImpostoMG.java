package org.fatec;

public class ImpostoMG extends Calculadora {

	public ImpostoMG(double precoBase) {
		super(precoBase);
	}

	@Override
	public double calcularImposto() {
		return precoBase + 100;
	}
	
}
