package presentation;

import java.util.ArrayList;
import java.util.List;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

public class Location {

	private final int _id;
	private final String _name;
	private final double _latitude;
	private final double _longitude;
	private List<Integer> _vecinos;

	Location(int id, String name, double latitude, double longitude) {
		_id = id;
		_name = name;
		_latitude = latitude;
		_longitude = longitude;
		_vecinos = new ArrayList<>();
	}

	public int id() {
		return _id;
	}

	public String placeName() {
		return _name;
	}

	public List<Integer> vecinos() {
		return _vecinos;
	}

	public Coordinate getCoordinate() {
		return new Coordinate(_latitude, _longitude);
	}

	public void setVecinos(List<Integer> vecinos) {
		_vecinos = vecinos;
	}

	public MapMarkerDot markWithName() {
		Coordinate coordinate = new Coordinate(_latitude, _longitude);
		return new MapMarkerDot(_name, coordinate);
	}

	public MapMarkerDot mark() {
		Coordinate coordinate = new Coordinate(_latitude, _longitude);
		return new MapMarkerDot(coordinate);
	}

	public MapMarkerDot markWithId() {
		Coordinate coordinate = new Coordinate(_latitude, _longitude);
		return new MapMarkerDot(String.valueOf(_id), coordinate);
	}

}
