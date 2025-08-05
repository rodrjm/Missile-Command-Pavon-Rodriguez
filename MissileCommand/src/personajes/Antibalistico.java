package personajes;

/**
 * @see Antibalistico Clases que representa los misiles antibalisticos dentro
 *      del juego
 */
public class Antibalistico extends Personaje {

	private int posFinalX;
	private int posFinalY;

	/**
	 * @see Antibalistico Constructor de misil antibalístico
	 * @param x      Representa la posición en X en el mapa
	 * @param y      Representa la posición en Y en el mapa
	 * @param finalX Representa la posición en X a la cual se dirige el misil
	 * @param finalY Representa la posición en Y a la cual se dirige el misil
	 */
	public Antibalistico(int x, int y, int finalX, int finalY) {
		super(x, y, 'A', 0);
		this.posFinalX = finalX;
		this.posFinalY = finalY;
	}

	/**
	 * @see mover Procedimiento para mover un misil antibalístico
	 */
	public void mover() {
		double nuevoX, nuevoY;

		if (posFinalX == this.getX()) { // En caso de que la posición en X no se modifique, se va a mover una unidad de
										// posición en Y
			nuevoX = this.getX();
			if (posFinalY < this.getY())
				nuevoY = this.getY() - 1;
			else
				nuevoY = this.getY() + 1;
		} else if (posFinalY == this.getY()) { // En caso de que la posición en Y no se modifique, se va a mover una
												// unidad de posición en X
			nuevoY = this.getY();
			if (posFinalX < this.getX())
				nuevoX = this.getX() - 1;
			else
				nuevoX = this.getX() + 1;
		} else { // En caso de que ambas posiciones se modifiquen, se mueve una unidad de
					// posición en X y lo que corresponda en Y
			if (posFinalX < this.getX())
				nuevoX = this.getX() - 1;
			else
				nuevoX = this.getX() + 1;

			nuevoY = (((nuevoX - this.getX()) / (posFinalX - this.getX())) * (posFinalY - this.getY())) + (this.getY());
		}

		super.setPos((int) nuevoX, (int) nuevoY);

		if ((this.posFinalX == this.getX()) && (this.posFinalY == this.getY())) { // verifica si llego al objetivo y lo
																					// explota
			this.setExploto(true);
		}
	}
	@Override
	public boolean esMisil(){
		return true;
	}
	@Override
	public boolean esAntibalistico(){
		return true;
	}
}
