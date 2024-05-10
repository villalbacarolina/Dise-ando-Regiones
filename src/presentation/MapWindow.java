package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

public class MapWindow {
	private JFrame newFrame;
	private JMapViewer _mapa;
	private Map<String,MapMarkerDot> _vertices;

	public MapWindow() {
		_vertices = new HashMap<>();
		newFrame = new JFrame("Nueva Ventana");
		newFrame.setTitle("Map View");
		newFrame.setResizable(false);
		newFrame.setAutoRequestFocus(false);
		newFrame.setSize(400, 650);
		newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newFrame.getContentPane().add(new JLabel("¡Hola, soy una nueva ventana!"));
		newFrame.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.black, 5)); // Borde negro de 5px
		panel.add(new JLabel("¡Hola, soy una ventana con borde!"));
		newFrame.add(panel, BorderLayout.CENTER);

		JButton button = new JButton("Cerrar Ventana");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newFrame.dispose();

			}
		});
		newFrame.add(button, BorderLayout.SOUTH);

		positionWindowHalfScreen(newFrame);
		initializeMap();
		newFrame.setVisible(true);
		


	}

	public boolean isVisible() {
		return newFrame.isVisible();
	}

	public void setMarkersDot(List<MapMarkerDot> vertices) {
		for (MapMarkerDot vertex : vertices) {
            String name = vertex.getName();
            if (!_vertices.containsKey(name)) {
                _vertices.put(name, vertex);
            }
        }
		
	
		System.out.println(vertices);
		updateMapMarkers();
	}
	
	private void initializeMap() {
		_mapa = new JMapViewer();
		_mapa.setZoomControlsVisible(false);
		Coordinate coordinate = new Coordinate(-40, -66);
		_mapa.setDisplayPosition(coordinate, 4);
		newFrame.getContentPane().add(_mapa);
	}
	
	  // Método para actualizar los marcadores en el mapa
    private void updateMapMarkers() {
        _mapa.removeAllMapMarkers(); // Eliminar todos los marcadores existentes
        for (MapMarkerDot marker : _vertices.values()) {
        	marker.getStyle().setBackColor(Color.red);
        	marker.getStyle().setColor(Color.red);
            _mapa.addMapMarker(marker); // Añadir de nuevo todos los marcadores desde el mapa
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
		frame.setLocation(x, y);
	}
}
