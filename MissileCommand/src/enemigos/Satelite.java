package enemigos;



/**
 * @see Satelite Clase que representa a los satelites dentro del juego
 */
public class Satelite extends Bombardero {



	/**
	 * @see Satelite Constructor de Satelite
	 * @param x Representa la posición en X en el mapa
	 * @param y Representa la posición en Y en el mapa
	 */
	public Satelite(int x, int y) {
		super(x, y, 's', 1);
		this.setPosInicialX(x);
		
		this.setCantMisiles((int) (Math.random() * 3) + 2);
		this.setTiempoMisiles(new int[this.getCantMisiles()]);
		for (int i = 0; i < this.getCantMisiles(); i++) {
			this.tiempoMisiles[i] = (int) (Math.random() * 500);
		}
	}

//	public int getCantMisiles() {
//		return cantMisiles;
//	}
//
//	public void setCantMisiles(int cantMisiles) {
//		this.cantMisiles = cantMisiles;
//	}
//
//	public int[] getTiempoMisiles() {
//		return tiempoMisiles;
//	}
//
//	public void setTiempoMisiles(int[] tiempoMisiles) {
//		this.tiempoMisiles = tiempoMisiles;
//	}
//
//	public int getPosInicialX() {
//		return posInicialX;
//	}
//
//	public void setPosInicialX(int posInicialX) {
//		this.posInicialX = posInicialX;
//	}
//
//	/**
//	 * @see mover Procedimiento para mover un satélite de un lado hacia otro
//	 */
	public void mover() {
		double nuevoX;

		if (this.getPosInicialX() == 0)
			nuevoX = this.getX() + 3;
		else
			nuevoX = this.getX() - 3;

		super.setPos((int) nuevoX, this.getY());
	}
	@Override
	public boolean esSatelite(){
		return true;
	}
}
