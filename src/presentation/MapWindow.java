package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;

import utils.Observer;

public class MapWindow {
	private JFrame newFrame;
	private JMapViewer _mapa;
	private Map<Integer, Location> _vertices;
	private Map<Integer ,MapMarker> _markers;
    private static JPanel floatingPanel; // Panel flotante para mostrar la información
    private JDialog infoDialog;
	private String clicked;
	private List<Observer> _observers;
	
	public MapWindow() {
		_vertices = new HashMap<>();
		_markers = new HashMap<>();
		_observers = new ArrayList<>();
		mainWindow();
		closeButton();
		positionWindowHalfScreen(newFrame);
		initializeMap();


		
		newFrame.setVisible(true);
		
		

	}

	private void mainWindow() {
		newFrame = new JFrame("Nueva Ventana");
		newFrame.setTitle("Map View");
		newFrame.setResizable(false);
		newFrame.setAutoRequestFocus(false);
		newFrame.setSize(400, 650);
		newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newFrame.getContentPane().add(new JLabel("¡Hola, soy una nueva ventana!"));
		newFrame.setLayout(new BorderLayout());
	}

	private void closeButton() {
		JButton button = new JButton("Cerrar Ventana");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newFrame.dispose();
			}
		});
		newFrame.add(button, BorderLayout.SOUTH);
	}

	// Método para actualizar los marcadores en el mapa
	private void printMarkers() {
		_mapa.removeAllMapMarkers(); // Eliminar todos los marcadores existentes
		for (Location location : _vertices.values()) {

			MapMarkerDot marker = location.mark();
			_markers.put(location.id(), location.markWithName());
			marker.getStyle().setBackColor(Color.red);
			marker.getStyle().setColor(Color.red);
			_mapa.addMapMarker(marker); // Añadir de nuevo todos los marcadores desde el mapa
		}
	}

	private void printConnections() {

		for (int key : _vertices.keySet()) {
			Location vertice = _vertices.get(key);
			Coordinate start = vertice.getCoordinate();

			for (int vecino : vertice.vecinos()) {
				Coordinate end = _vertices.get(vecino).getCoordinate();
				MapPolygon line = new MapPolygonImpl(Arrays.asList(start, end, start));
				_mapa.addMapPolygon(line);
			}
		}

	}

	private void positionWindowHalfScreen(JFrame frame) {
		// Obtener las dimensiones de la pantalla
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

		// Calcular las coordenadas para centrar la ventana
		int x = (screenWidth - frame.getWidth() - 50);
		int y = (screenHeight - frame.getHeight()) / 2;

		// Establecer la ubicación de la ventana
		frame.setLocation(x, 0);
	}

	private void initializeMap() {
		_mapa = new JMapViewer();
		_mapa.setZoomControlsVisible(false);
		Coordinate coordinate = new Coordinate(-40, -66);
		_mapa.setDisplayPosition(coordinate, 4);
		
		
	     _mapa.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                super.mouseClicked(e);
	                checkMarkerHit(e, _markers, _mapa);
	            }
	        });
		
		newFrame.getContentPane().add(_mapa);
	}

	private void loadVertices(List<Location> vertices) {
		_vertices.clear();
		for (Location vertice : vertices) {
			int id = vertice.id();
			if (!_vertices.containsKey(id)) {
				_vertices.put(id, vertice);
			}
		}
	}
	
	public boolean isVisible() {
		return newFrame.isVisible();
	}

	public void close() {
		newFrame.dispose();
	}

	public void setMarkersDot(List<Location> vertices) {
		loadVertices(vertices);
		printMarkers();
		printConnections();
	}


	private void checkMarkerHit(MouseEvent e, Map<Integer,MapMarker> markers, JMapViewer viewer) {
        int x = e.getX();
        int y = e.getY();
        
        for (Map.Entry<Integer, MapMarker> markerValue : markers.entrySet()) {
        	MapMarker marker = markerValue.getValue();
            Point p = viewer.getMapPosition(marker.getLat(), marker.getLon(), false);
            if (p != null) {
                // Calcular la distancia del clic al centro del marcador
                double dist = Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
                // Asumiendo que el radio del marcador es de 20 pixeles para la detección de clic
                if (dist < 6.0) {

                	for(Observer observer : _observers) {
                		observer.dotClicked(marker.getName(), markerValue.getKey());
                	}
                     break;
                }
               
               
            }
        }
    }
	
	
	public void registerObserver(Observer observer) {
		_observers.add(observer);
	}

}
