package servidorlinda;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Thread_Thread3 extends Thread{
	private Socket socket_cliente_linda2 = null;

	public Thread_Thread3(Socket socket_cliente_linda2) {
		this.socket_cliente_linda2 = socket_cliente_linda2;
	}
	
	public Thread_Thread3() {
		
	}
	public void run() {
    	int contador2 = 0;
        // Obtenemos los flujos
            try {
            	DataInputStream in = new DataInputStream(socket_cliente_linda2.getInputStream()); // tuberias llegada
    			DataOutputStream out = new DataOutputStream(socket_cliente_linda2.getOutputStream()); // tuberias
    			ArrayList<Tupla1> objeto = new ArrayList<>();
    			String msg1 = "";
    			String []result = null;
    			Tupla1 x = null;
    			while (in != null) {
    				msg1 = in.readUTF();
    				System.out.println("Hola cliente desde servidor 2");
    				if (msg1.contains("PN")) {
    					result = msg1.split(" ");
	    				if(result.length-1 ==4) {
	    					String A = result[1];
	        				String B = result[2];
	        				String C = result[3];
	        				String D = result[4];
	    					Tupla1 t = new Tupla1(A,B,C,D);
	    					objeto.add(t);
	    					System.out.println("enviamos tupla desde servidor 2");
	    					out.writeUTF("enviamos tupla desde servidor 2");
	    				}else {
	    					String A = result[1];
	        				String B = result[2];
	        				String C = result[3];
	        				String D = result[4];
	        				String E = result[5];
	    					Tupla1 t = new Tupla1(A,B,C,D,E);
	    					objeto.add(t);
	    					System.out.println("enviamos tupla desde servidor 2");
	    					out.writeUTF("enviamos tupla desde servidor 2");
	    				}
    				}
    				
    				if (msg1.contains("ReadN")) {
    					int contador = 0;
    					String d1= " ";
    					String d2= " ";
    					String d3= " ";
    					String d4= " ";
    					String d5= " ";
    					if(result.length-1 ==4) {
	    					String A = result[1];
	        				String B = result[2];
	        				String C = result[3];
	        				String D = result[4];
	        				int encontrado = 0;
	        				
	        				
	        				for (int i = 0; i<objeto.size(); i++) {
	        					//como no podemos recorrer un objeto ya que no es una 
	        					System.out.println("##############vuelta numero" +contador+" ############################");
	        					x = objeto.get(i);
	        					System.out.println("cogemos el objeto = "+x);
	        					//
	        					if(x.getDato1().equals(A)) {
	        						encontrado++;
        							d1 = x.getDato1();
        							System.out.println("encontramos la primera " +x.getDato1()+"= "+A);
        							if(x.getDato2().equals(B)) {
        								encontrado++;
            							d2 = x.getDato2();
            							System.out.println("encontramos la segunda " +x.getDato2()+"= "+B);
            							if(x.getDato3().equals(C)) {
            								encontrado++;
                							d3 = x.getDato3();
                							System.out.println("encontramos la tercera " +x.getDato3()+"= "+C);
                							if(x.getDato4().equals(D)) {
                								encontrado++;
                    							d4 = x.getDato4();
                    							System.out.println("encontramos la cuarta " +x.getDato4()+"= "+D);
                    							//out.writeUTF(d1+" "+d2+" "+d3+" "+d4);
                    							//out.flush();
                    							
                    						}else {
                    							System.out.println("******** no encontramos el cuarto********");
                    							encontrado = 0;
                    						}
                						}else {
                							System.out.println("******** no encontramos el tercero********");
                							encontrado = 0;
                						}
            							
            						}else {
            							System.out.println("******** no encontramos el segundo********");
            							encontrado = 0;
            						}
        							
        						}else {
        							
        							System.out.println("********NO EXISTE LA TUPLA!!********");
        							encontrado = 0;
        						}
	        					contador++;
	    					}
	        				
	        				//si hemos encontrado todos los valores, devolvemos
	        				if(encontrado == 4) {
	        					System.out.println("-----------------------DATOS ENCOTRADOS-----------------------");
	        					out.writeUTF(d1+" "+d2+" "+d3+" "+d4);
    							out.flush();
	        				}else {
	        					out.writeUTF("********NO EXISTE LA TUPLA!!********");
	        				}
    					}else {
    						int contador21 = 0;
    						String A = result[1];
	        				String B = result[2];
	        				String C = result[3];
	        				String D = result[4];
	        				String E = result[5];
	        				int encontrado = 0;
	        				
	        				for (int i = 0; i<objeto.size(); i++) {
	        					//como no podemos recorrer un objeto ya que no es una 
	        					System.out.println("##############vuelta numero" +contador21+" ############################");
	        					x = objeto.get(i);
	        					System.out.println("cogemos el objeto = "+x);
	        					//
	        					if(x.getDato1().equals(A)) {
	        						encontrado++;
        							d1 = x.getDato1();
        							System.out.println("encontramos la primera "+x.getDato1()+"= "+A);
        							if(x.getDato2().equals(B)) {
        								encontrado++;
            							d2 = x.getDato2();
            							System.out.println("encontramos la segunda "+x.getDato2()+"= "+B);
            							if(x.getDato3().equals(C)) {
            								encontrado++;
                							d3 = x.getDato3();
                							System.out.println("encontramos la tercera " +x.getDato3()+"= "+C);
                							if(x.getDato4().equals(D)) {
                								encontrado++;
                    							d4 = x.getDato4();
                    							System.out.println("encontramos la cuarta " +x.getDato4()+"= "+D);
                    							if(x.getDato5().equals(E)) {
                    								encontrado++;
                        							d5 = x.getDato5();
                        							System.out.println("encontramos la quinta " +x.getDato5()+"= "+E);
                        							//out.writeUTF(d1+" "+d2+" "+d3+" "+d4+" "+d5);
                        							//out.flush();
                        							
                        						}else {
                        							System.out.println("******** no encontramos el quinto********");
                        							encontrado = 0;
                        						}
                    						}else {
                    							System.out.println("******** no encontramos el cuarto********");
                    							encontrado = 0;
                    						}
                						}else {
                							System.out.println("******** no encontramos el tercero********");
                							encontrado = 0;
                						}
            						}else {
            							System.out.println("******** no encontramos el segundo********");
            							encontrado = 0;
            						}
        							
        						}else {
        							System.out.println("********NO EXISTE LA TUPLA!!********");
        							encontrado = 0;
        						}	
	        					contador21++;//13
	    					}
	        				System.out.println("+++++ "+encontrado);
	        				//si hemos encontrado todos los valores, devolvemos
	        				if(encontrado == 5) {
	        					System.out.println("-----------------------DATOS ENCOTRADOS-----------------------");
	        					out.writeUTF(d1+" "+d2+" "+d3+" "+d4+" "+d5);
    							out.flush();
	        				}else {
	        					out.writeUTF("********NO EXISTE LA TUPLA!!********");
	        				}
	        					
    					}
    				}
    				
    				if(msg1.contains("RN")) {
    					//eliminar
    					int contador = 0;
    					String d1= " ";
    					String d2= " ";
    					String d3= " ";
    					String d4= " ";
    					String d5= " ";
    					
    					if(result.length-1 ==4) {
    						String A = result[1];
	        				String B = result[2];
	        				String C = result[3];
	        				String D = result[4];
	        				int encontrado = 0;
    						for (int i = 0; i<objeto.size(); i++) {
	        					//como no podemos recorrer un objeto ya que no es una 
	        					System.out.println("##############vuelta numero" +contador+" ############################");
	        					x = objeto.get(i);
	        					System.out.println("cogemos el objeto = "+x);
	        					//
	        					if(x.getDato1().equals(A)) {
	        						encontrado++;
        							d1 = x.getDato1();
        							System.out.println("encontramos la primera " +x.getDato1()+"= "+A);
        							if(x.getDato2().equals(B)) {
        								encontrado++;
            							d2 = x.getDato2();
            							System.out.println("encontramos la segunda " +x.getDato2()+"= "+B);
            							if(x.getDato3().equals(C)) {
            								encontrado++;
                							d3 = x.getDato3();
                							System.out.println("encontramos la tercera " +x.getDato3()+"= "+C);
                							if(x.getDato4().equals(D)) {
                								encontrado++;
                    							d4 = x.getDato4();
                    							System.out.println("encontramos la cuarta " +x.getDato4()+"= "+D);
                    							//eliminamos el objeto
                    							objeto.remove(i);
                    							
                    						}else {
                    							System.out.println("******** no encontramos el cuarto********");
                    							encontrado = 0;
                    						}
                						}else {
                							System.out.println("******** no encontramos el tercero********");
                							encontrado = 0;
                						}
            							
            						}else {
            							System.out.println("******** no encontramos el segundo********");
            							encontrado = 0;
            						}	
        						}
	        					contador++;
	    					}
    						if(encontrado == 4) {
    							String s = d1+" "+d2+" "+d3+" "+d4;
    							out.writeUTF("---------------BORRADO----------");
    							out.flush();
	        				}else {
	        					out.writeUTF("********NO EXISTE LA TUPLA!!********");
	        				}	
    					}else {
    						////////////////////////////
    						int contador21 = 0;
    						String A = result[1];
	        				String B = result[2];
	        				String C = result[3];
	        				String D = result[4];
	        				String E = result[5];
	        				int encontrado = 0;
	        				
	        				for (int i = 0; i<objeto.size(); i++) {
	        					//como no podemos recorrer un objeto ya que no es una 
	        					System.out.println("##############vuelta numero" +contador21+" ############################");
	        					x = objeto.get(i);
	        					System.out.println("cogemos el objeto = "+x);
	        					//
	        					if(x.getDato1().equals(A)) {
	        						encontrado++;
        							d1 = x.getDato1();
        							System.out.println("encontramos la primera "+x.getDato1()+"= "+A);
        							if(x.getDato2().equals(B)) {
        								encontrado++;
            							d2 = x.getDato2();
            							System.out.println("encontramos la segunda "+x.getDato2()+"= "+B);
            							if(x.getDato3().equals(C)) {
            								encontrado++;
                							d3 = x.getDato3();
                							System.out.println("encontramos la tercera " +x.getDato3()+"= "+C);
                							if(x.getDato4().equals(D)) {
                								encontrado++;
                    							d4 = x.getDato4();
                    							System.out.println("encontramos la cuarta " +x.getDato4()+"= "+D);
                    							if(x.getDato5().equals(E)) {
                    								encontrado++;
                        							d5 = x.getDato5();
                        							System.out.println("encontramos la quinta " +x.getDato5()+"= "+E);
                        							objeto.remove(i);
                        							
                        						}else {
                        							System.out.println("******** no encontramos el quinto********");
                        							encontrado = 0;
                        						}
                    						}else {
                    							System.out.println("******** no encontramos el cuarto********");
                    							encontrado = 0;
                    						}
                						}else {
                							System.out.println("******** no encontramos el tercero********");
                							encontrado = 0;
                						}
            						}else {
            							System.out.println("******** no encontramos el segundo********");
            							encontrado = 0;
            						}
        							
        						}else {
        							System.out.println("********NO EXISTE LA TUPLA!!********");
        							encontrado = 0;
        						}	
	        					contador21++;//13
	    					}
	        				System.out.println("+++++ "+encontrado);
	        				//si hemos encontrado todos los valores, devolvemos
	        				if(encontrado == 5) {
	        					System.out.println("-----------------------DATOS ENCOTRADOS-----------------------");
	        					out.writeUTF("-----------------------DATOS ENCOTRADOS-----------------------");
    							out.flush();
	        				}else {
	        					out.writeUTF("********NO EXISTE LA TUPLA!!********");
	        				}
    					}
    				}
    				
    			}
	            // Creamos un buffer de 8KB
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}       
    }
}
