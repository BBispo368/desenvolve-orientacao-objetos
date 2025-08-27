package modulo2;

import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Dados que podem ser alterados conforme instrução
        Autor autor = new Autor("Jessica Felix", "Brasileira");
        Livro livro = new Livro("Java for Beginners", autor, "Tecnologia");
        Usuario usuario = new Usuario("Lucas Rafael", 25);

        // Simular livro não disponível (pode ser por empréstimo anterior)
        livro.marcarComoEmprestado();

        // Impressão conforme solicitado
        if (!livro.isDisponivel()) {
            System.out.println("O livro não está disponível");
        } else {
            System.out.println("O livro está disponível");
        }

        System.out.println("Livro: " + livro.getTitulo());
        System.out.println();
        System.out.println("Autor: " + autor.getNome());
        System.out.println();
        System.out.println("Genero: " + livro.getGenero());
        System.out.println();
        System.out.println("Usuario: " + usuario.getNome());
        System.out.println();
        System.out.println("Idade: " + usuario.getIdade());
        System.out.println();

        // Criar datas (pode alterar)
        Date dataRetirada = new Date();
        Date dataDevolucao = new Date();

        System.out.println("Data de Retirada: " + dataRetirada);
        System.out.println();
        System.out.println("Data de Devolucao: " + dataDevolucao);
    }
}