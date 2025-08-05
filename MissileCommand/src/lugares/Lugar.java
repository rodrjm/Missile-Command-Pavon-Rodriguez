package lugares;

import personajes.Personaje;

/**
 * @see Lugar Clase que representa a los lugares dentro del juego
 */
public class Lugar extends Personaje {

	/**
	 * @see Lugar Constructor de lugar
	 * @param x     Representa la posición en X en el mapa
	 * @param y     Representa la posición en Y en el mapa
	 * @param c     Representa el caracter con el cual se va a representar al lugar
	 *              en el mapa
	 * @param radio Representa al radio del objeto lugar
	 */
	public Lugar(int x, int y, Character c, int radio) {
		super(x, y, c, radio);
	}
	@Override
	public boolean esLugar(){
		return true;
	}
}
