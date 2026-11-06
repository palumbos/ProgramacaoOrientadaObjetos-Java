package exercicio8;

public class Main {
    static int contarPares(int[] vetor, int tamanho) {
        if (tamanho == 0) {
            return 0;
        }
        int ePar = (vetor[tamanho - 1] % 2 == 0) ? 1 : 0;
        return ePar + contarPares(vetor, tamanho - 1);
    }

    public static void main(String[] args) {
        int[] vetor = {1, 2, 3, 4, 6, 7};
        int resultado = contarPares(vetor, vetor.length);
        System.out.println(resultado);
    }
}
