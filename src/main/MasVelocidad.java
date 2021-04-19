package main;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class MasVelocidad extends Habilidad{
	
	private PImage velo;
	private boolean atrapaVelo= false;
	private boolean J1tomo = false;
	private boolean J2tomo = false;
	private boolean startTimer = false;
	private int temporalH = 1;
	private int timer = 1;
	

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
		if(atrapaVelo == true) {
			resetearVelo(j1);
		}
	}


	@Override
	public boolean tomoH(JugadorUno j1, JugadorDos j2) {
		
		//float v1 = app.dist(j1.posX, j1.posY,getX(), getY());
		
		if (j1.posX>=159 && j1.posX<=195 && j1.posY>=349 && j1.posY<=390) {
			atrapaVelo=true;
			J1tomo = true;
			J2tomo = false;
			startTimer = true;
			if(J1tomo == true) {
				j1.setVel(3);
				System.out.println("a ver si funciona la velocidad");
			}
			else {j1.getVel();}
			System.out.println("aja");
			
		}
		
		
		if (j2.posX>=159 && j2.posX<=195 && j2.posY>=349 && j2.posY<=390) {
			atrapaVelo=true;
			J2tomo = true;
			J1tomo = false;
			startTimer = true;
			if(J2tomo == true) {
				j2.setVel(3);
				System.out.println("a ver si funciona la velocidad");
			}
			System.out.println("aja");
			
		}
	
		return atrapaVelo;
	}
	
	public void resetearVelo(JugadorUno j1) {
		if (startTimer == true) {
			timer ++;
		}
		if(timer == 100) {
			J1tomo = false;
			J2tomo = false;
			j1.setVel(1);
			timer = 0;
			startTimer = false;
		}
	}

	
	

	
}
