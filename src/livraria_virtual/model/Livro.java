package livraria_virtual.model;

public class Livro extends produto {

	private String genero;

	public Livro(int id, String titulo, String autoria, String genero, float preco) {
		super(id, titulo, autoria, preco);
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public void visualizar() {
		System.out.println("\n***********************************************************");
		System.out.println("Dados do Livro:");
		System.out.println("***********************************************************");
		// AJUSTADO AQUI: Agora chama getId() que pertence à classe produto
		System.out.println("ID: " + this.getId()); 
		System.out.println("Título: " + this.getTitulo());
		System.out.println("Autoria: " + this.getAutoria());
		System.out.println("Gênero: " + this.genero);
		System.out.printf("Preço: R$ %.2f%n", this.getPreco());
	}
}