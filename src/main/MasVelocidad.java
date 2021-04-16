package main;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class MasVelocidad extends Habilidad{
	
	private PImage velo;

	public MasVelocidad(int x, int y, PApplet app) {
		super(x, y, app);
		velo= app.loadImage("../img/vel.png");
	}

	@Override
	public void pintarH() {
		app.imageMode(PConstants.CORNER);
		app.image(velo,getX(),getY(),50,50);
		
	}

	@Override
	public boolean tomoH(JugadorUno j1) {
		boolean atrapaVelo= false;
		float v1 = app.dist(j1.posX, j1.posY,getX(), getY());
		
		if (j1.posX>=150 || j1.posX<=195) {
			atrapaVelo=true;
			System.out.println("aja");

		}
		return atrapaVelo;
	}

	

	
}
