package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

import processing.core.PApplet;

public class TCPConexion extends Thread{
	
	private Main ref;
	private Socket socket;
	private BufferedWriter writer;
	private BufferedReader reader;
	
	
	public void run () {
		
			try {
				ServerSocket server = new ServerSocket(5000);
				System.out.println("Esperando cliente en el canal 5000...");
				Socket socket = server.accept();
				System.out.println("P1 esta conectado");

				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader breader = new BufferedReader(isr);
				
				OutputStreamWriter osw = new OutputStreamWriter(os);
                writer = new BufferedWriter(osw);
                
				while (true) {
					
					System.out.println("Esperando mensaje...");
					String jugadorRecibido = breader.readLine();
					System.out.println(jugadorRecibido);
					
					Gson gson = new Gson();
					
					Coordenada jugadorN = gson.fromJson(jugadorRecibido, Coordenada.class);
					ref.avanzar(jugadorN, this);
					
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	
	public void enviarMensaje(String msg){
        new Thread(() -> {
            try {
                writer.write(msg + "\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
	
	public void setMain(Main main) {
		this.ref =  main;
		
	}
	
}