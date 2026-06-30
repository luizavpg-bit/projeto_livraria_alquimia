package livraria_virtual.exception;

public class BuscaSemResultadoException extends RuntimeException {

	public BuscaSemResultadoException(String campo, String valor) {
		super("Nenhum resultado encontrado para " + campo + ": \"" + valor + "\"");
	}
}

