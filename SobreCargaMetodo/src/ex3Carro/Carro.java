
package ex3Carro;

class Carro {
    String marca;
    String modelo;

    public Carro(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Carro: " + marca + " " + modelo;
    }}
