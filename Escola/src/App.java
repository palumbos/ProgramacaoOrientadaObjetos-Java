public class App {
    public static void main(String[] args) {
        // Composição (Escola -> Endereco)
        Endereco endereco = new Endereco("Av. Central", 100, "Lages", "SC");
        Escola escola = new Escola("IFSC - Campus Exemplo", endereco);

        // Associação (Escola -> Biblioteca)
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Mariana Souza");
        escola.associarBiblioteca(biblioteca);

        // Composição (Escola -> Predio -> Sala)
        Predio predioA = new Predio("Bloco A");
        predioA.adicionarSala("A-101", 35);
        predioA.adicionarSala("A-102", 40);
        escola.adicionarPredio(predioA);

        // Herança (Pessoa <- Professor/Aluno)
        Professor prof = new Professor("Carlos Lima", "123.456.789-00", "987654");
        Aluno a1 = new Aluno("Ana", "111.222.333-44", "2026A001");        Aluno a2 = new Aluno("João", "555.666.777-88", "2026A002");

        // Agregação (Disciplina -> Professor/Alunos)
        Disciplina disciplina = new Disciplina("Programação", 80, prof);
        disciplina.matricularAluno(a1);
        disciplina.matricularAluno(a2);

        // Agregação (Escola -> Disciplinas)
        escola.adicionarDisciplina(disciplina);

        // Exibição importando dados de várias classes
        escola.exibirResumoCompleto();
    }
}