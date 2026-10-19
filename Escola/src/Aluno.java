public class Aluno extends Pessoa {
    private String matricula;

    public Aluno(String nome, String cpf, String matricula) {
        super(nome, cpf);
        this.matricula = matricula;
    }

    public String getMatricula() { return matricula; }

    @Override
    public String toString() {
        return "Aluno{" + super.toString() + ", matricula='" + matricula + "'}";
    }
}