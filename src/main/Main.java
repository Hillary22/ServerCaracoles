package main;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
	
	PImage background,caracol1,caracol2,tonelada,velo;
	int vel,posx1,posx2;
	int posy1, posy2;
	private TCPConexion conexion;
	private String jugador1avanza;
	JugadorUno jugador1;

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
		jugador1 = new JugadorUno(70,posy1,50,this);
		
		
	}
	
public void avanzar(Coordenada jugadorN, Object obj) {
		
		System.out.println(jugadorN.getJugador());
		
		if (obj instanceof TCPConexion) {
			switch(jugadorN.getAvanzar()) {
			case "goUP":
				jugador1.avanzar();
				break;
			}
		}
		
		
		
	}
	
	public void draw() {
		
		background(255,255,255);
		fill(0);
    	textSize(29);
    	ellipse(70,posy1,50,50);
    	text("x="+mouseX+"y="+mouseY,mouseX,mouseY);
    	jugador1.retroceder();
    	jugador1.pintarJ();
    	
	}

}
