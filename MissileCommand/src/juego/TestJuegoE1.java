package juego;

import java.util.ArrayList;

import java.util.List;

import modelos.enemigos.Avion;
import modelos.enemigos.Balistico;
import modelos.enemigos.CruceroInteligente;
import modelos.enemigos.CruceroTonto;
import modelos.enemigos.Satelite;
import modelos.lugares.Ciudad;
import modelos.lugares.EstadoSilo;
import modelos.lugares.Lugar;
import modelos.lugares.Silo;
import modelos.personajes.Antibalistico;
import modelos.personajes.Explosion;
import modelos.personajes.Personaje;

/**
 * @see TestJuegoE1 Clase main del juego
 */
public class TestJuegoE1 {

	public static void main(String[] args) {
		List<Personaje> listaDibujar = new ArrayList<>();
		List<Personaje> listaLugares = new ArrayList<>();
		crearNivel(1, listaDibujar, listaLugares);
		vaciarListas(listaDibujar, listaLugares);
		crearNivel(2, listaDibujar, listaLugares);
		vaciarListas(listaDibujar, listaLugares);
		crearNivel(3, listaDibujar, listaLugares);
	}

	/**
	 * @see vaciarListas Procedimiento que vacía listas de lugares y la lista
	 *      que se dibuja en el mapa
	 * @param listaDibujar
	 *            Lista que se dibuja en el mapa
	 * @param listaLugares
	 *            Lista que representa a los lugares dentro del mapa
	 */
	private static void vaciarListas(List<Personaje> listaDibujar, List<Personaje> listaLugares) {
		for (int i = 0; i < listaDibujar.size(); i++) {
			listaDibujar.remove(i);
		}
		for (int i = 0; i < listaLugares.size(); i++) {
			listaLugares.remove(i);
		}
	}

	/**
	 * @see moverPersonajes Procedimiento que sirve para mover los personajes y
	 *      verificar funciones del avión y el satélite
	 * @param listaDibujar
	 *            Lista que se dibuja en el mapa
	 * @param listaLugares
	 *            Lista que representa a los lugares dentro del mapa
	 * @param j
	 *            Tiempo en el cual transcurre el juego para verificar funciones
	 *            del avión y el satélite
	 */
	private static void moverPersonajes(List<Personaje> listaDibujar, List<Personaje> listaLugares, int j) {
		for (int i = 0; i < listaDibujar.size(); i++) {
			if ((listaDibujar.get(i) instanceof Personaje) && (!(listaDibujar.get(i) instanceof Lugar))
					&& (!(listaDibujar.get(i) instanceof Explosion))) {
				listaDibujar.get(i).mover();
			}
			if (listaDibujar.get(i) instanceof Avion) {
				Avion a = (Avion) listaDibujar.get(i);
				for (int k = 0; k < a.getTiempoMisiles().length; k++) {
					if (a.getTiempoMisiles()[k] == j) {
						int objetivo = (int) (Math.random() * 8);
						Balistico b = new Balistico(a.getPosX(), a.getPosY(), (Lugar) listaLugares.get(objetivo));
						listaDibujar.add(b);
					}
				}
			}
			if (listaDibujar.get(i) instanceof Satelite) {
				Satelite s = (Satelite) listaDibujar.get(i);
				for (int k = 0; k < s.getTiempoMisiles().length; k++) {
					if (s.getTiempoMisiles()[k] == j) {
						int objetivo = (int) (Math.random() * 8);
						Balistico b = new Balistico(s.getPosX(), s.getPosY(), (Lugar) listaLugares.get(objetivo));
						listaDibujar.add(b);
					}
				}
			}
		}
	}

	/**
	 * @see verExplosiones Procedimiento para incluir objetos Explosion en la
	 *      lista que se dibuja en el mapa
	 * @param listaDibujar
	 *            Lista que se dibuja en el mapa
	 */
	private static void verExplosiones(List<Personaje> listaDibujar) {
		for (int i = 0; i < listaDibujar.size(); i++) {
			if (listaDibujar.get(i).exploto == true) {
				listaDibujar.add(listaDibujar.get(i).explotar());
			}
		}
	}

	/**
	 * @see verColisiones Procedimiento para ver las colisiones que se pueden
	 *      producir en el juego
	 * @param listaDibujar
	 *            Lista que se dibuja en el mapa
	 */
	private static void verColisiones(List<Personaje> listaDibujar) {
		List<Personaje> listaExplotar = new ArrayList<>();
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

	/**
	 * @see achicarAgrandarExplosiones Procedimiento que sirve para modificar el
	 *      radio de las explosiones
	 * @param listaDibujar
	 *            Lista que se dibuja en el mapa
	 */
	private static void achicarAgrandarExplosiones(List<Personaje> listaDibujar) {
		for (int i = 0; i < listaDibujar.size(); i++) {
			if (listaDibujar.get(i) instanceof Explosion) {
				Explosion e = (Explosion) listaDibujar.get(i);
				if (!(e.isTerminoExplosion())) {
					if (e.isCreciendo()) {
						e.agrandarRadio();
					} else {
						e.achicarRadio();
					}
				} else {
					listaDibujar.remove(i);
				}
			}
		}

	}

	/**
	 * @see agregarLugares Procedimiento que sirve para agregar lugares al mapa
	 * @param listaDibujar
	 *            Lista que se dibuja en el mapa
	 * @param listaLugares
	 *            Lista que representa a los lugares dentro del mapa
	 */
	private static void agregarLugares(List<Personaje> listaDibujar, List<Personaje> listaLugares) {
		// Primera porcion de mapa
		Lugar l1 = new Silo(2, 0,EstadoSilo.LIVE);
		listaDibujar.add(l1);
		listaLugares.add(l1);
		Lugar l2 = new Ciudad(65, 0);
		listaDibujar.add(l2);
		listaLugares.add(l2);
		Lugar l3 = new Ciudad(130, 0);
		listaDibujar.add(l3);
		listaLugares.add(l3);
		// Segunda porcion de mapa
		Lugar l4 = new Ciudad(195, 0);
		listaDibujar.add(l4);
		listaLugares.add(l4);
		Lugar l5 = new Silo(260, 0,EstadoSilo.LIVE);
		listaDibujar.add(l5);
		listaLugares.add(l5);
		Lugar l6 = new Ciudad(325, 0);
		listaDibujar.add(l6);
		listaLugares.add(l6);
		// tercera porcion de mapa
		Lugar l7 = new Ciudad(390, 0);
		listaDibujar.add(l7);
		listaLugares.add(l7);
		Lugar l8 = new Ciudad(455, 0);
		listaDibujar.add(l8);
		listaLugares.add(l8);
		Lugar l9 = new Silo(523, 0,EstadoSilo.LIVE);
		listaDibujar.add(l9);
		listaLugares.add(l9);
	}

	/**
	 * @see lanzarMisiles Procedimiento que sirve para lanzar misiles balisticos
	 * @param listaDibujar
	 *            Lista que se dibuja en el mapa
	 * @param listaLugares
	 *            Lista que representa a los lugares dentro del mapa
	 */
	private static void lanzarMisiles(List<Personaje> listaDibujar, List<Personaje> listaLugares) {
		int numero = (int) (Math.random() * 5) + 12; // cantidad de misiles en
		// la oleada

		for (int i = 0; i < numero; i++) {
			int objetivo = (int) (Math.random() * 8);
			Balistico b = new Balistico((int) (Math.random() * 525), 480, (Lugar) listaLugares.get(objetivo));
			listaDibujar.add(b);
		}
	}

	/**
	 * @see lanzarAntibalisticos Procedimiento que sirve para lanzar misiles
	 *      antibalisticos
	 * @param listaDibujar
	 *            Lista que se dibuja en el mapa
	 * @param listaLugares
	 *            Lista que representa a los lugares dentro del mapa
	 */
	private static void lanzarAntibalisticos(List<Personaje> listaDibujar, List<Personaje> listaLugares) {
		Antibalistico a1 = new Antibalistico(2, 0, 50, 240);
		listaDibujar.add(a1);
		Antibalistico a2 = new Antibalistico(2, 0, 100, 240);
		listaDibujar.add(a2);
		Antibalistico a3 = new Antibalistico(2, 0, 150, 240);
		listaDibujar.add(a3);
		Antibalistico a4 = new Antibalistico(260, 0, 200, 240);
		listaDibujar.add(a4);
		Antibalistico a5 = new Antibalistico(260, 0, 250, 240);
		listaDibujar.add(a5);
		Antibalistico a6 = new Antibalistico(260, 0, 300, 240);
		listaDibujar.add(a6);
		Antibalistico a7 = new Antibalistico(523, 0, 350, 240);
		listaDibujar.add(a7);
		Antibalistico a8 = new Antibalistico(523, 0, 400, 240);
		listaDibujar.add(a8);
		Antibalistico a9 = new Antibalistico(523, 0, 500, 240);
		listaDibujar.add(a9);
	}

	/**
	 * @see crearNivel Procedimiento que sirve para crear los niveles del juego
	 * @param nivel
	 *            Representa al nivel al cual se quiere crear
	 * @param listaDibujar
	 *            Lista que se dibuja en el mapa
	 * @param listaLugares
	 *            Lista que representa a los lugares dentro del mapa
	 */
	private static void crearNivel(int nivel, List<Personaje> listaDibujar, List<Personaje> listaLugares) {
		// int puntaje;

		switch (nivel) {
		case 1: {
			System.out.println("Nivel 1");
			agregarLugares(listaDibujar, listaLugares);
			lanzarMisiles(listaDibujar, listaLugares);
			lanzarAntibalisticos(listaDibujar, listaLugares);
			int tiempoTonto = (int) (Math.random() * 500);
			for (int i = 0; i < 1000; i++) {
				if (i == tiempoTonto) {
					int objetivo = (int) (Math.random() * 8);
					CruceroTonto t = new CruceroTonto((int) (Math.random() * 525), 480,
							(Lugar) listaLugares.get(objetivo));
					listaDibujar.add(t);
				}

				moverPersonajes(listaDibujar, listaLugares, i);
				verExplosiones(listaDibujar);
				achicarAgrandarExplosiones(listaDibujar);
				verColisiones(listaDibujar);
			}

			System.out.println("Fin del Nivel 1");
			// System.out.println("Tu puntaje fue de: "+puntaje);
			break;
		}
		case 2: {
			System.out.println("Nivel 2");
			agregarLugares(listaDibujar, listaLugares);
			lanzarMisiles(listaDibujar, listaLugares);
			lanzarAntibalisticos(listaDibujar, listaLugares);

			int tiempoTonto = (int) (Math.random() * 500);
			int tiempoAvion = (int) (Math.random() * 700);
			int tiempoSat = (int) (Math.random() * 700);
			for (int i = 0; i < 1000; i++) {
				if (i == tiempoTonto) {
					int objetivo = (int) (Math.random() * 8);
					CruceroTonto t = new CruceroTonto((int) (Math.random() * 525), 480,
							(Lugar) listaLugares.get(objetivo));
					listaDibujar.add(t);
				}
				if ((i == tiempoAvion) && (tiempoAvion < 500)) {
					int dirAvion = (int) (Math.random() * 1);
					Avion a;
					if (dirAvion == 0)
						a = new Avion(0, 380);
					else
						a = new Avion(525, 380);
					listaDibujar.add(a);
				}
				if ((i == tiempoSat) && (tiempoSat < 500)) {
					int dirSat = (int) (Math.random() * 1);
					Satelite s;
					if (dirSat == 0)
						s = new Satelite(0, 380);
					else
						s = new Satelite(525, 380);
					listaDibujar.add(s);
				}

				moverPersonajes(listaDibujar, listaLugares, i);
				verExplosiones(listaDibujar);
				achicarAgrandarExplosiones(listaDibujar);
				verColisiones(listaDibujar);
			}

			System.out.println("Fin del Nivel 2");
			// System.out.println("Tu puntaje fue de: "+puntaje);
			break;
		}
		case 3: {
			System.out.println("Nivel 3");
			agregarLugares(listaDibujar, listaLugares);
			lanzarMisiles(listaDibujar, listaLugares);
			lanzarAntibalisticos(listaDibujar, listaLugares);

			int tiempoInteligente = (int) (Math.random() * 700);
			int tiempoAvion = (int) (Math.random() * 700);
			int tiempoSat = (int) (Math.random() * 700);
			for (int i = 0; i < 1000; i++) {
				if (i == tiempoInteligente) {
					int objetivo = (int) (Math.random() * 8);
					CruceroInteligente cInt = new CruceroInteligente((int) (Math.random() * 525), 480,
							(Lugar) listaLugares.get(objetivo));
					listaDibujar.add(cInt);
				}
				if ((i == tiempoAvion) && (tiempoAvion < 500)) {
					int dirAvion = (int) (Math.random() * 1);
					Avion a;
					if (dirAvion == 0)
						a = new Avion(0, 350);
					else
						a = new Avion(525, 350);
					listaDibujar.add(a);
				}
				if ((i == tiempoSat) && (tiempoSat < 500)) {
					int dirSat = (int) (Math.random() * 1);
					Satelite s;
					if (dirSat == 0)
						s = new Satelite(0, 350);
					else
						s = new Satelite(525, 350);
					listaDibujar.add(s);
				}

				moverPersonajes(listaDibujar, listaLugares, i);
				verExplosiones(listaDibujar);
				achicarAgrandarExplosiones(listaDibujar);
				verColisiones(listaDibujar);
			}

			System.out.println("Fin del Nivel 3");
			// System.out.println("Tu puntaje fue de: "+puntaje);
			break;
		}
		default:
			break;
		}
	}
}