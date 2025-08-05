package lugares;

/**
 * @see Ciudad Clase que representa a las ciudades dentro del juego
 */
public class Ciudad extends Lugar {

	/**
	 * @see Ciudad Constructor de Ciudad
	 * @param x
	 *            Representa la posición en X en el mapa
	 * @param y
	 *            Representa la posición en Y en el mapa
	 */
	public Ciudad(int x, int y) {
		super(x, y, 'C', 1);
	}

	@Override
	public boolean esCiudad() {
		return true;
	}
	@Override
	public boolean esLugar(){
		return true;
	}
}
