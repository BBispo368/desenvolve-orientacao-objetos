package modulo2;

import java.util.ArrayList;
import java.util.List;

public class Autor extends Pessoa {
    private String nacionalidade;
    private final List<Livro> obras = new ArrayList<>();

    public Autor(String nome, String nacionalidade) {
        super(nome, 0); // Autor não precisa de idade para este exercício
        this.nacionalidade = nacionalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<Livro> getObras() {
        return obras;
    }

    public void adicionarObra(Livro livro) {
        if (livro != null && !obras.contains(livro)) {
            obras.add(livro);
        }
    }
}