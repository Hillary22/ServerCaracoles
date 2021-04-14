package main;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
	
	PImage background,caracol1,caracol2,tonelada,velo, win;
	int vel,posx1,posx2;
	int posy1, posy2;
	int time, second, view;
	private TCPConexion conexion;
	private String jugador1avanza;
	JugadorUno jugador1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("main.Main");
	}

	public void settings() {
		size(360, 640);
		
	}
	public void setup() {
		
		posy1 = 510;
		vel = 1;
		time=0;
		conexion = new TCPConexion();
		conexion.setMain(this);
		conexion.start();
		jugador1 = new JugadorUno(70,posy1,50,this);
		background = loadImage("../img/pista.png");
		tonelada = loadImage("../img/tonelada.png"); 
		velo = loadImage("../img/vel.png");
		win = loadImage("../img/wpviolet.png");
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
		switch(view) {
		case 0:
			imageMode(CORNER);
			image(background,0,0,width,height);
		
//			fill(0);
//	    	textSize(29);
//	    	ellipse(70,posy1,50,50);
	    	text("x="+mouseX+"y="+mouseY,mouseX,mouseY);
	    	jugador1.retroceder();
	    	jugador1.pintarJ();
	    	
	    	//time
	    	textSize(18);
			text(time,72,34);
			second = second + 1;
			if (second == 100) {
				second = 0;
			}
			if (view == 0 && second == 99) {
				time=time + 1;
			}
	    	break;
		
		case 1:
			imageMode(CORNER);
			image(win, 0,0, width, height);
			break;


		}
		
    	
	}

}
