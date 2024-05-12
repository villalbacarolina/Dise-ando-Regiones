package presentation;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import app.DisenandoRegiones;
import utils.Observable;
import utils.Observer;

public class ConectarVerticesWindow implements Observable {

	private JPanel _panel;
	private JFrame _frame;
	private Map<String, Set<Observer>> _observers;

	private JTextField _origenInput;
	private JTextField _destinoInput;
	private JTextField _similaridadInput;

	public ConectarVerticesWindow(DisenandoRegiones app) {
		mainWindow();
		createPanel();
		initEvents();
		createLabels();
		createInputs();

		connectButton(app);
	}

	private void createInputs() {
		_origenInput = new JTextField();
		_origenInput.setBounds(130, 38, 114, 21);
		_panel.add(_origenInput);
		_origenInput.setColumns(10);

		_destinoInput = new JTextField();
		_destinoInput.setBounds(130, 67, 114, 21);
		_panel.add(_destinoInput);
		_destinoInput.setColumns(10);

		_similaridadInput = new JTextField();
		_similaridadInput.setBounds(130, 96, 114, 21);
		_panel.add(_similaridadInput);
		_similaridadInput.setColumns(10);
	}

	private void createLabels() {
		JLabel origen = new JLabel("Origen");
		origen.setBounds(71, 40, 49, 17);
		_panel.add(origen);

		JLabel destino = new JLabel("Destino");
		destino.setBounds(73, 69, 47, 17);
		_panel.add(destino);

		JLabel similaridad = new JLabel("Similaridad");
		similaridad.setBounds(71, 98, 55, 17);
		_panel.add(similaridad);
	}

	private void connectButton(DisenandoRegiones app) {
		JButton btnAgregar = new JButton("Conectar vértices");
		btnAgregar.setBounds(110, 142, 126, 27);
		_panel.add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Integer origen = Integer.parseInt(_origenInput.getText());
				Integer destino = Integer.parseInt(_destinoInput.getText());
				Integer similaridad = Integer.parseInt(_similaridadInput.getText());

				app.agregarPeso(origen,destino,similaridad);
				
				ConectarVerticesWindow.this.notify("Connect", null);
				_frame.dispose();
			}
		});
	}

	private void createPanel() {
		_panel = new JPanel();
		_panel.setFocusable(true);
		_panel.requestFocusInWindow();
		_panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					_frame.dispose();
				}
			}
		});
		_panel.setBounds(0, 0, 350, 211);

		_frame.getContentPane().add(_panel);
		_panel.setLayout(null);
	}

	private void initEvents() {
		_observers = new HashMap<>();
		_observers.put("Connect", new HashSet<>());
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
