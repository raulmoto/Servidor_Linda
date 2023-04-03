package servidorlinda;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {
	 private final int PUERTO = 1234; //Puerto para la conexión
	 private final int PUERTO2 = 4000; //Puerto para la conexión s1
	 private final int PUERTO3 = 4001; //Puerto para la conexión s2
	 private final int PUERTO4 = 4002; //Puerto para la conexión s3
	 private final int PUERTO5 = 4003; //Puerto para la conexión s4
	 //private final int PUERTO1 = 1235;
	    private final String HOST = "localhost"; //Host para la conexión
	    protected  ServerSocket ss; //Socket del servidor la calse k da java para implementar la tuberia de parte del servidor
	    protected  Socket cs; //Socket del cliente la calse k da java para implementar la tuberia de parte del servidor
	    protected  ServerSocket ss1;
	    protected  ServerSocket ss2;
	    protected  ServerSocket ss3;
	    protected  ServerSocket ss4;
	    
	    public Conexion(String tipo) throws IOException {//Constructor
	        if(tipo.equalsIgnoreCase("linda")) {
	            ss = new ServerSocket(PUERTO);//Se crea el socket para el servidor en puerto 1234
	            //cs = new Socket(); //Socket para el cliente
	          
	        }else if(tipo.equalsIgnoreCase("servidor1")) {
	        	ss1 = new ServerSocket(PUERTO2);
	        }else if(tipo.equalsIgnoreCase("servidor2")) {
	        	ss2 = new ServerSocket(PUERTO3);
	        }else if(tipo.equalsIgnoreCase("servidor3")) {
	        	ss3 = new ServerSocket(PUERTO4);
	        }else if(tipo.equalsIgnoreCase("copia")) {
	        	ss4 = new ServerSocket(PUERTO5);
	        }else {
	            cs = new Socket(HOST, PUERTO); //Socket para el cliente en localhost en puerto 1234
	        }
	    }

}
