package modulo2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AutorTest {

    @Test
    public void testAtributosEObrasEFlagUsuario() {
        // autor tradicional (padrão)
        Autor autor = new Autor("Jess", "Brasileira");
        assertEquals("Jess", autor.getNome());
        assertEquals("Brasileira", autor.getNacionalidade());
        assertFalse(autor.isEhUsuario(), "Por padrão autor não deve ser usuário");

        // autor que também é usuário (usar novo construtor)
        Autor autorUsuario = new Autor("Carlos", 40, "Brasileira", true);
        assertEquals("Carlos", autorUsuario.getNome());
        assertEquals(40, autorUsuario.getIdade());
        assertTrue(autorUsuario.isEhUsuario(), "Autor criado com flag deve ser usuário");

        // obras
        Livro livro = new Livro("Obra 1", autor, "ficcao");
        assertTrue(autor.getObras().contains(livro));
        // adicionar obra manualmente não duplica
        autor.adicionarObra(livro);
        long ocorrencias = autor.getObras().stream().filter(l -> l == livro).count();
        assertEquals(1, ocorrencias);
    }
}
