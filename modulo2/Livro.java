package modulo2;

public class Livro {
    private final String titulo;
    private final Autor autor;
    private String genero;
    private boolean disponivel = true;
    private boolean publicado = false; // novo campo para suportar publicação

    public Livro(String titulo, Autor autor, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        if (autor != null) {
            autor.adicionarObra(this);
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void marcarComoEmprestado() {
        this.disponivel = false;
    }

    public void marcarComoDisponivel() {
        this.disponivel = true;
    }

    // novos getters/setters para publicação
    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }
}