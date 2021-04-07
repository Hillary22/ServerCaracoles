package main;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
	
	PImage background,caracol1,caracol2,tonelada,velo;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("main.Main");
	}

	public void settings() {
		size(700, 500);
		background = loadImage("../img/bg.png");
		caracol1 = loadImage("../img/p1.png");
		caracol2 = loadImage("../img/p2.png");
		tonelada = loadImage("../img/tonelada.png"); 
		velo = loadImage("../img/velo.png"); 
	}
	public void setup() {
		
	}
	public void draw() {
		
	}

}
