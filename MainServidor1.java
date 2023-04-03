package servidorlinda;

import java.io.IOException;

public class MainServidor1 {
	
	public static void main(String[] args) throws IOException {
	    Servidor1 serv = new Servidor1(); //Se crea el servidor

	    System.out.println("Iniciando servidor1\n");
	    serv.startServer1(); //Se inicia el servidor
	}

}
