import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(String titulo, String autor){
        livros.add(new Livro(titulo, autor));
    }

    public List<Livro> listaLivros(){
        return new ArrayList<>(livros);
    }
    /**
     * Busca Livros por autor, ignorando maiusculas/minusculas.
     * @param autor Nome do autor a ser buscado.
     * @return Lista de livros do autor especificado.
     */

    public List<Livro> buscaPorAutor(String autor){
        return livros.stream()
            .filter(livro ->livro.getAutor().equalsIgnoreCase(autor))
            .collect(Collectors.toList());
    }

    public Livro buscarPorIsbn(String isbn){
        return livros.stream()
            .filter(livro -> livro.getIsbn().equals(isbn))
            .findFirst()
            .orElse(null);
    }
    
}
