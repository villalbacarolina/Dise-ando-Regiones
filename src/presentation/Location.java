package presentation;

import java.util.ArrayList;
import java.util.List;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

public class Location {

	private final int _id;
	private final String _nombre;
	private final double _latitud;
	private final double _longitud;
	private List<Integer> _vecinos;

	Location(int id, String nombre, double latitud, double longitud) {
		_id = id;
		_nombre = nombre;
		_latitud = latitud;
		_longitud = longitud;
		_vecinos = new ArrayList<>();
	}

	public int id() {
		return _id;
	}

	public String nombreDelLugar() {
		return _nombre;
	}

	public List<Integer> vecinos() {
		return _vecinos;
	}

	public Coordinate getCoordenada() {
		return new Coordinate(_latitud, _longitud);
	}

	public void setVecinos(List<Integer> vecinos) {
		_vecinos = vecinos;
	}

	public MapMarkerDot marcaConNombre() {
		Coordinate coordenada = new Coordinate(_latitud, _longitud);
		return new MapMarkerDot(_nombre, coordenada);
	}

	public MapMarkerDot marca() {
		Coordinate coordenada = new Coordinate(_latitud, _longitud);
		return new MapMarkerDot(coordenada);
	}

	public MapMarkerDot marcaConID() {
		Coordinate coordenada = new Coordinate(_latitud, _longitud);
		return new MapMarkerDot(String.valueOf(_id), coordenada);
	}

}
