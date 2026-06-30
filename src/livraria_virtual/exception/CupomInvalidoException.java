package livraria_virtual.exception;

public class CupomInvalidoException extends RuntimeException {

	public CupomInvalidoException(String codigo) {
		super("Cupom \"" + codigo + "\" inválido, inexistente ou expirado!");
	}
}