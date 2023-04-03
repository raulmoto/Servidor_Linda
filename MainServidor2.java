package servidorlinda;

import java.io.IOException;

public class MainServidor2 {
	
	public static void main(String[] args) throws IOException {
	    Servidor2 serv = new Servidor2(); //Se crea el servidor

	    System.out.println("Iniciando servidor2\n");
	    serv.startServer2(); //Se inicia el servidor
	}

}
