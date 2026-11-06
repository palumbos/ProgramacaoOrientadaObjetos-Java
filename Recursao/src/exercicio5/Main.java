package exercicio5;

public class Main {
    static int multiplicarSomando(int n1, int n2) {
        if (n2 == 0) {
            return 0; 
        }
        return n1 + multiplicarSomando(n1, n2 - 1);
    }

    public static void main(String[] args) {
        int resultado = multiplicarSomando(4, 3);
        System.out.println(resultado); 
    }
}
