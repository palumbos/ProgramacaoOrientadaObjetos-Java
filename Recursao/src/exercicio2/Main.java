package exercicio2;

public class Main {

    static void contagemCrecente(int n) {
        if (n == 0) {
            System.out.println("Fim!");
            return;
        }

        contagemCrecente(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        contagemCrecente(3);
    }
}
