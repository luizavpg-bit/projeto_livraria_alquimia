package livraria_virtual.repository;

import java.util.List;
import java.util.Optional;

import livraria_virtual.model.Livro;

public interface Repository {

	List<Livro> listarTodos();

	Optional<Livro> buscarPorID(int id);

	List<Livro> buscarPorTitulo(String titulo);

	List<Livro> buscarPorAutoria(String autoria);

	List<Livro> buscarPorGenero(String genero);

	void cadastrar(Livro livro);

	void atualizar(Livro livro);

	void deletar(int id);
}
