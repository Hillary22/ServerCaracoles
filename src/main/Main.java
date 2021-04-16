package main;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
	
	PImage background,caracol1,caracol2,tonelada,velo, win1, win2, clock;
	int vel,posx1,posx2;
	int posy1, posy2;
	int time, second, view, playerswin;
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
		background = loadImage("../img/back.png");
		tonelada = loadImage("../img/tonelada.png"); 
		velo = loadImage("../img/vel.png");
		win1 = loadImage("../img/gv.png");
		win2 = loadImage("../img/gyvoy.png");
		clock = loadImage("../img/clock.png");


	}
	
public void avanzar(Coordenada jugadorN, Object obj) {
		
		System.out.println(jugadorN.getJugador());
		
		if (obj instanceof TCPConexion) {
			switch(jugadorN.getAvanzar()) {
			case "goUP":
				jugador1.avanzar();
				break;
			case "goLeft":
				jugador1.irIzquierda();
				break;
			case "goRight":
				jugador1.irDerecha();
				break;
			}
		}
		
		
		
	}
	
	public void draw() {
		switch(view) {
		case 0:
			imageMode(CORNER);
			
			image(background,0,0,width,height);
			
	    	text("x="+mouseX+"y="+mouseY,mouseX,mouseY);
	    	jugador1.retroceder();
	    	jugador1.pintarJ();
			image(clock,0,0);

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
			win();
	    	break;
		
		case 1:
			imageMode(CORNER);
			image(win1, 0,0, width, height);
			textSize(18);
			text(time, 192, 414);
			
			break;
		case 2:
			imageMode(CORNER);
			image(win2,0,0, width, height);
			textSize(18);
			text(time, 192, 414);
			break;

		}
		
	}

	public void win() {
		//pensando
		
		if (jugador1.getPosX()>=70 && jugador1.getPosY()>0 && jugador1.getPosX()<280 && jugador1.getPosY()<84) {
			view = 1;
			}	
		}
	
}
