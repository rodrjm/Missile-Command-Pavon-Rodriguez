package juego;

public class Posicion {

	private float posX;
	private float posY;

	public Posicion(float posX,float posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float f) {
		this.posX = f;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	/**
	 * @see setPos Procedimiento que establece la posición de un personaje en el
	 *      mapa
	 * @param x
	 *            Representa la posición en X
	 * @param y
	 *            Representa la posición en Y
	 */
	public void setPos(float posX, float posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public Posicion getPos() {
		Posicion p = new Posicion(this.getPosX(), this.getPosY());
		return p;
	}
}
