package exercicio7;

public class Main {
    static int somarVetor(int[] vetor, int tamanho) {
        if (tamanho == 0) {
            return 0;
        }
        return vetor[tamanho - 1] + somarVetor(vetor, tamanho - 1);
    }

    public static void main(String[] args) {
        int[] vetor = {2, 4, 6, 8};
        int resultado = somarVetor(vetor, vetor.length);
        System.out.println(resultado);
    }
}
