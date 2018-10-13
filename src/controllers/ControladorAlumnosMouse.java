package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import interfaces.GestorAlumnos;
import models.Alumno;

public class ControladorAlumnosMouse extends MouseAdapter{
	
	private static ControladorAlumnosMouse INSTANCIA;
	private static GestorAlumnos stManager ;
	
	public static ControladorAlumnosMouse instancia() {
		if ( INSTANCIA == null ) 
			INSTANCIA = new ControladorAlumnosMouse();
		return INSTANCIA;
	}
		
	private ControladorAlumnosMouse() { }
	
	public static void setManager( GestorAlumnos stuM ) {
		stManager = stuM;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if ( e.getClickCount() >= 2) {
			System.out.println(stManager);
			
			/*
			Alumno	alu = stManager.getListaAlumnos().getSelectedValue();
				stManager.getTextoDNI().setText( alu.getNombre() );
				stManager.getTextoNombre().setText( alu.getNombre() ); 
				stManager.getTextoApellido().setText( alu.getApell_1() );
				stManager.getTextoApellido_2().setText( alu.getApell_2() );*/ 
		}
		
		
	}
		
	
	

}
