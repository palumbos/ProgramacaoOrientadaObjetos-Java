package exercicio6;

public class Main {
    static int potencia(int base, int expoente) {
        if (expoente == 0) {
            return 1;
        }
        return base * potencia(base, expoente - 1);
    }

    public static void main(String[] args) {
        int resultado = potencia(2, 4);
        System.out.println(resultado);
    }
}
