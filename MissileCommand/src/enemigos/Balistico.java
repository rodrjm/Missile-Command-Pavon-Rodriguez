package enemigos;

import java.util.List;

import juego.Juego;
import lugares.Lugar;
import personajes.Personaje;

/**
 * @see Balistico Clase que representa a los misiles balisticos dentro del juego
 */


public class Balistico extends Misil {
	private boolean bifurcado;
	
	
	public boolean esBifurcado() {
		return bifurcado;
	}

	public void setEsBifurcado(boolean esBifurcado) {
		this.bifurcado = esBifurcado;
	}

	/**
	 * @see Balistico Constructor de misil balistico
	 * @param x        Representa la posición en X en el mapa
	 * @param y        Representa la posición en Y en el mapa
	 * @param  personaje Representa el objetivo al cual va dirigido el misil
	 */
	public Balistico(int x, int y, Personaje  personaje) {
		super(x, y, (Lugar) personaje, 'b', 1);
		this.setEsBifurcado(false);
	}
	
	public void bifurcar(Balistico b, List<Personaje> listaLugares){
		//Un misil de cada 40 se bifurca. Si es un misil bifurcado no se bifurca
		int bifurcar = (int) (Math.random() * 40) ;
		if (bifurcar==1){//Si bifurcar es =1 el misil se bifurca
			int bifurcarEn = (int) (Math.random() * 3) + 3 ;//El misil se puede bifurcar en 3, 4, 5 o 6 misiles nuevos
			for(int i=0; i < bifurcarEn; i++){
				int objetivo = (int) (Math.random() * 8);
				Lugar l= (Lugar) listaLugares.get(objetivo);
				Balistico bal = new Balistico(b.getX(),b.getY(), l);
				bal.setEsBifurcado(true);
				Juego.listaDibujar.remove(b);
				Juego.listaDibujar.add(bal);
			}
		}
	
	}

	/**
	 * @see mover Procedimiento para mover un misil balistico a la posición del
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
	public boolean esBalistico(){
		return true;
	}

}
