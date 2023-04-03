package servidorlinda;

public class Estado_Servidor1 {
	
	static boolean servidor1Disponible = true;
	public Estado_Servidor1() {
		
	}
	public static boolean isServidor1Disponible() {
		return servidor1Disponible;
	}
	public static void setServidor1Disponible(boolean servidor1Disponible) {
		Estado_Servidor1.servidor1Disponible = servidor1Disponible;
	}
	
	

}
