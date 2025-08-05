package modelos.personajes;

import java.awt.Graphics;

import juego.Escenario;
import juego.Posicion;

//import java.math.*;

/**
 * @see Personaje Clase que representa a todos los personajes del juego, ya que
 *      tiene la posición y la representación en el mapa
 */
public class Personaje extends Posicion {
	public boolean exploto;
	private int radio;
	private int puntaje;
	private boolean vivo;
	
	/**
	 * @see Personaje Constructor de cada personaje
	 * @param x              Representa la posición en X en el mapa
	 * @param y              Representa la posición en Y en el mapa
	 * @param representacion Representa el caracter por el cual se distingue al
	 *                       personaje en el mapa
	 * @param radio          Representa el radio del personaje
	 */
	public Personaje(float x, float y, int radio) {
		super(x, y);
		this.radio = radio;
		this.exploto = false;
		this.vivo = true;
	}

	/**
	 * @see distancia Procedimiento que calcula la distancia entre dos puntos
	 * @param f Posición en X del primer punto
	 * @param g Posición en Y del primer punto
	 * @param h Posición en X del segundo punto
	 * @param i Posición en Y del segundo punto
	 * @return Retorna la distancia que hay entre ambos puntos
	 */
	public double distancia(float f, float g, float h, float i) {
		return Math.sqrt(Math.pow(h - f, 2) + Math.pow(i - g, 2));
	}

	/**
	 * @see explotar Procedimiento que crea un objeto explosion
	 * @return Retorna el objeto explosion creado
	 */
	public Explosion explotar() {
		Explosion e = new Explosion(this.getPosX(), this.getPosY());
		
		Escenario.getInstancia().setPersonaje(e);
		
		e.setExploto(false);
		e.setCreciendo(true);
		return e;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public int getRadio() {
		return this.radio;
	}

	public boolean isExploto() {
		return exploto;
	}

	public void setExploto(boolean exploto) {
		this.exploto = exploto;
	}
	
	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	/**
	 * @see colision Procedimiento que analiza si dos objetos Personaje colisionan
	 * @param p Objeto Personaje con el cual se va a analizar si hay colision o no
	 * @return Retorna true en caso de haber colision, y false en caso de que no
	 *         haya
	 */
	public boolean colision(Personaje p) {
		if (this.distancia(this.getPosX(), this.getPosY(), p.getPosX(), p.getPosY()) < (this.getRadio() + p.getRadio()))
			return true;
		else
			return false;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	public int getPuntaje() {
		return this.puntaje;
	}
	
	public void mover() {
	}

	public void dibujar(Graphics gr) {
		// TODO Auto-generated method stub
		
	}
}
