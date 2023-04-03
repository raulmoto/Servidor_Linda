package servidorlinda;




import java.io.IOException;
import java.net.Socket;

public class Servidor_Linda extends Conexion {

	public Servidor_Linda() throws IOException {
		super("linda");
		// TODO Auto-generated constructor stub
	}
	
	public void startServer() {// Método para iniciar el servidor
		int cont = 0;
		try {
			Socket socket_cliente_linda = new Socket("localhost", 4000);
			System.out.println("Conectado a  servidor1 en el puerto 4000");
			
			
			Socket socket_cliente_linda2 = new Socket("localhost", 4001);
			System.out.println("Conectado a  servidor2 en el puerto 4001");
			
			Socket c3 = new Socket("localhost", 4002);
			System.out.println("Conectado a  servidor3 en el puerto 4002");
			
			Socket c4 = new Socket("localhost", 4003);
			System.out.println("Conectado a  servidor copia 4003");
			
			Thread_Ping tp = new Thread_Ping(socket_cliente_linda);
			tp.start();
			System.out.println("Esperando linda..."); // Esperando conexión
			while (true) {
				//------------------------------------------------------------------------
				
				System.out.println("entramos a while..."); 
				  cs = ss.accept();
				  cont++;
				  System.out.println("cliente numero: "+cont); 
				  
				  Thread_Control hilo_servidor1 = new Thread_Control(cs,socket_cliente_linda,socket_cliente_linda2,c3,c4, tp);
		          hilo_servidor1.start();    
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
