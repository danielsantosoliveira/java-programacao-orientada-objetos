# Java ☕
## Programação Orientada a Objetos
### Polimorfismo

Criado método abstrato, na super classe Calculadora;	
```java
public abstract double calcularImposto();
```

Criados métodos nas subClasses ImpostoMG e ImpostoSP:	
```java
public double calcularImposto() {
		return precoBase + 100;
	}
```
utilizando então o polimorfismo.
