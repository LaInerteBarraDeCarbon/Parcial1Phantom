package aplicaciones;

public class Aplicacion {

	private int peso;
	private int posicion;
	private int cantidad;

	public Aplicacion(final int peso, final int posicion, final int cantidad) {
		this.peso = peso;
		this.posicion = posicion + 1;
		this.cantidad = cantidad;
	}

	public int getPeso() {
		return peso;
	}

	public int getPosicion() {
		return posicion;
	}

	public int getCantidad() {
		return cantidad;
	}

}
