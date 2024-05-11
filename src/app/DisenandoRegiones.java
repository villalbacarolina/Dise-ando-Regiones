package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import utils.AristaDTO;
import utils.Vertice;

public class DisenandoRegiones {

	private Grafo _grafo;
	private Grafo _agm;

	private DisenandoRegiones() {}
	
	public static DisenandoRegiones argentina() {
		int cant_provincias = 24;
		DisenandoRegiones dr = new DisenandoRegiones();
		dr.crearArgentina(cant_provincias);
		return dr;
	}

	public void agregarPeso(int origen, int destino, int peso) {
		_grafo.actualizarPeso(origen, destino, peso);
	}

	public List<Integer> obtenerVecinos(int origen) {
		return _grafo.obtenerVecinos(origen);
	}

	public List<AristaDTO> obtenerAristasDe(int origen) {
		Set<Arista> aristas = _grafo.obtenerAristasDe(origen);
		List<AristaDTO> aristasDTO = new ArrayList<>();
		for(Arista arista : aristas) {
			aristasDTO.add(new AristaDTO(arista.getOrigen(), arista.getDestino(), arista.getPeso()));
		}
		return aristasDTO;
	}
	
	public void generarRegiones(int cantRegiones) {
		_agm = Kruskal.generar(_grafo);

		verificarGrafoNull(_agm);
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

	public List<Integer> obtenerVecinoDeAGM(int vertice) {
		return _agm.obtenerVecinos(vertice);
	}

	public int cantVertices() {
		return _grafo.tamanio();
	}

	private void crearArgentina(int cant_provincias) {
		_grafo = new Grafo(cant_provincias);
		// para visualizar el grafico de aristas, ver /utils/aristas argentina.jpg
		_grafo.agregarArista(Vertice.JUJUY.getValue(), Vertice.SALTA.getValue(), 0);
		_grafo.agregarArista(Vertice.SALTA.getValue(), Vertice.CATAMARCA.getValue(), 0);
		_grafo.agregarArista(Vertice.SALTA.getValue(), Vertice.TUCUMAN.getValue(), 0);
		_grafo.agregarArista(Vertice.SALTA.getValue(), Vertice.SANTIAGO_DEL_ESTERO.getValue(), 0);
		_grafo.agregarArista(Vertice.SALTA.getValue(), Vertice.FORMOSA.getValue(), 0);
		_grafo.agregarArista(Vertice.SALTA.getValue(), Vertice.CHACO.getValue(), 0);
		_grafo.agregarArista(Vertice.CATAMARCA.getValue(), Vertice.TUCUMAN.getValue(), 0);
		_grafo.agregarArista(Vertice.CATAMARCA.getValue(), Vertice.SANTIAGO_DEL_ESTERO.getValue(), 0);
		_grafo.agregarArista(Vertice.CATAMARCA.getValue(), Vertice.LA_RIOJA.getValue(), 0);
		_grafo.agregarArista(Vertice.TUCUMAN.getValue(), Vertice.SANTIAGO_DEL_ESTERO.getValue(), 0);
		_grafo.agregarArista(Vertice.SANTIAGO_DEL_ESTERO.getValue(), Vertice.CHACO.getValue(), 0);
		_grafo.agregarArista(Vertice.SANTIAGO_DEL_ESTERO.getValue(), Vertice.SANTA_FE.getValue(), 0);
		_grafo.agregarArista(Vertice.SANTIAGO_DEL_ESTERO.getValue(), Vertice.CORDOBA.getValue(), 0);
		_grafo.agregarArista(Vertice.CORDOBA.getValue(), Vertice.LA_RIOJA.getValue(), 0);
		_grafo.agregarArista(Vertice.CORDOBA.getValue(), Vertice.SAN_LUIS.getValue(), 0);
		_grafo.agregarArista(Vertice.CORDOBA.getValue(), Vertice.SANTA_FE.getValue(), 0);
		_grafo.agregarArista(Vertice.CORDOBA.getValue(), Vertice.BUENOS_AIRES.getValue(), 0);
		_grafo.agregarArista(Vertice.SANTA_FE.getValue(), Vertice.CHACO.getValue(), 0);
		_grafo.agregarArista(Vertice.SANTA_FE.getValue(), Vertice.CORRIENTES.getValue(), 0);
		_grafo.agregarArista(Vertice.SANTA_FE.getValue(), Vertice.ENTRE_RIOS.getValue(), 0);
		_grafo.agregarArista(Vertice.SANTA_FE.getValue(), Vertice.BUENOS_AIRES.getValue(), 0);
		_grafo.agregarArista(Vertice.BUENOS_AIRES.getValue(), Vertice.ENTRE_RIOS.getValue(), 0);
		_grafo.agregarArista(Vertice.BUENOS_AIRES.getValue(), Vertice.CABA.getValue(), 0);
		_grafo.agregarArista(Vertice.BUENOS_AIRES.getValue(), Vertice.LA_PAMPA.getValue(), 0);
		_grafo.agregarArista(Vertice.BUENOS_AIRES.getValue(), Vertice.RIO_NEGRO.getValue(), 0);
		_grafo.agregarArista(Vertice.LA_PAMPA.getValue(), Vertice.SAN_LUIS.getValue(), 0);
		_grafo.agregarArista(Vertice.LA_PAMPA.getValue(), Vertice.MENDOZA.getValue(), 0);
		_grafo.agregarArista(Vertice.LA_PAMPA.getValue(), Vertice.NEUQUEN.getValue(), 0);
		_grafo.agregarArista(Vertice.LA_PAMPA.getValue(), Vertice.RIO_NEGRO.getValue(), 0);
		_grafo.agregarArista(Vertice.SAN_LUIS.getValue(), Vertice.LA_RIOJA.getValue(), 0);
		_grafo.agregarArista(Vertice.SAN_LUIS.getValue(), Vertice.SAN_JUAN.getValue(), 0);
		_grafo.agregarArista(Vertice.SAN_LUIS.getValue(), Vertice.MENDOZA.getValue(), 0);
		_grafo.agregarArista(Vertice.LA_RIOJA.getValue(), Vertice.SAN_JUAN.getValue(), 0);
		_grafo.agregarArista(Vertice.SAN_JUAN.getValue(), Vertice.MENDOZA.getValue(), 0);
		_grafo.agregarArista(Vertice.MENDOZA.getValue(), Vertice.NEUQUEN.getValue(), 0);
		_grafo.agregarArista(Vertice.NEUQUEN.getValue(), Vertice.RIO_NEGRO.getValue(), 0);
		_grafo.agregarArista(Vertice.RIO_NEGRO.getValue(), Vertice.CHUBUT.getValue(), 0);
		_grafo.agregarArista(Vertice.CHUBUT.getValue(), Vertice.SANTA_CRUZ.getValue(), 0);
		_grafo.agregarArista(Vertice.SANTA_CRUZ.getValue(), Vertice.TIERRA_DEL_FUEGO.getValue(), 0);
		_grafo.agregarArista(Vertice.FORMOSA.getValue(), Vertice.CHACO.getValue(), 0);
		_grafo.agregarArista(Vertice.CHACO.getValue(), Vertice.CORRIENTES.getValue(), 0);
		_grafo.agregarArista(Vertice.CORRIENTES.getValue(), Vertice.MISIONES.getValue(), 0);
		_grafo.agregarArista(Vertice.CORRIENTES.getValue(), Vertice.ENTRE_RIOS.getValue(), 0);
	}

	private void verificarGrafoNull(Grafo grafo) {
		if (grafo == null) {
			throw new IllegalArgumentException("El grafo no puede ser null");
		}
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
