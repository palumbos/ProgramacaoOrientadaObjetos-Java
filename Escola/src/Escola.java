import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Escola {
    private String nome;

    // Composição: endereço "nasce e morre" com a escola (no exemplo)
    private Endereco endereco;

    // Composição: prédios pertencem à escola
    private List<Predio> predios = new ArrayList<>();

    // Associação: biblioteca pode existir separada e apenas se relaciona
    private Biblioteca biblioteca;

    // Agregação: disciplinas podem existir (conceitualmente) sem a escola
    
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Escola(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public void associarBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void adicionarPredio(Predio predio) {
        predios.add(predio);
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public List<Predio> getPredios() { return Collections.unmodifiableList(predios); }
    public List<Disciplina> getDisciplinas() { return Collections.unmodifiableList(disciplinas); }

    // Importando campos de outras classes para exibir informações
    public void exibirResumoCompleto() {
        System.out.println("=== ESCOLA ===");
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);

        System.out.println("\n=== BIBLIOTECA (associação) ===");
        System.out.println(biblioteca != null ? biblioteca : "Sem biblioteca associada");

        System.out.println("\n=== PRÉDIOS (composição) ===");
        if (predios.isEmpty()) {
            System.out.println("Nenhum prédio cadastrado.");
        } else {
            for (Predio p : predios) {
                System.out.println("- " + p.getNome());
                for (Sala s : p.getSalas()) {
                    System.out.println("   * " + s);
                }
            }
        }

        System.out.println("\n=== DISCIPLINAS (agregação) ===");
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
        } else {
            for (Disciplina d : disciplinas) {
                System.out.println("- " + d.getNome());
                System.out.println("   Professor: " + d.getProfessor().getNome() + " (SIAPE: " + d.getProfessor().getSiape() + ")");
                System.out.println("   Alunos:");
                for (Aluno a : d.getAlunos()) {
                    System.out.println("     - " + a.getNome() + " (Matrícula: " + a.getMatricula() + ")");
                }
            }
        }
    }
}