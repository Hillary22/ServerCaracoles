package main;

import processing.core.PApplet;
import processing.core.PImage;

public class JugadorUno extends Jugador{
	
	private PImage caracol1;

	public JugadorUno(int posX, int posY, int vel, PApplet app) {
		super(posX, posY, vel, app);
		caracol1 = app.loadImage("../img/p2.png");
		
	}

	public void pintarJ() {

<<<<<<< HEAD
		app.image(this.caracol1, this.posX, this.posY, 35, 50);
=======
		app.image(this.caracol1, this.posX, this.posY, 34, 94);
>>>>>>> 23144dc5a40742d2b40c506be87d547a6e97e920
	}

	
	
}
