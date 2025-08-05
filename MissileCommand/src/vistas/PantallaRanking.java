package vistas;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PantallaRanking extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable tablaRanking;
	
	public PantallaRanking() {
		
		setBounds(0, 0, 509, 500);
		setLocationRelativeTo(PantallaPrincipal.getInstancia());
		this.setResizable(false);
		setTitle("Missile Command - Ranking");
		getContentPane().setLayout(null);
		
		final JLabel labelAtras = new JLabel(""); // Creacion boton atras
		labelAtras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PantallaPrincipal.getInstancia().setVisible(true);
				setVisible(false); // Pone visible la pantalla principal
			}

			public void mouseEntered(MouseEvent arg0) {
				URL url = getClass().getClassLoader().getResource("imagenes/atras1.png");
				ImageIcon img = new ImageIcon(url);
				labelAtras.setIcon(img);
			}

			public void mouseExited(MouseEvent arg0) {
				URL url = getClass().getClassLoader().getResource("imagenes/atras2.png");
				ImageIcon img = new ImageIcon(url);
				labelAtras.setIcon(img);
			}
		});
		URL url = getClass().getClassLoader().getResource("imagenes/atras2.png");
		ImageIcon img = new ImageIcon(url);
		labelAtras.setIcon(img);
		labelAtras.setBounds(15, 15, 60, 60);
		getContentPane().add(labelAtras);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				PantallaPrincipal.getInstancia().setVisible(true);
				setVisible(false); // Pone visible la pantalla principal
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		scrollPane.setBounds(50, 200, 400, 250);
		getContentPane().add(scrollPane);

		Object[][] datos = new Object[PantallaPrincipal.getTop()][5];
		for (int i = 0; i < PantallaPrincipal.getTop(); i++) {
			datos[i][0] = i+1;
			datos[i][1] = "Juan";
			datos[i][2] = 500;
			datos[i][3] = 223;
			//  datos[i][1] = JuegoMain.getTopPuntajes().get(i).getNombre();
			//  datos[i][2] = JuegoMain.getTopPuntajes().get(i).getPuntaje();
			//  datos[i][3] = JuegoMain.getTopPuntajes().get(i).getTiempo();
		}

		String[] columnas = {"Posición", "Nombre", " Puntaje", "Tiempo (seg)"};

		DefaultTableCellRenderer alinearCen = new DefaultTableCellRenderer();
		alinearCen.setHorizontalAlignment(SwingConstants.CENTER);
		DefaultTableCellRenderer alinearDer = new DefaultTableCellRenderer();
		alinearDer.setHorizontalAlignment(SwingConstants.RIGHT);
		DefaultTableModel dtm = new DefaultTableModel(datos, columnas);

		tablaRanking = new JTable(dtm);
		scrollPane.setViewportView(tablaRanking);
		scrollPane.setBackground(Color.WHITE);

		tablaRanking.setBackground(Color.WHITE);
		tablaRanking.getTableHeader().setForeground(Color.BLACK);
		tablaRanking.getTableHeader().setBackground(Color.WHITE);
		tablaRanking.setRowHeight(50);
		tablaRanking.setBorder(null);
		tablaRanking.setForeground(Color.BLACK);
		tablaRanking.setShowGrid(false);
		tablaRanking.getTableHeader().setReorderingAllowed(false);
		tablaRanking.getTableHeader().setResizingAllowed(false);
		tablaRanking.getColumnModel().getColumn(0).setCellRenderer(alinearCen);
		tablaRanking.getColumnModel().getColumn(1).setCellRenderer(alinearCen);
		tablaRanking.getColumnModel().getColumn(2).setCellRenderer(alinearDer);
		tablaRanking.getColumnModel().getColumn(3).setCellRenderer(alinearDer);
		tablaRanking.setFocusable(false);
		tablaRanking.setEnabled(false);
		
		JLabel labelFondo = new JLabel("");
		url = getClass().getClassLoader().getResource("imagenes/fondoRanking.png");
		img = new ImageIcon(url);
		labelFondo.setIcon(img);
		labelFondo.setBounds(0, 0, 509, 500);
		getContentPane().add(labelFondo);
	}
}
