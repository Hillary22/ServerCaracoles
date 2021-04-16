package main;

import processing.core.PApplet;
import processing.core.PImage;

public class MasVelocidad extends Habilidad{
	
	private PImage velo;

	public MasVelocidad(int x, int y, PApplet app) {
		super(x, y, app);
		velo= app.loadImage("../img/vel.png");
	}

	@Override
	public void pintarH() {
		app.image(velo,getX(),getY(),50,50);
		
	}

	@Override
	public boolean tomoH(JugadorUno j1, JugadorDos j2) {
		boolean atrapaVelo= false;
		float v1 = app.dist(j1.posX, j1.posY,getX(), getY());
		float v2 = app.dist(j2.posX, j2.posY,getX(), getY());
		
		if (v1>=0 && v2>=0) {
			atrapaVelo=true;
		}
		return atrapaVelo;
	}

	

	
}
