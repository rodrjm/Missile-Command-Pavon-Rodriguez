package enemigos;

import lugares.Lugar;
import personajes.Personaje;

/**
 * @see Misil Clase que representa a los misiles dentro del juego
 */
public class Misil extends Personaje {

	private Lugar objetivo;
	private int puntaje;

	/**
	 * @see Misil Constructor de Misil
	 * @param x     Representa la posición en X en el mapa
	 * @param y     Representa la posición en Y en el mapa
	 * @param obj   Representa el objetivo al cual va dirigido el misil
	 * @param c     Representa el caracter con el cual se va a representar al misil
	 *              en el mapa
	 * @param radio Representa el radio del objeto misil
	 */
	public Misil(int x, int y, Lugar obj, Character c, int radio) {
		super(x, y, c, radio);
		this.setObjetivo(obj);
	}

	public Lugar getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(Lugar objetivo) {
		this.objetivo = objetivo;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	@Override
	public boolean esMisil(){
		return true;
	}

}
