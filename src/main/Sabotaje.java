package main;

import processing.core.PApplet;
import processing.core.PImage;

public class Sabotaje extends Habilidad{
	
	private PImage tone;//tonelada
	private boolean atrapaTone= false;

	public Sabotaje(int x, int y, PApplet app) {
		super(x, y, app);
		tone = app.loadImage("../img/tonelada.png");
	}

	@Override
	public void pintarH(JugadorUno j1, JugadorDos j2) {
		
		if(atrapaTone == false) {
		app.image(tone,getX(),getY(),50,50);
		tomoH(j1, j2);
		}
	}

	

	@Override
	public boolean tomoH(JugadorUno j1, JugadorDos j2) {
		
		//float t1 = app.dist(j1.posX, j1.posY,getX(), getY());

		if (j1.posX>=157 && j1.posX<=192 && j1.posY>=202 && j1.posY<=240) {
			atrapaTone=true;
			System.out.println("aja");
			
		}
		if (j2.posX>=157 && j2.posX<=192 && j2.posY>=202 && j2.posY<=240) {
			atrapaTone=true;
			System.out.println("aja");
			
		}
			
		
		return atrapaTone;
	}

	

}
