package controller.gestorLibros;

import interfaces.GestorLibros;

public class ControladorLibros {

	private static ControladorLibros  instancia;
	private static GestorLibros gestLibros;
	
	// =========== INICIO SINGLETON =========== // 
	public static ControladorLibros instancia() {
		if( instancia == null ) 
				instancia = new ControladorLibros();
		return instancia;
	}
	
	// =========== FIN SINGLETON =========== //
	
	private ControladorLibros() {}
	
	
	
	
}
