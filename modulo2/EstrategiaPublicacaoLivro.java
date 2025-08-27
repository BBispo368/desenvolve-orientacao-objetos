package modulo2;

public class EstrategiaPublicacaoLivro implements EstrategiaPublicacao {
    @Override
    public void publicar(Object item) {
        if (item instanceof Livro) {
            Livro l = (Livro) item;
            l.setPublicado(true);
        } else {
            throw new IllegalArgumentException("Estratégia de publicação de livro recebeu tipo inválido.");
        }
    }
}