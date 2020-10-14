package com.gwb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControleCliente {

	private Integer op, posicao = null;
	List<String> cadastro, nomes = new ArrayList<>();
	List<Clientes> cadastroApoio = new ArrayList<>();
	String separador = System.getProperty("file.separator"), local = System.getProperty("user.home");

	Controle controle = new Controle();
	Date date = new Date();

	public void cadastrarCliente() {
		Clientes cliente = new Clientes();
		System.out.println("\n===== CADASTRAR NOVO CLIENTE =====");
		cliente.id = pegarID() + 1;
		System.out.print("NOME: ");
		cliente.nome = controle.texto();
		System.out.print("TELEFONE: ");
		cliente.telefone = controle.texto();
		System.out.println("DATA DE NASCIMENTO");
		System.out.print("DIA (DD):");
		cliente.diaNascimento = controle.inteiro();
		System.out.print("MÊS (MM):");
		cliente.mesNascimento = controle.inteiro();
		System.out.print("ANO (AAAA):");
		cliente.anoNascimento = controle.inteiro();
		cliente.idade = Utils.calculaIdade(cliente.diaNascimento.toString() + "-" + cliente.mesNascimento.toString()
				+ "-" + cliente.anoNascimento.toString(), "dd-MM-yyyy");
		System.out.print("GÊNERO M ou F: ");
		cliente.genero = controle.texto().toUpperCase();

		cadastro.add(cliente.id.toString());
		cadastro.add(cliente.nome);
		cadastro.add(cliente.telefone);
		cadastro.add(cliente.diaNascimento.toString());
		cadastro.add(cliente.mesNascimento.toString());
		cadastro.add(cliente.anoNascimento.toString());
		cadastro.add(cliente.idade.toString());
		cadastro.add(cliente.genero);
		System.out.println("\nCadastro realizado com sucesso.");
	}

	public void editarCliente() {
		Clientes cliente = new Clientes();

		System.out.println("\nOpção -> Editar Cliente");

		if (this.cadastro.isEmpty()) {
			System.out.println("\nNão há cadastros :(");
		} else {

			Menu.menuEditarCliente();
			op = controle.inteiro();

			switch (op) {

			case 1:
				if (buscarCliente() >= 0) {
					System.out.println("\n===== EDITAR CLIENTE =====");
					System.out.print("NOME: ");
					cliente.nome = controle.texto();
					cadastro.set(posicao + 1, cliente.nome);
					System.out.print("TELEFONE: ");
					cliente.telefone = controle.texto();
					cadastro.set(posicao + 2, cliente.telefone);
					System.out.println("DATA DE NASCIMENTO");
					System.out.print("DIA (DD):");
					cliente.diaNascimento = controle.inteiro();
					cadastro.set(posicao + 3, cliente.diaNascimento.toString());
					System.out.print("MÊS (MM):");
					cliente.mesNascimento = controle.inteiro();
					cadastro.set(posicao + 4, cliente.mesNascimento.toString());
					System.out.print("ANO (AAAA):");
					cliente.anoNascimento = controle.inteiro();
					cadastro.set(posicao + 5, cliente.anoNascimento.toString());
					cliente.idade = Utils.calculaIdade(cliente.diaNascimento.toString() + "-"
							+ cliente.mesNascimento.toString() + "-" + cliente.anoNascimento.toString(), "dd-MM-yyyy");
					cadastro.set(posicao + 6, cliente.idade.toString());
					System.out.print("GÊNERO M ou F: ");
					cliente.genero = controle.texto().toUpperCase();
					cadastro.set(posicao + 7, cliente.genero);

					System.out.println("\nEdição realizada com sucesso...");
					break;
				} else {
					System.err.println("\nNão foi encontrado ID compatível.");
					break;
				}

			case 2:
				if (buscarCliente() >= 0) {
					System.out.println("\n===== EDITAR CLIENTE =====");
					System.out.print("NOME: ");
					cliente.nome = controle.texto();
					cadastro.set(posicao + 1, cliente.nome);

					System.out.println("\nEdição realizada com sucesso...");
					break;
				} else {
					System.err.println("\nNão foi encontrado ID compatível.");
					break;
				}

			case 3:
				if (buscarCliente() >= 0) {
					System.out.println("\n===== EDITAR CLIENTE =====");
					System.out.print("TELEFONE: ");
					cliente.telefone = controle.texto();
					cadastro.set(posicao + 2, cliente.telefone);

					System.out.println("\nEdição realizada com sucesso...");
					break;
				} else {
					System.err.println("\nNão foi encontrado ID compatível.");
					break;
				}

			case 4:
				if (buscarCliente() >= 0) {
					System.out.println("\n===== EDITAR CLIENTE =====");
					System.out.println("DATA DE NASCIMENTO");
					System.out.print("DIA (DD):");
					cliente.diaNascimento = controle.inteiro();
					cadastro.set(posicao + 3, cliente.diaNascimento.toString());
					System.out.print("MÊS (MM):");
					cliente.mesNascimento = controle.inteiro();
					cadastro.set(posicao + 4, cliente.mesNascimento.toString());
					System.out.print("ANO (AAAA):");
					cliente.anoNascimento = controle.inteiro();
					cadastro.set(posicao + 5, cliente.anoNascimento.toString());
					cliente.idade = Utils.calculaIdade(cliente.diaNascimento.toString() + "-"
							+ cliente.mesNascimento.toString() + "-" + cliente.anoNascimento.toString(), "dd-MM-yyyy");
					cadastro.set(posicao + 6, cliente.idade.toString());

					System.out.println("\nEdição realizada com sucesso...");
					break;
				} else {
					System.err.println("\nNão foi encontrado ID compatível.");
					break;
				}

			case 5:
				if (buscarCliente() >= 0) {
					System.out.println("\n===== EDITAR CLIENTE =====");
					System.out.print("GÊNERO M ou F: ");
					cliente.genero = controle.texto().toUpperCase();
					cadastro.set(posicao + 7, cliente.genero);

					System.out.println("\nEdição realizada com sucesso...");
					break;
				} else {
					System.err.println("\nNão foi encontrado ID compatível.");
					break;
				}

			case 0:
				System.out.println("\nCancelado.");
				break;

			default:
				System.err.println("\nOpção inválida...");
				break;
			}

		}
	}

	public void excluirCliente() {
		if (this.cadastro.isEmpty()) {
			System.out.println("\nNão há cadastros :(");
		} else {
			System.out.println("\nOpção -> Excluir Cliente\n");
			Menu.menuOpcao();
			op = controle.inteiro();

			switch (op) {
			case 1:
				if (buscarCliente() >= 0) {
					for (int i = posicao + 7; i >= posicao; i--) {
						cadastro.remove(i);
					}
					System.out.println("\nExclusão realizada com sucesso.");
					break;
				} else {
					System.err.println("\nNão foi encontrado ID compatível.");
					break;
				}

			case 0:
				System.out.println("\nCancelado.");
				break;

			default:
				System.err.println("\nOpção inválida...");
				break;
			}
		}
	}

	public void listarClientes() {
		System.out.println("\nOpção -> Listar Clientes");

		if (this.cadastro.isEmpty()) {
			System.out.println("\nNão há cadastros :(");
		} else {
			Menu.menuListarClientes();
			op = controle.inteiro();

			switch (op) {
			case 1:

				if (listarTodosClientes().isEmpty()) {
					System.out.println("\nNão há cadastro(s)");
				} else {
					System.out.print("\n====== Todos Clientes \nQuantidade Registro(s): " + (cadastroApoio.size()));
					listarTodosClientes().forEach(txt -> System.out.println(txt));
				}
				break;

			case 2:
				if (listarClientesMasculino().isEmpty()) {
					System.out.println("\nNão há cadastro(s) Masculino");
				} else {
					System.out.print("\n====== Clientes Masculino \nQuantidade Registro(s): " + (cadastroApoio.size()));
					listarClientesMasculino().forEach(txt -> System.out.println(txt));
				}
				break;
			case 3:
				if (listarClientesFeminino().isEmpty()) {
					System.out.println(
							"\nNão há cadastro(s) Feminino \nQuantidade Registro(s): " + (cadastroApoio.size()));
				} else {
					System.out.print("\n====== Clientes Feminino");
					listarClientesFeminino().forEach(txt -> System.out.println(txt));
				}
				break;
			case 0:
				System.out.println("\nCancelado.");
				break;
			default:
				System.err.println("\nOpção inválida...");
				break;
			}
		}
	}

	public List<Clientes> listarTodosClientes() {
		cadastroApoio = new ArrayList<>();
		nomes = new ArrayList<>();

		for (int i = 0; i < cadastro.size(); i++) {
			nomes.add(cadastro.get(i + 1));
			i += 7;
		}
		nomes.sort(null);
		for (String nome : nomes) {
			posicao = cadastro.indexOf(nome);
			Clientes cliente = new Clientes();
			cliente.id = Integer.parseInt(cadastro.get(posicao - 1));
			cliente.nome = cadastro.get(posicao);
			cliente.telefone = cadastro.get(posicao + 1);
			cliente.diaNascimento = Integer.parseInt(cadastro.get(posicao + 2));
			cliente.mesNascimento = Integer.parseInt(cadastro.get(posicao + 3));
			cliente.anoNascimento = Integer.parseInt(cadastro.get(posicao + 4));
			cliente.idade = Integer.parseInt(cadastro.get(posicao + 5));
			cliente.genero = cadastro.get(posicao + 6);
			cadastroApoio.add(cliente);
		}
		return cadastroApoio;
	}

	public List<Clientes> listarClientesMasculino() {
		cadastroApoio = new ArrayList<>();
		nomes = new ArrayList<>();

		for (int i = 0; i < cadastro.size(); i++) {
			nomes.add(cadastro.get(i + 1));
			i += 7;
		}
		nomes.sort(null);

		for (String nome : nomes) {
			if (cadastro.get(cadastro.indexOf(nome) + 6).equals("M")) {
				posicao = cadastro.indexOf(nome);
				Clientes cliente = new Clientes();
				cliente.id = Integer.parseInt(cadastro.get(posicao - 1));
				cliente.nome = cadastro.get(posicao);
				cliente.telefone = cadastro.get(posicao + 1);
				cliente.diaNascimento = Integer.parseInt(cadastro.get(posicao + 2));
				cliente.mesNascimento = Integer.parseInt(cadastro.get(posicao + 3));
				cliente.anoNascimento = Integer.parseInt(cadastro.get(posicao + 4));
				cliente.idade = Integer.parseInt(cadastro.get(posicao + 5));
				cliente.genero = cadastro.get(posicao + 6);
				cadastroApoio.add(cliente);
			}
		}

		return cadastroApoio;
	}

	public List<Clientes> listarClientesFeminino() {
		cadastroApoio = new ArrayList<>();
		nomes = new ArrayList<>();

		for (int i = 0; i < cadastro.size(); i++) {
			nomes.add(cadastro.get(i + 1));
			i += 7;
		}
		nomes.sort(null);

		for (String nome : nomes) {
			if (cadastro.get(cadastro.indexOf(nome) + 6).equals("F")) {
				posicao = cadastro.indexOf(nome);
				Clientes cliente = new Clientes();
				cliente.id = Integer.parseInt(cadastro.get(posicao - 1));
				cliente.nome = cadastro.get(posicao);
				cliente.telefone = cadastro.get(posicao + 1);
				cliente.diaNascimento = Integer.parseInt(cadastro.get(posicao + 2));
				cliente.mesNascimento = Integer.parseInt(cadastro.get(posicao + 3));
				cliente.anoNascimento = Integer.parseInt(cadastro.get(posicao + 4));
				cliente.idade = Integer.parseInt(cadastro.get(posicao + 5));
				cliente.genero = cadastro.get(posicao + 6);
				cadastroApoio.add(cliente);
			}
		}

		return cadastroApoio;
	}

	public int buscarCliente() {
		Integer posicao = -1;
		if (this.cadastro.isEmpty()) {
			System.out.println("Não há cadastros para persistir :(");
		} else {
			System.out.print("\nInforme o ID do cliente que deseja editar: ");
			String id = controle.texto();
			posicao = cadastro.indexOf(id);
			if (posicao >= 0)
				this.posicao = posicao;
			this.posicao = posicao;
		}
		return this.posicao;
	}

	public void persistir() throws IOException {
		File dir = new File(local + separador + "gwb" + separador + "temp");
		File arquivo = new File(local + separador + "gwb" + separador + "temp" + separador + "cadastro.ser");

		if (this.cadastro.isEmpty()) {
			FileOutputStream fOut = new FileOutputStream(arquivo);
			ObjectOutputStream oOut = new ObjectOutputStream(fOut);
			oOut.writeObject(cadastro);
			oOut.close();
			System.out.println("Não há cadastros para persistir :(");
		} else {
			if (!dir.exists())
				dir.mkdirs();
			if (!arquivo.exists())
				arquivo.createNewFile();

			try {
				FileOutputStream fOut = new FileOutputStream(arquivo);
				ObjectOutputStream oOut = new ObjectOutputStream(fOut);
				oOut.writeObject(cadastro);
				oOut.close();
				System.out.println("\nSalvo com sucesso.");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void carregar() throws Exception {
		File arquivo = new File(local + separador + "gwb" + separador + "temp" + separador + "cadastro.ser");
		if (!arquivo.exists()) {
			System.out.println("Não há persistência.");
		} else {
			try {
				FileInputStream fOut = new FileInputStream(arquivo);
				ObjectInputStream oOut = new ObjectInputStream(fOut);
				cadastro = (List<String>) oOut.readObject();
				oOut.close();
				System.out.println("\nCarregado com sucesso.");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public Integer pegarID() {
		if (cadastro.isEmpty())
			return 0;
		else {
			return Integer.parseInt(cadastro.get(cadastro.size() - 8));
		}
	}

	public float idadeMediaTodos() {
		Integer tIdade = 0;
		for (int i = 0; i < cadastro.size() % 7; i++) {
			tIdade += Integer.parseInt(cadastro.get((cadastro.size() % 7) * 6));
		}
		return (tIdade / (cadastro.size() % 7));
	}

	public float idadeMediaMasculino() {
		Integer tIdade = 0;
		for (int i = 0; i < cadastro.size(); i++) {
			if (cadastro.get(i).equals("M")) {
				tIdade += Integer.parseInt(cadastro.get(i - 1));
			}
		}
		return (tIdade / (cadastro.size() % 7));
	}

	public float idadeMediaFeminino() {
		Integer tIdade = 0;
		for (int i = 0; i < cadastro.size(); i++) {
			if (cadastro.get(i).equals("F")) {
				tIdade += Integer.parseInt(cadastro.get(i - 1));
			}
		}
		return (tIdade / (cadastro.size() % 7));
	}

	public void relatorio() {
		if (this.cadastro.isEmpty()) {
			System.out.println("Não há cadastros :(");
		} else {
			System.out.println("\n========= RELATÓRIO =========");
			System.out.println("====== Média de Idade: ======");
			System.out.println("= Todos: " + idadeMediaTodos() + "               =");
			System.out.println("= Masculino: " + idadeMediaMasculino() + "           =");
			System.out.println("= Feminino: " + idadeMediaFeminino() + "            =");
			System.out.println("========= RELATÓRIO =========");
		}
	}
}
