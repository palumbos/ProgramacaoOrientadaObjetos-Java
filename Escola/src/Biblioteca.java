public class Biblioteca {
    private String nome;
    private String responsavel;

    public Biblioteca(String nome, String responsavel) {
        this.nome = nome;
        this.responsavel = responsavel;
    }

    public String getNome() { return nome; }

    @Override
    public String toString() {
        return "Biblioteca{nome='" + nome + "', responsavel='" + responsavel + "'}";
    }
}
