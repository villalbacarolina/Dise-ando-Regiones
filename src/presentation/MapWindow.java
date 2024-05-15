package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;

import utils.MarcaDTO;
import utils.Observable;
import utils.Observer;
import utils.TipoMarca;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MapWindow implements Observable {
	private JFrame newFrame;
	private JMapViewer _mapa;
	private Map<Integer, Location> _vertices;
	private Map<Integer, MapMarker> _marcas;
	private Map<String, Set<Observer>> _observers;
	private TipoMarca _tipoMarca;
	private JButton _btnVerNombres;
	private JButton _btnVerIds;
	private JButton btnOcultar;

	public MapWindow() {
		_vertices = new HashMap<>();
		_marcas = new HashMap<>();
		_tipoMarca = Location::marca;
		ventanaPrincipal();
		posicionarVentana(newFrame);
		iniciarMapa();
		btnMostrarNombres();
		btnMostrarIds();
		btnOcultarReferencias();
		iniciarEventos();
		newFrame.setVisible(true);
	}

	private void btnOcultarReferencias() {
		btnOcultar = new JButton("Ocultar");
		btnOcultar.setBounds(283, 611, 105, 27);
		btnOcultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pintarMarcas(Location::marca);
			}
		});
		_mapa.add(btnOcultar);
	}

	private void btnMostrarIds() {
		_btnVerIds = new JButton("Ver IDs");
		_btnVerIds.setBounds(160, 611, 105, 27);
		_mapa.add(_btnVerIds);
		_btnVerIds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pintarMarcas(Location::marcaConID);
			}
		});
	}

	private void btnMostrarNombres() {
		_btnVerNombres = new JButton("Ver nombres");
		_btnVerNombres.setBounds(12, 611, 125, 27);
		_mapa.add(_btnVerNombres);
		_btnVerNombres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pintarMarcas(Location::marcaConNombre);
			}
		});
	}

	private void iniciarEventos() {
		_observers = new HashMap<>();
		_observers.put("DotClicked", new HashSet<>());
	}

	private void ventanaPrincipal() {
		newFrame = new JFrame("Nueva Ventana");
		newFrame.setTitle("Map View");
		newFrame.setResizable(false);
		newFrame.setAutoRequestFocus(false);
		newFrame.setSize(400, 650);
		newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newFrame.getContentPane().add(new JLabel("¡Hola, soy una nueva ventana!"));
		newFrame.getContentPane().setLayout(new BorderLayout());
	}

	private void pintarMarcas(TipoMarca tipoMarca) {
		_tipoMarca = tipoMarca;
		_mapa.removeAllMapMarkers();
		_marcas.clear();
		for (Location location : _vertices.values()) {
			MapMarkerDot marca = tipoMarca.crearMarca(location);
			_marcas.put(location.id(), location.marcaConNombre());
			marca.getStyle().setBackColor(Color.red);
			marca.getStyle().setColor(Color.red);
			_mapa.addMapMarker(marca);
		}
	}

	private void pintarConexiones() {

		_mapa.removeAllMapPolygons();

		for (int key : _vertices.keySet()) {
			Location vertice = _vertices.get(key);
			if (vertice != null) {
				Coordinate start = vertice.getCoordenada();
				for (int vecino : vertice.vecinos()) {
					Coordinate end = _vertices.get(vecino).getCoordenada();
					MapPolygon line = new MapPolygonImpl(Arrays.asList(start, end, start));
					_mapa.addMapPolygon(line);
				}
			}
		}
	}

	private void posicionarVentana(JFrame frame) {
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

	private void iniciarMapa() {
		_mapa = new JMapViewer();
		_mapa.setZoomControlsVisible(false);
		Coordinate coordinate = new Coordinate(-40, -66);
		_mapa.setDisplayPosition(coordinate, 4);
		newFrame.getContentPane().add(_mapa);
		_mapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				comprobarClickEnMarca(e, _marcas, _mapa);
			}
		});
	}

	private void cargarVertices(List<Location> vertices) {
		_vertices.clear();
		for (Location vertice : vertices) {
			int id = vertice.id();
			if (!_vertices.containsKey(id)) {
				_vertices.put(id, vertice);
			}
		}
	}

	public boolean esVisible() {
		return newFrame.isVisible();
	}

	public void cerrar() {
		newFrame.dispose();
	}

	public void setMarcas(List<Location> vertices) {
		cargarVertices(vertices);
		pintarConexiones();
		pintarMarcas(_tipoMarca);
	}

	private void comprobarClickEnMarca(MouseEvent e, Map<Integer, MapMarker> markers, JMapViewer viewer) {
		int x = e.getX();
		int y = e.getY();

		for (Map.Entry<Integer, MapMarker> marca : markers.entrySet()) {
			MapMarker marker = marca.getValue();
			Point p = viewer.getMapPosition(marker.getLat(), marker.getLon(), false);
			if (p != null) {
				// Calcular la distancia del clic al centro del marcador
				double dist = Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
				// Radio de la marca
				if (dist < 6.0) {
					Object markDTO = new MarcaDTO(marker.getName(), marca.getKey());
					notificar("DotClicked", markDTO);
					break;
				}
			}
		}
	}

	@Override
	public void agregarObserver(String event, Observer observer) {
		if (!_observers.containsKey(event)) {
			throw new RuntimeException("Evento no existe:" + event);
		}
		Set<Observer> observers = _observers.get(event);
		observers.add(observer);
	}

	@Override
	public void notificar(String evento, Object dto) {
		if (!_observers.containsKey(evento)) {
			throw new RuntimeException("Evento no existe:" + evento);
		}

		Set<Observer> observers = _observers.get(evento);
		for (Observer observer : observers) {
			observer.actualizar(dto);
		}
	}

}
