package servidorlinda;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class Thread_Ping extends Thread{
	
	private Socket socket_cliente_linda;
	private DataInputStream entradalinda;
	private DataOutputStream salidalinda;
	

	public DataInputStream getEntradalinda() {
		return entradalinda;
	}

	public void setEntradalinda(DataInputStream entradalinda) {
		this.entradalinda = entradalinda;
	}

	public DataOutputStream getSalidalinda() {
		return salidalinda;
	}

	public void setSalidalinda(DataOutputStream salidalinda) {
		this.salidalinda = salidalinda;
	}


	public static boolean active;
	public static boolean reiniciado = false;
	private boolean connected = false;
	
	public Thread_Ping(Socket socket_cliente_linda) {
		this.socket_cliente_linda = socket_cliente_linda; // inicializar la variable
		Thread_Ping.active = true;
	}
	
	public void reconectar() {
	    
	    while (!connected) {
	    	System.out.println(active);
	        try {
	            System.out.println("Intentando reconectar...");
	            System.out.println(socket_cliente_linda);
	            socket_cliente_linda = new Socket("localhost", 4000);
	            System.out.println(socket_cliente_linda);
	            entradalinda = new DataInputStream(socket_cliente_linda.getInputStream());
				salidalinda = new DataOutputStream(socket_cliente_linda.getOutputStream());
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
			entradalinda = new DataInputStream(socket_cliente_linda.getInputStream());
			salidalinda = new DataOutputStream(socket_cliente_linda.getOutputStream());
		
			while (true) {
				try {
					salidalinda.writeUTF("ping");
					System.out.println("hacemos ping");	
				} catch (SocketException e) {
					// System.out.println(e.getMessage());
					System.out.println("no se puede hacer ping");
					System.out.println(e.getMessage());
					active = false;	
				}
				
				try {
					if (entradalinda.available() > 0) {
						System.out.println("SEGUNDO TRY");
						 mensajes1 = entradalinda.readUTF();
						 if (mensajes1.equalsIgnoreCase("SERVIDOR 1 ACTIVO")) {
							 System.out.println("--------------mensaje PING---------------------");
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

