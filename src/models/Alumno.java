package models;

public class Alumno {
	
	private		String		dni;
	private		String		nombre;
	private		String		apell_1;
	private		String		apell_2;
	
	public Alumno( String dni , String nombre , String apell_1 , String apell_2 ) {
	
		this.dni 		= 	dni;
		this.nombre 	= 	nombre;
		this.apell_1 	= 	apell_1;
		this.apell_2 	= 	apell_2;
	}

	@Override
	public String toString() {
		return dni + ", " +apell_1 + ", " + nombre ;
	}

	
	
			// Getters \\
	
	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApell_1() {
		return apell_1;
	}

	public String getApell_2() {
		return apell_2;
	}
	

	
	
	

}
