package utils;

import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

import presentation.Location;

@FunctionalInterface
public interface TipoMarca {
	MapMarkerDot crearMarca(Location lugar);
}
