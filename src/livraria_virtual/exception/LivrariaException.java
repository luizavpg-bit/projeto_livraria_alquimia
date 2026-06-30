package livraria_virtual.exception;

public class LivrariaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public LivrariaException(String mensagem) {
        super(mensagem);
    }
}
