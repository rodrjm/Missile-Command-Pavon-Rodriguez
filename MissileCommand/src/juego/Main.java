package juego;

import controladores.Inicio;
// import vistas.Entorno;
// import vistas.PantallaPrincipal;

public class Main {

	public static void main(String[] args) {
		// PantallaPrincipal pPrincipal = new PantallaPrincipal();
		// pPrincipal.setVisible(true);
		
		// Entorno entorno = new Entorno();
		// entorno.setVisible(true);
		
		Inicio inicio = new Inicio();
		Inicio.setControlador(inicio);
	}

}
