package enemigos;

import lugares.Lugar;
import personajes.Explosion;

/**
 * @see CruceroInteligente Clase que representa a los cruceros inteligentes
 *      dentro del juego
 */
public class CruceroInteligente extends Misil {

	int radioRadar = 5;

	/**
	 * @see CruceroInteligente Constructor de crucero inteligente
	 * @param x   Representa la posición en X en el mapa
	 * @param y   Representa la posición en Y en el mapa
	 * @param obj Representa el objetivo al cual va dirigido el crucero inteligente
	 */
	public CruceroInteligente(int x, int y, Lugar obj) {
		super(x, y, obj, 'i', 1);
	}

	public int getRadioRadar() {
		return radioRadar;
	}

	/**
	 * @see detectarExplosion Funcion que sirve para que el sensor de el crucero
	 *      inteligente detecte explosiones cerca suyo
	 * @param e Objeto que representa a la explosion a esquivar
	 * @return Returna true en caso de que haya una explosión en el sensor, y false
	 *         en caso de que no
	 */
	public boolean detectarExplosion(Explosion e) {
		if (this.getY() > e.getY()) {
			if (this.distancia(this.getX(), this.getY(), e.getX(), e.getY()) < (this.getRadioRadar() + e.getRadio()))
				return true;
		}
		return false;
	}

	/**
	 * @see mover Procedimiento para mover un crucero inteligente a la posición del
	 *      objetivo
	 */
	public void mover() {
		double nuevoX, nuevoY;
		int posFinalX = this.getObjetivo().getX();
		int posFinalY = this.getObjetivo().getY();
		if (!((this.getObjetivo().getX() == this.getX()) && (this.getObjetivo().getY() == this.getY()))) {// verifica
																											// que
																											// no
																											// llego
																											// al
																											// objetivo
			if (posFinalX == this.getX()) { // En caso de que la posiciï¿½n en X
											// no
											// se modifique, se va a mover una
											// unidad de posiciï¿½n en Y

				nuevoX = this.getX();
				if (posFinalY < this.getY()) {
					nuevoY = this.getY() - 1;

				} else {
					nuevoY = this.getY() + 1;

				}
			}

			else if (posFinalY == this.getY()) { // En caso de que la posiciï¿½n
													// en
													// Y no se modifique, se va
													// a
													// mover una unidad de
													// posiciï¿½n en X
				nuevoY = this.getY();
				if (posFinalX < this.getX()) {
					nuevoX = this.getX() - 1;

				} else {
					nuevoX = this.getX() + 1;
				}
			} else { // En caso de que ambas posiciones se modifiquen, se mueve
						// una
						// unidad de posiciï¿½n en X y lo que corresponda en Y
				if (posFinalX < this.getX()) {
					nuevoX = this.getX() - 1;
				} else {
					nuevoX = this.getX() + 1;
				}

				nuevoY = (((nuevoX - this.getX()) / (posFinalX - this.getX())) * (posFinalY - this.getY()))
						+ (this.getY());
			}

			super.setPos((int) nuevoX, (int) nuevoY);
		}
		if ((this.getObjetivo().getX() == this.getX()) && (this.getObjetivo().getY() == this.getY())) {// verifica
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
			super.setPos(this.getX() + 1, this.getY());
		} else
			super.setPos(this.getX() - 1, this.getY());
	}
	@Override
	public boolean esCruceroInteligente(){
		return true;
	}
}
