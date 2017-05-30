package aplicaciones;

import java.io.File;

/**
 * Clase que se encarga de administrar las condiciones de correción de la OIA.
 * <br>
 */
public abstract class EjercicioOIA {
	/**
	 * Archivo de entrada del ejercicio. <br>
	 */
	protected File entrada;
	/**
	 * Archivo con el resultado final. <br>
	 */
	protected File salida;

	/**
	 * Construye los archivos de entrada y salida. <br>
	 * 
	 * @param e
	 *            Archivo de entrada. <br>
	 * @param s
	 *            Archivo de salida. <br>
	 */
	public EjercicioOIA(File e, File s) {
		this.entrada = e;
		this.salida = s;
	}

	/**
	 * Clase que se encarga de resolver el problema. <br>
	 */
	public abstract void resolver();
}
