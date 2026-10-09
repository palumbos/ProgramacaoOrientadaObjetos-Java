public class Sala {
    private String codigo;
    private int capacidade;

    public Sala(String codigo, int capacidade) {
        this.codigo = codigo;
        this.capacidade = capacidade;
    }

    public String getCodigo() { return codigo; }

    @Override
    public String toString() {
        return "Sala{codigo='" + codigo + "', capacidade=" + capacidade + "}";
    }
}
