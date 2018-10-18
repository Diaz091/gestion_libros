package controller.mainMenu;

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

	
	
}
