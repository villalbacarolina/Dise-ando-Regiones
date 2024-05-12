package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import app.DisenandoRegiones;
import utils.AristaDTO;
import utils.MapWindowEvent;
import utils.MarkDTO;
import utils.MarkerSelector;
import utils.VecinoStrategy;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame _frame;
	private MapWindow _mapWindow = null; // Referencia a NewWindow
	private AgregarVerticeWindow _agregarVerticeWindow = null;
	private ConectarVerticesWindow _conectarVerticeWindow = null;
	private EliminarVerticeWindow _eliminarVerticeWindow = null;
	private DisenandoRegiones _app;
	private int _regiones; // cantidad de regiones
//	private JLabel _labelSelected;
	private JTextField _similaridadInput;
	private JPanel _panel_2;
	private JPanel _panel_3;
	private JLabel _provincia_seleccionada;
	private JButton btnActualizarSimilaridad;
	private int _provincia_seleccionada_id;
	private JComboBox<String> _provinciasLimitrofesBox;
//	private int _similaridad;
	private int[] _similaridadesLimitrofes;

//	private boolean _customMap;
	private Map<Integer, Location> _locationsByID;
	private Map<String, Location> _locationsByNames;
	private int _provincia_box_seleccionada;
	private JComboBox<Integer> _regionesBox;

	private JTextField origen;
	private JTextField destino;
	private JTextField peso;
	private JButton _btnArgentina;
	private JButton _btnPersonalizado;
	private JButton _btnAddVertice;
	private JButton _btnConectar;
	private JButton _btnEliminarVertice;
//	private JComboBox<String> _provinciasLimitrofes;
//	private Integer[] _regionesDisponibles;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window._frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		_regiones = 1;
//		_similaridad = 0;
		_locationsByID = new HashMap<>();
		_locationsByNames = new HashMap<>();
		createMainWindow();
		btnCrearArgentina();
		btnCrearPersonalizado();
		title();
		btnAgregarVertice();
		btnEliminarVertice();
		btnConectarVertices();
		loadPanels();
		_frame.setVisible(true);

	}

	private void loadPanels() {
//		panel1();
		panel2();
		panel3();

	}

	private void btnCrearPersonalizado() {
		_btnPersonalizado = new JButton("Personalizado");
		_btnPersonalizado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_app = DisenandoRegiones.crear(0);
				_btnArgentina.setVisible(false);
				_btnPersonalizado.setVisible(false);
				_btnAddVertice.setVisible(true);
				_btnConectar.setVisible(true);
				_btnEliminarVertice.setVisible(true);
//				_customMap = true;
				//loadPanels();
				loadMap();
			}
		});
		_btnPersonalizado.setBounds(566, 41, 137, 27);
		_frame.getContentPane().add(_btnPersonalizado);
	}

	private void btnCrearArgentina() {
		_btnArgentina = new JButton("Argentina");
		_btnArgentina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_app = DisenandoRegiones.argentina();
				_btnPersonalizado.setVisible(false);
				_btnArgentina.setVisible(false);
				_btnAddVertice.setVisible(true);
				_btnConectar.setVisible(true);
				_btnEliminarVertice.setVisible(true);
				loadArgentinaLocations();
//				loadPanels();
				loadMap();
			}

		});
		_btnArgentina.setBounds(128, 41, 105, 27);
		_frame.getContentPane().add(_btnArgentina);
	}

	private void setLocations(Location location) {
		_locationsByID.put(location.id(), location);
		_locationsByNames.put(location.placeName(), location);
	}

	private void loadArgentinaLocations() {
		setLocations(new Location(0, "Jujuy", -23.320, -65.363));
		setLocations(new Location(1, "Salta", -25.166, -64.964));
		setLocations(new Location(2, "Catamarca", -27.587, -66.796));
		setLocations(new Location(3, "Tucumán", -27.058, -65.409));
		setLocations(new Location(4, "Santiago del Estero", -27.783, -63.252));
		setLocations(new Location(5, "Córdoba", -32.142, -63.801));
		setLocations(new Location(6, "Santa Fe", -30.706, -60.949));
		setLocations(new Location(7, "Buenos Aires", -36.675, -60.558));
		setLocations(new Location(8, "CABA", -34.613, -58.377));
		setLocations(new Location(9, "La Pampa", -36.676, -64.290));
		setLocations(new Location(10, "San Luis", -33.757, -66.028));
		setLocations(new Location(11, "La Rioja", -29.685, -66.852));
		setLocations(new Location(12, "San Juan", -30.865, -68.889));
		setLocations(new Location(13, "Mendoza", -34.629, -68.583));
		setLocations(new Location(14, "Neuquén", -38.952, -70.065));
		setLocations(new Location(15, "Río Negro", -40.813, -66.783));
		setLocations(new Location(16, "Chubut", -43.788, -68.526));
		setLocations(new Location(17, "Santa Cruz", -48.815, -69.955));
		setLocations(new Location(18, "Tierra del Fuego", -54.231, -67.050));
		setLocations(new Location(19, "Formosa", -24.894, -59.932));
		setLocations(new Location(20, "Chaco", -26.386, -60.765));
		setLocations(new Location(21, "Corrientes", -28.774, -57.801));
		setLocations(new Location(22, "Misiones", -26.875, -54.651));
		setLocations(new Location(23, "Entre Ríos", -32.058, -59.201));
	}

	private void createMainWindow() {
		_frame = new JFrame();
		_frame.setResizable(false);
		_frame.setBounds(100, 40, 800, 600);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.getContentPane().setLayout(null);
	}

	private void title() {
		JLabel lblDiseandoRegiones = new JLabel("Diseñando Regiones");
		lblDiseandoRegiones.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDiseandoRegiones.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiseandoRegiones.setBounds(284, 36, 257, 30);
		_frame.getContentPane().add(lblDiseandoRegiones);
	}

	private void btnConectarVertices() {
		_btnConectar = new JButton("Conectar");
		_btnConectar.setBounds(37, 132, 150, 27);
		_btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_conectarVerticeWindow = new ConectarVerticesWindow(_app);
//				_conectarVerticeWindow.addObserver("Connect", x -> loadMap());
				_conectarVerticeWindow.addObserver("Connect", x -> updateLugaresEnMapa());
			}
		});
		_btnConectar.setVisible(false);
		_frame.getContentPane().add(_btnConectar);
	}

	private void btnEliminarVertice() {
		_btnEliminarVertice = new JButton("Eliminar Vertice");
		_btnEliminarVertice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_eliminarVerticeWindow = new EliminarVerticeWindow();
				_eliminarVerticeWindow.addObserver("Eliminar", id -> eliminarVertice(id));

			}
		});
		_btnEliminarVertice.setBounds(37, 171, 150, 27);
		_btnEliminarVertice.setVisible(false);
		_frame.getContentPane().add(_btnEliminarVertice);
	}

	private void btnAgregarVertice() {
		_btnAddVertice = new JButton("Agregar vertice");
		_btnAddVertice.setBounds(37, 93, 150, 27);
		_btnAddVertice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_agregarVerticeWindow = new AgregarVerticeWindow(_app);
				_agregarVerticeWindow.addObserver("Create", (location) -> updateVertices(location));
			}
		});
		_btnAddVertice.setVisible(false);
		_frame.getContentPane().add(_btnAddVertice);
	}

	private void eliminarVertice(Object vertice) {
		if (!(vertice instanceof Integer)) {
			return;
		}
		int v = (Integer) vertice;

		_app.eliminarVertice(v);

		Location loc = _locationsByID.get(vertice);

		_locationsByID.remove(loc.id());
		_locationsByNames.remove(loc.placeName());

		updateCantidadDeRegiones();
//		_loadMap();
		updateLugaresEnMapa();
	}

	public void updateVertices(Object location) {

		if (!(location instanceof Location)) {
			return;
		}
		Location loc = (Location) location;

		_locationsByID.put(loc.id(), loc);
		_locationsByNames.put(loc.placeName(), loc);
		updateCantidadDeRegiones();
		updateLugaresEnMapa();
	}

	private void panel2() {

		_panel_2 = new JPanel();
		_panel_2.setBounds(250, 100, 311, 204);
		_frame.getContentPane().add(_panel_2);
		_panel_2.setLayout(null);

		_provincia_seleccionada = new JLabel("");
		_provincia_seleccionada.setBounds(0, 0, 311, 20);
		_panel_2.add(_provincia_seleccionada);
		_provincia_seleccionada.setHorizontalAlignment(SwingConstants.CENTER);
		_provincia_seleccionada.setFont(new Font("Dialog", Font.BOLD, 18));

		JLabel lblProvinciasLimtrofes = new JLabel("Provincias limítrofes");
		lblProvinciasLimtrofes.setHorizontalAlignment(SwingConstants.CENTER);
		lblProvinciasLimtrofes.setBounds(0, 50, 311, 17);
		_panel_2.add(lblProvinciasLimtrofes);

		_similaridadInput = new JTextField();
		_similaridadInput.setHorizontalAlignment(SwingConstants.CENTER);
		_similaridadInput.setBounds(94, 129, 120, 21);
		_panel_2.add(_similaridadInput);
		_similaridadInput.setColumns(10);

		JLabel lblPeso = new JLabel("Similaridad");
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setBounds(0, 105, 311, 17);
		_panel_2.add(lblPeso);

		btnActualizarSimilaridad = new JButton("Actualizar");

		btnActualizarSimilaridad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Location origen = _locationsByID.get(_provincia_seleccionada_id);
				Location destino = _locationsByNames.get(_provinciasLimitrofesBox.getSelectedItem());
				int similaridad = Integer.parseInt(_similaridadInput.getText());
				_app.agregarPeso(origen.id(), destino.id(), similaridad);

				System.out.println("Tamaño: " + _similaridadesLimitrofes.length);
				System.out.println(_provincia_box_seleccionada);
				_similaridadesLimitrofes[_provincia_box_seleccionada] = similaridad;
			}
		});
		btnActualizarSimilaridad.setBounds(104, 165, 105, 27);

		_provinciasLimitrofesBox = new JComboBox<String>();
		_provinciasLimitrofesBox.setBounds(34, 67, 246, 26);

		_provinciasLimitrofesBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int provIndex = _provinciasLimitrofesBox.getSelectedIndex();
				updateSimilidadInput(_similaridadesLimitrofes[provIndex]);
				_provincia_box_seleccionada = _provinciasLimitrofesBox.getSelectedIndex();
			}

		});

		_panel_2.add(_provinciasLimitrofesBox);
		_panel_2.add(btnActualizarSimilaridad);

		_panel_2.setVisible(false);

	}

	private void panel3() {
		_panel_3 = new JPanel();
		_panel_3.setBounds(250, 360, 299, 156);
		_frame.getContentPane().add(_panel_3);
		_panel_3.setLayout(null);
		JLabel lblCantidadDeRegiones = new JLabel("Cantidad de regiones a visualizar");
		lblCantidadDeRegiones.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadDeRegiones.setBounds(0, 47, 299, 17);
		_panel_3.add(lblCantidadDeRegiones);

		JLabel labelSelected_1 = new JLabel("Generar regiones");
		labelSelected_1.setBounds(0, 0, 299, 35);
		_panel_3.add(labelSelected_1);
		labelSelected_1.setHorizontalAlignment(SwingConstants.CENTER);
		labelSelected_1.setFont(new Font("Dialog", Font.BOLD, 20));

		JButton btnNewButton = new JButton("Generar Regiones");
		btnNewButton.setBounds(70, 117, 150, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarRegiones();
			}

		});

		_panel_3.add(btnNewButton);

		_regionesBox = new JComboBox<Integer>();
		_regionesBox.setBounds(104, 70, 69, 30);
		_regionesBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_regiones = (int) _regionesBox.getSelectedItem();
			}
		});

		_panel_3.add(_regionesBox);
		
		_panel_3.setVisible(false);
//-----		loadCantidadRegiones();
//		updateCantidadDeRegiones();
	}

	private void updateSimilidadInput(int similaridad) {
		_similaridadInput.setText(String.valueOf(similaridad));
	}

	private void loadMap() {

		if (_mapWindow != null) {
			_mapWindow.close();
		}

		if (_mapWindow == null || !_mapWindow.isVisible()) {
			_mapWindow = new MapWindow();

			updateLugaresEnMapa();
			_mapWindow.addObserver(MapWindowEvent.DOT_CLICKED.toString(), (mark) -> dotClicked(mark));

		}

	}

	private void updateLugaresEnMapa() {
		
		List<Location> vertices = new ArrayList<>();

		for (Location location : _locationsByID.values()) {
			vertices.add(location);
			location.setVecinos(_app.obtenerVecinos(location.id()));
		}

		_mapWindow.setMarkersDot(vertices);
	}

	private void dotClicked(Object o) {
		if (!(o instanceof MarkDTO)) {
			return;
		}
		MarkDTO mark = (MarkDTO) o;

		mostrarPanel(_panel_2);
		mostrarPanel(_panel_3);
		loadProvinciaSeleccionada(mark.name());
		loadProvinciasLimitrofes(mark);
		updateActualizarBtn();
		updateCantidadDeRegiones();

	}

	private void updateActualizarBtn() {
		if (_provinciasLimitrofesBox.getItemCount() == 0) {
			btnActualizarSimilaridad.setEnabled(false);
			return;
		}
		btnActualizarSimilaridad.setEnabled(true);
	}

	private void loadProvinciasLimitrofes(MarkDTO mark) {
		List<AristaDTO> aristas = _app.obtenerAristasDe(mark.id());

		String[] provinciasLimitrofes = new String[aristas.size()];
		int[] similaridades = new int[aristas.size()];
		int index = 0;

		for (AristaDTO arista : aristas) {
			Location destino = _locationsByID.get(arista.get_destino());
			if (mark.id() != arista.get_origen()) {
				destino = _locationsByID.get(arista.get_origen());
			}

			provinciasLimitrofes[index] = destino.placeName();
			similaridades[index] = arista.get_peso();

			index++;
		}

//		loadProvinciasLimitrofes(provinciasLimitrofes);
		_provinciasLimitrofesBox.setModel(new DefaultComboBoxModel<String>(provinciasLimitrofes));
		_similaridadesLimitrofes = similaridades;
		_provincia_box_seleccionada = 0;

		if (similaridades.length > 0) {
			updateSimilidadInput(similaridades[0]);
			return;
		}

		_similaridadInput.setText("");

	}

	private void mostrarPanel(JPanel panel) {
		panel.setVisible(true);
	}

	private void loadCantidadRegiones() {
		_regionesBox = new JComboBox<Integer>();
		_regionesBox.setBounds(104, 70, 69, 30);
		_regionesBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_regiones = (int) _regionesBox.getSelectedItem();
			}
		});

		_panel_3.add(_regionesBox);

	}

	private void updateCantidadDeRegiones() {
		int cantVertices = _app.cantVertices();

		Integer[] regiones = new Integer[cantVertices];
		for (int i = 0; i < cantVertices; i++) {
			regiones[i] = i + 1;
		}
		_regionesBox.setModel(new DefaultComboBoxModel<Integer>(regiones));
	}

	private void updateProvinciasLimitrofes(String[] provinciasLimitrofes) {
		_provinciasLimitrofesBox.setModel(new DefaultComboBoxModel<String>(provinciasLimitrofes));
	}

	private void loadProvinciaSeleccionada(String prov) {
		_provincia_seleccionada.setText(prov);
		_provincia_seleccionada_id = _locationsByNames.get(prov).id();
	}

	private void generarRegiones() {
		try {
			_app.generarRegiones(_regiones);
			_btnAddVertice.setVisible(false);
			_btnConectar.setVisible(false);
			_btnEliminarVertice.setVisible(false);
//			loadMap();
			updateLugaresEnMapa();
			
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
	}
}
