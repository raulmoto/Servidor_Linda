package servidorlinda;

import java.io.IOException;
import java.net.Socket;

public class Servidor3 extends Conexion {
	private Socket c3 = null;

	public Servidor3() throws IOException {
		super("servidor3");
	}
	
	/*PRE:--
	 POST:metodo que se ejecuta cuando arrancamos servidor 3
	 * */
	public void startServer3() {// Método para iniciar el servidor
		int cont = 0;
		try {
			System.out.println("Esperando desde S3..."); // Esperando conexión
			while (true) {
				System.out.println("entramos a while..."); 
				c3 = ss3.accept();
				int port = ss3.getLocalPort();
				System.out.println("puerto s3:" +port); 
				  cont++;
				  System.out.println("cliente numero : "+cont+ " desde S3"); 
		         Thread_Thread4 tNuevoClientes1 = new Thread_Thread4(c3 );
		         tNuevoClientes1.start();    
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

