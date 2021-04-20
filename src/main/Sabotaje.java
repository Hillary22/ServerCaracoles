package main;

import processing.core.PApplet;
import processing.core.PImage;

public class Sabotaje extends Habilidad{
	
	private PImage tone;//tonelada
	private boolean atrapaTone= false;
	private boolean J1tomo = false;
	private boolean J2tomo = false;
	private boolean startTimer = false;
	private int temporalH = 1;
	private int timer = 0;

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
		if(atrapaTone == true) {
			resetearTone(j1,j2);
		}
	}

	

	@Override
	public boolean tomoH(JugadorUno j1, JugadorDos j2) {
		
		//float t1 = app.dist(j1.posX, j1.posY,getX(), getY());

		if (j1.posX>=157 && j1.posX<=192 && j1.posY>=202 && j1.posY<=240) {
			atrapaTone=true;
			J1tomo = true;
			J2tomo = false;
			startTimer = true;
			if(J1tomo == true) {
				j2.setRetro(3);
				System.out.println("a ver si funciona la velocidad");
			}
			else {j1.getVel();}
			System.out.println("aja");
			
		}
		if (j2.posX>=157 && j2.posX<=192 && j2.posY>=202 && j2.posY<=240) {
			atrapaTone=true;
			atrapaTone=true;
			J2tomo = true;
			J1tomo = false;
			startTimer = true;
			if(J2tomo == true) {
				j1.setRetro(3);
				System.out.println("a ver si funciona la velocidad");
			}
			else {j1.getVel();}
			System.out.println("aja");
			
		}
			
		
		return atrapaTone;
	}
	
	public void resetearTone(JugadorUno j1, JugadorDos j2) {
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

	public boolean isAtrapaTone() {
		return atrapaTone;
	}

	public void setAtrapaTone(boolean atrapaTone) {
		this.atrapaTone = atrapaTone;
	}

	

}
