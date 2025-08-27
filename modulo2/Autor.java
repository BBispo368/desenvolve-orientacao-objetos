package modulo2;

import java.util.ArrayList;
import java.util.List;

public class Autor extends Pessoa {
    private String nacionalidade;
    private final List<Livro> obras = new ArrayList<>();
    private boolean ehUsuario; // indica se o autor também é um usuário

    // construtor padrão: autor tradicional (não usuário), idade não especificada
    public Autor(String nome, String nacionalidade) {
        super(nome, 0);
        this.nacionalidade = nacionalidade;
        this.ehUsuario = false;
    }

    // construtor que permite informar idade e se é usuário
    public Autor(String nome, int idade, String nacionalidade, boolean ehUsuario) {
        super(nome, idade);
        this.nacionalidade = nacionalidade;
        this.ehUsuario = ehUsuario;
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

    public boolean isEhUsuario() {
        return ehUsuario;
    }

    public void setEhUsuario(boolean ehUsuario) {
        this.ehUsuario = ehUsuario;
    }
}
