package app.disenandoRegiones;

import static org.junit.Assert.*;
import org.junit.Test;
import app.DisenandoRegiones;
import app.Grafo;

public class DisenandoRegionesTest {

	@Test(expected = IllegalArgumentException.class)
	public void generarRegionesCantNegativaTest() {
		DisenandoRegiones disReg = DisenandoRegiones.crear(0);
		disReg.generarRegiones(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void generarRegionesCantExcesivaTest() {
		DisenandoRegiones disReg = DisenandoRegiones.crear(3);
		disReg.generarRegiones(7);
	}

	@Test
	public void generarRegionesTest() {
		DisenandoRegiones app = setup();

		app.generarRegiones(1);

		assertEquals(app.obtenerAristasDe(0).size(), 1);
		assertEquals(app.obtenerAristasDe(1).size(), 2);
		assertEquals(app.obtenerAristasDe(2).size(), 2);
		assertEquals(app.obtenerAristasDe(3).size(), 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void generarRegionesGrafoSinAristasTest() {
		DisenandoRegiones disReg = DisenandoRegiones.crear(4);
		disReg.generarRegiones(2);
	}

	private DisenandoRegiones setup() {

		DisenandoRegiones app = DisenandoRegiones.crear(4);

		app.agregarPeso(0, 1, 10);
		app.agregarPeso(1, 2, 10);
		app.agregarPeso(2, 3, 10);
		app.agregarPeso(0, 2, 20);
		app.agregarPeso(0, 3, 50);

		return app;
	}

}
