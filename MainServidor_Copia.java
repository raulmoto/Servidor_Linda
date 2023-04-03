package servidorlinda;

import java.io.IOException;

public class MainServidor_Copia {
	
	public static void main(String[] args) throws IOException {
	    Servidor_Copia serv = new Servidor_Copia(); //Se crea el servidor

	    System.out.println("Iniciando servidor copia\n");
	    serv.startServerCopia(); //Se inicia el servidor
	}


}
