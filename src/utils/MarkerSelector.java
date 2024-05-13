package utils;

import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

import presentation.Location;

@FunctionalInterface
public interface MarkerSelector {
	MapMarkerDot createMarker(Location location);
}
