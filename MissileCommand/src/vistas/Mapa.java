package vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import juego.Escenario;
import modelos.enemigos.*;
import modelos.personajes.Explosion;

public class Mapa extends JPanel {

	private static final long serialVersionUID = 1L;

	public Mapa() {
		this.setPreferredSize(new Dimension(560, 540));
		this.setBounds(50, 50, 525, 480);
		this.setBackground(Color.RED);
		this.setVisible(true);

		Escenario e = new Escenario();
		Escenario.setInstancia(e);
	}

	public void paintComponent(Graphics gr) {
		Image img[] = null;
		try {
			img = generarImagenes();
			graficarMapa(img[0], gr);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			graficarLugares(img, gr);
			graficarPersonajes(img, gr);
	}

	public Image[] generarImagenes() throws IOException {
		Image img[] = new Image[12];
		URL url = getClass().getClassLoader().getResource("imagenes/fondoMapa.png");
		Image image = ImageIO.read(url);
		img[0] = image;
		image = ImageIO.read(getClass().getClassLoader().getResource("imagenes/ciudad.png"));
		img[1] = image;
		image = ImageIO.read(getClass().getClassLoader().getResource("imagenes/silo.png"));
		img[2] = image;
		image = ImageIO.read(getClass().getClassLoader().getResource("imagenes/antibalistico.png"));
		img[3] = image;
		image = ImageIO.read(getClass().getClassLoader().getResource("imagenes/crucero.png"));
		img[4] = image;
		image = ImageIO.read(getClass().getClassLoader().getResource("imagenes/avionIzq.png"));
		img[5] = image;
		image = ImageIO.read(getClass().getClassLoader().getResource("imagenes/avionDer.png"));
		img[6] = image;
		image = ImageIO.read(getClass().getClassLoader().getResource("imagenes/sateliteIzq.png"));
		img[7] = image;
		image = ImageIO.read(getClass().getClassLoader().getResource("imagenes/sateliteDer.png"));
		img[8] = image;
		image = ImageIO.read(getClass().getClassLoader().getResource("imagenes/explosion.png"));
		img[9] = image;
		image = ImageIO.read(getClass().getClassLoader().getResource("imagenes/balistico.png"));
		img[10] = image;
		image = ImageIO.read(getClass().getClassLoader().getResource("imagenes/vacio.png"));
		img[11] = image;
		return img;
	}

	public void graficarMapa(Image img, Graphics gr) {
		gr.drawImage(img, 0, 0, 560, 540, null);
	}

	public void graficarLugares(Image img[], Graphics gr) {
		int tam = 30;
		for (int i = 0; i < Escenario.getInstancia().getList().size(); i++) {
			if (Escenario.getInstancia().esCiudad(i)) {
				gr.drawImage(img[1], (int) Escenario.getInstancia().getPersonaje(i).getPosX(), 470, tam, tam, null);
			}
			if (Escenario.getInstancia().esSilo(i)) {
				gr.drawImage(img[2], (int) Escenario.getInstancia().getPersonaje(i).getPosX(), 470, tam, tam, null);
			}
		}
	}

	public void graficarPersonajes(Image img[], Graphics gr) {
		int tam;
		for (int i = 0; i < Escenario.getInstancia().getList().size(); i++) {
			if (Escenario.getInstancia().esAntibalistico(i)) {
				tam = 10;
				//gr.drawImage(img[3], (int )Escenario.getInstancia().getPersonaje(i).getPosX(),(int)Escenario.getInstancia().getPersonaje(i).getPosY() , tam, tam, null);
				Escenario.getInstancia().getPersonaje(i).dibujar(gr);
			}
			if (Escenario.getInstancia().esAvion(i)) {
				tam = 20;
				Avion a = (Avion) Escenario.getInstancia().getPersonaje(i);
				if (a.getPosInicialX() == 0)
					gr.drawImage(img[6],(int) Escenario.getInstancia().getPersonaje(i).getPosX(),(int)Escenario.getInstancia().getPersonaje(i).getPosY() , tam, tam, null);
				else
					gr.drawImage(img[5], (int)Escenario.getInstancia().getPersonaje(i).getPosX(),(int)Escenario.getInstancia().getPersonaje(i).getPosY() , tam, tam, null);
			}
			if (Escenario.getInstancia().esBalistico(i)) {
				tam = 10;
				gr.drawImage(img[10],(int) Escenario.getInstancia().getPersonaje(i).getPosX(),(int)Escenario.getInstancia().getPersonaje(i).getPosY() , tam, tam, null);
			}
			if ((Escenario.getInstancia().esCruceroInteligente(i))
					|| (Escenario.getInstancia().esCruceroTonto(i))) {
				tam = 10;
				gr.drawImage(img[4],(int)Escenario.getInstancia().getPersonaje(i).getPosX(),(int)Escenario.getInstancia().getPersonaje(i).getPosY() , tam, tam, null);
			}
			if (Escenario.getInstancia().esExplosion(i)) {
				Explosion e = (Explosion) Escenario.getInstancia().getPersonaje(i);
				if (e.isTerminoExplosion()) {
					Escenario.getInstancia().vaciarPosicion(Escenario.getInstancia().getPersonaje(i));
				} else {
//					if (e.getRadio() == 3)
//						tam = 15;
//					else if (e.getRadio() == 5)
//						tam = 20;
//					else if (e.getRadio() == 8)
//						tam = 25;
//					else if (e.getRadio() == 10)
//						tam = 30;
//					else
//						tam = 10;
					tam=Escenario.getInstancia().getPersonaje(i).getRadio();
					gr.drawImage(img[9], (int)Escenario.getInstancia().getPersonaje(i).getPosX(),(int)Escenario.getInstancia().getPersonaje(i).getPosY() , tam, tam, null);
				}
			}
			if (Escenario.getInstancia().esSatelite(i)) {
				tam = 20;
				Satelite s = (Satelite) Escenario.getInstancia().getPersonaje(i);
				if (s.getPosInicialX() == 0)
					gr.drawImage(img[8],(int)Escenario.getInstancia().getPersonaje(i).getPosX(),(int)Escenario.getInstancia().getPersonaje(i).getPosY() , tam, tam, null);
				else
					gr.drawImage(img[7],(int) Escenario.getInstancia().getPersonaje(i).getPosX(),(int)Escenario.getInstancia().getPersonaje(i).getPosY() , tam, tam, null);
			}
		}
	}
}