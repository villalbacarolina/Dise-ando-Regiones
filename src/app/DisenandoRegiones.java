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
		_grafo.agregarArista(Argentina.JUJUY.getId(), Argentina.SALTA.getId(), 100);
		_grafo.agregarArista(Argentina.SALTA.getId(), Argentina.CATAMARCA.getId(), 200);
		_grafo.agregarArista(Argentina.SALTA.getId(), Argentina.TUCUMAN.getId(), 150);
		_grafo.agregarArista(Argentina.SALTA.getId(), Argentina.SANTIAGO_DEL_ESTERO.getId(), 400);
		_grafo.agregarArista(Argentina.SALTA.getId(), Argentina.FORMOSA.getId(), 700);
		_grafo.agregarArista(Argentina.SALTA.getId(), Argentina.CHACO.getId(), 650);
		_grafo.agregarArista(Argentina.CATAMARCA.getId(), Argentina.TUCUMAN.getId(), 150);
		_grafo.agregarArista(Argentina.CATAMARCA.getId(), Argentina.SANTIAGO_DEL_ESTERO.getId(), 300);
		_grafo.agregarArista(Argentina.CATAMARCA.getId(), Argentina.LA_RIOJA.getId(), 100);
		_grafo.agregarArista(Argentina.TUCUMAN.getId(), Argentina.SANTIAGO_DEL_ESTERO.getId(), 250);
		_grafo.agregarArista(Argentina.SANTIAGO_DEL_ESTERO.getId(), Argentina.CHACO.getId(), 550);
		_grafo.agregarArista(Argentina.SANTIAGO_DEL_ESTERO.getId(), Argentina.SANTA_FE.getId(), 450);
		_grafo.agregarArista(Argentina.SANTIAGO_DEL_ESTERO.getId(), Argentina.CORDOBA.getId(), 200);
		_grafo.agregarArista(Argentina.CORDOBA.getId(), Argentina.LA_RIOJA.getId(), 600);
		_grafo.agregarArista(Argentina.CORDOBA.getId(), Argentina.SAN_LUIS.getId(), 250);
		_grafo.agregarArista(Argentina.CORDOBA.getId(), Argentina.SANTA_FE.getId(), 300);
		_grafo.agregarArista(Argentina.CORDOBA.getId(), Argentina.BUENOS_AIRES.getId(), 450);
		_grafo.agregarArista(Argentina.SANTA_FE.getId(), Argentina.CHACO.getId(), 600);
		_grafo.agregarArista(Argentina.SANTA_FE.getId(), Argentina.CORRIENTES.getId(), 550);
		_grafo.agregarArista(Argentina.SANTA_FE.getId(), Argentina.ENTRE_RIOS.getId(), 150);
		_grafo.agregarArista(Argentina.SANTA_FE.getId(), Argentina.BUENOS_AIRES.getId(), 350);
		_grafo.agregarArista(Argentina.BUENOS_AIRES.getId(), Argentina.ENTRE_RIOS.getId(), 250);
		_grafo.agregarArista(Argentina.BUENOS_AIRES.getId(), Argentina.CABA.getId(), 50);
		_grafo.agregarArista(Argentina.BUENOS_AIRES.getId(), Argentina.LA_PAMPA.getId(), 400);
		_grafo.agregarArista(Argentina.BUENOS_AIRES.getId(), Argentina.RIO_NEGRO.getId(), 850);
		_grafo.agregarArista(Argentina.LA_PAMPA.getId(), Argentina.SAN_LUIS.getId(), 500);
		_grafo.agregarArista(Argentina.LA_PAMPA.getId(), Argentina.MENDOZA.getId(), 700);
		_grafo.agregarArista(Argentina.LA_PAMPA.getId(), Argentina.NEUQUEN.getId(), 750);
		_grafo.agregarArista(Argentina.LA_PAMPA.getId(), Argentina.RIO_NEGRO.getId(), 800);
		_grafo.agregarArista(Argentina.SAN_LUIS.getId(), Argentina.LA_RIOJA.getId(), 400);
		_grafo.agregarArista(Argentina.SAN_LUIS.getId(), Argentina.SAN_JUAN.getId(), 150);
		_grafo.agregarArista(Argentina.SAN_LUIS.getId(), Argentina.MENDOZA.getId(), 100);
		_grafo.agregarArista(Argentina.LA_RIOJA.getId(), Argentina.SAN_JUAN.getId(), 500);
		_grafo.agregarArista(Argentina.SAN_JUAN.getId(), Argentina.MENDOZA.getId(), 150);
		_grafo.agregarArista(Argentina.MENDOZA.getId(), Argentina.NEUQUEN.getId(), 850);
		_grafo.agregarArista(Argentina.NEUQUEN.getId(), Argentina.RIO_NEGRO.getId(), 450);
		_grafo.agregarArista(Argentina.RIO_NEGRO.getId(), Argentina.CHUBUT.getId(), 550);
		_grafo.agregarArista(Argentina.CHUBUT.getId(), Argentina.SANTA_CRUZ.getId(), 650);
		_grafo.agregarArista(Argentina.SANTA_CRUZ.getId(), Argentina.TIERRA_DEL_FUEGO.getId(), 750);
		_grafo.agregarArista(Argentina.FORMOSA.getId(), Argentina.CHACO.getId(), 150);
		_grafo.agregarArista(Argentina.CHACO.getId(), Argentina.CORRIENTES.getId(), 100);
		_grafo.agregarArista(Argentina.CORRIENTES.getId(), Argentina.MISIONES.getId(), 200);
		_grafo.agregarArista(Argentina.CORRIENTES.getId(), Argentina.ENTRE_RIOS.getId(), 650);

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
