package presentation;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.Observable;
import utils.Observer;

public abstract class Dialog implements Observable {
	protected Map<String, Set<Observer>> _observers;
	protected JFrame _frame;
	protected JPanel _panel;

	Dialog() {
		_observers = new HashMap<>();
		ventanaPrincipal();
		crearPanel();
	}

	private void crearPanel() {
		_panel = new JPanel();
		_panel.setFocusable(true);
		_panel.requestFocusInWindow();
		_panel.setBounds(0, 0, 350, 211);
		_frame.getContentPane().add(_panel);
		_panel.setLayout(null);
		_panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					_frame.dispose();
				}
			}
		});
	}

	public void close() {
		_frame.dispose();
	}

	private void ventanaPrincipal() {
		_frame = new JFrame("Nueva Ventana");
		_frame.setType(Type.UTILITY);
		_frame.setTitle("Agregar vertice");
		_frame.setResizable(false);
		_frame.setAutoRequestFocus(false);
		_frame.setSize(350, 211);
		_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		_frame.getContentPane().setLayout(null);
		posicionarVentana();
		_frame.setVisible(true);
	}

	abstract void iniciarEventos();

	private void posicionarVentana() {
		Dimension tamanioVentana = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = tamanioVentana.width;
		int alto = tamanioVentana.height;

		int x = (ancho - _frame.getWidth() - 50) / 2;
		int y = (alto - _frame.getHeight()) / 2;

		_frame.setLocation(x, y);
	}

	@Override
	public void agregarObserver(String evento, Observer observer) {

		if (!_observers.containsKey(evento)) {
			throw new RuntimeException("Evento no existe:" + evento);
		}

		Set<Observer> observers = _observers.get(evento);
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
