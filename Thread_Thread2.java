package servidorlinda;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Thread_Thread2 extends Thread {
	private Socket socket_cliente_linda = null;

	public Thread_Thread2(Socket socket_cliente_linda) {
		this.socket_cliente_linda = socket_cliente_linda;
	}

	public void run() {
		int contador2 = 0;
		// abrimos las tuberias
		try {
			DataInputStream in = new DataInputStream(socket_cliente_linda.getInputStream()); // tuberias llegada
			DataOutputStream out = new DataOutputStream(socket_cliente_linda.getOutputStream()); // tuberias
			String msg1 = "";
			String[] result = null;
			ArrayList<Tupla1> objeto = new ArrayList<>();
			Tupla1 x = null;
			// inicimaso un bucle infinito para atender una peticion y devolver un resultado
			while (true) {
				msg1 = in.readUTF();
				// System.out.println("ltr="+msg1);
				if (socket_cliente_linda.isConnected()) {
					if (msg1.equalsIgnoreCase("ping")) {
						System.out.println("entra el ping");
						// System.out.println("si");
						// System.out.println("SERVIDOR 1 ACTIVO");
						out.writeUTF("SERVIDOR 1 ACTIVO");
					}
				}
				if (msg1.contains("PN")) {
					// separamos los datos para poder almacenarlos en la tupla
					result = msg1.split(" ");
					if (result.length - 1 == 1) {
						String A = result[1];
						Tupla1 t = new Tupla1(A);
						objeto.add(t);
						System.out.println("enviamos tupla desde servidor 1");
						out.writeUTF("enviamos tupla desde servidor 1");
					} else if (result.length - 1 == 2) {
						String A = result[1];
						String B = result[2];
						Tupla1 t = new Tupla1(A, B);
						objeto.add(t);
						System.out.println("enviamos tupla desde servidor 1");
						out.writeUTF("enviamos tupla desde servidor 1.1");
					} else {
						String A = result[1];
						String B = result[2];
						String C = result[3];
						// insertamos en la tupla
						Tupla1 t = new Tupla1(A, B, C);
						objeto.add(t);
						System.out.println("enviamos tupla desde servidor 1");
						out.writeUTF("enviamos tupla desde servidor 1.2");
					}
				}
				if (msg1.contains("ReadN")) {
					String d1 = " ";
					String d2 = " ";
					String d3 = " ";
					result = msg1.split(" ");
					System.out.println("result= " + result);
					if (result.length - 1 == 1) {
						String A = result[1];
						for (int i = 0; i < objeto.size(); i++) {
							x = objeto.get(i);
							System.out.println("cogemos el objeto = " + x);
							if (objeto.get(i).getDato1().equalsIgnoreCase(A)) {
								String s = objeto.get(i).getDato1();
								System.out.println("Encontrado");
								out.writeUTF(s);
								break;
							} else {
								System.out.println("No Encontrado");
								out.writeUTF("TUPLA NO ENCONTRADA");
							}
						}
						System.out.println("leemos datos desde servidor 1");

					} else if (result.length - 1 == 2) {
						System.out.println("entramos en 2222222");
						String A = result[1];
						String B = result[2];
						int contador = 0;
						for (int i = 0; i < objeto.size(); i++) {
							x = objeto.get(i);
							System.out.println("cogemos el objeto = " + x);
							System.out.println(
									"##############vuelta numero" + contador + " ############################");
							if (objeto.get(i).getDato2() != null && objeto.get(i).getDato3() == null) {
								if (objeto.get(i).getDato1().equalsIgnoreCase(A)
										&& objeto.get(i).getDato2().equalsIgnoreCase(B)) {
									String s = objeto.get(i).getDato1() + " " + objeto.get(i).getDato2();
									System.out.println("Encontrado2");
									out.writeUTF(s);
									break;
								} else {
									System.out.println("No Encontrado");
								}
							}
						}
					} else if (result.length - 1 == 3) {
						System.out.println("result leng= " + result.length);
						System.out.println("entramos en 999");
						System.out.println("entramos en 999" + result[1]);
						String A = result[1];
						String B = result[2];
						String C = result[3];
						int encontrado = 0;
						int contador = 0;
						// cogemos el size del array por lo tanto tenemos algo similar
						// [tato1,dato2,dato3]
						for (int i = 0; i < objeto.size(); i++) {
							System.out.println(
									"##############vuelta numero" + contador + " ############################");
							// como no podemos recorrer un objeto ya que no es una
							x = objeto.get(i);
							System.out.println("cogemos el objeto = " + x);
							//
							if (x.getDato1().equals(A)) {
								encontrado++;
								d1 = x.getDato1();
								System.out.println("encontramos la primera");
								if (x.getDato2().equals(B)) {
									encontrado++;
									d2 = x.getDato2();
									System.out.println("encontramos la segunda");
									if (x.getDato3().equals(C)) {
										encontrado++;
										d3 = x.getDato2();
										System.out.println("encontramos la tercera");
										// out.writeUTF(d1+" "+d2+" "+d3);
										// out.flush();
										break;
									} else {
										System.out.println("******** no encontramos el tercero********");
										encontrado = 0;
									}
								} else {
									System.out.println("******** no encontramos el segundo********");
									encontrado = 0;
								}

							} else {
								System.out.println("******** no encontramos el primero********");
								encontrado = 0;
							}
						}
						// si hemos encontrado todos los valores, devolvemos
						System.out.println("++"+encontrado);
						if (encontrado == 4) {
							out.writeUTF(d1 + " " + d2 + " " + d3);
							out.flush();
						} else {
							out.writeUTF("********NO EXISTE LA TUPLA!!********");
						}
					}
				}

				if (msg1.contains("RN")) {
					//
					String d1 = " ";
					String d2 = " ";
					String d3 = " ";
					int contador = 0;
					result = msg1.split(" ");
					System.out.println("result= " + result);
					if (result.length - 1 == 1) {
						String A = result[1];
						for (int i = 0; i < objeto.size(); i++) {
							x = objeto.get(i);
							System.out.println("cogemos el objeto = " + x);
							System.out.println(
									"##############vuelta numero" + contador + " ############################");
							if (objeto.get(i).getDato1().equalsIgnoreCase(A)) {
								String s = objeto.get(i).getDato1();
								objeto.remove(i);
								System.out.println("Encontrado");
								out.writeUTF("---------------BORRADO----------");

							} else {
								System.out.println("No Encontrado");
								out.writeUTF("TUPLA NO ENCONTRADA");
							}
						}
						System.out.println("leemos datos desde servidor 1");

					} else if (result.length - 1 == 2) {
						System.out.println("entramos en 2222222");
						String A = result[1];
						String B = result[2];
						for (int i = 0; i < objeto.size(); i++) {
							if (objeto.get(i).getDato2() != null && objeto.get(i).getDato3() == null) {
								if (objeto.get(i).getDato1().equalsIgnoreCase(A)
										&& objeto.get(i).getDato2().equalsIgnoreCase(B)) {
									String s = objeto.get(i).getDato1() + " " + objeto.get(i).getDato2();
									System.out.println("Encontrado2");
									objeto.remove(i);
									out.writeUTF("---------------BORRADO----------");

								} else {
									System.out.println("No Encontrado");
								}
							}
						}
					} else if (result.length - 1 == 3) {
						System.out.println("result leng= " + result.length);
						System.out.println("entramos en 999");
						System.out.println("entramos en 999" + result[1]);
						String A = result[1];
						String B = result[2];
						String C = result[3];
						int encontrado = 0;
						int contador1 = 0;
						// cogemos el size del array por lo tanto tenemos algo similar
						// [tato1,dato2,dato3]
						for (int i = 0; i < objeto.size(); i++) {
							System.out.println(
									"##############vuelta numero" + contador1 + " ############################");
							// como no podemos recorrer un objeto ya que no es una
							x = objeto.get(i);
							System.out.println("cogemos el objeto = " + x);
							//
							if (x.getDato1().equals(A)) {
								encontrado++;
								d1 = x.getDato1();
								System.out.println("encontramos la primera");
								if (x.getDato2().equals(B)) {
									encontrado++;
									d2 = x.getDato2();
									System.out.println("encontramos la segunda");
									if (x.getDato3().equals(C)) {
										encontrado++;
										d3 = x.getDato2();
										System.out.println("encontramos la tercera");
										objeto.remove(i);
									} else {
										System.out.println("******** no encontramos el tercero********");
										encontrado = 0;
									}
								} else {
									System.out.println("******** no encontramos el segundo********");
									encontrado = 0;
								}

							} else {
								System.out.println("******** no encontramos el segundo********");
								encontrado = 0;
							}
						}
						// si hemos encontrado todos los valores, devolvemos
						if (encontrado == 3) {
							String s = d1 + " " + d2 + " " + d3;

							out.writeUTF("---------------BORRADO----------");
							out.flush();
						} else {
							out.writeUTF("********NO EXISTE LA TUPLA!!********");
						}
					}
				}
				contador2++;
				if (msg1.equalsIgnoreCase("FinalizarS1")) {
					break;
				}
			}
			socket_cliente_linda.close();
			// Creamos un buffer de 8KB
		} catch (Exception e) {
			System.out.println("Entramos a catch");
			e.printStackTrace();
		}
	}
}
