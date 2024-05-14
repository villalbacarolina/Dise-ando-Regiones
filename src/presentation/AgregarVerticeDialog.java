package presentation;

import app.DisenandoRegiones;
import utils.FuncionesUtils;
import utils.Observable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.awt.event.ActionEvent;

public class AgregarVerticeDialog extends Dialog implements Observable {

	private JTextField nombreInput;
	private JTextField latitudInput;
	private JTextField longitudInput;

	public AgregarVerticeDialog(DisenandoRegiones app) {
		iniciarEventos();
		crearLabels();
		crearInputs();
		createButton(app);
	}

	@Override
	void iniciarEventos() {
		_observers.put("Create", new HashSet<>());
	}

	private void createButton(DisenandoRegiones app) {
		JButton btnAgregar = new JButton("Agregar vertice");
		btnAgregar.setBounds(110, 142, 126, 27);
		_panel.add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String origenName = nombreInput.getText();
					Double origenLat = FuncionesUtils.intentarParsearDouble("Latitud", latitudInput.getText());
					Double origenLon = FuncionesUtils.intentarParsearDouble("Longitud", longitudInput.getText());
					int id = app.agregarVertice();
					Object location = new Location(id, origenName, origenLat, origenLon);
					AgregarVerticeDialog.this.notificar("Create", location);
					_frame.dispose();
				} catch (Exception error) {
					System.out.println(error.getMessage());
				}
			}
		});
	}

	private void crearInputs() {
		longitudInput = new JTextField();
		longitudInput.setBounds(130, 96, 114, 21);
		_panel.add(longitudInput);
		longitudInput.setColumns(10);

		latitudInput = new JTextField();
		latitudInput.setBounds(130, 67, 114, 21);
		_panel.add(latitudInput);
		latitudInput.setColumns(10);

		nombreInput = new JTextField();
		nombreInput.setBounds(130, 38, 114, 21);
		_panel.add(nombreInput);
		nombreInput.setColumns(10);
	}

	private void crearLabels() {
		JLabel lblLongitud = new JLabel("Longitud");
		lblLongitud.setBounds(71, 98, 55, 17);
		_panel.add(lblLongitud);

		JLabel Nombre = new JLabel("Nombre");
		Nombre.setBounds(71, 40, 49, 17);
		_panel.add(Nombre);

		JLabel lblLatidud = new JLabel("Latidud");
		lblLatidud.setBounds(73, 69, 47, 17);
		_panel.add(lblLatidud);
	}

}
