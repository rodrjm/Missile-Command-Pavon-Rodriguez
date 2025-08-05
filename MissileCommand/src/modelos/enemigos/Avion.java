package modelos.enemigos;

/**
 * @see Avion Clase que representa a los aviones dentro del juego
 */
public class Avion extends Bombardero {

	private int cantMisiles;
	private int[] tiempoMisiles;
	private int posInicialX;

	/**
	 * @see Avion Constructor de Avion
	 * @param x
	 *            Representa la posición en X en el mapa
	 * @param y
	 *            Representa la posición en Y en el mapa
	 */
	public Avion(int x, int y) {
		super(x, y, 1);
		this.posInicialX = x;

		this.cantMisiles = (int) (Math.random() * 3) + 2;
		this.tiempoMisiles = new int[cantMisiles];
		for (int i = 0; i < cantMisiles; i++) {
			this.tiempoMisiles[i] = (int) (Math.random() * 500);
		}
	}

	public int getCantMisiles() {
		return cantMisiles;
	}

	public void setCantMisiles(int cantMisiles) {
		this.cantMisiles = cantMisiles;
	}

	public int[] getTiempoMisiles() {
		return tiempoMisiles;
	}

	public void setTiempoMisiles(int[] tiempoMisiles) {
		this.tiempoMisiles = tiempoMisiles;
	}

	public int getPosInicialX() {
		return posInicialX;
	}

	public void setPosInicialX(int posInicialX) {
		this.posInicialX = posInicialX;
	}

	/**
	 * @see mover Procedimiento para mover un avión de un lado hacia otro
	 */
	public void mover() {
		double nuevoX;

		if ((this.posInicialX == 0) && (this.getPosX() < 526)) {
			nuevoX = this.getPosX() + 2;
			super.setPos((int) nuevoX, this.getPosY());
		}
		else
			if ((!(this.posInicialX == 0)) && (this.getPosX() > 0)) {
				nuevoX = this.getPosX() - 2;
				super.setPos((int) nuevoX, this.getPosY());
			}
			else
				super.setVivo(false);
	}
}
