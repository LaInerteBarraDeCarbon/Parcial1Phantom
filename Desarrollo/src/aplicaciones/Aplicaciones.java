package aplicaciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicaciones extends EjercicioOIA {

	private int[] aplicaciones;
	private List<Aplicacion> pesoAplicaciones = new ArrayList<Aplicacion>();
	private int cantidadAplicaciones;
	private int pesoAplicacion;
	private boolean entra;

	public Aplicaciones(final File entrada, final File salida) {
		super(entrada, salida);
		try {
			leerArchivo(super.entrada);
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo.");
			e.printStackTrace();
		}
	}

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
				pesoAplicaciones.add(new Aplicacion(suma, i, cantidad));
			}
			i++;
		} while (i < this.cantidadAplicaciones && suma >= this.pesoAplicacion);
		if (!this.pesoAplicaciones.isEmpty() && this.pesoAplicaciones.get(0).getPeso() >= this.pesoAplicacion) {
			this.pesoAplicaciones.sort(new OrdenaPesos());
			this.entra = true;
		} else {
			this.entra = false;
		}
	}

	public void leerArchivo(final File entrada) throws IOException {
		try {
			Scanner sc = new Scanner(entrada);
			this.cantidadAplicaciones = sc.nextInt();
			if (this.cantidadAplicaciones <= 0 || this.cantidadAplicaciones >= 50001) {
				cantidadSuperada("Cantidad de aplicaciones");
			}
			this.pesoAplicacion = sc.nextInt();
			if (this.pesoAplicacion >= 1001 || this.pesoAplicacion <= 0) {
				cantidadSuperada("Peso de aplicaci�n entrada");
			}
			this.aplicaciones = new int[this.cantidadAplicaciones];
			for (int i = 0; i < this.cantidadAplicaciones; i++) {
				this.aplicaciones[i] = sc.nextInt();
				if (this.aplicaciones[i] >= 1001 || this.aplicaciones[i] <= 0) {
					cantidadSuperada("Peso de aplicaci�n celular " + (i + 1));
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void cantidadSuperada(final String mensaje) {
		throw new ArithmeticException("Valor fuera de rango: " + mensaje + ".");
	}

	public void grabaArchivo() {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(super.salida));
			if (this.entra) {
				salida.println(this.pesoAplicaciones.get(0).getCantidad());
				salida.println(this.pesoAplicaciones.get(0).getPosicion());
			} else {
				salida.println("MEMORIA INSUFICIENTE");
			}
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
