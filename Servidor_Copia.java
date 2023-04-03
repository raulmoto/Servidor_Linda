package servidorlinda;


import java.io.IOException;
import java.net.Socket;

public class Servidor_Copia extends Conexion {
	private Socket c4 = null;

	public Servidor_Copia() throws IOException {
		super("copia");
	}
	
	/*PRE:--
	 POST:metodo que se ejecuta cuando arrancamos servidor copia 
	 * */
	public void startServerCopia() {// Método para iniciar el servidor
		int cont = 0;
		try {
			System.out.println("Esperando desde servidor copia..."); // Esperando conexión
			while (true) {
				System.out.println("entramos a while..."); 
				c4 = ss4.accept();
				int port = ss4.getLocalPort();
				System.out.println("puerto servidor copia:" +port); 
				  cont++;
				  System.out.println("cliente numero : "+cont+ " desde copia"); 
		         Thread_Thread5 tNuevoClientes1 = new Thread_Thread5(c4 );
		         tNuevoClientes1.start();    
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}