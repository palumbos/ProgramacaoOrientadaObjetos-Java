import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Predio {
    private String nome;
    private List<Sala> salas = new ArrayList<>();

    public Predio(String nome) {
        this.nome = nome;
    }

    // Composição: o prédio "cria e possui" salas
    public void adicionarSala(String codigo, int capacidade) {
        salas.add(new Sala(codigo, capacidade));
    }    public String getNome() { return nome; }

    public List<Sala> getSalas() {
        return Collections.unmodifiableList(salas);
    }

    @Override
    public String toString() {
        return "Predio{nome='" + nome + "', salas=" + salas + "}";
    }
}
