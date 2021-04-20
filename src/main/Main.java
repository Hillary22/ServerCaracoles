package main;

import com.google.gson.Gson;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
	
	PImage background,caracol1,caracol2,tonelada,velo, win1, win2, clock, ins, startp;
	int vel,posx1,posx2;
	int posy;
	int time, second, view, playerswin;
	private TCPConexion conexionP1;
	private TCPConexionP2 conexionP2;
	private String jugador1name, jugador2name;
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
		
		view = 0;
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
		jugador1name = "no name";
		jugador2name = "no name";

		//Cargando las imagenes 
		background = loadImage("../img/back.png");
		tonelada = loadImage("../img/tonelada.png"); 
		velo = loadImage("../img/vel.png");
		win1 = loadImage("../img/gy.png");
		win2 = loadImage("../img/gv.png");
		clock = loadImage("../img/clock.png");
		ins = loadImage("../img/instrucciones.png");
		startp = loadImage("../img/start.png");

	}
	
	public void avanzar(Coordenada jugadorN, Object obj) {
		
		System.out.println(jugadorN.getJugador());
		jugador1name = jugadorN.getJugador();
		jugador2name = jugadorN.getJugador();
		
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
			image(startp,0,0,width,height);
			break;
		case 1:
			imageMode(CORNER);
			image(ins,0,0,width,height);
			break;
		case 2:
			imageMode(CORNER);
			image(background,0,0,width,height);
			
			//habilidades
			mv.pintarH(jugador1, jugador2);
			st.pintarH(jugador1, jugador2);
			j.validarVelo();
			j.resetearVelo(time);
			
			//jugadores
	    	jugador1.retroceder();
	    	jugador1.pintarJ();
	    	jugador2.retroceder();
	    	jugador2.pintarJ();
			image(clock,0,0);
			

	    	//time
	    	textSize(18);
			text(time+" s",72,34);
			second = second + 1;
			if (second == 100) { second = 0; }
			if (view == 2 && second == 99) { time=time + 1; }
			win();
	    	break;
		
		case 3:
			imageMode(CORNER);
			image(win1, 0,0, width, height);
			textSize(18);
			text(time, 190, 290);
			text(jugador1name, 190, 254);
	    	text("x="+mouseX+"y="+mouseY,mouseX,mouseY);

			break;
			
		case 4:
			imageMode(CORNER);
			image(win2,0,0, width, height);
			textSize(18);
			text(time, 190, 290);
			text(jugador2name, 190, 254);
	    	text("x="+mouseX+"y="+mouseY,mouseX,mouseY);

			break;

		}
		
	}
	
	public void mouseClicked() {
		switch(view) {
		case 0: 
			if (mouseX>120 && mouseY<425 && mouseX<228 && mouseY>393) {
				view = 2;
			}
			if (mouseX>115 && mouseY<478 && mouseX<238 && mouseY>441) {
				view = 1;
			}
				break;
		case 1:
			if (mouseX>60 && mouseY<104 && mouseX<87 && mouseY>76) {
				view = 0;
			}
			break;
		case 3:
			if (mouseX>124 && mouseY<543 && mouseX<217 && mouseY>515) {
				jugador1.setPosX(110);
				jugador1.setPosY(510);
				jugador2.setPosX(220);
				jugador2.setPosY(510);
				mv.setAtrapaVelo(false);
				st.setAtrapaTone(false);
				jugador1.setVel(1);
				jugador2.setVel(1);
				time = 0;
				view = 2;
			}
			if (mouseX>126 && mouseY<594 && mouseX<236 && mouseY>560) {
				exit();
			}
			break;
		case 4:
			if (mouseX>124 && mouseY<543 && mouseX<217 && mouseY>515) {
				jugador1.setPosX(110);
				jugador1.setPosY(510);
				jugador2.setPosX(220);
				jugador2.setPosY(510);
				mv.setAtrapaVelo(false);
				st.setAtrapaTone(false);
				time = 0;
				view = 2;
				jugador1.setVel(1);
				jugador2.setVel(1);
			}
			if (mouseX>126 && mouseY<594 && mouseX<236 && mouseY>560) {
				exit();
			}
			break;
		}
	}

	
	public void sendMessage(String msg) {
        conexionP1.enviarMensaje(msg);

    }
	public void win() {
		//pensando
		
		if (jugador1.getPosX()>=70 && jugador1.getPosY()>0 && jugador1.getPosX()<280 && jugador1.getPosY()<84) {
			view = 3;
			
			}
		if (jugador2.getPosX()>=70 && jugador2.getPosY()>0 && jugador2.getPosX()<280 && jugador2.getPosY()<84) {
			view = 4;
			}	
		}
	
}
