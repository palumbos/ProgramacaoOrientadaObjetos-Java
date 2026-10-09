import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Disciplina {
    private String nome;
    private int cargaHoraria;

    // Agregação: professor existe independente da disciplina
    private Professor professor;

    // Agregação: alunos existem independente da disciplina
    private List<Aluno> alunos = new ArrayList<>();

    public Disciplina(String nome, int cargaHoraria, Professor professor) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    public void matricularAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public String getNome() { return nome; }
    public Professor getProfessor() { return professor; }
    public List<Aluno> getAlunos() { return Collections.unmodifiableList(alunos); }

    @Override
    public String toString() {
        return "Disciplina{nome='" + nome + "', cargaHoraria=" + cargaHoraria +
                ", professor=" + professor.getNome() +
                ", alunos=" + alunos.size() + "}";
    }}
