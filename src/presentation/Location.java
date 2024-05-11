package presentation;

import java.util.ArrayList;
import java.util.List;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

public enum Location {
	JUJUY(0,"Jujuy", -23.320, -65.363),
	SALTA(1,"Salta", -25.166, -64.964),
	CATAMARCA(2,"Catamarca", -27.587, -66.796),
	TUCUMAN(3,"Tucumán", -27.058, -65.409),
	SANTIAGO_DEL_ESTERO(4,"Santiago del Estero", -27.783, -63.252),
	CORDOBA(5,"Córdoba", -32.142, -63.801),
	SANTA_FE(6,"Santa Fe", -30.706, -60.949),
	BUENOS_AIRES(7,"Buenos Aires", -36.675, -60.558),
	CABA(8,"CABA", -34.613, -58.377),
	LA_PAMPA(9,"La Pampa", -36.676, -64.290),
	SAN_LUIS(10,"San Luis", -33.757, -66.028),
	LA_RIOJA(11,"La Rioja", -29.685, -66.852),
	SAN_JUAN(12,"San Juan", -30.865, -68.889),
	MENDOZA(13,"Mendoza", -34.629, -68.583),
	NEUQUEN(14,"Neuquén", -38.952, -70.065),
	RIO_NEGRO(15,"Río Negro", -40.813, -66.783),
	CHUBUT(16,"Chubut", -43.788, -68.526),
	SANTA_CRUZ(17,"Santa Cruz", -48.815, -69.955),
	TIERRA_DEL_FUEGO(18,"Tierra del Fuego", -54.231, -67.050),
	FORMOSA(19,"Formosa", -24.894, -59.932),
	CHACO(20,"Chaco", -26.386, -60.765),
	CORRIENTES(21,"Corrientes", -28.774, -57.801),
	MISIONES(22,"Misiones", -26.875, -54.651),
	ENTRE_RIOS(23,"Entre Ríos", -32.058, -59.201);

	private final int _id;
    private final String _name;
    private final double _latitude;
    private final double _longitude;
    private List<Integer> _vecinos;

    // Constructor del enum
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
    
    public List<Integer> vecinos(){
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
    	return new MapMarkerDot(_name,coordinate);
    }
    public MapMarkerDot mark() {
    	Coordinate coordinate = new Coordinate(_latitude, _longitude);
    	return new MapMarkerDot(coordinate);
    }
    
    
}
