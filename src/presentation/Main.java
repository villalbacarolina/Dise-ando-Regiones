package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import app.DisenandoRegiones;
import utils.AristaDTO;
import utils.VecinoStrategy;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Main {

	private JFrame _frame;
	private MapWindow _mapWindow = null; // Referencia a NewWindow
	private DisenandoRegiones _app;
	private int _regiones;
	private String selected;
	JLabel labelSelected;

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
		_app = DisenandoRegiones.argentina();
		_regiones = 1;
		mainWindow();
		title();
		openMapButton();
		comboBoxRegiones();
		labelCantRegiones();
		generarRegionesButton();
		labelSelected();

	}

	private void mainWindow() {
		_frame = new JFrame();
		_frame.setResizable(false);
		_frame.setBounds(100, 40, 800, 600);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.getContentPane().setLayout(null);
	}

	private void title() {
		JLabel lblDiseandoRegiones = new JLabel("Diseñando Regiones");
		lblDiseandoRegiones.setBounds(307, 51, 174, 30);
		_frame.getContentPane().add(lblDiseandoRegiones);
	}

	private void openMapButton() {
		JButton btnOpenMap = new JButton("Mapa Original");
		btnOpenMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadMap(id -> _app.obtenerVecinos(id));
			}
		});
		btnOpenMap.setBounds(291, 82, 150, 27);
		_frame.getContentPane().add(btnOpenMap);
	}

	private void labelCantRegiones() {
		JLabel label = new JLabel("Cantidad de regiones");
		label.setBounds(70, 49, 141, 35);
		_frame.getContentPane().add(label);
	}

	private void labelSelected() {
		labelSelected = new JLabel("Selecciona una provincia");
		labelSelected.setBounds(70, 200, 200, 35);
		_frame.getContentPane().add(labelSelected);
	}

	private void comboBoxRegiones() {
		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		int cantVertices = _app.cantVertices();

		Integer[] regiones = new Integer[cantVertices];
		for (int i = 0; i < cantVertices; i++) {
			regiones[i] = i + 1;
		}

		comboBox.setModel(new DefaultComboBoxModel<Integer>(regiones));
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_regiones = (int) comboBox.getSelectedItem();
			}
		});
		comboBox.setBounds(80, 80, 69, 30);
		_frame.getContentPane().add(comboBox);
	}

	private void generarRegionesButton() {
		JButton btnNewButton = new JButton("Generar Regiones");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadMap(id -> _app.obtenerVecinoDeAGM(id));
			}
		});
		btnNewButton.setBounds(61, 126, 150, 27);
		_frame.getContentPane().add(btnNewButton);
	}

	private void loadMap(VecinoStrategy strategy) {

		if (_mapWindow != null) {
			_mapWindow.close();
		}

		if (_mapWindow == null || !_mapWindow.isVisible()) {
			_mapWindow = new MapWindow();

			_app.generarRegiones(_regiones);

			for (Location location : Location.values()) {
				location.setVecinos(strategy.obtenerVecinos(location.id()));
			}

			List<Location> vertices = Arrays.asList(Location.values());

			_mapWindow.setMarkersDot(vertices);
			_mapWindow.registerObserver((msg, id) -> dotClicked(msg, id));

		}

	}

	private void dotClicked(String dotName, int id) {
		labelSelected.setText(dotName);
		List<AristaDTO> aristas = _app.obtenerAristasDe(id);
		Location origen = Location.getLocation(id);

		for (AristaDTO arista : aristas) {
			Location destino = Location.getLocation(arista.get_destino());
			int peso = arista.get_peso();
			if (id != arista.get_origen()) {
				destino = Location.getLocation(arista.get_origen());
			} 


			System.out.println(origen.placeName());
			System.out.println(destino.placeName());
			System.out.println(peso);

			System.out.println("--------");
		}

	}
}
