package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import app.DisenandoRegiones;
import utils.FuncionesUtils;
import utils.Observable;

public class ConectarVerticesDialog extends Dialog implements Observable {

	private JTextField _origenInput;
	private JTextField _destinoInput;
	private JTextField _similaridadInput;

	public ConectarVerticesDialog(DisenandoRegiones app) {
		iniciarEventos();
		crearLabels();
		crearInputs();
		connectButton(app);
	}

	private void crearInputs() {
		_origenInput = new JTextField();
		_origenInput.setBounds(145, 38, 114, 21);
		_panel.add(_origenInput);
		_origenInput.setColumns(10);

		_destinoInput = new JTextField();
		_destinoInput.setBounds(145, 67, 114, 21);
		_panel.add(_destinoInput);
		_destinoInput.setColumns(10);

		_similaridadInput = new JTextField();
		_similaridadInput.setBounds(145, 96, 114, 21);
		_panel.add(_similaridadInput);
		_similaridadInput.setColumns(10);
	}

	private void crearLabels() {
		JLabel origen = new JLabel("Origen");
		origen.setBounds(71, 40, 49, 17);
		_panel.add(origen);

		JLabel destino = new JLabel("Destino");
		destino.setBounds(73, 69, 47, 17);
		_panel.add(destino);

		JLabel similaridad = new JLabel("Similaridad");
		similaridad.setBounds(71, 98, 75, 17);
		_panel.add(similaridad);
	}

	private void connectButton(DisenandoRegiones app) {
		JButton btnAgregar = new JButton("Conectar vértices");
		btnAgregar.setBounds(100, 142, 150, 27);
		_panel.add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer origen = FuncionesUtils.intentarParsearInteger("Origen", _origenInput.getText());
					Integer destino = FuncionesUtils.intentarParsearInteger("Destino", _destinoInput.getText());
					Integer similaridad = FuncionesUtils.intentarParsearInteger("Similaridad",
							_similaridadInput.getText());

					app.agregarPeso(origen, destino, similaridad);

					ConectarVerticesDialog.this.notificar("Connect", null);
					_frame.dispose();
				} catch (Exception error) {
					System.out.println(error.getMessage());
				}
			}
		});
	}

	@Override
	void iniciarEventos() {
		_observers.put("Connect", new HashSet<>());
	}

}
