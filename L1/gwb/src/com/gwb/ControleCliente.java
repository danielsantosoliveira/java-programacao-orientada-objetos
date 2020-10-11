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
	List<String> cadastro = new ArrayList<>();
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
		cliente.genero = controle.texto();

		cadastro.add(cliente.id.toString());
		cadastro.add(cliente.nome);
		cadastro.add(cliente.telefone);
		cadastro.add(cliente.diaNascimento.toString());
		cadastro.add(cliente.mesNascimento.toString());
		cadastro.add(cliente.anoNascimento.toString());
		cadastro.add(cliente.idade.toString());
		cadastro.add(cliente.genero);
	}

	public void excluirCliente() {
		if (this.cadastro.isEmpty()) {
			System.out.println("Não há cadastros :(");
		} else {
			Menu.menuOpcao();
			op = controle.inteiro();

			switch (op) {
			case 1:
				if (buscarCliente() >= 0) {
					System.out.println("\nOpção -> Excluir Cliente");
					for (int i = posicao + 6; i >= posicao; i--) {
						cadastro.remove(i);
					}
					System.out.println("\nExclusão realizada com sucesso.");
					break;
				} else {
					System.out.println("Não foi encontrado ID compatível.");
					break;
				}

			case 0:
				System.out.println("Cancelado.");
				break;

			default:
				System.out.println("Opção inválida...");
				break;
			}
		}
	}

	public void editarCliente() {
		Clientes cliente = new Clientes();

		System.out.println("\nOpção -> Editar Cliente");

		if (this.cadastro.isEmpty()) {
			System.out.println("Não há cadastros :(");
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
					cliente.genero = controle.texto();
					cadastro.set(posicao + 7, cliente.genero);

					System.out.println("Edição realizada com sucesso...");
					break;
				} else {
					System.out.println("Não foi encontrado ID compatível.");
					break;
				}

			case 2:
				if (buscarCliente() >= 0) {
					System.out.println("\n===== EDITAR CLIENTE =====");
					System.out.print("NOME: ");
					cliente.nome = controle.texto();
					cadastro.set(posicao + 1, cliente.nome);

					System.out.println("Edição realizada com sucesso...");
					break;
				} else {
					System.out.println("Não foi encontrado ID compatível.");
					break;
				}

			case 3:
				if (buscarCliente() >= 0) {
					System.out.println("\n===== EDITAR CLIENTE =====");
					System.out.print("TELEFONE: ");
					cliente.telefone = controle.texto();
					cadastro.set(posicao + 2, cliente.telefone);

					System.out.println("Edição realizada com sucesso...");
					break;
				} else {
					System.out.println("Não foi encontrado ID compatível.");
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

					System.out.println("Edição realizada com sucesso...");
					break;
				} else {
					System.out.println("Não foi encontrado ID compatível.");
					break;
				}

			case 5:
				if (buscarCliente() >= 0) {
					System.out.println("\n===== EDITAR CLIENTE =====");
					System.out.print("GÊNERO M ou F: ");
					cliente.genero = controle.texto();
					cadastro.set(posicao + 7, cliente.genero);

					System.out.println("Edição realizada com sucesso...");
					break;
				} else {
					System.out.println("Não foi encontrado ID compatível.");
					break;
				}

			case 0:
				System.out.println("Cancelado.");
				break;

			default:
				System.out.println("Opção inválida...");
				break;
			}

		}
	}

	public void listarClientes() {
		System.out.println("\nOpção -> Listar Clientes");

		if (this.cadastro.isEmpty()) {
			System.out.println("Não há cadastros :(");
		} else {
			Menu.menuListarClientes();
			op = controle.inteiro();

			switch (op) {
			case 1:
				System.out.print("\n====== Todos Clientes \nQuantidade Registro(s): " + (cadastro.size() % 8));
				listarTodosClientes().forEach(txt -> System.out.println(txt));
				break;

			case 2:
				if (listarClientesMasculino().isEmpty()) {
					System.out.println("Não há cadastro(s) Masculino");
				} else {
					System.out.print("\n====== Clientes Masculino \nQuantidade Registro(s): " + (cadastro.size() % 8));
					listarClientesMasculino().forEach(txt -> System.out.println(txt));
				}
				break;
			case 3:
				if (listarClientesFeminino().isEmpty()) {
					System.out
							.println("Não há cadastro(s) Feminino \nQuantidade Registro(s): " + (cadastro.size() % 8));
				} else {
					System.out.print("\n====== Clientes Feminino");
					listarClientesFeminino().forEach(txt -> System.out.println(txt));
				}
				break;
			case 0:
				System.out.println("Cancelado.");
				break;
			default:
				System.out.println("Opção inválida...");
				break;
			}
		}
	}

	public List<Clientes> listarTodosClientes() {
		cadastroApoio = new ArrayList<>();
		for (int i = 0; i < cadastro.size(); i++) {
			Clientes cliente = new Clientes();
			cliente.id = Integer.parseInt(cadastro.get(i));
			cliente.nome = cadastro.get(i + 1);
			cliente.telefone = cadastro.get(i + 2);
			cliente.diaNascimento = Integer.parseInt(cadastro.get(i + 3));
			cliente.mesNascimento = Integer.parseInt(cadastro.get(i + 4));
			cliente.anoNascimento = Integer.parseInt(cadastro.get(i + 5));
			cliente.idade = Integer.parseInt(cadastro.get(i + 6));
			cliente.genero = cadastro.get(i + 7);
			cadastroApoio.add(cliente);
			i += 7;
		}
		return cadastroApoio;
	}

	public List<Clientes> listarClientesMasculino() {
		cadastroApoio = new ArrayList<>();
		for (int i = 0; i < cadastro.size(); i++) {
			if (cadastro.get(i).equals("M")) {
				Clientes cliente = new Clientes();

				cliente.id = Integer.parseInt(cadastro.get(i - 7));
				cliente.nome = cadastro.get(i - 6);
				cliente.telefone = cadastro.get(i - 5);
				cliente.diaNascimento = Integer.parseInt(cadastro.get(i - 4));
				cliente.mesNascimento = Integer.parseInt(cadastro.get(i - 3));
				cliente.anoNascimento = Integer.parseInt(cadastro.get(i - 2));
				cliente.idade = Integer.parseInt(cadastro.get(i - 1));
				cliente.genero = cadastro.get(i);
				cadastroApoio.add(cliente);
			}
		}
		return cadastroApoio;
	}

	public List<Clientes> listarClientesFeminino() {
		cadastroApoio = new ArrayList<>();
		for (int i = 0; i < cadastro.size(); i++) {
			if (cadastro.get(i).equals("F")) {
				Clientes cliente = new Clientes();

				cliente.id = Integer.parseInt(cadastro.get(i - 7));
				cliente.nome = cadastro.get(i - 6);
				cliente.telefone = cadastro.get(i - 5);
				cliente.diaNascimento = Integer.parseInt(cadastro.get(i - 4));
				cliente.mesNascimento = Integer.parseInt(cadastro.get(i - 3));
				cliente.anoNascimento = Integer.parseInt(cadastro.get(i - 2));
				cliente.idade = Integer.parseInt(cadastro.get(i - 1));
				cliente.genero = cadastro.get(i);
				cadastroApoio.add(cliente);
			}
		}
		return cadastroApoio;
	}

	public int buscarCliente() {
		System.out.print("\nInforme o ID do cliente que deseja editar: ");
		String id = controle.texto();
		posicao = cadastro.indexOf(id);
		if (posicao >= 0)
			return posicao;
		return posicao = -1;
	}

	public void persistir() throws IOException {
		if (this.cadastro.isEmpty()) {
			System.out.println("Não há cadastros para persistir :(");
		} else {
			File dir = new File(local + separador + "gwb" + separador + "temp");
			if (!dir.exists())
				dir.mkdirs();

			File arquivo = new File(local + separador + "gwb" + separador + "temp" + separador + "cadastro.ser");
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
			return Integer.parseInt(cadastro.get(cadastro.size() - 7));
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
