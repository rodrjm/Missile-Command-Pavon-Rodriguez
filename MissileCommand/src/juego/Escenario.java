package juego;

import java.util.LinkedList;

import modelos.enemigos.*;
import modelos.lugares.*;
import modelos.personajes.*;

public class Escenario {

	// Personaje matriz[][] = new Personaje[600][600];
	private LinkedList<Personaje> list = new LinkedList<>();

	int alto = 480;

	int ancho = 525;

	public LinkedList<Personaje> getList() {
		return list;
	}

	public void setList(LinkedList<Personaje> list) {
		this.list = list;
	}

	private static Escenario instancia;

	public static Escenario getInstancia() {
		return instancia;
	}

	public static void setInstancia(Escenario unaInstancia) {
		instancia = unaInstancia;
	}

	public Escenario() {
		this.setPersonaje(new Silo(2, 250, EstadoSilo.LIVE));
		this.setPersonaje(new Ciudad(65, 470));
		this.setPersonaje(new Ciudad(130, 470));
		this.setPersonaje(new Ciudad(195, 470));
		this.setPersonaje(new Silo(260, 470, EstadoSilo.LIVE));
		this.setPersonaje(new Ciudad(325, 470));
		this.setPersonaje(new Ciudad(390, 470));
		this.setPersonaje(new Ciudad(455, 470));
		this.setPersonaje(new Silo(523, 470, EstadoSilo.LIVE));
	}

	public void setPersonaje(Personaje p) {
		this.list.add(p);
	}

	public Personaje getPersonaje(int i) {
		return this.list.get(i);
	}

	public void vaciarPosicion(Personaje p) {
		this.list.remove(p);
	}

	public boolean esCiudad(int i) {
		if (Escenario.getInstancia().getPersonaje(i) instanceof Ciudad) {
			return true;
		}
		return false;
	}

	public boolean esSilo(int i) {
		if (Escenario.getInstancia().getPersonaje(i) instanceof Silo) {
			return true;
		}
		return false;
	}

	public boolean esAvion(int i) {
		if (Escenario.getInstancia().getPersonaje(i) instanceof Avion) {
			return true;
		}
		return false;
	}

	public boolean esBalistico(int i) {
		if (Escenario.getInstancia().getPersonaje(i) instanceof Balistico) {
			return true;
		}
		return false;
	}

	public boolean esCruceroInteligente(int i) {
		if (Escenario.getInstancia().getPersonaje(i) instanceof CruceroInteligente) {
			return true;
		}
		return false;
	}

	public boolean esCruceroTonto(int i) {
		if (Escenario.getInstancia().getPersonaje(i) instanceof CruceroTonto) {
			return true;
		}
		return false;
	}

	public boolean esSatelite(int i) {
		if (Escenario.getInstancia().getPersonaje(i) instanceof Satelite) {
			return true;
		}
		return false;
	}

	public boolean esAntibalistico(int i) {
		if (Escenario.getInstancia().getPersonaje(i) instanceof Antibalistico) {
			return true;
		}
		return false;
	}

	public boolean esExplosion(int i) {
		if (Escenario.getInstancia().getPersonaje(i) instanceof Explosion) {
			return true;
		}
		return false;
	}

	public boolean esPersonaje(int i) {
		if (Escenario.getInstancia().getPersonaje(i) instanceof Personaje) {
			return true;
		}
		return false;
	}

	public boolean esLugar(int i) {
		if (Escenario.getInstancia().getPersonaje(i) instanceof Lugar) {
			return true;
		}
		return false;
	}

	public boolean esVacio(int i) {
		if (Escenario.getInstancia().getPersonaje(i) instanceof Vacio) {
			return true;
		}
		return false;
	}
}
