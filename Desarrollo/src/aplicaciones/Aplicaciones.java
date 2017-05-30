package aplicaciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Crea una clase Aplicaciones que se encarga de encontrar la menor cantidad de
 * aplicaciones a eliminar, con el mayor peso posible, entre las primeras
 * posiciones. <br>
 * Si borrando todas las aplicaciones del celular no alcanza la memoria, se
 * avisa. <br>
 */
public class Aplicaciones extends EjercicioOIA {

	/**
	 * Lista con los pesos de la aplicación. <br>
	 */
	private int[] aplicaciones;
	/**
	 * La cantidad de aplicaciones en el dispositivo. <br>
	 */
	private int cantidadAplicaciones;
	/**
	 * Peso de la aplicación a instalar. <br>
	 */
	private int pesoAplicacion;
	/**
	 * Condición para saber si la memoria total es suficiente. <br>
	 */
	private boolean entra;
	/**
	 * Posición inicial de las aplicaciones a eliminar. <br>
	 */
	private int posicion;
	/**
	 * Cantidad de aplicaciones a eliminar. <br>
	 */
	private int cantidad;
	/**
	 * Tamaño de memoria que ocupan las aplicaciones. <br>
	 */
	private int tamaño;

	/**
	 * Crea una lista con el peso de las aplicaciones y su ubicación en el
	 * dispositivo. <br>
	 * 
	 * @param entrada
	 *            Archivo de entrada. <br>
	 * @param salida
	 *            Archivo de salida. <br>
	 */
	public Aplicaciones(final File entrada, final File salida) {
		super(entrada, salida);
		try {
			leerArchivo(super.entrada);
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo.");
			e.printStackTrace();
		}
	}

	/**
	 * Resuelve el ejercicio dado en el enunciado. <br>
	 */
	@Override
	public void resolver() {
		int i = 0;
		int suma;
		do {
			int j = i;
			int cantidad = 0;
			suma = 0;
			while (j < this.cantidadAplicaciones && suma < this.pesoAplicacion) {
				suma += this.aplicaciones[j];
				j++;
				cantidad++;
			}
			if (suma >= this.pesoAplicacion) {
				if (cantidad < this.cantidad) {
					asignarPosicion(cantidad, i, suma);
				} else {
					if (this.cantidad == cantidad && this.tamaño < suma) {
						asignarPosicion(cantidad, i, suma);
					} else {
						if (this.cantidad == cantidad && this.tamaño == suma && this.posicion > j) {
							asignarPosicion(cantidad, i, suma);
						}
					}
				}
			}
			i++;
		} while (i < this.cantidadAplicaciones && suma >= this.pesoAplicacion);
		if (this.tamaño > 0) {
			this.entra = true;
		} else {
			this.entra = false;
		}
	}

	/**
	 * Asigna los valores correspondiente a la consigna. <br>
	 * 
	 * @param cantidad
	 *            Cantidad de aplicaciones. <br>
	 * @param posicion
	 *            Posición de la primera aplicación. <br>
	 * @param peso
	 *            Peso total de las aplicaciones. <br>
	 */
	private void asignarPosicion(final int cantidad, final int posicion, final int peso) {
		this.cantidad = cantidad;
		this.posicion = posicion;
		this.tamaño = peso;
	}

	/**
	 * Lee el archivo de entrada. <br>
	 * Si el archivo no se puede abrir, sale.<br>
	 * Si los parametros están fuera de rango, sale. <br>
	 * 
	 * @param entrada
	 *            Archivo de entrada. <br>
	 * @throws IOException
	 *             Excepción de apertura de archivo. <br>
	 */
	private void leerArchivo(final File entrada) throws IOException {
		try {
			Scanner sc = new Scanner(entrada);
			this.cantidadAplicaciones = sc.nextInt();
			if (this.cantidadAplicaciones <= 0 || this.cantidadAplicaciones >= 50001) {
				cantidadSuperada("Cantidad de aplicaciones");
			}
			this.pesoAplicacion = sc.nextInt();
			if (this.pesoAplicacion >= 1001 || this.pesoAplicacion <= 0) {
				cantidadSuperada("Peso de aplicación entrada");
			}
			this.aplicaciones = new int[this.cantidadAplicaciones];
			for (int i = 0; i < this.cantidadAplicaciones; i++) {
				this.aplicaciones[i] = sc.nextInt();
				if (this.aplicaciones[i] >= 1001 || this.aplicaciones[i] <= 0) {
					cantidadSuperada("Peso de aplicación celular " + (i + 1));
				}
			}
			this.cantidad = this.cantidadAplicaciones;
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Avisa al usuario que algún parametro no se respetó. <br>
	 * 
	 * @param mensaje
	 *            Mensaje de error. <br>
	 */
	public void cantidadSuperada(final String mensaje) {
		throw new ArithmeticException("Valor fuera de rango: " + mensaje + ".");
	}

	/**
	 * Graba el archivo con el resultado final. <br>
	 */
	public void grabaArchivo() {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(super.salida));
			if (this.entra) {
				salida.println(this.cantidad);
				salida.println(this.posicion + 1);
			} else {
				salida.println("MEMORIA INSUFICIENTE");
			}
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
