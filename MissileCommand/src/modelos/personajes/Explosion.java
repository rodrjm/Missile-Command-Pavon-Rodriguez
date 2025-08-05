package modelos.personajes;

import juego.Escenario;

/**
 * @see Explosion Clase que representa las explosiones dentro del juego
 */
public class Explosion extends Personaje {
	boolean creciendo;
	int radioMaximo = 40;
	boolean terminoExplosion;

	public Explosion(float f, float g) {
		super(f, g, 1);
		creciendo = true;
		exploto = false;
		terminoExplosion = false;
	}

	@Override
	public void setExploto(boolean exploto) {
		this.exploto = false;
	}

	public boolean isTerminoExplosion() {
		return terminoExplosion;
	}

	public void setTerminoExplosion(boolean terminoExplosion) {
		this.terminoExplosion = terminoExplosion;
	}

	public boolean isCreciendo() {
		return creciendo;
	}

	public void setCreciendo(boolean creciendo) {
		this.creciendo = creciendo;
	}

	/**
	 * @see achicarRadio Procedimiento que sirve para achicar el radio de la
	 *      explosión
	 */
	public void achicarRadio() {
		this.setRadio(this.getRadio() - 1);
		if (this.getRadio() == 0) {
			this.setTerminoExplosion(true);
			super.setVivo(false);
			Escenario.getInstancia().vaciarPosicion(this);
		}
	}

	/**
	 * @see agrandarRadio Procedimiento que sirve para agrandar el radio de la
	 *      explosión
	 */
	public void agrandarRadio() {
		this.setRadio(this.getRadio() + 1);
		if (this.getRadio() == this.radioMaximo) {
			this.setCreciendo(false);
		}
	}

	public void achicarAgrandarRadio() {
		if (this.isCreciendo())
			this.agrandarRadio();
		else
			this.achicarRadio();
	}
}
