package main;

import processing.core.PApplet;
import processing.core.PImage;

public class JugadorDos extends Jugador{

	private PImage 	caracol2;
	
	public JugadorDos(int posX, int posY, int vel, PApplet app) {
		super(posX, posY, vel, app);
		caracol2 = app.loadImage("../img/p1.png");
	}

	public void pintarJ() {

		app.image(this.caracol2, this.posX, this.posY, 38, 90);

	}

	

}
