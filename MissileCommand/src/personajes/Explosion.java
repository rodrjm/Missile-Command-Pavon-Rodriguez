package personajes;

import java.util.ArrayList;
import java.util.List;

import enemigos.CruceroInteligente;

/**
 * @see Explosion Clase que representa las explosiones dentro del juego
 */
public class Explosion extends Personaje {
	boolean creciendo;
	int radioMaximo = 20;
	boolean terminoExplosion;
	int radio;
	public Explosion(int x, int y) {
		super(x, y, 'E', 1);
		creciendo = true;
		exploto = false;
		terminoExplosion = false;
	
	}

	@Override
	public void setExploto(boolean exploto) {
		this.exploto = false;
	}

	public boolean isTerminoExplosion() {
		return terminoExplosion;
	}

	public void setTerminoExplosion(boolean terminoExplosion) {
		this.terminoExplosion = terminoExplosion;
	}

	public boolean isCreciendo() {
		return creciendo;
	}

	public void setCreciendo(boolean creciendo) {
		this.creciendo = creciendo;
	}

	/**
	 * @see achicarRadio Procedimiento que sirve para achicar el radio de la
	 *      explosión
	 */
	public void achicarRadio() {
		this.setRadio(this.getRadio() - 1);
		if (this.getRadio() == 0) {
			this.setTerminoExplosion(true);
		}
	}

	/**
	 * @see agrandarRadio Procedimiento que sirve para agrandar el radio de la
	 *      explosión
	 */
	public void agrandarRadio() {
		this.setRadio(this.getRadio() + 1);
		if (this.getRadio() == this.radioMaximo) {
			this.setCreciendo(false);
		}
	}
	/**
	 * @see achicarAgrandarExplosiones Procedimiento que sirve para modificar el
	 *      radio de las explosiones
	 * @param listaDibujar Lista que se dibuja en el mapa
	 */
	public static void achicarAgrandarExplosiones(List<Personaje> listaDibujar) {
		for (int i = 0; i < listaDibujar.size(); i++) {
			if (listaDibujar.get(i).esExplosion()) {
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
	 * @see verExplosiones Procedimiento para incluir objetos Explosion en la lista
	 *      que se dibuja en el mapa
	 * @param listaDibujar Lista que se dibuja en el mapa
	 */
	public static void verExplosiones(List<Personaje> listaDibujar) {
		for (int i = 0; i < listaDibujar.size(); i++) {
			if (listaDibujar.get(i).exploto == true) {
				listaDibujar.add(listaDibujar.get(i).explotar());
			}
		}
	}
	/**
	 * @see verColisiones Procedimiento para ver las colisiones que se pueden
	 *      producir en el juego
	 * @param listaDibujar Lista que se dibuja en el mapa
	 */
	public static void verColisiones(List<Personaje> listaDibujar) {
		List<Personaje> listaExplotar = new ArrayList<>();
		for (int i = 0; i < listaDibujar.size(); i++) {
			Personaje p1 = (Personaje) listaDibujar.get(i);
			for (int j = 0; j < listaDibujar.size(); j++) {
				if (i != j) {
					Personaje p2 = (Personaje) listaDibujar.get(j);
					if ((p1.esCruceroInteligente()) && (p2.esExplosion())) {
						Explosion e = (Explosion) p2;
						CruceroInteligente c = (CruceroInteligente) p1;
						if (c.detectarExplosion(e)) {
							c.moverIzqDer();
						}
					}
					if (p1.colision(p2)) {
						if ((p1.esExplosion()) && !(p2.esExplosion())) {
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
	@Override
	public boolean esExplosion(){
		return true;
	}

}
