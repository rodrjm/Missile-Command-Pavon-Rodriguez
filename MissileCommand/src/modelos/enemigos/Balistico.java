package modelos.enemigos;

import juego.Escenario;
import modelos.lugares.Lugar;
import vistas.Entorno;

/**
 * @see Balistico Clase que representa a los misiles balisticos dentro del juego
 */
public class Balistico extends Misil {

	/**
	 * @see Balistico Constructor de misil balistico
	 * @param x
	 *            Representa la posición en X en el mapa
	 * @param y
	 *            Representa la posición en Y en el mapa
	 * @param objetivo
	 *            Representa el objetivo al cual va dirigido el misil
	 */
	public Balistico(float x, float y, Lugar objetivo) {
		super(x, y, objetivo, 1);
	}

	/**
	 * @see mover Procedimiento para mover un misil balistico a la posición del
	 *      objetivo
	 */
	public void mover() {

		double nuevoX, nuevoY;
		float posFinalX = this.getObjetivo().getPosX();
		float posFinalY = this.getObjetivo().getPosY();

		int vel = 2;
		int i = 0;
		while ((i < vel) && !(this.exploto)) {
			i++;
			Escenario.getInstancia().vaciarPosicion(this);
			if (posFinalX == this.getPosX()) { // En caso de que la posición en
												// X no
												// se
												// modifique, se va a mover una
												// unidad
												// de
												// posición en Y
				nuevoX = this.getPosX();
				if (posFinalY < this.getPosY())
					nuevoY = this.getPosY() - 1;
				else
					nuevoY = this.getPosY() + 1;
			} else if (posFinalY == this.getPosY()) { // En caso de que la
														// posición
														// en
														// Y no se modifique, se
														// va
														// a
														// mover una
														// unidad de posición en
														// X
				nuevoY = this.getPosY();
				if (posFinalX < this.getPosX())
					nuevoX = this.getPosX() - 1;
				else
					nuevoX = this.getPosX() + 1;
			} else { // En caso de que ambas posiciones se modifiquen, se mueve
						// una
						// unidad de
						// posición en Y y lo que corresponda en X
				if (posFinalX < this.getPosX())
					nuevoX = this.getPosX() - 1;
				else
					nuevoX = this.getPosX() + 1;

				// nuevoX = (nuevoY - this.getPosY());
				// nuevoX = (nuevoX * (posFinalX - this.getPosX()));
				// nuevoX = (nuevoX / (posFinalY - this.getPosY()));
				// nuevoX = (nuevoX + this.getPosX());

				nuevoY = (((nuevoX - this.getPosX()) * ((posFinalY - this.getPosY()) / (posFinalX - this.getPosX())))
						+ this.getPosY());
			}

			super.setPos((int) nuevoX, (int) nuevoY);

			Escenario.getInstancia().setPersonaje(this);
			if ((posFinalX == this.getPosX()) && (posFinalY == this.getPosY())) { // verifica
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
}
