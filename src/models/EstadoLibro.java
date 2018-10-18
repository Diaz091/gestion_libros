package models;

import javax.swing.DefaultComboBoxModel;

public enum EstadoLibro {
	
	NUEVO("Nuevo"),
	USADONUEVO("Usado Nuevo"),
	USADOSEMINUEVO("Usado Seminuevo"),
	USADOESTROPEADO("Usado Estropeado"),
	RESTAURADO("Restaurado");

	private String estado; 
	
	EstadoLibro(String name) {
		
		this.estado=name;
	}
	
	public String getTexto() {
		return estado;
	}
	
	public static EstadoLibro getEstado(String str) {

		for( EstadoLibro e : EstadoLibro.values() ) {
			if( str.equalsIgnoreCase( e.getTexto() ) ) {
				return e;
			}
		}
		
		return null;
	}
	
	public static DefaultComboBoxModel < EstadoLibro > cargarModeloCombo(){
		DefaultComboBoxModel < EstadoLibro > modeloEstados = new DefaultComboBoxModel < EstadoLibro >();
		
			for( EstadoLibro es : EstadoLibro.values() ) {
				modeloEstados.addElement( es );
			}
		
		return modeloEstados;
	}
	
	@Override
	public String toString() {
		return getTexto();
	}
	
}
