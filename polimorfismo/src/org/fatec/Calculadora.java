package org.fatec;



// N�o � poss�vel instanciar objetos diretamente de uma classe abstrata;
// Ela serve para aproveitamento de c�digo, heran�a e polimorfismo;

public abstract class Calculadora { // para que haja met�dos gen�ricos, necessariamente a classe tamb�m tem de ser, se denomina Abstract.
	// utilizado protected para que as subclasses consigam acessar o atributo sem precisar utilizar o m�todo get ou set.
	protected double precoBase;
	
	public Calculadora (double precoBase) {
		this.precoBase = precoBase;
	}
	
	public abstract double calcularImposto(); // � um m�todo sem corpo, como se fosse definir depois.

}
