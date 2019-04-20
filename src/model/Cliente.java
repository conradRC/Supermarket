import java.util.ArrayList;
public class Cliente {
    private String nombre;
    private ArrayList <Byte> carroCompra;
    public Cliente(String nombre, ArrayList <Byte> carroCompra) {
        this.nombre = nombre;
        this.carroCompra = carroCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList <Byte> getCarroCompra() {
        return carroCompra;
    }
}