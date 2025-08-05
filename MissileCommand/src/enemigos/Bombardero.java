package enemigos;

import java.util.List;

import juego.Juego;
import personajes.Personaje;

public class Bombardero	extends Personaje {
	private int cantMisiles;
	protected int[] tiempoMisiles;
	private int posInicialX;

	public Bombardero(int x, int y, char representacion, int radio) {
		// TODO Auto-generated constructor stub
		super(x,y,representacion,radio);
	}
	public int getCantMisiles() {
		return cantMisiles;
	}

	public void setCantMisiles(int cantMisiles) {
		this.cantMisiles = cantMisiles;
	}

	public int[] getTiempoMisiles() {
		return tiempoMisiles;
	}

	public void setTiempoMisiles(int[] tiempoMisiles) {
		this.tiempoMisiles = tiempoMisiles;
	}

	public int getPosInicialX() {
		return posInicialX;
	}

	public void setPosInicialX(int posInicialX) {
		this.posInicialX = posInicialX;
	}

	/**
	 * @see mover Procedimiento para mover un satélite de un lado hacia otro
	 */
	public void mover() {

	}
	@Override
	public boolean esBombardero(){
		return true;
	}

	public void lanzarMisil(List<Personaje> listaLugares) {
		// TODO Auto-generated method stub
		int objetivo = (int) (Math.random() * 8);
		Balistico b = new Balistico(this.getX(), this.getY(),listaLugares.get(objetivo));
//		listaDibujar.add(b);
		Juego.listaDibujar.add(b);
	}
	
}
