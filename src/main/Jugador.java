package main;

import processing.core.PApplet;

public abstract class  Jugador {
	protected PApplet app;
	protected int posX;
	protected int posY;
	protected int vel;
	
	public Jugador(int posX, int posY, int vel, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.app = app;
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
