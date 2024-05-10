package presentation;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private JFrame frame;
    private MapWindow mapWindow = null;  // Referencia a NewWindow

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		initializeMap();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDiseandoRegiones = new JLabel("Diseñando Regiones");
		lblDiseandoRegiones.setBounds(307, 51, 174, 30);
		frame.getContentPane().add(lblDiseandoRegiones);
		
		JButton btnOpenMap = new JButton("Open Map");
		btnOpenMap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        if (mapWindow == null || !mapWindow.isVisible()) {
		        	System.out.println("Click");
		        	List<MapMarkerDot> vertices = new ArrayList<>();
		        	
		        	vertices.add(new MapMarkerDot("CABA",new Coordinate(-34.8,-58.4)));
		        	vertices.add(new MapMarkerDot("Buenos Aires",new Coordinate(-36.4,-61)));
		        	vertices.add(new MapMarkerDot("La Pampa",new Coordinate(-37.4,-65.5)));
		        	
		        	
		        	mapWindow = new MapWindow();
		        	mapWindow.setMarkersDot(vertices);
		        }		
			}
		});

		btnOpenMap.setBounds(318, 126, 105, 27);
		frame.getContentPane().add(btnOpenMap);
		
		

	}
	

	private void initializeMap() {
		Coordinate coordinate = new Coordinate(-40, -67);
		
		MapMarker marker1 = new MapMarkerDot("Aqui", coordinate);
		marker1.getStyle().setBackColor(Color.red);
		marker1.getStyle().setColor(Color.orange);
	}
}
