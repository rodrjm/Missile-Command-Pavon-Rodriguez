package lugares;

/**
 * @see Silo Clase que representa a los silos dentro del juego
 */
public class Silo extends Lugar {

	private int cantMisiles;
	
	/**
	 * @see Silo Constructor de Silo
	 * @param x Representa la posición en X en el mapa
	 * @param y Representa la posición en Y en el mapa
	 */
	public Silo(int x, int y) {
		super(x, y, 'S', 1);
		this.cantMisiles = 10;
	}

	/**
	 * @see restarMisil Procedimiento que resta misiles una vez que son lanzados por
	 *      el silo
	 */
	public void restarMisil() {
		this.cantMisiles = this.cantMisiles - 1;
	}

	public void setCantMisiles(int cantMisiles) {
		this.cantMisiles = cantMisiles;
	}

	public int getCantMisiles() {
		return this.cantMisiles;
	}
	@Override
	public boolean esSilo(){
		return true;
	}
}
