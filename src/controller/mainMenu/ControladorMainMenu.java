package controller.mainMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.alumnos.ControladorAlumnos;
import controllers.alumnos.ControladorAlumnosOrig;
import interfaces.GestorAlumnos;
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
				ControladorAlumnosOrig.setManager( GestorAlumnos.instancia() );
				ControladorAlumnosOrig.instancia().iniciar();
				main.dispose();
				ControladorAlumnosOrig.instancia().getStManager().getPanelInicio().setVisible(false);
			}
		});
		
	}
	
	private void evento() {
		
	}
}
