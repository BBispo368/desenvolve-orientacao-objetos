package modulo2;

public class UsuarioDecorator extends Usuario implements PublicavelInterface {
    private EstrategiaPublicacao estrategiaPublicacao;
    private Object alvoPublicacao;

    public UsuarioDecorator(String nome, int idade) {
        super(nome, idade);
    }

    public void setEstrategiaPublicacao(EstrategiaPublicacao estrategiaPublicacao) {
        this.estrategiaPublicacao = estrategiaPublicacao;
    }

    public void setAlvoPublicacao(Object alvoPublicacao) {
        this.alvoPublicacao = alvoPublicacao;
    }

    @Override
    public void publicar() {
        if (estrategiaPublicacao == null) {
            throw new IllegalStateException("Estratégia de publicação não configurada.");
        }
        if (alvoPublicacao == null) {
            throw new IllegalStateException("Alvo de publicação não configurado.");
        }
        estrategiaPublicacao.publicar(alvoPublicacao);
    }
}