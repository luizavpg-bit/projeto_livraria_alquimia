package livraria_virtual.exception;

public class ProdutoNaoEncontradoException extends RuntimeException {

	public ProdutoNaoEncontradoException(int id) {
		super("Produto com ID " + id + " não foi encontrado!");
	}
}

