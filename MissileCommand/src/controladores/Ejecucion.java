package controladores;

import java.util.Timer;
import java.util.TimerTask;

import controladores.Inicio;
import controladores.Juego;

public class Ejecucion extends TimerTask {

	private Timer timer;
	private int tiempoM = 0;

	public Ejecucion(Timer timer) {
		this.timer = timer;
	}

	@Override
	public void run() {
		if (!Inicio.getControlador().isGameOver()) {
			actualizarJuego();
			tiempoM++;
		} else {
			timer.cancel();
		}
	}

	public void actualizarJuego() {
		Juego.getJuego().mover();
		Juego.getJuego().actualizarPersonajes();
		Juego.getJuego().lanzarMisiles(tiempoM);
		Inicio.getControlador().actualizar();
	}
}
