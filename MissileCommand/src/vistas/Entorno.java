package vistas;

import java.awt.Color;

import javax.swing.JFrame;

import controladores.Mouse;

public class Entorno extends JFrame {

	private static final long serialVersionUID = 1L;
	// private PanelGeneral panel;
	private Mapa mapa;
	public static Entorno instancia;
	
	public static Entorno getInstancia() {
		return instancia;
	}

	public static void setInstancia(Entorno instancia) {
		Entorno.instancia = instancia;
	}

	public Entorno() {
		this.mapa = new Mapa();
		this.setBounds(0, 0, 560, 540);
		this.setLocationRelativeTo(PantallaPrincipal.getInstancia());
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.red);
		this.add(mapa);
		this.mapa.addMouseListener(new Mouse());
		this.setVisible(true);
	}
	
	public void reGenerar(){
		this.mapa.repaint();
	}
}
