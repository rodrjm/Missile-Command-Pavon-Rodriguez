package juego;

import java.util.ArrayList;

import java.util.List;

import enemigos.Avion;
import enemigos.Balistico;
import enemigos.CruceroInteligente;
import enemigos.CruceroTonto;
import enemigos.Satelite;
import lugares.Ciudad;
import lugares.Lugar;
import lugares.Silo;
import personajes.Antibalistico;
import personajes.Explosion;
import personajes.Personaje;
import taller2.modelo.Graficador;

/**
 * @see Juego Clase main del juego
 */
public class Juego {
	public static List<Personaje> listaDibujar = new ArrayList<>();

	// public static List<Personaje> listaLugares= new ArrayList<>();
	/**
	 * @see vaciarListas Procedimiento que vacía listas de lugares y la lista
	 *      que se dibuja en el mapa
	 * @param listaDibujar
	 *            Lista que se dibuja en el mapa
	 * @param listaLugares
	 *            Lista que representa a los lugares dentro del mapa
	 */
	public static void vaciarListas(List<Personaje> listaDibujar, List<Personaje> listaLugares) {
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
			if ((listaDibujar.get(i).esPersonaje()) && (!(listaDibujar.get(i).esLugar()))
					&& (!(listaDibujar.get(i).esExplosion()))) {
				listaDibujar.get(i).mover();
				if (listaDibujar.get(i).esBalistico()) {
					Balistico b = (Balistico) listaDibujar.get(i);
					if (!b.esBifurcado()) {
						b.bifurcar(b, listaLugares);
					}
				}
			}
			if (listaDibujar.get(i).esAvion()) {
				Avion a = (Avion) listaDibujar.get(i);
				for (int k = 0; k < a.getTiempoMisiles().length; k++) {
					if (a.getTiempoMisiles()[k] == j) {
						a.lanzarMisil(listaLugares);
					}
				}
			}
			if (listaDibujar.get(i).esSatelite()) {
				Satelite s = (Satelite) listaDibujar.get(i);
				for (int k = 0; k < s.getTiempoMisiles().length; k++) {
					if (s.getTiempoMisiles()[k] == j) {
						s.lanzarMisil(listaLugares);
					}
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
	public static void agregarLugares(List<Personaje> listaDibujar, List<Personaje> listaLugares) {
		// Primera porcion de mapa
		Lugar l1 = new Silo(2, 0);
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
		Lugar l5 = new Silo(260, 0);
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
		Lugar l9 = new Silo(523, 0);
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
	public static void lanzarAntibalisticos(List<Personaje> listaDibujar, List<Personaje> listaLugares) {
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

	public static void crearNivel(int nivel, List<Personaje> listaDibujar, List<Personaje> listaLugares) {
		// int puntaje;

		System.out.println("Nivel " + nivel);
		int[] aVar = new int[10];
		// aVar[0] = (int) (Math.random() * 80) + 80; // Tiempo segunda oleada
		// misiles
		// aVar[1] = (int) (Math.random() * 80) + 160; // Tiempo tercera oleada
		// misiles
		// aVar[2] = (int) (Math.random() * 80) + 240; // Tiempo cuarta oleada
		// misiles
		aVar[3] = (int) (Math.random() * 500); // Tiempo crucero tonto
		aVar[4] = (int) (Math.random() * 700); // Tiempo avion
		aVar[5] = (int) (Math.random() * 700); // Tiempo satelite
		aVar[6] = (int) (Math.random() * 200) + 280; // Posicion de bifurcacion
		aVar[7] = (int) (Math.random() * 700); // Tiempo crucero inteligente

		boolean var = false;
		int[] aNivel = { 1, 2, 5, 6, 9, 10, 13, 14 };
		for (int i = 0; i < aNivel.length; i++) {
			if (nivel == aNivel[i]) {
				var = true;
				break;
			}
		}

		agregarLugares(listaDibujar, listaLugares);
		lanzarMisiles(listaDibujar, listaLugares);
		lanzarAntibalisticos(listaDibujar, listaLugares);
		for (int i = 0; i < 1000; i++) {
			if (var) {
				if (nivel == 1) {
					// acciones que se realizan en el nivel 1
					if (i == aVar[3]) {
						int objetivo = (int) (Math.random() * 8);
						CruceroTonto t = new CruceroTonto((int) (Math.random() * 525), 480,
								(Lugar) listaLugares.get(objetivo));
						listaDibujar.add(t);
					}
				} else {
					// acciones que se realizan en los niveles 2,5,6,9,10,13,14
					if (i == aVar[3]) {
						int objetivo = (int) (Math.random() * 8);
						CruceroTonto t = new CruceroTonto((int) (Math.random() * 525), 480,
								(Lugar) listaLugares.get(objetivo));
						listaDibujar.add(t);
					}
					if ((i == aVar[4]) && (aVar[4] < 500)) {
						int dirAvion = (int) (Math.random() * 1);
						Avion a;
						if (dirAvion == 0)
							a = new Avion(0, 380);
						else
							a = new Avion(525, 380);
						listaDibujar.add(a);
					}
					if ((i == aVar[5]) && (aVar[5] < 500)) {
						int dirSat = (int) (Math.random() * 1);
						Satelite s;
						if (dirSat == 0)
							s = new Satelite(0, 380);
						else
							s = new Satelite(525, 380);
						listaDibujar.add(s);
					}
				}
			} else {
				// acciones que se realizan en los niveles 3,4,7,8,11,12,15,16
				if ((i == aVar[4]) && (aVar[4] < 500)) {
					int dirAvion = (int) (Math.random() * 1);
					Avion a;
					if (dirAvion == 0)
						a = new Avion(0, 300);
					else
						a = new Avion(525, 300);
					listaDibujar.add(a);
				}
				if ((i == aVar[5]) && (aVar[5] < 500)) {
					int dirSat = (int) (Math.random() * 1);
					Satelite s;
					if (dirSat == 0)
						s = new Satelite(0, 300);
					else
						s = new Satelite(525, 300);
					listaDibujar.add(s);
				}
				if (i == aVar[7]) {
					int objetivo = (int) (Math.random() * 8);
					CruceroInteligente cInt = new CruceroInteligente((int) (Math.random() * 525), 480,
							(Lugar) listaLugares.get(objetivo));
					listaDibujar.add(cInt);
				}
			}
			moverPersonajes(listaDibujar, listaLugares, i);
			Explosion.verExplosiones(listaDibujar);
			Explosion.achicarAgrandarExplosiones(listaDibujar);
			Explosion.verColisiones(listaDibujar);
			Graficador.refrescarDownTop(listaDibujar, 100);
		}

		System.out.println("Fin del Nivel " + nivel);
		// // int puntaje;
		//
		// switch (nivel) {
		// case 1: {
		// System.out.println("Nivel 1");
		// agregarLugares(listaDibujar, listaLugares);
		// lanzarMisiles(listaDibujar, listaLugares);
		// lanzarAntibalisticos(listaDibujar, listaLugares);
		// int tiempoTonto = (int) (Math.random() * 500);
		// for (int i = 0; i < 1000; i++) {
		// if (i == tiempoTonto) {
		// int objetivo = (int) (Math.random() * 8);
		// CruceroTonto t = new CruceroTonto((int) (Math.random() * 525), 480,
		// (Lugar) listaLugares.get(objetivo));
		// listaDibujar.add(t);
		// }
		//
		// moverPersonajes(listaDibujar, listaLugares, i);
		// Explosion.verExplosiones(listaDibujar);
		// Explosion.achicarAgrandarExplosiones(listaDibujar);
		// Explosion.verColisiones(listaDibujar);
		// Graficador.refrescarDownTop(listaDibujar, 100);
		// }
		//
		// System.out.println("Fin del Nivel 1");
		// // System.out.println("Tu puntaje fue de: "+puntaje);
		// break;
		// }
		// case 2: {
		// System.out.println("Nivel 2");
		// agregarLugares(listaDibujar, listaLugares);
		// lanzarMisiles(listaDibujar, listaLugares);
		// lanzarAntibalisticos(listaDibujar, listaLugares);
		//
		// int tiempoTonto = (int) (Math.random() * 500);
		// int tiempoAvion = (int) (Math.random() * 700);
		// int tiempoSat = (int) (Math.random() * 700);
		// for (int i = 0; i < 1000; i++) {
		// if (i == tiempoTonto) {
		// int objetivo = (int) (Math.random() * 8);
		// CruceroTonto t = new CruceroTonto((int) (Math.random() * 525), 480,
		// (Lugar) listaLugares.get(objetivo));
		// listaDibujar.add(t);
		// }
		// if ((i == tiempoAvion) && (tiempoAvion < 500)) {
		// int dirAvion = (int) (Math.random() * 1);
		// Avion a;
		// if (dirAvion == 0)
		// a = new Avion(0, 380);
		// else
		// a = new Avion(525, 380);
		// listaDibujar.add(a);
		// }
		// if ((i == tiempoSat) && (tiempoSat < 500)) {
		// int dirSat = (int) (Math.random() * 1);
		// Satelite s;
		// if (dirSat == 0)
		// s = new Satelite(0, 380);
		// else
		// s = new Satelite(525, 380);
		// listaDibujar.add(s);
		// }
		//
		// moverPersonajes(listaDibujar, listaLugares, i);
		// Explosion.verExplosiones(listaDibujar);
		// Explosion.achicarAgrandarExplosiones(listaDibujar);
		// Explosion.verColisiones(listaDibujar);
		// Graficador.refrescarDownTop(listaDibujar, 100);
		// }
		//
		// System.out.println("Fin del Nivel 2");
		// // System.out.println("Tu puntaje fue de: "+puntaje);
		// break;
		// }
		// case 3: {
		// System.out.println("Nivel 3");
		// agregarLugares(listaDibujar, listaLugares);
		// lanzarMisiles(listaDibujar, listaLugares);
		// lanzarAntibalisticos(listaDibujar, listaLugares);
		//
		// int tiempoInteligente = (int) (Math.random() * 700);
		// int tiempoAvion = (int) (Math.random() * 700);
		// int tiempoSat = (int) (Math.random() * 700);
		// for (int i = 0; i < 1000; i++) {
		// if (i == tiempoInteligente) {
		// int objetivo = (int) (Math.random() * 8);
		// CruceroInteligente cInt = new CruceroInteligente((int) (Math.random()
		// * 525), 480,
		// (Lugar) listaLugares.get(objetivo));
		// listaDibujar.add(cInt);
		// }
		// if ((i == tiempoAvion) && (tiempoAvion < 500)) {
		// int dirAvion = (int) (Math.random() * 1);
		// Avion a;
		// if (dirAvion == 0)
		// a = new Avion(0, 350);
		// else
		// a = new Avion(525, 350);
		// listaDibujar.add(a);
		// }
		// if ((i == tiempoSat) && (tiempoSat < 500)) {
		// int dirSat = (int) (Math.random() * 1);
		// Satelite s;
		// if (dirSat == 0)
		// s = new Satelite(0, 350);
		// else
		// s = new Satelite(525, 350);
		// listaDibujar.add(s);
		// }
		//
		// moverPersonajes(listaDibujar, listaLugares, i);
		// Explosion.verExplosiones(listaDibujar);
		// Explosion.achicarAgrandarExplosiones(listaDibujar);
		// Explosion.verColisiones(listaDibujar);
		// Graficador.refrescarDownTop(listaDibujar, 100);
		// }
		//
		// System.out.println("Fin del Nivel 3");
		//
		// break;
		// }
		// default:
		// break;
		// }
	}
}