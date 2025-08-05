package modelos.enemigos;

import modelos.lugares.Lugar;

/**
 * @see CruceroTonto Clase que representa a los cruceros tontos dentro del juego
 */
public class CruceroTonto extends Misil {

	/**
	 * @see CruceroTonto Constructor de crucero tonto
	 * @param x
	 *            Representa la posición en X en el mapa
	 * @param y
	 *            Representa la posición en Y en el mapa
	 * @param obj
	 *            Representa el objetivo al cual va dirigido el crucero tonto
	 */
	public CruceroTonto(int x, int y, Lugar obj) {
		super(x, y, obj, 1);
	}

	/**
	 * @see mover Procedimiento para mover un crucero tonto a la posición del
	 *      objetivo
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
			if (posFinalX == this.getPosX()) { // En caso de que la posición en
												// X
												// no
												// se modifique, se va a mover
												// una
												// unidad de posición en Y

				nuevoX = this.getPosX();
				if (posFinalY < this.getPosY()) {
					nuevoY = this.getPosY() - 1;

				} else {
					nuevoY = this.getPosY() + 1;

				}
			}

			else if (posFinalY == this.getPosY()) { // En caso de que la
													// posición
													// en
													// Y no se modifique, se va
													// a
													// mover una unidad de
													// posición en X
				nuevoY = this.getPosY();
				if (posFinalX < this.getPosX()) {
					nuevoX = this.getPosX() - 1;

				} else {
					nuevoX = this.getPosX() + 1;
				}
			} else { // En caso de que ambas posiciones se modifiquen, se mueve
						// una
						// unidad de posición en X y lo que corresponda en Y
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
		if ((this.getObjetivo().getPosX() == this.getPosX()) && (this.getObjetivo().getPosY() == this.getPosY())) { // Verifica
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
}
