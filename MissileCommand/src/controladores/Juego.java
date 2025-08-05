package controladores;

import java.util.LinkedList;

import juego.Escenario;
import modelos.enemigos.Balistico;
import modelos.enemigos.CruceroInteligente;
import modelos.lugares.Ciudad;
import modelos.lugares.EstadoSilo;
import modelos.lugares.Lugar;
import modelos.lugares.Silo;
import modelos.personajes.Explosion;
import modelos.personajes.Personaje;

public class Juego {

	public static Juego juego;

	public Juego() {
	}

	public static Juego getJuego() {
		return juego;
	}

	public static void setJuego(Juego juego) {
		Juego.juego = juego;
	}

	public void mover() {
		for (int i = 0; i < Escenario.getInstancia().getList().size(); i++) {
			if (Escenario.getInstancia().esPersonaje(i)) {
				Personaje p = (Personaje) Escenario.getInstancia().getPersonaje(i);
				p.mover();
			}
		}
	}

	public void actualizarPersonajes() {
		for (int i = 0; i < Escenario.getInstancia().getList().size(); i++) {
			Escenario instancia = Escenario.getInstancia();
			if (instancia.getPersonaje(i) != null) {
				Personaje p = (Personaje) Escenario.getInstancia().getPersonaje(i);
				if (p.isExploto()) {
					Explosion e = p.explotar();
					instancia.vaciarPosicion(p);
					instancia.setPersonaje(e);
					
				}
				this.verColisiones(Escenario.getInstancia().getList());
				if ((instancia.getPersonaje(i) != null) && (instancia.esExplosion(i))) {
					Explosion e = (Explosion) instancia.getPersonaje(i);
					e.achicarAgrandarRadio();
				}
			}
		}
	}

	public void lanzarMisiles(int tiempo) {
		int pOleada = 0;
		int sOleada = (int) (Math.random() * 100);
		int tOleada = (int) (Math.random() * 200);
		if ((tiempo == pOleada) || (tiempo == sOleada) || (tiempo == tOleada)) {
			int cant = (int) (Math.random() * 2) + 3;

			for (int i = 0; i < cant; i++) {
				int objetivo = (int) (Math.random() * 8);
				Lugar l = obtenerLugar(objetivo);
				Balistico b = new Balistico((int) (Math.random() * 525), 0, l);
				Escenario.getInstancia().setPersonaje(b);
			}
		}
	}

	public Lugar obtenerLugar(int objetivo) {
		Lugar l;
		switch (objetivo) {
		case 0: {
			l = new Silo(2, 470, EstadoSilo.LIVE);
			break;
		}
		case 1: {
			l = new Ciudad(65, 470);
			break;
		}
		case 2: {
			l = new Ciudad(130, 470);
			break;
		}
		case 3: {
			l = new Ciudad(195, 470);
			break;
		}
		case 4: {
			l = new Silo(260, 470, EstadoSilo.LIVE);
			break;
		}
		case 5: {
			l = new Ciudad(325, 470);
			break;
		}
		case 6: {
			l = new Ciudad(390, 470);
			break;
		}
		case 7: {
			l = new Ciudad(455, 470);
			break;
		}
		default: {
			l = new Silo(523, 470, EstadoSilo.LIVE);
			break;
		}
		}
		return l;
	}
	/**
	 * @see verColisiones Procedimiento para ver las colisiones que se pueden
	 *      producir en el juego
	 * @param listaDibujar Lista que se dibuja en el mapa
	 */
	private void verColisiones(LinkedList<Personaje> listaDibujar) {
		LinkedList<Personaje> listaExplotar = new LinkedList<Personaje>();
		for (int i = 0; i < listaDibujar.size(); i++) {
			Personaje p1 = (Personaje) listaDibujar.get(i);
			for (int j = 0; j < listaDibujar.size(); j++) {
				if (i != j) {
					Personaje p2 = (Personaje) listaDibujar.get(j);
					if ((p1 instanceof CruceroInteligente) && (p2 instanceof Explosion)) {
						Explosion e = (Explosion) p2;
						CruceroInteligente c = (CruceroInteligente) p1;
						if (c.detectarExplosion(e)) {
							c.moverIzqDer();
						}
					}
					if (p1.colision(p2)) {
						if ((p1 instanceof Explosion) && !(p2 instanceof Explosion)) {
							listaExplotar.add(p2);

						}
					}
				}

			}

		}
		for (int i = 0; i < listaExplotar.size(); i++) {
			listaDibujar.remove(listaExplotar.get(i));
			listaDibujar.add(listaExplotar.get(i).explotar());
		}
	}

	
	
	
	
	
	

	public void crearNivel(int nivel) {
		boolean var = false;
		System.out.println("Nivel " + nivel);
		Escenario escenario = new Escenario();
		Escenario.setInstancia(escenario);
		int[] arreglo = { 1, 2, 5, 6, 9, 10, 13, 14 };
		for (int i = 0; i < arreglo.length; i++) {
			if (nivel == arreglo[i]) {
				var = true;
				break;
			}
		}

		if (var) {
			if (nivel == 1) {
				// acciones que se realizan en el nivel 1
			} else {
				// acciones que se realizan en los niveles 2,5,6,9,10,13,14
			}
		} else {
			// acciones que se realizan en los niveles 3,4,7,8,11,12,15,16
		}
	}
}
