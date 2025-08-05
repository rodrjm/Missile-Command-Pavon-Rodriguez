package enemigos;

import lugares.Lugar;

/**
 * @see CruceroTonto Clase que representa a los cruceros tontos dentro del juego
 */
public class CruceroTonto extends Misil {

	/**
	 * @see CruceroTonto Constructor de crucero tonto
	 * @param x   Representa la posición en X en el mapa
	 * @param y   Representa la posición en Y en el mapa
	 * @param obj Representa el objetivo al cual va dirigido el crucero tonto
	 */
	public CruceroTonto(int x, int y, Lugar obj) {
		super(x, y, obj, 't', 1);
	}

	/**
	 * @see mover Procedimiento para mover un crucero tonto a la posición del
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
			if (posFinalX == this.getX()) { // En caso de que la posición en X
											// no
											// se modifique, se va a mover una
											// unidad de posición en Y

				nuevoX = this.getX();
				if (posFinalY < this.getY()) {
					nuevoY = this.getY() - 1;

				} else {
					nuevoY = this.getY() + 1;

				}
			}

			else if (posFinalY == this.getY()) { // En caso de que la posición
													// en
													// Y no se modifique, se va
													// a
													// mover una unidad de
													// posición en X
				nuevoY = this.getY();
				if (posFinalX < this.getX()) {
					nuevoX = this.getX() - 1;

				} else {
					nuevoX = this.getX() + 1;
				}
			} else { // En caso de que ambas posiciones se modifiquen, se mueve
						// una
						// unidad de posición en X y lo que corresponda en Y
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
		if ((this.getObjetivo().getX() == this.getX()) && (this.getObjetivo().getY() == this.getY())) { // Verifica
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
	@Override
	public boolean esCruceroTonto(){
		return true;
	}
}
