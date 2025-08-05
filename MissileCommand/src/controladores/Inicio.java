package controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;

import controladores.Inicio;
// import controladores.Ejecucion;
import controladores.Juego;
import vistas.Entorno;
import vistas.PantallaPrincipal;

public class Inicio {

	private Entorno entorno;
	public static Inicio inicio;
	private boolean gameOver;

	public Inicio() {
		PantallaPrincipal pPrincipal = new PantallaPrincipal();
		PantallaPrincipal.setInstancia(pPrincipal);
		PantallaPrincipal.getInstancia().getBotonJugar().addMouseListener(new BotonJugar());
	}

	public void ejecucion() {
		Timer timer = new Timer("Imprimir....");
		if (!isGameOver()) {
			Ejecucion e = new Ejecucion(timer);
			timer.schedule(e, 0, 200);
		} else {
			timer.cancel();
		}
	}

	public class BotonJugar extends MouseAdapter {

		public void mouseClicked(MouseEvent arg0) {
			PantallaPrincipal.getInstancia().desaparecer();
			Inicio.getControlador().setGameOver(false);
			Juego.setJuego(new Juego());
			entorno = new Entorno();
			Inicio.getControlador().setEntorno(entorno);
			Inicio.getControlador().ejecucion();
		}

		public void mouseEntered(MouseEvent arg0) {
			PantallaPrincipal.getInstancia().botonJugarActivado();
		}

		public void mouseExited(MouseEvent arg0) {
			PantallaPrincipal.getInstancia().botonJugarDesactivado();
		}
	}

	public static Inicio getControlador() {
		return inicio;
	}

	public static void setControlador(Inicio inicio) {
		Inicio.inicio = inicio;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public Entorno getEntorno() {
		return entorno;
	}

	public void setEntorno(Entorno entorno) {
		this.entorno = entorno;
	}

	public void actualizar() {
		this.getEntorno().reGenerar();
	}
}
