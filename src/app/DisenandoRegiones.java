package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import utils.AristaDTO;
import utils.Argentina;

public class DisenandoRegiones {

	private Grafo _grafo;
	private Grafo _agm;

	private DisenandoRegiones() {
	}

	public static DisenandoRegiones argentina() {
		int cant_provincias = 24;
		DisenandoRegiones dr = new DisenandoRegiones();
		dr.crearArgentina(cant_provincias);
		return dr;
	}

	public static DisenandoRegiones crear(int vertices) {
		DisenandoRegiones dr = new DisenandoRegiones();
		dr.personalizado(vertices);
		return dr;
	}

	private void personalizado(int vertices) {
		_grafo = new Grafo(vertices);
		_agm = null;
	}

	public void eliminarVertice(int vertice) {
		_grafo.eliminarVertice(vertice);
	}

	public void agregarPeso(int origen, int destino, int peso) {
		_grafo.actualizarPeso(origen, destino, peso);
	}

	public List<Integer> obtenerVecinos(int origen) {
		if (_agm != null) {
			return _agm.obtenerVecinos(origen);
		}
		return _grafo.obtenerVecinos(origen);
	}

	public List<AristaDTO> obtenerAristasDe(int origen) {
		Set<Arista> aristas;

		if (_agm != null) {
			aristas = _agm.obtenerAristasDe(origen);
		} else {
			aristas = _grafo.obtenerAristasDe(origen);
		}

		List<AristaDTO> aristasDTO = new ArrayList<>();
		for (Arista arista : aristas) {
			aristasDTO.add(new AristaDTO(arista.getOrigen(), arista.getDestino(), arista.getPeso()));
		}
		return aristasDTO;
	}

	public void generarRegiones(int cantRegiones) {
		_agm = Kruskal.generar(_grafo);

		verificarCantRegiones(cantRegiones, _agm);
		_agm.validarQueNoEsteVacio();

		for (int i = 0; i < cantRegiones - 1; i++) {
			Arista aristaMayor = _agm.obtenerAristas().get(0);

			for (Arista arista : _agm.obtenerAristas()) {
				if (arista.getPeso() > aristaMayor.getPeso()) {
					aristaMayor = arista;
				}
			}

			_agm.eliminarArista(aristaMayor.getOrigen(), aristaMayor.getDestino());
		}
	}

	public int cantVertices() {
		return _grafo.tamanio();
	}

	public int cantVerticesDisponibles() {
		return _grafo.verticesDisponibles();
	}

	public int agregarVertice() {
		return _grafo.agregarVertice();
	}

	public void reiniciar() {
		_agm = null;
	}

	private void crearArgentina(int cant_provincias) {
		_grafo = new Grafo(cant_provincias);
		// para visualizar el grafico de aristas, ver /utils/aristas argentina.jpg
		_grafo.agregarArista(Argentina.JUJUY.getValue(), Argentina.SALTA.getValue(), 100);
		_grafo.agregarArista(Argentina.SALTA.getValue(), Argentina.CATAMARCA.getValue(), 200);
		_grafo.agregarArista(Argentina.SALTA.getValue(), Argentina.TUCUMAN.getValue(), 150);
		_grafo.agregarArista(Argentina.SALTA.getValue(), Argentina.SANTIAGO_DEL_ESTERO.getValue(), 400);
		_grafo.agregarArista(Argentina.SALTA.getValue(), Argentina.FORMOSA.getValue(), 700);
		_grafo.agregarArista(Argentina.SALTA.getValue(), Argentina.CHACO.getValue(), 650);
		_grafo.agregarArista(Argentina.CATAMARCA.getValue(), Argentina.TUCUMAN.getValue(), 150);
		_grafo.agregarArista(Argentina.CATAMARCA.getValue(), Argentina.SANTIAGO_DEL_ESTERO.getValue(), 300);
		_grafo.agregarArista(Argentina.CATAMARCA.getValue(), Argentina.LA_RIOJA.getValue(), 100);
		_grafo.agregarArista(Argentina.TUCUMAN.getValue(), Argentina.SANTIAGO_DEL_ESTERO.getValue(), 250);
		_grafo.agregarArista(Argentina.SANTIAGO_DEL_ESTERO.getValue(), Argentina.CHACO.getValue(), 550);
		_grafo.agregarArista(Argentina.SANTIAGO_DEL_ESTERO.getValue(), Argentina.SANTA_FE.getValue(), 450);
		_grafo.agregarArista(Argentina.SANTIAGO_DEL_ESTERO.getValue(), Argentina.CORDOBA.getValue(), 200);
		_grafo.agregarArista(Argentina.CORDOBA.getValue(), Argentina.LA_RIOJA.getValue(), 600);
		_grafo.agregarArista(Argentina.CORDOBA.getValue(), Argentina.SAN_LUIS.getValue(), 250);
		_grafo.agregarArista(Argentina.CORDOBA.getValue(), Argentina.SANTA_FE.getValue(), 300);
		_grafo.agregarArista(Argentina.CORDOBA.getValue(), Argentina.BUENOS_AIRES.getValue(), 450);
		_grafo.agregarArista(Argentina.SANTA_FE.getValue(), Argentina.CHACO.getValue(), 600);
		_grafo.agregarArista(Argentina.SANTA_FE.getValue(), Argentina.CORRIENTES.getValue(), 550);
		_grafo.agregarArista(Argentina.SANTA_FE.getValue(), Argentina.ENTRE_RIOS.getValue(), 150);
		_grafo.agregarArista(Argentina.SANTA_FE.getValue(), Argentina.BUENOS_AIRES.getValue(), 350);
		_grafo.agregarArista(Argentina.BUENOS_AIRES.getValue(), Argentina.ENTRE_RIOS.getValue(), 250);
		_grafo.agregarArista(Argentina.BUENOS_AIRES.getValue(), Argentina.CABA.getValue(), 50);
		_grafo.agregarArista(Argentina.BUENOS_AIRES.getValue(), Argentina.LA_PAMPA.getValue(), 400);
		_grafo.agregarArista(Argentina.BUENOS_AIRES.getValue(), Argentina.RIO_NEGRO.getValue(), 850);
		_grafo.agregarArista(Argentina.LA_PAMPA.getValue(), Argentina.SAN_LUIS.getValue(), 500);
		_grafo.agregarArista(Argentina.LA_PAMPA.getValue(), Argentina.MENDOZA.getValue(), 700);
		_grafo.agregarArista(Argentina.LA_PAMPA.getValue(), Argentina.NEUQUEN.getValue(), 750);
		_grafo.agregarArista(Argentina.LA_PAMPA.getValue(), Argentina.RIO_NEGRO.getValue(), 800);
		_grafo.agregarArista(Argentina.SAN_LUIS.getValue(), Argentina.LA_RIOJA.getValue(), 400);
		_grafo.agregarArista(Argentina.SAN_LUIS.getValue(), Argentina.SAN_JUAN.getValue(), 150);
		_grafo.agregarArista(Argentina.SAN_LUIS.getValue(), Argentina.MENDOZA.getValue(), 100);
		_grafo.agregarArista(Argentina.LA_RIOJA.getValue(), Argentina.SAN_JUAN.getValue(), 500);
		_grafo.agregarArista(Argentina.SAN_JUAN.getValue(), Argentina.MENDOZA.getValue(), 150);
		_grafo.agregarArista(Argentina.MENDOZA.getValue(), Argentina.NEUQUEN.getValue(), 850);
		_grafo.agregarArista(Argentina.NEUQUEN.getValue(), Argentina.RIO_NEGRO.getValue(), 450);
		_grafo.agregarArista(Argentina.RIO_NEGRO.getValue(), Argentina.CHUBUT.getValue(), 550);
		_grafo.agregarArista(Argentina.CHUBUT.getValue(), Argentina.SANTA_CRUZ.getValue(), 650);
		_grafo.agregarArista(Argentina.SANTA_CRUZ.getValue(), Argentina.TIERRA_DEL_FUEGO.getValue(), 750);
		_grafo.agregarArista(Argentina.FORMOSA.getValue(), Argentina.CHACO.getValue(), 150);
		_grafo.agregarArista(Argentina.CHACO.getValue(), Argentina.CORRIENTES.getValue(), 100);
		_grafo.agregarArista(Argentina.CORRIENTES.getValue(), Argentina.MISIONES.getValue(), 200);
		_grafo.agregarArista(Argentina.CORRIENTES.getValue(), Argentina.ENTRE_RIOS.getValue(), 650);

	}

	private void verificarCantRegiones(int cantRegiones, Grafo grafo) {
		if (cantRegiones <= 0) {
			throw new IllegalArgumentException("cantRegiones debe ser > 0");
		}

		if (cantRegiones > grafo.tamanio()) {
			throw new IllegalArgumentException("no se pueden crear mas regiones que vertices en el grafo");
		}
	}

}
