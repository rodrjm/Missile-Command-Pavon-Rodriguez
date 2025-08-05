package juego;

import java.util.ArrayList;
import java.util.List;

import personajes.Personaje;

public class TestJuego {
	public static void main(String[] args) {
		List<Personaje> listaLugares = new ArrayList<>();
		Juego.crearNivel(1, Juego.listaDibujar, listaLugares);
		Juego.vaciarListas(Juego.listaDibujar, listaLugares);
		Juego.crearNivel(2, Juego.listaDibujar, listaLugares);
		Juego.vaciarListas(Juego.listaDibujar, listaLugares);
		Juego.crearNivel(3, Juego.listaDibujar, listaLugares);
	}
	
}
