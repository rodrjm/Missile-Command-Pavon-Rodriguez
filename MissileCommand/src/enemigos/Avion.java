package enemigos;





/**
 * @see Avion Clase que representa a los aviones dentro del juego
 */
public class Avion extends Bombardero {

	// private int cantMisiles;
	// private int[] tiempoMisiles;
	// private int posInicialX;

	/**
	 * @see Avion Constructor de Avion
	 * @param x
	 *            Representa la posición en X en el mapa
	 * @param y
	 *            Representa la posición en Y en el mapa
	 */
	public Avion(int x, int y) {
		super(x, y, 'a', 1);
		this.setPosInicialX(x);

		this.setCantMisiles((int) (Math.random() * 3) + 2);
		this.setTiempoMisiles(new int[this.getCantMisiles()]);
		for (int i = 0; i < this.getCantMisiles(); i++) {
			this.tiempoMisiles[i] = (int) (Math.random() * 500);
		}
	}

	

	// public int getCantMisiles() {
	// return cantMisiles;
	// }
	//
	// public void setCantMisiles(int cantMisiles) {
	// this.cantMisiles = cantMisiles;
	// }
	//
	// public int[] getTiempoMisiles() {
	// return tiempoMisiles;
	// }
	//
	// public void setTiempoMisiles(int[] tiempoMisiles) {
	// this.tiempoMisiles = tiempoMisiles;
	// }
	//
	// public int getPosInicialX() {
	// return posInicialX;
	// }
	//
	// public void setPosInicialX(int posInicialX) {
	// this.posInicialX = posInicialX;
	// }

	/**
	 * @see mover Procedimiento para mover un avión de un lado hacia otro
	 */
	public void mover() {
		double nuevoX;

		if (this.getPosInicialX() == 0)
			nuevoX = this.getX() + 2;
		else
			nuevoX = this.getX() - 2;

		super.setPos((int) nuevoX, this.getY());
	}

	@Override
	public boolean esAvion() {
		return true;
	}
	//
	// public void lanzarMisil(List<Personaje> listaLugares) {
	// // TODO Auto-generated method stub
	// int objetivo = (int) (Math.random() * 8);
	// Balistico b = new Balistico(this.getX(),
	// this.getY(),listaLugares.get(objetivo));
	//// listaDibujar.add(b);
	// Juego.listaDibujar.add(b);
}

