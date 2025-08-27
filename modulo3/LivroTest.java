package modulo2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LivroTest {

    @Test
    public void testAtributosEStatus() {
        Autor autor = new Autor("Jess", "Brasileira");
        Livro livro1 = new Livro("Java Basico", autor, "tecnologia");
        Livro livro2 = new Livro("Java Avançado", autor, "tecnologia");

        // testar getters
        assertEquals("Java Basico", livro1.getTitulo());
        assertEquals(autor, livro1.getAutor());
        assertEquals("tecnologia", livro1.getGenero());

        // testar estado de disponibilidade via métodos
        livro1.marcarComoDisponivel();
        assertTrue(livro1.isDisponivel());

        livro2.marcarComoEmprestado();
        assertFalse(livro2.isDisponivel());

        // alterar gênero
        livro1.setGenero("Programação");
        assertEquals("Programação", livro1.getGenero());
    }
}
