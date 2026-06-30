package livraria_virtual.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import livraria_virtual.exception.LivrariaException;
import livraria_virtual.model.Cupom;
import livraria_virtual.model.Livro;
import livraria_virtual.repository.Repository;
import livraria_virtual.util.TextoUtil;

public class ContaController implements Repository {

	private List<Livro> livros = new ArrayList<>();
	private Map<String, Cupom> cupons = new HashMap<>();
	private int proximoId = 1;

	public ContaController() {
		criarCuponsTeste();
	}

	// Gera ID automático para novos livros
	public int gerarId() {
		return proximoId++;
	}

	private void criarCuponsTeste() {
		cupons.put("BEMVINDO10", new Cupom("BEMVINDO10", 10, true));
		cupons.put("LEITOR20", new Cupom("RAFAEL15", 15, true));
		cupons.put("PROMO50", new Cupom("AIMEE15", 15, true));
	}

	@Override
	public List<Livro> listarTodos() {
		return livros;
	}

	@Override
	public Optional<Livro> buscarPorID(int id) {
		return livros.stream()
				.filter(l -> l.getId() == id)
				.findFirst();
	}

	@Override
	public List<Livro> buscarPorTitulo(String titulo) {
		List<Livro> resultado = new ArrayList<>();
		String tituloBusca = TextoUtil.normalizar(titulo);

		for (Livro l : livros) {
			if (TextoUtil.normalizar(l.getTitulo()).contains(tituloBusca)) {
				resultado.add(l);
			}
		}

		if (resultado.isEmpty()) {
			throw new LivrariaException("Nenhum resultado encontrado para título: \"" + titulo + "\"");
		}

		return resultado;
	}

	@Override
	public List<Livro> buscarPorAutoria(String autoria) {
		List<Livro> resultado = new ArrayList<>();
		String autoriaBusca = TextoUtil.normalizar(autoria);

		for (Livro l : livros) {
			if (TextoUtil.normalizar(l.getAutoria()).contains(autoriaBusca)) {
				resultado.add(l);
			}
		}

		if (resultado.isEmpty()) {
			throw new LivrariaException("Nenhum resultado encontrado para autoria: \"" + autoria + "\"");
		}

		return resultado;
	}

	@Override
	public List<Livro> buscarPorGenero(String genero) {
		List<Livro> resultado = new ArrayList<>();
		String generoBusca = TextoUtil.normalizar(genero);

		for (Livro l : livros) {
			if (TextoUtil.normalizar(l.getGenero()).contains(generoBusca)) {
				resultado.add(l);
			}
		}

		if (resultado.isEmpty()) {
			throw new LivrariaException("Nenhum resultado encontrado para gênero: \"" + genero + "\"");
		}

		return resultado;
	}

	@Override
	public void cadastrar(Livro livro) {
		livros.add(livro);
		System.out.println("\nLivro cadastrado com sucesso!");
	}

	@Override
	public void atualizar(Livro livro) {
		Optional<Livro> existente = buscarPorID(livro.getId());

		if (existente.isEmpty()) {
			throw new LivrariaException("Produto com ID " + livro.getId() + " não foi encontrado!");
		}

		Livro l = existente.get();
		l.setTitulo(livro.getTitulo());
		l.setAutoria(livro.getAutoria());
		l.setGenero(livro.getGenero());
		l.setPreco(livro.getPreco());

		System.out.println("\nLivro atualizado com sucesso!");
	}

	@Override
	public void deletar(int id) {
		Optional<Livro> existente = buscarPorID(id);

		if (existente.isEmpty()) {
			throw new LivrariaException("Produto com ID " + id + " não foi encontrado!");
		}

		livros.remove(existente.get());
		System.out.println("\nLivro removido com sucesso!");
	}

	// ----------------- CUPOM DE DESCONTO -----------------

	public void aplicarCupom(int idLivro, String codigo) {

		Optional<Livro> livroOpt = buscarPorID(idLivro);
		if (livroOpt.isEmpty()) {
			throw new LivrariaException("Produto com ID " + idLivro + " não foi encontrado!");
		}

		Cupom cupom = cupons.get(codigo.toUpperCase());
		if (cupom == null || !cupom.isAtivo()) {
			throw new LivrariaException("Cupom \"" + codigo + "\" inválido, inexistente ou expirado!");
		}

		Livro livro = livroOpt.get();
		boolean aplicado = livro.aplicarDesconto(cupom.getPercentual());

		if (aplicado) {
			System.out.printf("%nCupom \"%s\" aplicado! Desconto de %.0f%% concedido.%n",
					cupom.getCodigo(), cupom.getPercentual());
			livro.visualizar();
		}
	}

	public void listarCupons() {
		System.out.println("\n----- Cupons disponíveis -----");
		for (Cupom c : cupons.values()) {
			System.out.printf("Código: %-12s | Desconto: %.0f%% | %s%n",
					c.getCodigo(), c.getPercentual(), c.isAtivo() ? "Ativo" : "Inativo");
		}
	}
}
