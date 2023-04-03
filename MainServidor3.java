package servidorlinda;

import java.io.IOException;

public class MainServidor3 {
	public static void main(String[] args) throws IOException {
	    Servidor3 serv = new Servidor3(); //Se crea el servidor

	    System.out.println("Iniciando servidor3\n");
	    serv.startServer3(); //Se inicia el servidor
	}

}
