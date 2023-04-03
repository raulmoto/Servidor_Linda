package servidorlinda;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class Thread_Ping2 extends Thread{
	
	private Socket c4;
	private DataInputStream entrada;
	private DataOutputStream salida;
	

	public DataInputStream getEntradalinda() {
		return entrada;
	}

	public void setEntradalinda(DataInputStream entrada) {
		this.entrada = entrada;
	}

	public DataOutputStream getSalidalinda() {
		return salida;
	}

	public void setSalidalinda(DataOutputStream salida) {
		this.salida = salida;
	}


	public static boolean active;
	public static boolean reiniciado = false;
	private boolean connected = false;
	
	public Thread_Ping2(Socket c4) {
		this.c4 = c4; // inicializar la variable
		Thread_Ping2.active = true;
	}
	
	public void reconectar() {
	    
	    while (!connected) {
	    	System.out.println(active);
	        try {
	            System.out.println("Intentando reconectar...");
	            System.out.println(c4);
	            c4 = new Socket("localhost", 4003);
	            System.out.println(c4);
	            entrada = new DataInputStream(c4.getInputStream());
				salida = new DataOutputStream(c4.getOutputStream());
                connected = true;
                active = true;
                reiniciado=true;
                System.out.println("CONECTADO");
	    }catch(IOException e) {
	    	e.printStackTrace();
	    	try {
				Thread.sleep(5000); // Espera 5 segundos antes de intentar reconectar
			} catch (InterruptedException ex) {
				System.out.println("Error en el thread: " + ex.getMessage());
			}
	    	}
	    }
	}

	
	public void run() {
		String mensajes1 = " ";
		try {
			entrada = new DataInputStream(c4.getInputStream());
			salida = new DataOutputStream(c4.getOutputStream());
			
			
			
			while (true) {
				try {
					salida.writeUTF("ping");
					System.out.println("hacemos ping COPIA");
					
					
				} catch (SocketException e) {
					// System.out.println(e.getMessage());
					System.out.println("no se puede hacer ping COPIA");
					System.out.println(e.getMessage());
					active = false;
					
					
				}
				
				try {
					if (entrada.available() > 0) {
						System.out.println("SEGUNDO TRY COPIA");
						 mensajes1 = entrada.readUTF();
						 if (mensajes1.equalsIgnoreCase("SERVIDOR copia ACTIVO")) {
							 System.out.println("--------------mensaje PING2---------------------");
						 }
					 }
					
				} catch (SocketException e) {
					// System.out.println(e.getMessage());
					System.out.println("no hay mensaje recibido");
					System.out.println(e.getMessage());	
				}
				
				if (!active) {
					connected = false;
					//System.out.println("CONEXION CON SERVIDOR 1 CERRADO***");
					reconectar();
					
				} else {
					//System.out.println("CONEXION CON SERVIDOR 1 abierta");
				}
				try {
					Thread.sleep(5000); // Espera 5 segundos antes de intentar reconectar
				} catch (InterruptedException ex) {
					System.out.println("Error en el thread: " + ex.getMessage());
				}	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}

