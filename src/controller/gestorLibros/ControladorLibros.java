package controller.gestorLibros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.mainMenu.ControladorMainMenu;
import interfaces.GestorLibros;
import interfaces.MainMenu;
import models.DataResource;
import models.EstadoLibro;
import models.Libro;

public class ControladorLibros {

	private static ControladorLibros  instancia;
	private  GestorLibros gestLibros;
	
	// =========== INICIO SINGLETON =========== // 
	public static ControladorLibros instancia() {
		if( instancia == null ) 
				instancia = new ControladorLibros();
		return instancia;
	}
	
	// =========== FIN SINGLETON =========== //
	
	private ControladorLibros() {}
	
	public void setGestorLibros( GestorLibros lib ) {
		this.gestLibros = lib; 
	}

	public void iniciar() {
		volver();
		eventos();
	}
	
	private void volver() {
		gestLibros.getBotonCerrar().addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorMainMenu.instancia().setMain( MainMenu.instancia() );
				MainMenu.instancia().setVisible( true );
				gestLibros.dispose();
			}
		});
	}
	
	private void eventos() {
		
		gestLibros.getBotonAñadir().addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// ======== Variables Datos Libros ======== //
				
					String nCodBarras	= gestLibros.getTxtCodigo().getText();
					String nIsbn 		= gestLibros.getTxtISBN().getText();
					String nTitulo		= gestLibros.getTxtTitulo().getText();
					String nAutor		= gestLibros.getTxtAutor().getText();
					String nEditorial	= gestLibros.getTxtEditorial().getText();
					String nAsignatura	= gestLibros.getTxtAsignatura().getText();
					EstadoLibro est     = (EstadoLibro) gestLibros.getCmbEstados().getSelectedItem();
								
				// ======== Fin Variables Datos Libros ======== //
				
				Libro nLibro = new Libro( nCodBarras , nIsbn , nTitulo , nAutor , nEditorial , nAsignatura , est );
				DataResource.instancia().insertarLibro( nLibro );
				
			}
		});
		
		gestLibros.getBotonListar().addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				gestLibros.getListaLibros().setModel( DataResource.instancia().cargarModelo() );
				gestLibros.repaint();
			}
		});
		
	}
	
	
}
