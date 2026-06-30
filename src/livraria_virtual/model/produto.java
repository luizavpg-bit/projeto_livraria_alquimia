package livraria_virtual.model;

public abstract class produto {

	private int id;
	private String titulo;
	private String autoria;
	private float preco;

	public produto(int id, String titulo, String autoria, float preco) {
		this.id = id;
		this.titulo = titulo;
		this.autoria = autoria;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutoria() {
		return autoria;
	}

	public void setAutoria(String autoria) {
		this.autoria = autoria;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	// Aplicar o percentual de desconto direto ao preço do produto
	public boolean aplicarDesconto(float percentual) {

		if (percentual <= 0 || percentual >= 100) {
			System.out.println("\nPercentual de desconto inválido!");
			return false;
		}

		this.preco = this.preco - (this.preco * (percentual / 100));
		return true;
	}

		public abstract void visualizar();
}