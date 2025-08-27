package modulo2;

public class EstrategiaPublicacaoArtigo implements EstrategiaPublicacao {
    @Override
    public void publicar(Object item) {
        if (item instanceof Artigo) {
            Artigo a = (Artigo) item;
            a.setPublicado(true);
        } else {
            throw new IllegalArgumentException("Estratégia de publicação de artigo recebeu tipo inválido.");
        }
    }
}