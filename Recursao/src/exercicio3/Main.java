package exercicio3;

public class Main {

    static int soma = 0;

    static void somaCrecente(int n) {
        soma = soma + n;
        if (n == 0) {
            System.out.println(soma);
            return;
        }

        somaCrecente(n - 1);
    }

    public static void main(String[] args) {
        somaCrecente(3);
    }
}
