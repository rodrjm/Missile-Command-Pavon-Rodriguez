package modelos.lugares;

/**
 * @see Silo Clase que representa a los silos dentro del juego
 */
public class Silo extends Lugar {

	private EstadoSilo estado;
	private int cantMisiles;

	/**
	 * @see Silo Constructor de Silo
	 * @param x
	 *            Representa la posición en X en el mapa
	 * @param y
	 *            Representa la posición en Y en el mapa
	 */
	public Silo(int x, int y, EstadoSilo estado) {
		super(x, y, 1);
		this.cantMisiles = 10;
		this.estado = estado;
	}

	public EstadoSilo getEstado() {
		return estado;
	}

	public void setEstado(EstadoSilo estado) {
		this.estado = estado;
	}

	/**
	 * @see restarMisil Procedimiento que resta misiles una vez que son lanzados
	 *      por el silo
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
	
	public void checkEstado() {
		if (this.cantMisiles < 5)
			this.setEstado(EstadoSilo.LOW);
	}
}
