package controller.mainMenu;

public class ControladorMainMenu {
	
	private static ControladorMainMenu INSTANCIA;
	
	public static ControladorMainMenu instancia() {
				if ( INSTANCIA == null ) 
			INSTANCIA =  new ControladorMainMenu();
		return INSTANCIA;
	}
	
	

}
