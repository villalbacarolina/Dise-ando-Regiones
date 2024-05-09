package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import utils.Vertice;

public class DisenandoRegiones {

	private Grafo _grafoArgentina;

	public DisenandoRegiones() {
		crearArgentina();
	}

	public void agregarPeso(Vertice origen, Vertice destino, int peso) {
		_grafoArgentina.actualizarPeso(origen.getValue(), destino.getValue(), peso);
	}
	
	public void obtenerVecinos(Vertice origen) {
		Set<Arista> conjunto_aristas = _grafoArgentina.obtenerAristasDe(origen.getValue());
		List<Arista> lista_aristas = new ArrayList<>(conjunto_aristas);
		
		
		//por ahora lo usamos para pintar los vecinos..
		//hay que retornar los valores de las aristas como un DTO o una tupla
		for(Arista arista: lista_aristas) {
			System.out.println(Vertice.getProvinciaPorNumero(arista.getOrigen()) + "-" + Vertice.getProvinciaPorNumero(arista.getDestino()) + "-" + arista.getPeso());
		}
	}

	public void crearArgentina() {
		_grafoArgentina = new Grafo(24);
		// para visualizar el grafico de aristas, ver /utils/aristas argentina.jpg
		_grafoArgentina.agregarArista(Vertice.JUJUY.getValue(), Vertice.SALTA.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.SALTA.getValue(), Vertice.CATAMARCA.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.SALTA.getValue(), Vertice.TUCUMAN.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.SALTA.getValue(), Vertice.SANTIAGO_DEL_ESTERO.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.SALTA.getValue(), Vertice.FORMOSA.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.SALTA.getValue(), Vertice.CHACO.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.CATAMARCA.getValue(), Vertice.TUCUMAN.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.CATAMARCA.getValue(), Vertice.SANTIAGO_DEL_ESTERO.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.CATAMARCA.getValue(), Vertice.LA_RIOJA.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.TUCUMAN.getValue(), Vertice.SANTIAGO_DEL_ESTERO.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.SANTIAGO_DEL_ESTERO.getValue(), Vertice.CHACO.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.SANTIAGO_DEL_ESTERO.getValue(), Vertice.SANTA_FE.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.SANTIAGO_DEL_ESTERO.getValue(), Vertice.CORDOBA.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.CORDOBA.getValue(), Vertice.LA_RIOJA.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.CORDOBA.getValue(), Vertice.SAN_LUIS.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.CORDOBA.getValue(), Vertice.SANTA_FE.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.CORDOBA.getValue(), Vertice.BUENOS_AIRES.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.SANTA_FE.getValue(), Vertice.CHACO.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.SANTA_FE.getValue(), Vertice.CORRIENTES.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.SANTA_FE.getValue(), Vertice.ENTRE_RIOS.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.SANTA_FE.getValue(), Vertice.BUENOS_AIRES.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.BUENOS_AIRES.getValue(), Vertice.ENTRE_RIOS.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.BUENOS_AIRES.getValue(), Vertice.CABA.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.BUENOS_AIRES.getValue(), Vertice.LA_PAMPA.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.BUENOS_AIRES.getValue(), Vertice.RIO_NEGRO.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.LA_PAMPA.getValue(), Vertice.SAN_LUIS.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.LA_PAMPA.getValue(), Vertice.MENDOZA.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.LA_PAMPA.getValue(), Vertice.NEUQUEN.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.LA_PAMPA.getValue(), Vertice.RIO_NEGRO.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.SAN_LUIS.getValue(), Vertice.LA_RIOJA.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.SAN_LUIS.getValue(), Vertice.SAN_JUAN.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.SAN_LUIS.getValue(), Vertice.MENDOZA.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.LA_RIOJA.getValue(), Vertice.SAN_JUAN.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.SAN_JUAN.getValue(), Vertice.MENDOZA.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.MENDOZA.getValue(), Vertice.NEUQUEN.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.NEUQUEN.getValue(), Vertice.RIO_NEGRO.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.RIO_NEGRO.getValue(), Vertice.CHUBUT.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.CHUBUT.getValue(), Vertice.SANTA_CRUZ.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.SANTA_CRUZ.getValue(), Vertice.TIERRA_DEL_FUEGO.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.FORMOSA.getValue(), Vertice.CHACO.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.CHACO.getValue(), Vertice.CORRIENTES.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.CORRIENTES.getValue(), Vertice.MISIONES.getValue(), 0);
		_grafoArgentina.agregarArista(Vertice.CORRIENTES.getValue(), Vertice.ENTRE_RIOS.getValue(), 0);


	}

}
