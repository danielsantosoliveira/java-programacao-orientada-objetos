package com.gwb;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Clientes implements Serializable {
	protected Integer id;
	protected String nome;
	protected String telefone;
	protected Integer diaNascimento;
	protected Integer mesNascimento;
	protected Integer anoNascimento;
	protected Integer idade;
	protected String genero;
	

	@Override
	public String toString() {

		String delimitador = "====================";
		String info = "ID: " + this.id + "\nNOME: " + this.nome + "\nTELEFONE: " + this.telefone
				+ "\nData de Nascimento: " + this.diaNascimento + "/" + this.mesNascimento + "/" + this.anoNascimento
				+ "\nIdade: " + idade + " anos\nGênero: " + this.genero;

		return "\n" + delimitador + "\n" + info + "\n" + delimitador;
	}

}
