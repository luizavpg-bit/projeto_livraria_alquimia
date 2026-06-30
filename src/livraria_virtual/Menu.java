package livraria_virtual;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                Livraria Alquimia                    ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Listar todos os produtos             ");
			System.out.println("            2 - Listar produtos pelo ID              ");
			System.out.println("            3 - Buscar por Título                    ");
			System.out.println("            4 - Buscar por Autor/Autora              ");
			System.out.println("            5 - Buscar por Gênero Literário          ");
			System.out.println("            6 - Cadastrar Produto                    ");
			System.out.println("            7 - Atualizar Produto                    ");
			System.out.println("            8 - Deletar Produto                      ");
			System.out.println("                                                     ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println("\nLivraria Alquimia - Conhecimento que transforma");
				sobre();
                 leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Listar produtos pelo ID\n\n");

					break;
				case 2:
					System.out.println("Buscar por Título\n\n");

					break;
				case 3:
					System.out.println("Buscar por Autor/Autora\n\n");

					break;
				case 4:
					System.out.println("Buscar por Gênero Literário\n\n");

					break;
				case 5:
					System.out.println("Cadastrar Produto\n\n");

					break;
				case 6:
					System.out.println("Atualizar Produto\n\n");

					break;
				case 7:
					System.out.println("Deletar produto\n\n");

					break;
				default:
					System.out.println("\nOpção Inválida!\n");
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
}