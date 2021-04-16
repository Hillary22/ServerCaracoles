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
	private int sabotajeH;
	private int pantalla =0;
	
	public Juego(PApplet app) {
		this.app =app;
		
		j1 = new JugadorUno(70, 510, 1, app);
		j2 = new JugadorDos(150, 510, 1, app);
	}
	
	//pintar pantallas
	public void pintarP() {
		
	}
	
	public void VerSitomoH() {
		
		for (int i = 0; i < habilidades.size(); i++) {
			if(habilidades.get(i).tomoH( j1,  j2)) {
			
				if(habilidades.get(i) instanceof MasVelocidad) {
					temporalH = (int)Math.floor(app.millis()/1000) ;
					j1.vel= 3;
					System.out.println("mas velocidad");
					//j2.vel= 1;
			}else {j1.vel= 1;}
				
				if(habilidades.get(i).tomoH( j1,  j2)) {
					
					if(habilidades.get(i) instanceof Sabotaje) {
						sabotajeH = (int)Math.floor(app.millis()/1000) ;
						
				}
			}
			habilidades.remove(i);
		}
		
	}
}
	
}
