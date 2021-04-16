package main;

import processing.core.PApplet;

public abstract class Habilidad {

	
	protected PApplet app;
	protected int x, y;
	
	public Habilidad(int x, int y, PApplet app) {
		this.x=x;
		this.y=y;
		this.app=app;
	}
	
	public abstract void pintarH(); 
	public abstract boolean tomoH(JugadorUno j1);

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
