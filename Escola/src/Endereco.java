public class Endereco {
    private String rua;
    private int numero;
    private String cidade;
    private String uf;

    public Endereco(String rua, int numero, String cidade, String uf) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
    }    @Override
    public String toString() {
        return rua + ", " + numero + " - " + cidade + "/" + uf;
    }
}
