package livraria_virtual;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import livraria_virtual.controller.ContaController;
import livraria_virtual.exception.LivrariaException;
import livraria_virtual.model.Livro;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();

	public static void main(String[] args) {

		int opcao;

		criarLivrosTeste();

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                Livraria Alquimia                    ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Listar todos os produtos             ");
			System.out.println("            2 - Listar produto pelo ID               ");
			System.out.println("            3 - Buscar por Título                    ");
			System.out.println("            4 - Buscar por Autor/Autora              ");
			System.out.println("            5 - Buscar por Gênero Literário          ");
			System.out.println("            6 - Cadastrar Produto                    ");
			System.out.println("            7 - Atualizar Produto                    ");
			System.out.println("            8 - Deletar Produto                      ");
			System.out.println("            9 - Aplicar Cupom de Desconto            ");
			System.out.println("           10 - Listar Cupons Disponíveis            ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("\nEntrada inválida! Digite um número correspondente a uma opção do menu.");
				leia.nextLine();
			}

			if (opcao == 0) {
				System.out.println("\nLivraria Alquimia - Conhecimento que transforma");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Listar todos os produtos\n");
					listarTodos();
					keyPress();
					break;
				case 2:
					System.out.println("Listar produto pelo ID\n");
					buscarPorId();
					keyPress();
					break;
				case 3:
					System.out.println("Buscar por Título\n");
					buscarPorTitulo();
					keyPress();
					break;
				case 4:
					System.out.println("Buscar por Autor/Autora\n");
					buscarPorAutoria();
					keyPress();
					break;
				case 5:
					System.out.println("Buscar por Gênero Literário\n");
					buscarPorGenero();
					keyPress();
					break;
				case 6:
					System.out.println("Cadastrar Produto\n");
					cadastrarLivro();
					keyPress();
					break;
				case 7:
					System.out.println("Atualizar Produto\n");
					atualizarLivro();
					keyPress();
					break;
				case 8:
					System.out.println("Deletar Produto\n");
					deletarLivro();
					keyPress();
					break;
				case 9:
					System.out.println("Aplicar Cupom de Desconto\n");
					aplicarCupom();
					keyPress();
					break;
				case 10:
					contaController.listarCupons();
					keyPress();
					break;
				default:
					System.out.println("\nOpção Inválida! Escolha um número entre 0 e 10.\n");
					keyPress();
					break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Luiza Valentina ");
		System.out.println("github.com/luizavpg-bit");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {
		System.out.println("\n\nPressione Enter para continuar...");
		leia.nextLine();
	}

	public static void criarLivrosTeste() {
		contaController.cadastrar(new Livro(contaController.gerarId(), "O Hobbit", "J.R.R. Tolkien", "Fantasia", 49.90f));
		contaController.cadastrar(new Livro(contaController.gerarId(), "1984", "George Orwell", "Distopia", 39.90f));
	}

	// ----------- Métodos auxiliares de leitura segura -----------

	private static int lerInteiro(String mensagem) {
		while (true) {
			System.out.println(mensagem);
			try {
				int valor = leia.nextInt();
				leia.nextLine();
				return valor;
			} catch (InputMismatchException e) {
				System.out.println("\nValor inválido! Digite apenas números inteiros.");
				leia.nextLine();
			}
		}
	}

	private static float lerFloat(String mensagem) {
		while (true) {
			System.out.println(mensagem);
			String entrada = leia.nextLine();
			try {
				return Float.parseFloat(entrada.replace(",", "."));
			} catch (NumberFormatException e) {
				System.out.println("\nValor inválido! Digite um número (ex: 49.90).");
			}
		}
	}

	// ----------- Métodos do Menu -----------

	public static void listarTodos() {
		List<Livro> livros = contaController.listarTodos();

		if (livros.isEmpty()) {
			System.out.println("Nenhum livro cadastrado!");
			return;
		}

		for (Livro l : livros) {
			l.visualizar();
		}
	}

	public static void buscarPorId() {
		int id = lerInteiro("Digite o ID do produto: ");

		try {
			Optional<Livro> livro = contaController.buscarPorID(id);
			if (livro.isPresent()) {
				livro.get().visualizar();
			} else {
				throw new LivrariaException("Produto com ID " + id + " não foi encontrado!");
			}
		} catch (LivrariaException e) {
			System.out.println("\n" + e.getMessage());
		}
	}

	public static void buscarPorTitulo() {
		System.out.println("Digite o título (ou parte dele): ");
		String titulo = leia.nextLine();

		try {
			List<Livro> resultado = contaController.buscarPorTitulo(titulo);
			resultado.forEach(Livro::visualizar);
		} catch (LivrariaException e) {
			System.out.println("\n" + e.getMessage());
		}
	}

	public static void buscarPorAutoria() {
		System.out.println("Digite o nome do autor/autora (ou parte dele): ");
		String autoria = leia.nextLine();

		try {
			List<Livro> resultado = contaController.buscarPorAutoria(autoria);
			resultado.forEach(Livro::visualizar);
		} catch (LivrariaException e) {
			System.out.println("\n" + e.getMessage());
		}
	}

	public static void buscarPorGenero() {
		System.out.println("Digite o gênero literário: ");
		String genero = leia.nextLine();

		try {
			List<Livro> resultado = contaController.buscarPorGenero(genero);
			resultado.forEach(Livro::visualizar);
		} catch (LivrariaException e) {
			System.out.println("\n" + e.getMessage());
		}
	}

	public static void cadastrarLivro() {
		System.out.println("Digite o título: ");
		String titulo = leia.nextLine();

		System.out.println("Digite a autoria: ");
		String autoria = leia.nextLine();

		System.out.println("Digite o gênero: ");
		String genero = leia.nextLine();

		float preco = lerFloat("Digite o preço: ");

		contaController.cadastrar(new Livro(contaController.gerarId(), titulo, autoria, genero, preco));
	}

	public static void atualizarLivro() {
		int id = lerInteiro("Digite o ID do livro que deseja atualizar: ");

		try {
			Optional<Livro> livroOpt = contaController.buscarPorID(id);

			if (livroOpt.isEmpty()) {
				throw new LivrariaException("Produto com ID " + id + " não foi encontrado!");
			}

			Livro atual = livroOpt.get();

			System.out.printf("Título atual: %s%nNovo título (ENTER para manter): ", atual.getTitulo());
			String titulo = leia.nextLine();
			titulo = titulo.isEmpty() ? atual.getTitulo() : titulo;

			System.out.printf("Autoria atual: %s%nNova autoria (ENTER para manter): ", atual.getAutoria());
			String autoria = leia.nextLine();
			autoria = autoria.isEmpty() ? atual.getAutoria() : autoria;

			System.out.printf("Gênero atual: %s%nNovo gênero (ENTER para manter): ", atual.getGenero());
			String genero = leia.nextLine();
			genero = genero.isEmpty() ? atual.getGenero() : genero;

			System.out.printf("Preço atual: %.2f%nNovo preço (ENTER para manter): ", atual.getPreco());
			String entradaPreco = leia.nextLine();
			float preco = atual.getPreco();
			if (!entradaPreco.isEmpty()) {
				try {
					preco = Float.parseFloat(entradaPreco.replace(",", "."));
				} catch (NumberFormatException e) {
					System.out.println("\nValor inválido, preço mantido o atual.");
				}
			}

			contaController.atualizar(new Livro(id, titulo, autoria, genero, preco));

		} catch (LivrariaException e) {
			System.out.println("\n" + e.getMessage());
		}
	}

	public static void deletarLivro() {
		int id = lerInteiro("Digite o ID do livro que deseja excluir: ");

		try {
			Optional<Livro> livroOpt = contaController.buscarPorID(id);

			if (livroOpt.isEmpty()) {
				throw new LivrariaException("Produto com ID " + id + " não foi encontrado!");
			}

			System.out.printf("Tem certeza que deseja excluir \"%s\" (S/N)? ", livroOpt.get().getTitulo());
			String confirmacao = leia.nextLine();

			if (confirmacao.equalsIgnoreCase("S")) {
				contaController.deletar(id);
			} else {
				System.out.println("\nOperação cancelada!");
			}

		} catch (LivrariaException e) {
			System.out.println("\n" + e.getMessage());
		}
	}

	public static void aplicarCupom() {
		int id = lerInteiro("Digite o ID do livro: ");

		System.out.println("Digite o código do cupom: ");
		String codigo = leia.nextLine();

		try {
			contaController.aplicarCupom(id, codigo);
		} catch (LivrariaException e) {
			System.out.println("\n" + e.getMessage());
		}
	}
}