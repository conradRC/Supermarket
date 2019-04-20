package model;

public class Cliente {
    private String nombre;
    private byte [] carroCompra;
    public Cliente(String nombre, byte [] carroCompra) {
        this.nombre = nombre;
        this.carroCompra = carroCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public byte [] getCarroCompra() {
        return carroCompra;
    }
}