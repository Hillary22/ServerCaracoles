package main;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class MasVelocidad extends Habilidad{
	
	private PImage velo;
	private boolean atrapaVelo= false;
	

	public MasVelocidad(int x, int y, PApplet app) {
		super(x, y, app);
		velo= app.loadImage("../img/vel.png");
	}

	@Override
	public void pintarH(JugadorUno j1, JugadorDos j2) {
		
		if(atrapaVelo == false) {
			
			app.image(velo,getX(),getY(),50,50);
			tomoH(j1, j2);
		}
		
		
	}


	@Override
	public boolean tomoH(JugadorUno j1, JugadorDos j2) {
		
		//float v1 = app.dist(j1.posX, j1.posY,getX(), getY());
		
		if (j1.posX>=159 && j1.posX<=195 && j1.posY>=349 && j1.posY<=390) {
			atrapaVelo=true;
			System.out.println("aja");
			
		}
		
		
		if (j2.posX>=159 && j2.posX<=195 && j2.posY>=349 && j2.posY<=390) {
			atrapaVelo=true;
			System.out.println("aja");
			
		}
	
		return atrapaVelo;
	}

	
	

	
}
