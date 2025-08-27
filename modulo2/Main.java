package modulo2;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Autor tradicional
        Autor autor = new Autor("Jessica Felix", "Brasileira");
        // Autor que também é usuário (exemplo de uso do novo construtor)
        Autor autorUsuario = new Autor("Mariana Silva", 34, "Brasileira", true);

        Livro livro = new Livro("Java for Beginners", autor, "Tecnologia");
        Usuario usuario = new Usuario("Lucas Rafael", 25);

        // Criar um artigo conforme solicitado
        Artigo artigo = new Artigo("Entendendo Compiladores", autor, "tecnologia", true);

        // Simular livro não disponível
        livro.marcarComoEmprestado();

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

        Date dataRetirada = new Date();
        Date dataDevolucao = new Date();

        System.out.println("Data de Retirada: " + dataRetirada);
        System.out.println();
        System.out.println("Data de Devolucao: " + dataDevolucao);
        System.out.println();

        // Exibir informações do artigo criado
        System.out.println("Artigo: " + artigo.getTitulo());
        System.out.println("Autor do Artigo: " + artigo.getAutor().getNome());
        System.out.println("Publicado: " + (artigo.isPublicado() ? "Sim" : "Não"));
    }
}
