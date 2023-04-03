package servidorlinda;

import java.io.IOException;
import java.net.Socket;

public class Servidor2 extends Conexion {
	private Socket socket_cliente_linda2 = null;

	public Servidor2() throws IOException {
		super("servidor2");
	}
	
	/*PRE:--
	 POST:metodo que se ejecuta cuando arrancamos servidor 2 
	 * */
	public void startServer2() {// Método para iniciar el servidor
		int cont = 0;
		try {
			System.out.println("Esperando desde S2..."); // Esperando conexión
			while (true) {
				System.out.println("entramos a while..."); 
				socket_cliente_linda2 = ss2.accept();
				int port = ss2.getLocalPort();
				System.out.println("puerto s2:" +port); 
				  cont++;
				  System.out.println("cliente numero : "+cont+ " desde S2"); 
		         Thread_Thread3 tNuevoCliente2 = new Thread_Thread3(socket_cliente_linda2 );
		         tNuevoCliente2.start();    
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
