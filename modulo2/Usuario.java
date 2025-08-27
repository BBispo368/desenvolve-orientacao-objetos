package modulo2;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Pessoa {
    private final List<Emprestimo> historicoEmprestimos = new ArrayList<>();

    public Usuario(String nome, int idade) {
        super(nome, idade);
    }

    public List<Emprestimo> getHistoricoEmprestimos() {
        return historicoEmprestimos;
    }

    public void adicionarEmprestimoHistorico(Emprestimo e) {
        if (e != null) {
            historicoEmprestimos.add(e);
        }
    }

    public boolean possuiAtrasos() {
        for (Emprestimo e : historicoEmprestimos) {
            if (!e.isDevolvido() && e.estaAtrasado()) {
                return true;
            }
        }
        return false;
    }

    public boolean podeEmprestar(Livro livro) {
        if (livro == null) return false;
        if (!livro.isDisponivel()) return false;
        // regra simples: não tem atrasos
        return !possuiAtrasos();
    }
}