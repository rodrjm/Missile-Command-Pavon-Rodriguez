package controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import juego.Escenario;
import modelos.personajes.Antibalistico;

public class Mouse extends MouseAdapter {

	public void mouseClicked(MouseEvent arg0) {
		// Representa al lanzar misil cuando el usuario hace click
		if (arg0.getX() <= 175) {
			Escenario.getInstancia().setPersonaje(new Antibalistico(40, 470, arg0.getX(), arg0.getY(),40,470));
		} else if ((arg0.getX() >= 175) && (arg0.getX() < 350)) {
			Escenario.getInstancia().setPersonaje(new Antibalistico(260, 470, arg0.getX(), arg0.getY(),260, 470));
		} else {
			if ((arg0.getX() > 350)) {
				Escenario.getInstancia().setPersonaje(new Antibalistico(523, 470, arg0.getX(), arg0.getY(),523, 470));
			}
		}

	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// Representa a la cruz del mouse cuando se mueve por el mapa
	}
}
