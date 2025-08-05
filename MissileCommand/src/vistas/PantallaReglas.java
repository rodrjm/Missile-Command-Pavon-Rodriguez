package vistas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class PantallaReglas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contenedor;

	public PantallaReglas() {

		setBounds(0, 0, 738, 416);
		setLocationRelativeTo(PantallaPrincipal.getInstancia());
		this.setResizable(false);
		setTitle("Missile Command - Reglas del Juego");

		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedor);
		contenedor.setLayout(null);

		final JTextArea areaTexto;
		String texto = "El objetivo del juego es defender tus ciudades y bases de misiles. "
				+ "El enemigo dispara misiles balísticos interplanetarios y misiles crucero,"
				+ "ambos tienen como objetivo destruir tus ciudades y bases militares. "
				+ "Hay 2 tipos de misil crucero: misiles cruceros tontos (que caen en línea "
				+ "recta) y misiles crucero inteligentes, los cuales tratarán de evadir tus "
				+ "misiles antibalísticos (MABs). \n"
				+ "El enemigo ataca en una serie de oleadas que puede variar en el número de "
				+ "misiles balísticos interplanetarios que atacan. Cada oleada de misiles se "
				+ "mueve más rápido que la oleada anterior. Mientras más rápida es la oleada, "
				+ "más difícil es defender las ciudades. Por este motivo, mientras más rápida "
				+ "es la oleada, más alto será el puntaje ganado. \n"
				+ "Con cada oleada, tenés 30 MABs para defenderte, 10 en cada uno de los silos, "
				+ "los cuales están ubicados en la parte inferior de la pantalla, a la izquierda, "
				+ "al centro y a la derecha. Una vez que has disparado los 30 MABs, estarás indefenso "
				+ "hasta que comience una nueva oleada. \n"
				+ "Cada vez que un MAB llega a su destino o alcanza algún misil enemigo ocurre una "
				+ "explosión. La onda expansiva de esta explosión puede ocasionar que otros misiles "
				+ "balísticos interplanetarios o crucero que se encuentran en la zona de impacto "
				+ "también sean destruidos. Si la explosión del MAB no alcanza la cabeza del misil, "
				+ "éste seguirá con su trayectoria, sólo se verá afectada la estela que deja a su paso. \n"
				+ "Debes tener en cuenta que hay un umbral (línea horizontal imaginaria) en el campo de "
				+ "juego, debajo de la cual no podrás disparar misiles. De esta manera se protege a los "
				+ "silos y las ciudades de la autodestrucción. \n"
				+ "Si logras sobrevivir a la oleada, pasarás al siguiente nivel, si no logras sobrevivir "
				+ "a la oleada, tendrás sólo otra oportunidad para volver a defenderte. \n"
				+ "El juego finaliza cuando todas las ciudades son destruidas.";
		areaTexto = new JTextArea(texto, 200, 200);
		areaTexto.setEditable(false);
		areaTexto.setLineWrap(true);
		areaTexto.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(areaTexto);
		scroll.setBounds(30, 200, 670, 150);
		contenedor.add(scroll);

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
		contenedor.add(labelAtras);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				PantallaPrincipal.getInstancia().setVisible(true);
				setVisible(false); // Pone visible la pantalla principal
			}
		});

		JLabel labelFondo = new JLabel("");
		url = getClass().getClassLoader().getResource("imagenes/fondoReglas.png");
		img = new ImageIcon(url);
		labelFondo.setIcon(img);
		labelFondo.setBounds(0, 0, 738, 416);
		contenedor.add(labelFondo);
	}
}
