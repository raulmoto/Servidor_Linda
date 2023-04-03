package servidorlinda;
import java.io.IOException;
public class Main_Servidor_Linda {
	
	public static void main(String[] args) throws IOException {
	    Servidor_Linda serv = new Servidor_Linda(); //Se crea el servidor
	    System.out.println("Iniciando servidor linda\n");
	    serv.startServer(); //Se inicia el servidor
	}

}
