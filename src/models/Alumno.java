package models;

public class Alumno {
	
	private		String		dni;
	private		String		nombre;
	private		String		apell_1;
	private		String		apell_2;
	
	public Alumno(String dni, String nombre, String apell_1, String apell_2) {
	
		this.dni = dni;
		this.nombre = nombre;
		this.apell_1 = apell_1;
		this.apell_2 = apell_2;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apell_1=" + apell_1 + ", apell_2=" + apell_2 + "]";
	}
	
	

}
