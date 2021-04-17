package main;

import java.util.ArrayList;

import processing.core.PApplet;

public class Juego {

	private PApplet app;
	private TCPConexion conexion;
	private JugadorUno j1;
	private JugadorDos j2;
	private ArrayList<Habilidad> habilidades;
	private int temporalH;//variable para tiempo de habilidades 
	private int sabotajeH;//variable para tiempo de habilidades
	private int pantalla =0;
	private boolean J1tomo = false;
	private boolean J2tomo = false;
	private boolean J1tomoS = false;
	private boolean J2tomoS = false;
	
	
	public Juego(PApplet app) {
		this.app =app;
		
		j1 = new JugadorUno(70, 510, 1, app);
		j2 = new JugadorDos(150, 510, 1, app);
		habilidades = new ArrayList<>();
		habilidades.add(new MasVelocidad(150, 350, app));
		habilidades.add(new Sabotaje(150,200 , app));
		temporalH=0;
		sabotajeH=0;
	}
	

	
	public void verSitomoH() {
		
		for (int i = 0; i < habilidades.size(); i++) {
			if(habilidades.get(i).tomoH( j1)) {
			
				if(habilidades.get(i) instanceof MasVelocidad) {
					temporalH = (int)Math.floor(app.millis()/1000) ;
					validarVelo();
					//j1.vel= 3;
					System.out.println("soy franchescooooooo FIAAAAUUUNNN");
					//j2.vel= 1;
			}else {j1.vel= 1;}
				
				if(habilidades.get(i).tomoH( j1)) {
					
					if(habilidades.get(i) instanceof Sabotaje) {
						sabotajeH = (int)Math.floor(app.millis()/1000) ;
						validarTone();
				}
			}
			habilidades.remove(i);
		}
		
	}
}
	
	
	public void pintarHabilidad() {
		for (int i = 0; i < habilidades.size(); i++) {
			habilidades.get(i).pintarH(j1);
			
		}
		verSitomoH();
	}
	
	public void resetearVelo(int time) {
		int tiempoH = time - temporalH;
		if(tiempoH>4) {
			j1.vel = 1 ;
		}else {
			j2.vel = 1 ;}
	}
	
	public void validarVelo() {
		
		if(J1tomo == true) {
			j1.setVel(3);
			
		}
		else {j1.getVel();}
		
		if(J2tomo == true) {
			j2.setVel(3);
			
		}
		else {j2.getVel();}
	}
	
public void validarTone() {
		
		if(J1tomoS == true) {
			j1.setVel(3);
			
		}
		else {j1.getVel();}
		
		if(J2tomoS == true) {
			j2.setVel(3);
			
		}
		else {j2.getVel();}
	}
}
