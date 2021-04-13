package main;

import processing.core.PApplet;

public class Juego {

	private PApplet app;
	private TCPConexion conexion;
	private JugadorUno j1;
	private JugadorDos j2;
	
	private int pantalla =0;
	
	public Juego(PApplet app) {
		this.app =app;
		
		j1 = new JugadorUno(70, 510, 1, app);
		j2 = new JugadorDos(150, 510, 1, app);
	}
	
	//pintar pantallas
	public void pintarP() {
		
	}
	
}
