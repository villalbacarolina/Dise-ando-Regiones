package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.DisenandoRegiones;
import utils.MapWindowEvent;
import utils.MarkDTO;
import utils.Observable;
import utils.Observer;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AgregarVerticeWindow implements Observable {

	private static final long serialVersionUID = 1L;
	private JFrame _frame;
	private JTextField nombreInput;
	private JTextField latitudInput;
	private JTextField longitudInput;
	private Map<String, Set<Observer>> _observers;
	private JPanel panel;

	public AgregarVerticeWindow(DisenandoRegiones app) {
		mainWindow();
		createPanel();
		initEvents();
		createLabels();
		createInputs();

		createButton(app);

	}

	private void createPanel() {
		panel = new JPanel();
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					_frame.dispose();
				}
			}
		});
		panel.setBounds(0, 0, 350, 211);

		_frame.getContentPane().add(panel);
		panel.setLayout(null);		
	}

	private void initEvents() {
		_observers = new HashMap<>();
		_observers.put("Create", new HashSet<>());
	}

	private void mainWindow() {
		_frame = new JFrame("Nueva Ventana");
		_frame.setType(Type.UTILITY);
		_frame.setTitle("Agregar vertice");
		_frame.setResizable(false);
		_frame.setAutoRequestFocus(false);
		_frame.setSize(350, 211);
		_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		_frame.getContentPane().setLayout(null);
		positionWindow();
		_frame.setVisible(true);

	}

	private void createButton(DisenandoRegiones app) {
		JButton btnAgregar = new JButton("Agregar vertice");
		btnAgregar.setBounds(110, 142, 126, 27);
		panel.add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = app.agregarVertice();
				String origenName = nombreInput.getText();
				Double origenLat = Double.valueOf(latitudInput.getText());
				Double origenLon = Double.valueOf(longitudInput.getText());

				Object location = new Location(id, origenName, origenLat, origenLon);
				AgregarVerticeWindow.this.notify("Create", location);
				_frame.dispose();
			}
		});
	}

	private void createInputs() {
		longitudInput = new JTextField();
		longitudInput.setBounds(130, 96, 114, 21);
		panel.add(longitudInput);
		longitudInput.setColumns(10);

		latitudInput = new JTextField();
		latitudInput.setBounds(130, 67, 114, 21);
		panel.add(latitudInput);
		latitudInput.setColumns(10);
		
		nombreInput = new JTextField();
		nombreInput.setBounds(130, 38, 114, 21);
		panel.add(nombreInput);
		nombreInput.setColumns(10);
	}

	private void createLabels() {
		JLabel lblLongitud = new JLabel("Longitud");
		lblLongitud.setBounds(71, 98, 55, 17);
		panel.add(lblLongitud);
		
		JLabel Nombre = new JLabel("Nombre");
		Nombre.setBounds(71, 40, 49, 17);
		panel.add(Nombre);

		JLabel lblLatidud = new JLabel("Latidud");
		lblLatidud.setBounds(73, 69, 47, 17);
		panel.add(lblLatidud);
	}

	private void positionWindow() {
		// Obtener las dimensiones de la pantalla
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

		// Calcular las coordenadas para centrar la ventana
		int x = (screenWidth - _frame.getWidth() - 50) / 2;
		int y = (screenHeight - _frame.getHeight()) / 2;

		// Establecer la ubicación de la ventana
		_frame.setLocation(x, y);
	}

	@Override
	public void addObserver(String event, Observer observer) {

		if (!_observers.containsKey(event)) {
			throw new RuntimeException("Evento no existe:" + event);
		}
		Set<Observer> observers = _observers.get(event);
		observers.add(observer);
	}

	@Override
	public void notify(String event, Object dto) {
		if (!_observers.containsKey(event)) {
			throw new RuntimeException("Evento no existe:" + event);
		}

		Set<Observer> observers = _observers.get(event);
		for (Observer observer : observers) {
			observer.update(dto);
		}
	}

}
