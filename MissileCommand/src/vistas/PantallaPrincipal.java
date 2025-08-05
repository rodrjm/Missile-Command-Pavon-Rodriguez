package vistas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PantallaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contenedor;
	private JButton bJugar;
	public static int nivelJ = 1;
	public static int TopJ = 5;
	private PantallaConfiguracion pConfiguracion;
	private PantallaReglas pReglas;
	private PantallaRanking pRanking;

	public static PantallaPrincipal instancia;

	public PantallaPrincipal() {

		setBounds(100, 100, 650, 365);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		setTitle("Missile Command");
		this.setLocationRelativeTo(null);
		this.setPantallaReglas(new PantallaReglas());
		this.setPantallaConfiguracion(new PantallaConfiguracion());
		this.setPantallaRanking(new PantallaRanking());
		contenedor = new JPanel();
		setContentPane(contenedor);
		contenedor.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(-6, -18, 2618, 1326);
		contenedor.add(panel);
		panel.setLayout(null);

		bJugar = new JButton("");
		URL url = getClass().getClassLoader().getResource("imagenes/jugar2.png");
		ImageIcon img = new ImageIcon(url);
		bJugar.setIcon(img);
		bJugar.setBounds(30, 110, 170, 50);
		panel.add(bJugar);

		final JLabel labelReglas = new JLabel(""); // Creacion boton reglas
		labelReglas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PantallaPrincipal.this.getPantallaReglas().setLocationRelativeTo(PantallaPrincipal.this);
				PantallaPrincipal.this.getPantallaReglas().setVisible(true);
				setVisible(false); // Pone visible la pantalla reglas y no visible la principal
			}

			public void mouseEntered(MouseEvent arg0) {
				URL url = getClass().getClassLoader().getResource("imagenes/reglas1.png");
				ImageIcon img = new ImageIcon(url);
				labelReglas.setIcon(img);
			}

			public void mouseExited(MouseEvent arg0) {
				URL url = getClass().getClassLoader().getResource("imagenes/reglas2.png");
				ImageIcon img = new ImageIcon(url);
				labelReglas.setIcon(img);
			}
		});
		url = getClass().getClassLoader().getResource("imagenes/reglas2.png");
		img = new ImageIcon(url);
		labelReglas.setIcon(img);
		labelReglas.setBounds(30, 280, 265, 50);
		panel.add(labelReglas);

		final JLabel labelRanking = new JLabel(""); // Creacion boton ranking
		labelRanking.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PantallaRanking pRanking = new PantallaRanking();
				pRanking.setVisible(true);
				setVisible(false); // Pone visible la pantalla ranking y no visible la principal
			}

			public void mouseEntered(MouseEvent arg0) {
				URL url = getClass().getClassLoader().getResource("imagenes/rank1.png");
				ImageIcon img = new ImageIcon(url);
				labelRanking.setIcon(img);
			}

			public void mouseExited(MouseEvent arg0) {
				URL url = getClass().getClassLoader().getResource("imagenes/rank2.png");
				ImageIcon img = new ImageIcon(url);
				labelRanking.setIcon(img);
			}
		});
		url = getClass().getClassLoader().getResource("imagenes/rank2.png");
		img = new ImageIcon(url);
		labelRanking.setIcon(img);
		labelRanking.setBounds(460, 280, 170, 50);
		panel.add(labelRanking);

		final JLabel labelConfiguracion = new JLabel(""); // Boton configuracion
		labelConfiguracion.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PantallaPrincipal.this.getPantallaConfiguracion().setLocationRelativeTo(PantallaPrincipal.this);
				PantallaPrincipal.this.getPantallaConfiguracion().setVisible(true);
				setVisible(false); // Pone visible la pantalla configuracion y no visible la principal
			}

			public void mouseEntered(MouseEvent arg0) {
				URL url = getClass().getClassLoader().getResource("imagenes/config1.png");
				ImageIcon img = new ImageIcon(url);
				labelConfiguracion.setIcon(img);
			}

			public void mouseExited(MouseEvent arg0) {
				URL url = getClass().getClassLoader().getResource("imagenes/config2.png");
				ImageIcon img = new ImageIcon(url);
				labelConfiguracion.setIcon(img);
			}

		});
		url = getClass().getClassLoader().getResource("imagenes/config2.png");
		img = new ImageIcon(url);
		labelConfiguracion.setIcon(img);
		labelConfiguracion.setBounds(590, 20, 55, 55);
		panel.add(labelConfiguracion);

		JLabel labelFondo = new JLabel("");
		url = getClass().getClassLoader().getResource("imagenes/fondoPrincipal.png");
		img = new ImageIcon(url);
		labelFondo.setIcon(img);
		labelFondo.setBounds(0, 0, 650, 365);
		panel.add(labelFondo);
		this.setVisible(true);
	}

	public JButton getBotonJugar() {
		return bJugar;
	}

	public void setBotonJugar(JButton bJugar) {
		this.bJugar = bJugar;
	}

	public PantallaReglas getPantallaReglas() {
		return pReglas;
	}

	public void setPantallaReglas(PantallaReglas pReglas) {
		this.pReglas = pReglas;
	}

	public static PantallaPrincipal getInstancia() {
		return instancia;
	}

	public static void setInstancia(PantallaPrincipal instancia) {
		PantallaPrincipal.instancia = instancia;
	}

	public void desaparecer() {
		setVisible(false);
	}

	public void botonJugarActivado() {
		URL url = getClass().getClassLoader().getResource("imagenes/jugar1.png");
		ImageIcon img = new ImageIcon(url);
		this.bJugar.setIcon(img);
	}

	public void botonJugarDesactivado() {
		URL url = getClass().getClassLoader().getResource("imagenes/jugar2.png");
		ImageIcon img = new ImageIcon(url);
		this.bJugar.setIcon(img);
	}

	public static int getTop() {
		return TopJ;
	}

	public static void setTop(int top) {
		TopJ = top;
	}
	
	public static int getNivel() {
		return nivelJ;
	}

	public static void setNivel(int nivel) {
		nivelJ = nivel;
	}

	public PantallaConfiguracion getPantallaConfiguracion() {
		return pConfiguracion;
	}

	public void setPantallaConfiguracion(PantallaConfiguracion pConfiguracion) {
		this.pConfiguracion = pConfiguracion;
	}
	
	public PantallaRanking getPantallaRanking() {
		return pRanking;
	}
	
	public void setPantallaRanking(PantallaRanking pRanking) {
		this.pRanking = pRanking;
	}
}