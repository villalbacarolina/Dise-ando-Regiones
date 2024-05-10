package presentation;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

public enum Location {
	BUENOS_AIRES("Buenos Aires", -36.675, -60.558),
	CABA("CABA", -34.613, -58.377),
	CATAMARCA("Catamarca", -27.587, -66.796),
	CHACO("Chaco", -26.386, -60.765),
	CHUBUT("Chubut", -43.788, -68.526),
	CORDOBA("Córdoba", -32.142, -63.801),
	CORRIENTES("Corrientes", -28.774, -57.801),
	ENTRE_RIOS("Entre Ríos", -32.058, -59.201),
	FORMOSA("Formosa", -24.894, -59.932),
	JUJUY("Jujuy", -23.320, -65.363),
	LA_PAMPA("La Pampa", -36.676, -64.290),
	LA_RIOJA("La Rioja", -29.685, -66.852),
	MENDOZA("Mendoza", -34.629, -68.583),
	MISIONES("Misiones", -26.875, -54.651),
	NEUQUEN("Neuquén", -38.952, -70.065),
	RIO_NEGRO("Río Negro", -40.813, -66.783),
	SALTA("Salta", -25.166, -64.964),
	SAN_JUAN("San Juan", -30.865, -68.889),
	SAN_LUIS("San Luis", -33.757, -66.028),
	SANTA_CRUZ("Santa Cruz", -48.815, -69.955),
	SANTA_FE("Santa Fe", -30.706, -60.949),
	SANTIAGO_DEL_ESTERO("Santiago del Estero", -27.783, -63.252),
	TIERRA_DEL_FUEGO("Tierra del Fuego", -54.231, -67.050),
	TUCUMAN("Tucumán", -27.058, -65.409);

	
    private final String _name;
    private final double _latitude;
    private final double _longitude;

    // Constructor del enum
    Location(String name, double latitude, double longitude) {
        _name = name;
        _latitude = latitude;
        _longitude = longitude;
    }
    
    public String placeName() {
    	return _name;
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
