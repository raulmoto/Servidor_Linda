package servidorlinda;

public class DatosCompartidos {

	/*Pre:--
	 *Post:estos datos estan co partidos entre linda y el hilo ping para comprobar si los servidores estan caidos
	 * */
	private boolean servidor1;
	private boolean servidor_copia ;
	static Thread_Thread2 hilo1;
	static Thread_Ping ping;
	static Thread_Thread5 hilo_copia;
	
	
	public DatosCompartidos(boolean a,boolean b) {
		this.servidor1 = a;
		this.servidor_copia = b;
	}
	
	public DatosCompartidos() {

	}

	public boolean isServidor1() {
		return servidor1;
	}

	public void setServidor1(boolean servidor1) {
		this.servidor1 = servidor1;
	}

	public boolean isServidor_copia() {
		return servidor_copia;
	}

	public void setServidor_copia(boolean servidor_copia) {
		this.servidor_copia = servidor_copia;
	}

	public static Thread_Thread2 getHilo1() {
		return hilo1;
	}

	public static void setHilo1(Thread_Thread2 hilo1) {
		DatosCompartidos.hilo1 = hilo1;
	}

	public static Thread_Ping getPing() {
		return ping;
	}

	public static void setPing(Thread_Ping ping) {
		DatosCompartidos.ping = ping;
	}

	public static Thread_Thread5 getHilo_copia() {
		return hilo_copia;
	}

	public static void setHilo_copia(Thread_Thread5 hilo_copia) {
		DatosCompartidos.hilo_copia = hilo_copia;
	}


	
	

}
