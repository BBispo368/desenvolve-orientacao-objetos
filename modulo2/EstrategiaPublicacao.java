package modulo2;

public interface EstrategiaPublicacao {
    /**
     * Publica o item passado (Livro ou Artigo). Implementações devem verificar o tipo.
     * @param item objeto a ser publicado (Livro ou Artigo)
     */
    void publicar(Object item);
}