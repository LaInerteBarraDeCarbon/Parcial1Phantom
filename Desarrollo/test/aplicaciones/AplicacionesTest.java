package aplicaciones;

import java.io.File;

import org.junit.Test;

import aplicaciones.Aplicaciones;

public class AplicacionesTest {

	private String pathIn = "Preparacion de Prueba/Lote de Prueba/Entrada/";
	private String pathOut = "Ejecucion de Prueba/Salida Obtenida/";

	@Test
	public void testEnunciado() {
		Aplicaciones app = new Aplicaciones(new File(pathIn + "00_enunciado.in"),
				new File(pathOut + "00_enunciado.out"));
		app.resolver();
		app.grabaArchivo();
	}

	@Test
	public void testMaximosValores() {
		Aplicaciones app = new Aplicaciones(new File(pathIn + "01_maximos_valores.in"),
				new File(pathOut + "01_maximos_valores.out"));
		app.resolver();
		app.grabaArchivo();
	}

	@Test
	public void testMilPequeñas() {
		Aplicaciones app = new Aplicaciones(new File(pathIn + "02_mil_pequeñas.in"),
				new File(pathOut + "02_mil_pequeñas.out"));
		app.resolver();
		app.grabaArchivo();
	}

	@Test
	public void testMilYUnaAplicaciones() {
		Aplicaciones app = new Aplicaciones(new File(pathIn + "03_las_mil_y_una_aplicaciones.in"),
				new File(pathOut + "03_las_mil_y_una_aplicaciones.out"));
		app.resolver();
		app.grabaArchivo();
	}

	@Test
	public void testFatiga() {
		Aplicaciones app = new Aplicaciones(new File(pathIn + "04_fatiga.in"), new File(pathOut + "04_fatiga.out"));
		app.resolver();
		app.grabaArchivo();
	}
}
