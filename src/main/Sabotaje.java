package main;

import processing.core.PApplet;
import processing.core.PImage;

public class Sabotaje extends Habilidad{
	
	private PImage tone;//tonelada

	public Sabotaje(int x, int y, PApplet app) {
		super(x, y, app);
		tone = app.loadImage("../img/tonelada.png");
	}

	@Override
	public void pintarH() {
		app.image(tone,getX(),getY(),50,50);
		
	}

	

	@Override
	public boolean tomoH(JugadorUno j1) {
		boolean atrapaTone= false;
		float t1 = app.dist(j1.posX, j1.posY,getX(), getY());

		
		if (t1>=0) {
			atrapaTone=true;
		}
		return atrapaTone;
	}

	

}
