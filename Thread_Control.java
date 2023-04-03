
package servidorlinda;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/*Este es el cliente linda que hará conexion con el serviodr 1
 * 
 * */
public class Thread_Control extends Thread {
	private Socket cs = null;
	private Socket socket_cliente_linda2 = null;
	private Socket socket_cliente_linda;
	private Socket c3 = null;
	private Socket c4 = null;
	private Thread_Ping tp;
	



	// le pasamos la peticion del cliente
	public Thread_Control(Socket cs, Socket socket_cliente_linda, Socket socket_cliente_linda2, Socket c3, Socket c4,Thread_Ping tp) {
		this.cs = cs;
		this.socket_cliente_linda = socket_cliente_linda;
		this.socket_cliente_linda2 = socket_cliente_linda2;
		this.c3 = c3;
		this.c4 = c4;
		this.tp = tp;

	}
	
	
	public Thread_Control(Socket cs, Socket socket_cliente_linda2, Socket c3, Socket c4) {
		this.cs = cs;
		this.socket_cliente_linda2 = socket_cliente_linda2;
		this.c3 = c3;
		this.c4 = c4;

	}
	
	public Thread_Control() {
		

	}

	public void run() {

		Scanner sc = new Scanner(System.in);
		boolean seguir = true;
		String mensaje = "";
		String mensajes1 = "";
		String mensajes2 = "";
		String mensajes3 = "";
		try {
			// para conectar con el segundo servidor2

			//////////////////////////////////////////////////////////////////////////////////////////////////
			DataInputStream in = new DataInputStream(cs.getInputStream());
			DataOutputStream out = new DataOutputStream(cs.getOutputStream());

			DataInputStream entradalinda_s1 = new DataInputStream(socket_cliente_linda.getInputStream());
			DataOutputStream salidalinda_s1 = new DataOutputStream(socket_cliente_linda.getOutputStream());

			DataInputStream entradalinda_s2 = new DataInputStream(socket_cliente_linda2.getInputStream());
			DataOutputStream salidalinda_s2 = new DataOutputStream(socket_cliente_linda2.getOutputStream());

			DataInputStream c3in = new DataInputStream(c3.getInputStream());
			DataOutputStream c3out = new DataOutputStream(c3.getOutputStream());

			DataInputStream c4in = new DataInputStream(c4.getInputStream());
			DataOutputStream c4out = new DataOutputStream(c4.getOutputStream());
			//////////////////////////////////////////////////////////////////////////////////////////////////

			out.writeUTF("Petición recibida y aceptada dede hilo1");
			out.flush();
			String[] t = null;
			
			boolean activeC = true;
			while (true) {
				
				

				// ping para el servidor copia
				try {
					c4out.writeUTF("ping");
				} catch (SocketException e) {
					// System.out.println(e.getMessage());
					activeC = false;
				}
				

				if (in.available() > 0) {
					System.out.println("nuevo mensajes del cliente");
					mensaje = in.readUTF();
					t = mensaje.split(" ");
					System.out.println("Longitud--> " + t.length + "--> del mensaje = " + (t.length - 1));
					if ((t.length - 1) < 3 || (t.length - 1) == 3) {
						// enviamos al primer servidor
						// si el comado es PN
						if (Thread_Ping.active == true && activeC == true) {
							if(Thread_Ping.reiniciado) {
								salidalinda_s1 = tp.getSalidalinda();
								entradalinda_s1 = tp.getEntradalinda();
								Thread_Ping.reiniciado = false;
							}
							System.out.println("active++ = " + Thread_Ping.active);
							salidalinda_s1.writeUTF(mensaje);
							c4out.writeUTF(mensaje);
							salidalinda_s1.flush();
							c4out.flush();
							System.out.println("Mensaje enviado al servidor1 -> " + mensaje);
						} else if (Thread_Ping.active == false) {
							// si el servidor 1 esta caido pues enviamos el mensaje ya al servidor copia
							//.out.println("active = " + active);
							c4out.writeUTF(mensaje);
							c4out.flush();
							System.out.println("-------------------------------------------------------");
							System.out.println("-------------------------------------------------------");
							System.out.println("--------------EL SERSIDOR 1 HA CAIDO-------------------");
							System.out.println("-------------------------------------------------------");
							System.out.println("-------------------------------------------------------");
							// out.writeUTF("INSERTE UNA CADENA MAS LARGA");
						} else if (activeC == false) {
							// si el servidor 1 esta caido pues enviamos el mensaje ya al servidor copia
							//System.out.println("activeC = " + active);
							salidalinda_s1.writeUTF(mensaje);
							salidalinda_s1.flush();
							System.out.println("-----------------------------------------------------------");
							System.out.println("-----------------------------------------------------------");
							System.out.println("--------------EL SERSIDOR COPIA HA CAIDO-------------------");
							System.out.println("-----------------------------------------------------------");
							System.out.println("-----------------------------------------------------------");

						}

					} else if ((t.length - 1) == 4 || (t.length - 1) == 5) {
						// enviamos al segundo servidor
						salidalinda_s2.writeUTF(mensaje);
						salidalinda_s2.flush();
						System.out.println("Mensaje enviado al servidor2 -> " + mensaje);
					} else if ((t.length - 1) == 6) {
						// enviamos al tercer servidor
						c3out.writeUTF(mensaje);
						c3out.flush();
						System.out.println("Mensaje enviado al servidor3 -> " + mensaje);
					} else if (mensaje.equals("fin")) {
						System.out.println("fin del programa");
						break;
					}
					out.flush();
					salidalinda_s2.flush();
					salidalinda_s1.flush();
				} else {
					// System.out.println("sin entrada");
				}

				if (entradalinda_s1.available() > 0) {
					// System.out.println("nuevo mensaje de SERVIDOR 1");
					mensajes1 = entradalinda_s1.readUTF();
					// System.out.println("mensaje recibido desde el s1 en hilo2: " + mensajes1);
					if (mensajes1.equalsIgnoreCase("enviamos tupla desde servidor 1")
							|| mensajes1.equalsIgnoreCase("enviamos tupla desde servidor 1.1")
							|| mensajes1.equalsIgnoreCase("enviamos tupla desde servidor 1.2")) {
						System.out.println("--------------mensaje encontrado---------------------");
						out.writeUTF("S1::DATOS ENVIADOS CORRECTAMENTE");
						out.flush();
					} else if (mensajes1.equalsIgnoreCase("SERVIDOR 1 ACTIVO")) {
						// System.out.println("SERVIDOR 1 ACTIVO");
					} else {
						System.out.println("--------------mensaje distinto ---------------------");
						out.writeUTF("S1::DATOS READ ENCONTRADOS: " + mensajes1);
					}
				} else {
					// System.out.println("no hay datos de entrada de s1 ");
				}

				if (entradalinda_s2.available() > 0) {
					System.out.println("nuevo mensajes de s2");
					mensajes2 = entradalinda_s2.readUTF();
					System.out.println("mensaje recibido desde el s2 en hilo3: " + mensajes2);
					if (mensajes2.equalsIgnoreCase("enviamos tupla desde servidor 2")) {
						out.writeUTF("S2::DATOS ENVIADOS CORRECTAMENTE");
						out.flush();
					} else {
						out.writeUTF("S2::DATOS READ ENCONTRADOS: " + mensajes2);
					}
				}

				if (c3in.available() > 0) {
					System.out.println("nuevo mensajes de s3");
					mensajes3 = c3in.readUTF();
					System.out.println("mensaje recibido desde el s3 en hilo4: " + mensajes3);
					if (mensajes3.equalsIgnoreCase("enviamos tupla desde servidor 3")) {
						out.writeUTF("S3::DATOS ENVIADOS CORRECTAMENTE");
						out.flush();
						System.out.println("retornanmos datos al cliente");
					} else {
						out.writeUTF("S3::DATOS READ ENCONTRADOS: " + mensajes3);
					}
				}

				if (c4in.available() > 0) {
					//System.out.println("nuevo mensaje de SERVIDOR COPIA");
					mensajes1 = c4in.readUTF();
					//System.out.println("mensaje recibido desde el s1 en hilo2: " + mensajes1);
					if (mensajes1.equalsIgnoreCase("copiado")) {
						System.out.println("--------------mensaje encontrado---------------------");
						System.out.println("SCopia::DATOS ENVIADOS CORRECTAMENTE");
						if (Thread_Ping.active == false) {
							out.writeUTF("SCopia::DATOS ENVIADOS CORRECTAMENTE");
							out.flush();
						}
					} else if (mensajes1.equalsIgnoreCase("SERVIDOR copia ACTIVO")) {
						// System.out.println("SERVIDOR 1 ACTIVO");
					} else {
						System.out.println("--------------mensaje distinto ---------------------");
						System.out.println("SCopia::DATOS READ ENCONTRADOS: " + mensajes1);
					}
				} else {
					// System.out.println("no hay datos de entrada de s1 ");
				}
			}
			socket_cliente_linda.close();
			socket_cliente_linda2.close();
			cs.close();// Fin de la conexión
			socket_cliente_linda.close();
			c3.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
