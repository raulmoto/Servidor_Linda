package servidorlinda;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Thread_Thread5 extends Thread{
	private Socket c4 = null;

	public Thread_Thread5(Socket c4) {
		this.c4 = c4;
	}
	
	public Thread_Thread5() {
		
	}

	public void run() {
    	int contador2 = 0;
        // Obtenemos los flujos
            try {
            	DataInputStream in = new DataInputStream(c4.getInputStream()); // tuberias llegada
    			DataOutputStream out = new DataOutputStream(c4.getOutputStream()); // tuberias
    			String msg1 = "";
    			String []result = null;
    			ArrayList<Tupla1> objeto_copia = new ArrayList<>();
    			Tupla1 x = null;
    			while (true) {
    				msg1 = in.readUTF();
    				if(msg1.contains("ping")) {
    					//System.out.println("entra ping copia");
    					//System.out.println("SERVIDOR 1 ACTIVO");
    					out.writeUTF("SERVIDOR copia ACTIVO");
    				}
    				
    				
    				if (msg1.contains("PN")) {
	    				//separamos los datos para poder almacenarlos en la tupla
	    				result = msg1.split(" ");
	    				if(result.length-1 ==1) {
	    					String A = result[1];
	    					Tupla1 t = new Tupla1(A);
	    					objeto_copia.add(t);
	    					System.out.println("copiado en servidor copia");
	    					out.writeUTF("copiado");
	    				}else if (result.length-1 ==2) {
	    					String A = result[1];
	        				String B = result[2];
	        				Tupla1 t = new Tupla1(A,B);
	        				objeto_copia.add(t);
	        				System.out.println("copiado en servidor copia");
	        				out.writeUTF("copiado");
	    				}else {
	    					String A = result[1];
	        				String B = result[2];
	        				String C = result[3];
	        				//insertamos en la tupla
	        				Tupla1 t = new Tupla1(A,B,C);
	        				objeto_copia.add(t);
	        				System.out.println("enviamos tupla desde servidor copia");
	        				out.writeUTF("copiado");
	    				}
    				}
    				if (msg1.contains("ReadN")) {
    					String d1= " ";
    					String d2= " ";
    					String d3= " ";
    					result = msg1.split(" ");
    					System.out.println("result= " +result);
    					if(result.length-1 ==1) {
	    					String A = result[1];
	    					for (int i = 0; i<objeto_copia.size(); i++) {
	    						x = objeto_copia.get(i);
	        					System.out.println("cogemos el objeto = "+x);
	    						if (objeto_copia.get(i).getDato1().equalsIgnoreCase(A)) {
	    							String s = objeto_copia.get(i).getDato1();
	    					        System.out.println("Encontrado");
	    					        out.writeUTF("enviamos tupla desde servidor copia");
	    					        break;
	    					    }else {
	    					    	System.out.println("No Encontrado");
	    					    	out.writeUTF("TUPLA NO ENCONTRADA");
	    					    }
	    					}
	    					System.out.println("leemos datos desde servidor copia");
	    					
	    				}else if (result.length-1 ==2) {
	    					System.out.println("entramos en 2222222");
	    					String A = result[1];
	        				String B = result[2];
	        				int contador= 0;
	        				for (int i = 0; i<objeto_copia.size(); i++) {
	        					x = objeto_copia.get(i);
	        					System.out.println("cogemos el objeto = "+x);
	        					System.out.println("##############vuelta numero" +contador+" ############################");
	        					if(objeto_copia.get(i).getDato2() != null && objeto_copia.get(i).getDato3() == null) {
	        						if (objeto_copia.get(i).getDato1().equalsIgnoreCase(A) && objeto_copia.get(i).getDato2().equalsIgnoreCase(B)) {
		    							String s = objeto_copia.get(i).getDato1() +" "+ objeto_copia.get(i).getDato2();
		    					        System.out.println("Encontrado2");
		    					        out.writeUTF(s);
		    					        break;
		    					    }else {System.out.println("No Encontrado");}
	        					}
	    					}
	    				}else if (result.length-1 ==3) {
	    					System.out.println("result leng= " +result.length);
	    					System.out.println("entramos en 999");
	    					System.out.println("entramos en 999"+result[1]);
	    					String A = result[1];
	        				String B = result[2];
	        				String C = result[3];
	        				int encontrado = 0;
	        				int contador = 0;
	        				//cogemos el size del array por lo tanto tenemos algo similar [tato1,dato2,dato3]
	        				for (int i = 0; i<objeto_copia.size(); i++) {
	        					System.out.println("##############vuelta numero" +contador+" ############################");
	        					//como no podemos recorrer un objeto ya que no es una 
	        					x = objeto_copia.get(i);
	        					System.out.println("cogemos el objeto = "+x);
	        					//
	        					if(x.getDato1().equals(A)) {
	        						 encontrado++;
        							d1 = x.getDato1();
        							System.out.println("encontramos la primera");
        							if(x.getDato2().equals(B)) {
        								encontrado++;
            							d2 = x.getDato2();
            							System.out.println("encontramos la segunda");
            							if(x.getDato3().equals(C)) {
            								encontrado++;
                							d3 = x.getDato2();
                							System.out.println("encontramos la tercera");
                							//out.writeUTF(d1+" "+d2+" "+d3);
                							//out.flush();
                							break;
                						}else {
                							System.out.println("******** no encontramos el tercero********");
                							encontrado = 0;
                						}
            						}else {
            							System.out.println("******** no encontramos el segundo********");
            							encontrado = 0;
            						}
        							
        						}else {
        							System.out.println("******** no encontramos el segundo********");
        							encontrado = 0;
        						}	
	    					}
	        				//si hemos encontrado todos los valores, devolvemos
	        				if(encontrado == 4) {
	        					out.writeUTF(d1+" "+d2+" "+d3);
    							out.flush();
	        				}else {
	        					out.writeUTF("********NO EXISTE LA TUPLA!!********");
	        				}
	    				}	
    				}
    				
    				if (msg1.contains("RN")) {
    					//
    					String d1= " ";
    					String d2= " ";
    					String d3= " ";
    					int contador = 0;
    					result = msg1.split(" ");
    					System.out.println("result= " +result);
    					if(result.length-1 ==1) {
	    					String A = result[1];
	    					for (int i = 0; i<objeto_copia.size(); i++) {
	    						x = objeto_copia.get(i);
	        					System.out.println("cogemos el objeto = "+x);
	        					System.out.println("##############vuelta numero" +contador+" ############################");
	    						if (objeto_copia.get(i).getDato1().equalsIgnoreCase(A)) {
	    							String s = objeto_copia.get(i).getDato1();
	    							objeto_copia.remove(i);
	    					        System.out.println("Encontrado");
	    					        out.writeUTF("---------------BORRADO----------");
	    					       
	    					    }else {
	    					    	System.out.println("No Encontrado");
	    					    	out.writeUTF("TUPLA NO ENCONTRADA");
	    					    }
	    					}
	    					System.out.println("leemos datos desde servidor copia");
	    					
	    				}else if (result.length-1 ==2) {
	    					System.out.println("entramos en 2222222");
	    					String A = result[1];
	        				String B = result[2];
	        				for (int i = 0; i<objeto_copia.size(); i++) {
	        					if(objeto_copia.get(i).getDato2() != null && objeto_copia.get(i).getDato3() == null) {
	        						if (objeto_copia.get(i).getDato1().equalsIgnoreCase(A) && objeto_copia.get(i).getDato2().equalsIgnoreCase(B)) {
		    							String s = objeto_copia.get(i).getDato1() +" "+ objeto_copia.get(i).getDato2();
		    					        System.out.println("Encontrado2");
		    					        objeto_copia.remove(i);
		    					        out.writeUTF("---------------BORRADO----------");
		    					       
		    					    }else {System.out.println("No Encontrado");}
	        					}
	    					}
	    				}else if (result.length-1 ==3) {
	    					System.out.println("result leng= " +result.length);
	    					System.out.println("entramos en 999");
	    					System.out.println("entramos en 999"+result[1]);
	    					String A = result[1];
	        				String B = result[2];
	        				String C = result[3];
	        				int encontrado = 0;
	        				int contador1 = 0;
	        				//cogemos el size del array por lo tanto tenemos algo similar [tato1,dato2,dato3]
	        				for (int i = 0; i<objeto_copia.size(); i++) {
	        					System.out.println("##############vuelta numero" +contador1+" ############################");
	        					//como no podemos recorrer un objeto ya que no es una 
	        					x = objeto_copia.get(i);
	        					System.out.println("cogemos el objeto = "+x);
	        					//
	        					if(x.getDato1().equals(A)) {
	        						 encontrado++;
        							d1 = x.getDato1();
        							System.out.println("encontramos la primera");
        							if(x.getDato2().equals(B)) {
        								encontrado++;
            							d2 = x.getDato2();
            							System.out.println("encontramos la segunda");
            							if(x.getDato3().equals(C)) {
            								encontrado++;
                							d3 = x.getDato2();
                							System.out.println("encontramos la tercera");
                							objeto_copia.remove(i);
                						}else {
                							System.out.println("******** no encontramos el tercero********");
                							encontrado = 0;
                						}
            						}else {
            							System.out.println("******** no encontramos el segundo********");
            							encontrado = 0;
            						}
        							
        						}else {
        							System.out.println("******** no encontramos el segundo********");
        							encontrado = 0;
        						}	
	    					}
	        				//si hemos encontrado todos los valores, devolvemos
	        				if(encontrado == 3) {
	        					String s = d1+" "+d2+" "+d3;
	        				
	        					out.writeUTF("---------------BORRADO----------");
    							out.flush();
	        				}else {
	        					out.writeUTF("********NO EXISTE LA TUPLA!!********");
	        				}
	    				}
    				}
    				contador2++;
    				if(msg1.equalsIgnoreCase("FinalizarS1")) {
    					break;
    				}	
    			}
    			c4.close();
	            // Creamos un buffer de 8KB
			} catch (Exception e) {
				System.out.println("Entramos a catch");
				e.printStackTrace();
			}       
    }
}
