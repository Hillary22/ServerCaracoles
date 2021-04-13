package main;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
	
	PImage background,caracol1,caracol2,tonelada,velo;
	int vel,posx1,posy1,posx2,posy2;
	private TCPConexion conexion;
	private String jugador1avanza;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("main.Main");
	}

	public void settings() {
		size(360, 640);
		background = loadImage("../img/bg.png");
		
	
		tonelada = loadImage("../img/tonelada.png"); 
		velo = loadImage("../img/vel.png");
		posy1 = 510;
		vel = 1;
	}
	public void setup() {
		
		conexion = new TCPConexion();
		conexion.setMain(this);
		conexion.start();
		
	}
	
public void avanzar(Coordenada jugadorN) {
		
		System.out.println(jugadorN.getJugador());
		
		jugador1avanza = jugadorN.getAvanzar();
		
		if (jugador1avanza == "si") {
			posy1 = + vel;
			
		}

	}
	
	public void draw() {
		
		background(255,255,255);
		fill(0);
    	textSize(29);
    	ellipse(70,posy1,50,50);
    	text("x="+mouseX+"y="+mouseY,mouseX,mouseY);
    	
	}

}
