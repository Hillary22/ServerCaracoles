package main;

import com.google.gson.Gson;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
	
	PImage background,caracol1,caracol2,tonelada,velo, win1, win2, clock;
	int vel,posx1,posx2;
	int posy;
	int time, second, view, playerswin;
	private TCPConexion conexionP1;
	private TCPConexionP2 conexionP2;
	private String jugador1avanza;
	JugadorUno jugador1;
	JugadorDos jugador2;
	private MasVelocidad mv;
	private Sabotaje st;
	private Juego j;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("main.Main");
	}

	public void settings() {
		size(360, 640);
		
	}
	public void setup() {
		
		posy = 510;
		vel = 1;
		time=0;

		conexionP1 = new TCPConexion();
		conexionP1.setMain(this);
		conexionP1.start();
		conexionP2 = new TCPConexionP2();
		conexionP2.setMain(this);
		conexionP2.start();
		jugador1 = new JugadorUno(110,posy,50,this);
		jugador2 = new JugadorDos(220,posy,50,this);
		mv = new MasVelocidad(150, 350, this);
		st = new Sabotaje(150, 200, this);
		j = new Juego (this) ;
	
		 
		background = loadImage("../img/back.png");
		tonelada = loadImage("../img/tonelada.png"); 
		velo = loadImage("../img/vel.png");
		win1 = loadImage("../img/gye.png");
		win2 = loadImage("../img/gve.png");
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
		
		if (obj instanceof TCPConexionP2) {
			switch(jugadorN.getAvanzar()) {
			case "goUP":
				jugador2.avanzar();
				break;
			case "goLeft":
				jugador2.irIzquierda();
				break;
			case "goRight":
				jugador2.irDerecha();
				break;
			}
		}
		
	}
	
	public void draw() {
		switch(view) {
		case 0:
			imageMode(CORNER);
			
			image(background,0,0,width,height);
			
			//habilidades
		//	j.pintarHabilidad();
			mv.pintarH(jugador1, jugador2);
			st.pintarH(jugador1, jugador2);
			j.validarVelo();
			
			j.resetearVelo(time);
			
			//jugadores
			
	    	text("x="+mouseX+"y="+mouseY,mouseX,mouseY);
	    	jugador1.retroceder();
	    	jugador1.pintarJ();
	    	jugador2.retroceder();
	    	jugador2.pintarJ();
			image(clock,0,0);
			
			

	    	//time
	    	textSize(18);
			text(time+" s",72,34);
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
			text(time, 185, 282);
			
			break;
		case 2:
			imageMode(CORNER);
			image(win2,0,0, width, height);
			textSize(18);
			text(time, 192, 414);
			break;

		}
		
	}
	
	public void sendMessage(String msg) {
        conexionP1.enviarMensaje(msg);

    }
	public void win() {
		//pensando
		
		if (jugador1.getPosX()>=70 && jugador1.getPosY()>0 && jugador1.getPosX()<280 && jugador1.getPosY()<84) {
//			Gson gson = new Gson();
//            Perder perder = new Perder(perdio);
//            String ganar = gson.toJson(perder);
//			sendMessage("Ganó J1");
			view = 1;
			
			}
		if (jugador2.getPosX()>=70 && jugador2.getPosY()>0 && jugador2.getPosX()<280 && jugador2.getPosY()<84) {
			view = 2;
			}	
		}
	
}
