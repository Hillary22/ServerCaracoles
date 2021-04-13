package main;

import processing.core.PApplet;
import processing.core.PImage;

public class JugadorUno extends Jugador{
	
	private PImage caracol1;

	public JugadorUno(int posX, int posY, int vel, PApplet app) {
		super(posX, posY, vel, app);
		caracol1 = app.loadImage("../img/p1.png");
		
	}

	public void pintarJ() {

		app.image(this.caracol1, this.posX, this.posY, 50, 50);
	}

	
	
}
