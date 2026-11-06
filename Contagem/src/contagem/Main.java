package contagem;
public class Main {
    static void contagem(int n) {
        if (n == 0) {
            System.out.println("Fim!");
            return;
        }
        System.out.println(n);
        contagem(n - 1);
    }
    public static void main(String[] args) {
        contagem(3);
    }
}
