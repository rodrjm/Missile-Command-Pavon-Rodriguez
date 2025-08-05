package modelos.enemigos;

import modelos.lugares.Lugar;
import modelos.personajes.Explosion;

/**
 * @see CruceroInteligente Clase que representa a los cruceros inteligentes
 *      dentro del juego
 */
public class CruceroInteligente extends Misil {

	int radioRadar = 5;

	/**
	 * @see CruceroInteligente Constructor de crucero inteligente
	 * @param x
	 *            Representa la posición en X en el mapa
	 * @param y
	 *            Representa la posición en Y en el mapa
	 * @param obj
	 *            Representa el objetivo al cual va dirigido el crucero
	 *            inteligente
	 */
	public CruceroInteligente(int x, int y, Lugar obj) {
		super(x, y, obj, 1);
	}

	public int getRadioRadar() {
		return radioRadar;
	}

	/**
	 * @see detectarExplosion Funcion que sirve para que el sensor de el crucero
	 *      inteligente detecte explosiones cerca suyo
	 * @param e
	 *            Objeto que representa a la explosion a esquivar
	 * @return Returna true en caso de que haya una explosión en el sensor, y
	 *         false en caso de que no
	 */
	public boolean detectarExplosion(Explosion e) {
		if (this.getPosY() > e.getPosY()) {
			if (this.distancia(this.getPosX(), this.getPosY(), e.getPosX(),
					e.getPosY()) < (this.getRadioRadar() + e.getRadio()))
				return true;
		}
		return false;
	}

	/**
	 * @see mover Procedimiento para mover un crucero inteligente a la posición
	 *      del objetivo
	 */
	public void mover() {
		double nuevoX, nuevoY;
		float posFinalX = this.getObjetivo().getPosX();
		float posFinalY = this.getObjetivo().getPosY();
		if (!((this.getObjetivo().getPosX() == this.getPosX()) && (this.getObjetivo().getPosY() == this.getPosY()))) {// verifica
			// que
			// no
			// llego
			// al
			// objetivo
			if (posFinalX == this.getPosX()) { // En caso de que la posiciï¿½n
												// en X
												// no
												// se modifique, se va a mover
												// una
												// unidad de posiciï¿½n en Y

				nuevoX = this.getPosX();
				if (posFinalY < this.getPosY()) {
					nuevoY = this.getPosY() - 1;

				} else {
					nuevoY = this.getPosY() + 1;

				}
			}

			else if (posFinalY == this.getPosY()) { // En caso de que la
													// posiciï¿½n
													// en
													// Y no se modifique, se va
													// a
													// mover una unidad de
													// posiciï¿½n en X
				nuevoY = this.getPosY();
				if (posFinalX < this.getPosX()) {
					nuevoX = this.getPosX() - 1;

				} else {
					nuevoX = this.getPosX() + 1;
				}
			} else { // En caso de que ambas posiciones se modifiquen, se mueve
						// una
						// unidad de posiciï¿½n en X y lo que corresponda en Y
				if (posFinalX < this.getPosX()) {
					nuevoX = this.getPosX() - 1;
				} else {
					nuevoX = this.getPosX() + 1;
				}

				nuevoY = (((nuevoX - this.getPosX()) / (posFinalX - this.getPosX())) * (posFinalY - this.getPosY()))
						+ (this.getPosY());
			}

			super.setPos((int) nuevoX, (int) nuevoY);
		}
		if ((this.getObjetivo().getPosX() == this.getPosX()) && (this.getObjetivo().getPosY() == this.getPosY())) {// verifica
			// si
			// llego
			// al
			// objetivo
			// y
			// lo
			// explota
			this.setExploto(true);
		}
	}

	/**
	 * @see moverIzqDer Procedimiento que mueve al crucero inteligente hacia la
	 *      izquierda o derecha para esquivar una explosión
	 */
	public void moverIzqDer() {
		int dir = (int) (Math.random() * 1);
		if (dir == 0) {
			super.setPos(this.getPosX() + 1, this.getPosY());
		} else
			super.setPos(this.getPosX() - 1, this.getPosY());
	}
}
