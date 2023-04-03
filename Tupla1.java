package servidorlinda;

import java.io.Serializable;

public class Tupla1 implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dato1;
	private String dato2;
	private String dato3;
	private String dato4;
	private String dato5;
	private String dato6;
	private int size;
	
	public Tupla1() {}
	
	public Tupla1(String dato1) {
		this.dato1 = dato1;
		calucarSize();
	}
	
	public Tupla1(String dato1,String dato2) {
		this.dato1 = dato1;
		this.dato2 = dato2;
		calucarSize();
	}
    
    
	public Tupla1(String dato1,String dato2,String dato3) {
		this.dato1 = dato1;
		this.dato2 = dato2;
		this.dato3 = dato3;
	}
	
	public Tupla1(String dato1,String dato2,String dato3,String dato4) {
		this.dato1 = dato1;
		this.dato2 = dato2;
		this.dato3 = dato3;
		this.dato4 = dato4;
	}
	
	public Tupla1(String dato1,String dato2,String dato3,String dato4,String dato5) {
		this.dato1 = dato1;
		this.dato2 = dato2;
		this.dato3 = dato3;
		this.dato4 = dato4;
		this.dato5 = dato5;
	}
	
	public Tupla1(String dato1,String dato2,String dato3,String dato4,String dato5,String dato6) {
		this.dato1 = dato1;
		this.dato2 = dato2;
		this.dato3 = dato3;
		this.dato4 = dato4;
		this.dato5 = dato5;
		this.dato6 = dato6;
	}
	
	
	public void calucarSize() {
		this.size = 0;
		if(this.dato1 != null) {
			this.size++;
		}
		if(this.dato2 != null) {
			this.size++;
		}
		if(this.dato3 != null) {
			this.size++;
		}
		if(this.dato4 != null) {
			this.size++;
		}
		if(this.dato5 != null) {
			this.size++;
		}
		if(this.dato6 != null) {
			this.size++;
		}
		
	}
	
	public int calucarSize2() {
		this.size = 0;
		if(this.dato1 != null) {
			this.size++;
		}
		if(this.dato2 != null) {
			this.size++;
		}
		if(this.dato3 != null) {
			this.size++;
		}
		if(this.dato4 != null) {
			this.size++;
		}
		if(this.dato5 != null) {
			this.size++;
		}
		if(this.dato6 != null) {
			this.size++;
		}
		return size;
		
	}

	public String getDato1() {
		return dato1;
	}

	public void setDato1(String dato1) {
		this.dato1 = dato1;
	}

	public String getDato2() {
		return dato2;
	}

	public void setDato2(String dato2) {
		this.dato2 = dato2;
	}

	public String getDato3() {
		return dato3;
	}

	public void setDato3(String dato3) {
		this.dato3 = dato3;
	}

	public String getDato4() {
		return dato4;
	}

	public void setDato4(String dato4) {
		this.dato4 = dato4;
	}

	public String getDato5() {
		return dato5;
	}

	public void setDato5(String dato5) {
		this.dato5 = dato5;
	}

	public String getDato6() {
		return dato6;
	}

	public void setDato6(String dato6) {
		this.dato6 = dato6;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Tupla1 [dato1=" + dato1 + ", dato2=" + dato2 + ", dato3=" + dato3 + ", dato4=" + dato4 + ", dato5="
				+ dato5 + ", dato6=" + dato6 + ", size=" + size + "]";
	}

	
}
