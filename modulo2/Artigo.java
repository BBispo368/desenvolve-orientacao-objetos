package modulo2;

public class Artigo {
    private final String titulo;
    private final Autor autor;
    private String genero;
    private boolean publicado;

    public Artigo(String titulo, Autor autor, String genero, boolean publicado) {
        if (titulo == null || autor == null) {
            throw new IllegalArgumentException("Titulo e autor são obrigatórios");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.publicado = publicado;
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

    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }
}