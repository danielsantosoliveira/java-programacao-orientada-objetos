package org.fatec;

public class ImpostoSP extends Calculadora {

	public ImpostoSP(double precoBase) {
		super(precoBase);
	}

	@Override // Tag, sobrescrito;
	public double calcularImposto() {
		return precoBase + 50;
	}

	
}
