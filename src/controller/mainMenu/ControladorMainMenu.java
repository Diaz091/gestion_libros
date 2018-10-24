package controller.mainMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.alumnos.ControladorAlumnos;
import controller.gestorLibros.ControladorLibros;
import interfaces.GestorAlumnos;
import interfaces.GestorLibros;
import interfaces.MainMenu;

public class ControladorMainMenu {
	
	private static ControladorMainMenu INSTANCIA;
	private MainMenu main;
	
	public static ControladorMainMenu instancia() {
	if ( INSTANCIA == null ) 
			INSTANCIA =  new ControladorMainMenu();
		return INSTANCIA;
	}
	
	public void setMain( MainMenu mainM ) {
		this.main = mainM;
	}	

	public void iniciar() {
		
		main.getBotonAlumnos().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorAlumnos.setManager( GestorAlumnos.instancia() );
				
				ControladorAlumnos.instancia().iniciar();
				main.dispose();
				ControladorAlumnos.instancia().getStManager().getPanelInicio().setVisible(true);
			}
		});
		
		main.getBotonLibros().addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorLibros.instancia().setGestorLibros( new GestorLibros());
				
				ControladorLibros.instancia().iniciar();
				
				main.dispose();
				
			}
		});
		
	}
	
	private void evento() {
		
	}
}
