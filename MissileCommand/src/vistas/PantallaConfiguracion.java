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
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class PantallaConfiguracion extends JFrame{

	private static final long serialVersionUID = 1L;
	private JList<String> listaRanking;
	private JList<String> listaNiveles;

	public PantallaConfiguracion() {
		getContentPane().setLayout(null);
		this.setSize(655, 360);
		setLocationRelativeTo(PantallaPrincipal.getInstancia());
		this.setResizable(false);
		
		JLabel labelNivel = new JLabel("");
		labelNivel.setHorizontalAlignment(SwingConstants.CENTER);
		labelNivel.setText("Seleccionar nivel");
		labelNivel.setForeground(Color.BLACK);
		labelNivel.setBounds(30, 167, 290, 20);
		labelNivel.setBorder(BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.BLACK));
		labelNivel.setBackground(Color.WHITE);
		getContentPane().add(labelNivel);
		String niveles[]={"Nivel 1", "Nivel 2", "Nivel 3", "Nivel 4", "Nivel 5", "Nivel 6", "Nivel 7", "Nivel 8", "Nivel 9", "Nivel 10"};
		listaNiveles = new JList<String>(niveles);
		listaNiveles.setForeground(Color.BLACK);
		listaNiveles.setBackground(Color.WHITE);	
		JScrollPane scrollNivel = new JScrollPane(listaNiveles);
		scrollNivel.setBounds(30, 185, 290, 80);
		scrollNivel.setBackground(Color.WHITE);
		scrollNivel.setBorder(BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.BLACK));
		getContentPane().add(scrollNivel);
		
		JLabel labelSiNivel = new JLabel(""); // Boton para aceptar el nivel seleccionado
		labelSiNivel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PantallaPrincipal.getInstancia();
				PantallaPrincipal.setNivel(listaNiveles.getSelectedIndex()+1);
				PantallaPrincipal.getInstancia().setVisible(true);
				setVisible(false);
			}
			
			public void mouseEntered(MouseEvent arg0) {
				URL url = getClass().getClassLoader().getResource("imagenes/si1.png");
				ImageIcon img = new ImageIcon(url);
				labelSiNivel.setIcon(img);
			}

			public void mouseExited(MouseEvent arg0) {
				URL url = getClass().getClassLoader().getResource("imagenes/si2.png");
				ImageIcon img = new ImageIcon(url);
				labelSiNivel.setIcon(img);
			}
		});
		labelSiNivel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/si2.png")));
		labelSiNivel.setBounds(150, 270, 60, 60);
		getContentPane().add(labelSiNivel);
		
		JLabel labelRanking = new JLabel("");
		labelRanking.setHorizontalAlignment(SwingConstants.CENTER);
		labelRanking.setText("Cantidad de puntajes en tabla");
		labelRanking.setForeground(Color.BLACK);
		labelRanking.setBounds(330, 167, 290, 20);
		labelRanking.setBorder(BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.BLACK));
		labelRanking.setBackground(Color.WHITE);
		labelRanking.setVisible(true);
		getContentPane().add(labelRanking);
		String rankings[]={"Top 1", "Top 2", "Top 3", "Top 4", "Top 5"};
		listaRanking = new JList<String>(rankings);
		listaRanking.setForeground(Color.BLACK);
		listaRanking.setBackground(Color.WHITE);	
		JScrollPane scrollRanking = new JScrollPane(listaRanking);
		scrollRanking.setBounds(330, 185, 290, 80);
		scrollRanking.setBackground(Color.WHITE);
		scrollRanking.setBorder(BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.BLACK));
		getContentPane().add(scrollRanking);
		
		JLabel labelSiRank = new JLabel(""); // Boton para aceptar el ranking seleccionado
		labelSiRank.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PantallaPrincipal.setTop(listaRanking.getSelectedIndex()+1);
				PantallaPrincipal.getInstancia().setVisible(true);
				setVisible(false);
			}
			
			public void mouseEntered(MouseEvent arg0) {
				URL url = getClass().getClassLoader().getResource("imagenes/si1.png");
				ImageIcon img = new ImageIcon(url);
				labelSiRank.setIcon(img);
			}

			public void mouseExited(MouseEvent arg0) {
				URL url = getClass().getClassLoader().getResource("imagenes/si2.png");
				ImageIcon img = new ImageIcon(url);
				labelSiRank.setIcon(img);
			}
		});
		labelSiRank.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/si2.png")));
		labelSiRank.setBounds(450, 270, 60, 60);
		getContentPane().add(labelSiRank);
		
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
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imagenes/fondoConfiguracion.png")));
		labelFondo.setBounds(0, 0, 655, 360);
		getContentPane().add(labelFondo);
	}
}
