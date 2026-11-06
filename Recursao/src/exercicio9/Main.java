package exercicio9;

public class Main {
    static int contarImpares(int n) {
        if (n <= 0) {
            return 0;
        }
        int eImpar = (n % 2 != 0) ? 1 : 0;
        return eImpar + contarImpares(n - 1);
    }

    public static void main(String[] args) {
        int resultado = contarImpares(7);
        System.out.println(resultado);
    }
}
