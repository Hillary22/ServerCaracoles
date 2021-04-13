package main;

import processing.core.PApplet;

public abstract class  Jugador {
	protected PApplet app;
	protected int posX;
	protected int posY;
	protected int vel;
	private int counter = 0;
	private boolean retroceder, avanzar, goLeft, goRight;
	
	public Jugador(int posX, int posY, int vel, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.app = app;
	}
	
	public void retroceder() {
		counter ++;
		if(posY <= 600 && counter == 20) {
		counter = 0;
		this.posY += 3;
		}
	}
	
	public void avanzar() {
		this.posY = posY-4;
	}

	public abstract void pintarJ() ;
	
	
	public void habilidad() {
	}
	
	public void sabotaje() {
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}
	
	
}
