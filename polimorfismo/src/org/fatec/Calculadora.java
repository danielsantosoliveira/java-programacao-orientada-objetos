package org.fatec;



// Não é possível instanciar objetos diretamente de uma classe abstrata;
// Ela serve para aproveitamento de código, herança e polimorfismo;

public abstract class Calculadora { // para que haja metódos genéricos, necessariamente a classe também tem de ser, se denomina Abstract.
	// utilizado protected para que as subclasses consigam acessar o atributo sem precisar utilizar o método get ou set.
	protected double precoBase;
	
	public Calculadora (double precoBase) {
		this.precoBase = precoBase;
	}
	
	public abstract double calcularImposto(); // é um método sem corpo, como se fosse definir depois.

}
