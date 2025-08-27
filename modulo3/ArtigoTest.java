package modulo2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArtigoTest {

    @Test
    public void testConstrutorEGetters() {
        Autor autor = new Autor("Alan Turing", "Inglês");
        Artigo artigo = new Artigo("Entendendo Compiladores", autor, "tecnologia", true);

        assertEquals("Entendendo Compiladores", artigo.getTitulo());
        assertEquals(autor, artigo.getAutor());
        assertEquals("tecnologia", artigo.getGenero());
        assertTrue(artigo.isPublicado());

        // alterar gênero e publicado
        artigo.setGenero("Ciência da Computação");
        artigo.setPublicado(false);
        assertEquals("Ciência da Computação", artigo.getGenero());
        assertFalse(artigo.isPublicado());
    }

    @Test
    public void testConstrutorComParametrosInvalidos() {
        Autor autor = new Autor("Alan Turing", "Inglês");
        assertThrows(IllegalArgumentException.class, () -> new Artigo(null, autor, "x", true));
        assertThrows(IllegalArgumentException.class, () -> new Artigo("Titulo", null, "x", true));