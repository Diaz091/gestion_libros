package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.DataResource;
import models.Libro;
import resources.borders.Borders;
import resources.colors.Colors;
import resources.fonts.Fonts;
/**
 * @since
 * @version 1.0
 * */
public class GestorLibros extends JFrame{
	
	private static final long serialVersionUID = -3702218765809391813L;
	
	private JButton						botonAltas 	, 	botonBajas 	, 	botonModificar 	, 	botonConsultas;
	private JTextField					txtTitulo;
	private DefaultListModel < Libro > 	modeloListaLibros;
	private JList < Libro >				listaLibros;
	
	
	GestorLibros(){
				
		components();
		settings();
		
	}
	
	private void settings() {
		
		this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		this.setTitle( "Gestor de Alumnos" );
		this.setResizable( false );
		this.setSize( 925, 675 );
		this.setLayout( new FlowLayout() );
		this.setLocationRelativeTo(null);
		this.setVisible( true );
	}
	
	private void components() {
		
		dibujarPanel();
		dibujarInterior();
		
	}
	
	
	private void dibujarPanel() {
		JPanel	panelTitulo = new JPanel( );
		JLabel	tituloPrincipal = new JLabel( "Gestión de Préstamos de Libros" );
				tituloPrincipal.setFont( Fonts.fontTitle );
				panelTitulo.setBorder( Borders.border[ 3 ] );
				panelTitulo.setPreferredSize( new Dimension( 750 , 45 ) );
				panelTitulo.add( tituloPrincipal );
				
				this.getContentPane().add( panelTitulo );
	}
	
	private void dibujarInterior() {

		// Lista para visualizar libros, tanto los que estan en la BBDD cómo los que serán añadidos.
			listaLibros = new JList<Libro>( );
			listaLibros.setPreferredSize( new Dimension( 745 , 220));
			listaLibros.setBorder( Borders.border[ 8 ] );
			listaLibros.setBackground( Colors.transparentShy );
		// PANEL CON LOS DATOS DEL LIBRO
			JPanel	panelDatosLibro = new JPanel();
					
			
		
		
		
		this.getContentPane().add( listaLibros );
		
		
	}
	
	public static void main(String[] args) {
		
		new GestorLibros();

	}

}
