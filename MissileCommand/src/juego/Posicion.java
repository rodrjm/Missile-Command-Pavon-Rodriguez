package juego;

public class Posicion {

	private int posX;
	private int posY;
	
	public Posicion() {
	}
	public Posicion(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public void setPos(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	public Posicion getPos() {
		Posicion p = new Posicion(this.posX, this.posY);
		return p;
	}
	
}
