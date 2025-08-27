package modulo2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AutorTest {

    @Test
    public void testAtributosEObras() {
        Autor autor = new Autor("Jess", "Brasileira");

        // nome vem de Pessoa
        assertEquals("Jess", autor.getNome());
        assertEquals("Brasileira", autor.getNacionalidade());

        // adicionar obra e verificar lista
        Livro livro = new Livro("Obra 1", autor, "ficcao");
        // o construtor já registra a obra no autor; garantir presença
        assertTrue(autor.getObras().contains(livro));

        // adicionar obra manualmente (idempotência)
        autor.adicionarObra(livro);
        long ocorrencias = autor.getObras().stream().filter(l -> l == livro).count();
        assertEquals(1, ocorrencias);
    }
}