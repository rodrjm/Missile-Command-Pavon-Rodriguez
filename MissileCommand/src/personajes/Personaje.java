package personajes;

//import java.math.*;

import taller2.grafico.*;

/**
 * @see Personaje Clase que representa a todos los personajes del juego, ya que
 *      tiene la posición y la representación en el mapa
 */
public class Personaje implements Dibujable {
	boolean exploto;

	public boolean isExploto() {
		return exploto;
	}

	public void setExploto(boolean exploto) {
		this.exploto = exploto;
	}

	private int radio;
	int X;
	int Y;
	char representacion;

	/**
	 * @see Personaje Constructor de cada personaje
	 * @param x              Representa la posición en X en el mapa
	 * @param y              Representa la posición en Y en el mapa
	 * @param representacion Representa el caracter por el cual se distingue al
	 *                       personaje en el mapa
	 * @param radio          Representa el radio del personaje
	 */
	public Personaje(int x, int y, char representacion, int radio) {
		this.X = x;
		this.Y = y;
		this.representacion = representacion;
	//	this.radio = radio;
		this.exploto = false;
	}

	/**
	 * @see distancia Procedimiento que calcula la distancia entre dos puntos
	 * @param x1 Posición en X del primer punto
	 * @param y1 Posición en Y del primer punto
	 * @param x2 Posición en X del segundo punto
	 * @param y2 Posición en Y del segundo punto
	 * @return Retorna la distancia que hay entre ambos puntos
	 */
	public double distancia(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

	/**
	 * @see explotar Procedimiento que crea un objeto explosion
	 * @return Retorna el objeto explosion creado
	 */
	public Explosion explotar() {
		Explosion e = new Explosion(this.getX(), this.getY());
		e.setExploto(false);
		e.setCreciendo(true);
		return e;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	/**
	 * @see setPos Procedimiento que establece la posición de un personaje en el
	 *      mapa
	 * @param x Representa la posición en X
	 * @param y Representa la posición en Y
	 */
	public void setPos(int x, int y) {
		X = x;
		Y = y;
	}

	@Override
	public InformacionDibujable getInformacionDibujable() {
		return new InformacionDibujable(this.X, this.Y, this.representacion);
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public int getRadio() {
		return this.radio;
	}

	/**
	 * @see colision Procedimiento que analiza si dos objetos Personaje colisionan
	 * @param p Objeto Personaje con el cual se va a analizar si hay colision o no
	 * @return Retorna true en caso de haber colision, y false en caso de que no
	 *         haya
	 */
	public boolean colision(Personaje p) {
		if (this.distancia(this.getX(), this.getY(), p.getX(), p.getY()) < (this.getRadio() + p.getRadio()))
			return true;
		else
			return false;
	}

	public void mover() {
	}
	public boolean esVacio (){
		return false;
	}
	public boolean esMisil(){
		return false;
	}
	public boolean esAntibalistico(){
		return false;
	}
	public boolean esBalistico(){
		return false;
	}
	public boolean esCiudad(){
		return false;
	}
	public boolean esSilo(){
		return false;
	}
	public boolean esSatelite(){
		return false;
	}
	public boolean esAvion(){
		return false;
	}
	public boolean esExplosion(){
		return false;
	}
	public boolean esCruceroTonto(){
		return false;
	}
	public boolean esCruceroInteligente(){
		return false;
	}

	public boolean esLugar() {
		return false;
	}
	public boolean esBombardero() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean esPersonaje(){
		return true;
	}


}

