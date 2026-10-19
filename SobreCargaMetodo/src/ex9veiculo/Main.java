package ex9veiculo;

public class Main {

    public static void main(String[] args) {
        Veiculo generico = new Veiculo();
        Veiculo c = new Carro();
        Veiculo m = new Moto();
        Veiculo t = new Triciclo();
        
        
        generico.getRodas();
        c.getRodas();
        m.getRodas();
        t.getRodas();

    }
}
