package modulo2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class EmprestimoTest {

    @Test
    public void testCriacaoERegistroDevolucao() {
        Date dataRetirada = new Date();
        // data prevista daqui a 7 dias
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataRetirada);
        cal.add(Calendar.DAY_OF_MONTH, 7);
        Date dataPrevista = cal.getTime();

        Autor autor = new Autor("Alan Turing", "Inglês");
        Livro livro = new Livro("Java Basics", autor, "Tecnologia");
        Usuario usuario = new Usuario("Gabriel", 21);

        Emprestimo e = new Emprestimo(usuario, Arrays.asList(livro), dataRetirada, dataPrevista);

        // verificações básicas
        assertEquals(usuario, e.getUsuario());
        assertTrue(e.getLivros().contains(livro));
        assertEquals(dataRetirada, e.getDataRetirada());
        assertEquals(dataPrevista, e.getDataPrevistaDevolucao());
        assertFalse(e.isDevolvido());
        assertFalse(e.estaAtrasado());

        // registrar devolução
        Date dataDevolucao = new Date();
        e.registrarDevolucao(dataDevolucao);
        assertTrue(e.isDevolvido());
        assertEquals(dataDevolucao, e.getDataDevolucao());
        // livro deve ter sido marcado como disponível
        assertTrue(livro.isDisponivel());
    }

    @Test
    public void testEstaAtrasadoQuandoPrevistaNoPassado() {
        Date dataRetirada = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataRetirada);
        cal.add(Calendar.DAY_OF_MONTH, -10); // retirada 10 dias atrás
        Date dataPrevista = cal.getTime(); // prevista no passado

        Autor autor = new Autor("Alan Turing", "Inglês");
        Livro livro = new Livro("Java Basics", autor, "Tecnologia");
        Usuario usuario = new Usuario("Gabriel", 21);

        Emprestimo e = new Emprestimo(usuario, Arrays.asList(livro), dataRetirada, dataPrevista);

        assertTrue(e.estaAtrasado());

        // após registrar devolução, não deve mais estar atrasado
        e.registrarDevolucao(new Date());
        assertFalse(e.estaAtrasado());
    }
}