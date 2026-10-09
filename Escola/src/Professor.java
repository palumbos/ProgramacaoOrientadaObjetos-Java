public class Professor extends Pessoa {
    private String siape;

    public Professor(String nome, String cpf, String siape) {
        super(nome, cpf);
        this.siape = siape;
    }

    public String getSiape() { return siape; }

    @Override
    public String toString() {
        return "Professor{" + super.toString() + ", siape='" + siape + "'}";
    }

    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
