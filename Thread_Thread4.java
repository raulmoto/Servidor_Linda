package servidorlinda;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Thread_Thread4 extends Thread {
	private Socket c3 = null;

	public Thread_Thread4(Socket c3) {
		this.c3 = c3;
	}

	public Thread_Thread4() {

	}

	public void run() {
		int contador2 = 0;
		// Obtenemos los flujos
		try {
			DataInputStream in = new DataInputStream(c3.getInputStream()); // tuberias llegada
			DataOutputStream out = new DataOutputStream(c3.getOutputStream()); // tuberias
			ArrayList<Tupla1> objeto = new ArrayList<>();
			System.out.println(in);
			String msg1 = "";
			String[] result = null;
			Tupla1 x = null;
			while (true) {
				msg1 = in.readUTF();
				if (msg1.contains("PN")) {
					result = msg1.split(" ");
					if (result.length - 1 == 6) {
						String A = result[1];
						String B = result[2];
						String C = result[3];
						String D = result[4];
						String E = result[5];
						String F = result[6];
						Tupla1 t = new Tupla1(A, B, C, D, E, F);
						objeto.add(t);
						System.out.println("enviamos tupla desde servidor 3");
						out.writeUTF("enviamos tupla desde servidor 3");
					}
				}
				if (msg1.contains("ReadN")) {
					int contador = 0;

					String d1 = " ";
					String d2 = " ";
					String d3 = " ";
					String d4 = " ";
					String d5 = " ";
					String d6 = " ";

					String A = result[1];
					String B = result[2];
					String C = result[3];
					String D = result[4];
					String E = result[5];
					String F = result[6];
					int encontrado = 0;

					for (int i = 0; i < objeto.size(); i++) {
						// como no podemos recorrer un objeto ya que no es una
						x = objeto.get(i);
						System.out.println("cogemos el objeto = " + x);
						System.out.println("##############vuelta numero" +contador+" ############################");
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
									d3 = x.getDato3();
									System.out.println("encontramos la tercera");
									if (x.getDato4().equals(D)) {
										encontrado++;
										d4 = x.getDato4();
										System.out.println("encontramos la cuarta");
										if (x.getDato5().equals(E)) {
											encontrado++;
											d5 = x.getDato5();
											System.out.println("encontramos la quinta");
											if (x.getDato6().equals(E)) {
												encontrado++;
												d6 = x.getDato6();
												System.out.println("encontramos la sexta");	
											} else {
												encontrado = 0;
												System.out.println("******** no encontramos el sexto********");
											}
										} else {
											encontrado = 0;
											System.out.println("******** no encontramos el quinto********");
										}
									} else {
										encontrado = 0;
										System.out.println("******** no encontramos el cuarto********");
									}
								} else {
									encontrado = 0;
									System.out.println("******** no encontramos el tercero********");
								}	
							} else {
								encontrado = 0;
								System.out.println("******** no encontramos el segundo********");
							}
						}
						contador++;
					}
					
					//si hemos encontrado todos los valores, devolvemos
    				if(encontrado == 6) {
    					System.out.println("-----------------------DATOS ENCOTRADOS-----------------------");
    					out.writeUTF(d1+" "+d2+" "+d3+" "+d4);
						out.flush();
    				}else {
    					out.writeUTF("********NO EXISTE LA TUPLA!!********");
    				}
				}if (msg1.contains("RN")) {
					int contador = 0;

					String d1 = " ";
					String d2 = " ";
					String d3 = " ";
					String d4 = " ";
					String d5 = " ";
					String d6 = " ";

					String A = result[1];
					String B = result[2];
					String C = result[3];
					String D = result[4];
					String E = result[5];
					String F = result[6];
					int encontrado = 0;

					for (int i = 0; i < objeto.size(); i++) {
						// como no podemos recorrer un objeto ya que no es una
						x = objeto.get(i);
						System.out.println("cogemos el objeto = " + x);
						System.out.println("##############vuelta numero" +contador+" ############################");
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
									d3 = x.getDato3();
									System.out.println("encontramos la tercera");
									if (x.getDato4().equals(D)) {
										encontrado++;
										d4 = x.getDato4();
										System.out.println("encontramos la cuarta");
										if (x.getDato5().equals(E)) {
											encontrado++;
											d5 = x.getDato5();
											System.out.println("encontramos la quinta");
											if (x.getDato6().equals(E)) {
												encontrado++;
												d6 = x.getDato6();
												System.out.println("encontramos la sexta");
												objeto.remove(i);
												out.flush();
												
											} else {
												encontrado = 0;
												System.out.println("******** no encontramos el sexto********");
											}
										} else {
											encontrado = 0;
											System.out.println("******** no encontramos el quinto********");
										}
									} else {
										encontrado = 0;
										System.out.println("******** no encontramos el cuarto********");
									}
								} else {
									encontrado = 0;
									System.out.println("******** no encontramos el tercero********");
								}	
							} else {
								encontrado = 0;
								System.out.println("******** no encontramos el segundo********");
							}
						}
						contador++;
					}
					if(encontrado == 6) {
    					System.out.println("-----------------------DATOS ENCOTRADOS-----------------------");
    					out.writeUTF("-----------------------DATOS ENCOTRADOS-----------------------");
						out.flush();
    				}else {
    					out.writeUTF("********NO EXISTE LA TUPLA!!********");
    				}
				}
				
				break;
			}
			c3.close();
			// Creamos un buffer de 8KB
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
