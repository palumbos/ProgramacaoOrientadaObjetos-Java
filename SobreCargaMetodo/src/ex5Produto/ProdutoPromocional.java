
package ex5Produto;

class ProdutoPromocional extends Produto {

    public ProdutoPromocional(double preco) {
        super(preco);
    }

    @Override
    public double calcularDesconto() {
        return preco * 0.10;
    }
}
