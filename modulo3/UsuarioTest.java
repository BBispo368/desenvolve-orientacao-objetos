package modulo2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class UsuarioTest {

    @Test
    public void testHistoricoERestricoes() {
        Usuario usuario = new Usuario("Gabriel", 21);
        Autor autor = new Autor("Alan Turing", "Inglês");
        Livro livro = new Livro("Java Basics", autor, "Tecnologia");

        // inicialmente não tem empréstimos
        assertTrue(usuario.getHistoricoEmprestimos().isEmpty());
        assertFalse(usuario.possuiAtrasos());

        // criar datas: retirada hoje, prevista ontem (gera atraso)
        Date dataRetirada = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataRetirada);
        cal.add(Calendar.DAY_OF_MONTH, -1); // previsto no passado
        Date dataPrevista = cal.getTime();

        // criar empréstimo (marcará o livro como emprestado e adicionará ao histórico)
        Emprestimo emprestimo = new Emprestimo(usuario, Arrays.asList(livro), dataRetirada, dataPrevista);

        // histórico atualizado
        assertTrue(usuario.getHistoricoEmprestimos().contains(emprestimo));

        // usuário possui atraso (data prevista no passado e não devolvido)
        assertTrue(usuario.possuiAtrasos());

        // podeEmprestar deve ser falso enquanto houver atrasos ou livro indisponível
        // livro já emprestado pelo construtor -> indisponível
        assertFalse(usuario.podeEmprestar(livro));

        // devolver e checar que agora não possui atraso
        emprestimo.registrarDevolucao(new Date());
        assertFalse(usuario.possuiAtrasos());
    }
}