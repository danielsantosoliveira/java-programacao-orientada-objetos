# Java ☕
## Programação Orientada a Objetos
### Polimorfismo

Criado método abstrato, na classe Calculadora;
'''
  public abstract double calcularImposto();
'''

Criados métodos nas subClasses ImpostoMG e ImpostoSP:
'''
public double calcularImposto() {
		return precoBase + 100;
	}
'''
