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
    
    public byte getTotal() {
    	byte total=0;
    	for (byte c = 0; c < carroCompra.length; c++) {
			total+=carroCompra[c];
		}
    	return total;
    }
}