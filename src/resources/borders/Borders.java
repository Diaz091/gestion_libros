package resources.borders;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import resources.colors.Colors;
import resources.fonts.Fonts;
/**
 * @author Unai Díaz de Garayo
 */

public class Borders {
	private static Border bTitle = BorderFactory.createLineBorder( Colors.cute , 2);
	private static Border bTitleBorde = BorderFactory.createLineBorder( Colors.cute , 1);
	// Añadir siempre al final.
	public  static Border []  border = {
			BorderFactory.createLineBorder( Color.WHITE , 2 ), 
			BorderFactory.createEmptyBorder( 75 , 0 , 79 , 55 ),	
			BorderFactory.createEmptyBorder( 0 , 10 , 0 , 30 ),
			BorderFactory.createLineBorder( Color.BLACK , 2 ), 
			BorderFactory.createTitledBorder(bTitle , "Datos Alumno" , TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.ABOVE_TOP, Fonts.fontTitleBorder, Colors.cute),
			BorderFactory.createLineBorder( Color.WHITE , 2 ),
			BorderFactory.createEmptyBorder( 0 , 75 , 0 , 45 ),
			BorderFactory.createEmptyBorder( 0 , 0 , 45 , 0 ),
			BorderFactory.createTitledBorder(bTitleBorde , "Listado" , TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.ABOVE_TOP, Fonts.fontTitleBorder, Colors.cute),
			BorderFactory.createTitledBorder(bTitleBorde , "Datos Libro" , TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.ABOVE_TOP, Fonts.fontTitleBorder, Colors.cute),
 	};
}
