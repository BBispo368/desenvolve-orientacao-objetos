package modulo2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Emprestimo {
    private final List<Livro> livros = new ArrayList<>();
    private final Usuario usuario;
    private Date dataRetirada;
    private Date dataPrevistaDevolucao;
    private Date dataDevolucao;
    private boolean devolvido = false;

    public Emprestimo(Usuario usuario, List<Livro> livros, Date dataRetirada, Date dataPrevistaDevolucao) {
        if (usuario == null || livros == null || livros.isEmpty()) {
            throw new IllegalArgumentException("Usuário e ao menos um livro são necessários.");
        }
        this.usuario = usuario;
        for (Livro l : livros) {
            if (!l.isDisponivel()) {
                throw new IllegalStateException("Livro não disponível: " + l.getTitulo());
            }
        }
        this.livros.addAll(livros);
        this.dataRetirada = dataRetirada;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        // marca os livros como emprestados
        for (Livro l : this.livros) {
            l.marcarComoEmprestado();
        }
        // adiciona ao histórico do usuário
        usuario.adicionarEmprestimoHistorico(this);
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public Date getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void registrarDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
        this.devolvido = true;
        for (Livro l : livros) {
            l.marcarComoDisponivel();
        }
    }

    public boolean estaAtrasado() {
        if (devolvido || dataPrevistaDevolucao == null) return false;
        Date hoje = new Date();
        return hoje.after(dataPrevistaDevolucao);
    }
}