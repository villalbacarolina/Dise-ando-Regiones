package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import utils.FuncionesUtils;

public class EliminarVerticeDialog extends Dialog {

	private JTextField _verticeInput;

	public EliminarVerticeDialog() {
		super();
		crearLabels();
		crearInputs();
		iniciarEventos();
		eliminarButton();
	}

	private void eliminarButton() {
		JButton btnAgregar = new JButton("Eliminar vértice");
		btnAgregar.setBounds(110, 142, 150, 27);
		_panel.add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer origen = FuncionesUtils.intentarParsearInteger("Vértice", _verticeInput.getText());
					EliminarVerticeDialog.this.notificar("Eliminar", origen);
					_frame.dispose();
				} catch (Exception error) {
					System.out.println(error.getMessage());
				}
			}
		});
	}

	private void crearInputs() {
		_verticeInput = new JTextField();
		_verticeInput.setBounds(130, 38, 114, 21);
		_panel.add(_verticeInput);
		_verticeInput.setColumns(10);
	}

	private void crearLabels() {
		JLabel origen = new JLabel("Vertice");
		origen.setBounds(71, 40, 49, 17);
		_panel.add(origen);
	}

	@Override
	void iniciarEventos() {
		_observers.put("Eliminar", new HashSet<>());
	}

}
