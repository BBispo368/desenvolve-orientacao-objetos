package modulo2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PublicacaoStrategyTest {

    @Test
    public void testPublicacaoLivroComEstrategia() {
        Autor autor = new Autor("Jess", "Brasileira");
        Livro livro = new Livro("Livro Estratégia", autor, "Tecnologia");
        UsuarioDecorator usuario = new UsuarioDecorator("Gabriel", 30);

        assertFalse(livro.isPublicado());

        usuario.setEstrategiaPublicacao(new EstrategiaPublicacaoLivro());
        usuario.setAlvoPublicacao(livro);
        usuario.publicar();

        assertTrue(livro.isPublicado(), "Livro deve ser marcado como publicado pela estratégia de livro");
    }

    @Test
    public void testPublicacaoArtigoComEstrategia() {
        Autor autor = new Autor("Alan Turing", "Inglês");
        Artigo artigo = new Artigo("Entendendo Compiladores", autor, "tecnologia", false);
        UsuarioDecorator usuario = new UsuarioDecorator("Mariana", 28);

        assertFalse(artigo.isPublicado());

        usuario.setEstrategiaPublicacao(new EstrategiaPublicacaoArtigo());
        usuario.setAlvoPublicacao(artigo);
        usuario.publicar();

        assertTrue(artigo.isPublicado(), "Artigo deve ser marcado como publicado pela estratégia de artigo");
    }

    @Test
    public void testPublicarSemEstrategiaLanchaExcecao() {
        Autor autor = new Autor("Jess", "Brasileira");
        Livro livro = new Livro("Livro Sem Estratégia", autor, "Tecnologia");
        UsuarioDecorator usuario = new UsuarioDecorator("Pedro", 22);

        usuario.setAlvoPublicacao(livro);
        assertThrows(IllegalStateException.class, usuario::publicar);
    }

    @Test
    public void testPublicarComAlvoNuloLanchaExcecao() {
        UsuarioDecorator usuario = new UsuarioDecorator("Ana", 24);
        usuario.setEstrategiaPublicacao(new EstrategiaPublicacaoLivro());
        assertThrows(IllegalStateException.class,