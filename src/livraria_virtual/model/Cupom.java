package livraria_virtual.model;

public class Cupom {

	private String codigo;
	private float percentual;
	private boolean ativo;

	public Cupom(String codigo, float percentual, boolean ativo) {
		this.codigo = codigo;
		this.percentual = percentual;
		this.ativo = ativo;
	}

	public String getCodigo() {
		return codigo;
	}

	public float getPercentual() {
		return percentual;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
