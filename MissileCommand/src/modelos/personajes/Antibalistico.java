package modelos.personajes;

import java.awt.Color;
import java.awt.Graphics;

import juego.Escenario;

/**
 * @see Antibalistico Clases que representa los misiles antibalisticos dentro
 *      del juego
 */
public class Antibalistico extends Personaje {

	private float posFinalX;
	private float posFinalY;

	public int getPosInicialX() {
		return posInicialX;
	}

	public void setPosInicialX(int posInicialX) {
		this.posInicialX = posInicialX;
	}

	public int getPosInicialY() {
		return posInicialY;
	}

	public void setPosInicialY(int posInicialY) {
		this.posInicialY = posInicialY;
	}

	private boolean fin;
	private int posInicialX;
	private int posInicialY;

	public boolean isFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	/**
	 * @see Antibalistico Constructor de misil antibalístico
	 * @param x
	 *            Representa la posición en X en el mapa
	 * @param y
	 *            Representa la posición en Y en el mapa
	 * @param finalX
	 *            Representa la posición en X a la cual se dirige el misil
	 * @param finalY
	 *            Representa la posición en Y a la cual se dirige el misil
	 */
	public Antibalistico(int x, int y, int finalX, int finalY) {
		super(x, y, 1);
		this.posFinalX = finalX;
		this.posFinalY = finalY;
	}

	public Antibalistico(int x, int y, int finalX, int finalY, int posInicialX, int posInicialY) {
		super(x, y, 1);
		this.posFinalX = finalX;
		this.posFinalY = finalY;
		this.posInicialX = posInicialX;
		this.posInicialY = posInicialY;

	}

//	 public void mover() {
//	 if (isFin() != true) {
//	 // if (this.hayColision()){
//	 // this.setExplosion();
//	 // }
//	 if (Math.round(this.getPosY()) <= Math.round(this.posFinalY - 30)) {
//	 this.explotar();
//	 } else {
//	 this.moverse();
//	 }
//	 }
//	 }
	public double calcularDistancia(float posOrigenX, float posOrigenY, float posX, float posY) {
		return (Math.sqrt(Math.pow(posOrigenX - posX, 2) + Math.pow(posOrigenY - posY, 2)));
	}

//	 private void moverse() {
//	 float dirX = this.posFinalX - this.getPosX();
//	 float dirY = posFinalY - this.getPosY();
//	 float m = (dirY / dirX);
//	 float distancia = 30;
//	 if (this.calcularDistancia(this.getPosX(), this.getPosY(),
//	 this.posFinalX, this.posFinalY) < distancia) {
//	 distancia = (float) this.calcularDistancia(this.getPosX(),
//	 this.getPosY(), this.posFinalX, this.posFinalY);
//	 }
//	 float movimientoX = (float) Math.round(Math.sqrt(Math.pow(distancia, 2) /
//	 (1 + Math.pow(m, 2))));
//	 if (dirX < 0)
//	 movimientoX = -movimientoX;
//	 float movimientoY = m * movimientoX;
//	 this.setPosX(this.getPosX() + movimientoX);
//	 this.setPosY(Math.round((this.getPos().getPosY() + movimientoY)));
//	 }

	public void dibujar(Graphics g) {
		g.setColor(Color.black);
		g.drawLine((int) this.getPosInicialX(), (int) this.getPosInicialY(), (int) this.getPosX(),
				(int) this.getPosY());
	}

	public void mover() {
		double nuevoX, nuevoY;
		int vel = 5;
		int i = 0;
		while ((i < vel) && !(this.exploto)) {
			i++;
			if (posFinalX == this.getPosX()) { // En caso de que la posición en
												// X no
												// se modifique, se va a mover
												// una
												// unidad de
												// posición en Y
				nuevoX = this.getPosX();
				if (posFinalY < this.getPosY())
					nuevoY = this.getPosY() - 1;
				else
					nuevoY = this.getPosY() + 1;
			} else if (posFinalY == this.getPosY()) { // En caso de que la
														// posición
														// en Y no se modifique,
														// se
														// va a mover una
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
						// posición en X y lo que corresponda en Y
				if (posFinalX < this.getPosX())
					nuevoX = this.getPosX() - 1;
				else
					nuevoX = this.getPosX() + 1;

				nuevoY = (((nuevoX - this.getPosX()) / (posFinalX - this.getPosX())) * (posFinalY - this.getPosY()))
						+ (this.getPosY());
			}

			super.setPos((int) nuevoX, (int) nuevoY);

			if ((this.posFinalX == this.getPosX()) && (this.posFinalY == this.getPosY())) { // verifica
																							// si
																							// llego
																							// al
																							// objetivo
																							// y
																							// loexplota
				this.setExploto(true);
			}
		}
	}
}
