package servidorlinda;

import java.io.IOException;
import java.net.Socket;

public class Servidor1 extends Conexion {
	private Socket socket_cliente_linda = null;

	public Servidor1() throws IOException {
		super("servidor1");
	}
	
	/*PRE:--
	 POST:metodo que se ejecuta cuando arrancamos servidor 1 
	 * */
	public void startServer1() {// Método para iniciar el servidor
		int cont = 0;
		try {
			System.out.println("Esperando desde S1..."); // Esperando conexión
			while (true) {
				System.out.println("entramos a while..."); 
				socket_cliente_linda = ss1.accept();
				int port = ss1.getLocalPort();
				System.out.println("puerto s1:" +port); 
				
				  cont++;
				  System.out.println("cliente numero : "+cont+ " desde S1"); 
		         Thread_Thread2 tNuevoClientes1 = new Thread_Thread2(socket_cliente_linda );
		         tNuevoClientes1.start();    
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	

}
