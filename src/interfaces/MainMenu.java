package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sources.Fonts;


public class MainMenu extends JFrame {

	
	
	MainMenu(){
		
		
				
		components();
		settings();  //Ajustes Generales
	}
	
	
	
	
	private void settings() {
		
		this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		this.setTitle( "Gestor de Préstamos de Libros" );
		this.setLayout( new FlowLayout( ) );
		this.setResizable( false );
		this.setSize( 1050, 900 );
		this.setVisible( true );
	}
	
	private void components() {
		JPanel	panelTitulo = new JPanel( );
		JLabel	tituloPrincipal = new JLabel( "Gestión de Préstamos de Libros" );
				tituloPrincipal.setFont( Fonts.fontTitle );
				panelTitulo.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
				panelTitulo.setPreferredSize( new Dimension( 1000 , 45 ) );
				panelTitulo.add( tituloPrincipal );
				
		this.getContentPane().add( panelTitulo );
		
		
		JPanel	panelOpciones = new JPanel( );
				panelOpciones.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
				panelOpciones.setPreferredSize( new Dimension( 550 , 700 ) );
		
		JPanel	panelTituloOpciones = new JPanel( );
		JLabel	tituloSecundario = new JLabel( "Menú Principal" );
				panelOpciones.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
				tituloSecundario.setFont( Fonts.fontTitle );
				panelOpciones.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
				
				panelOpciones.add( tituloSecundario );
				
		this.getContentPane().add( panelOpciones );
	}
	
	
	
	
	
	
	
	
	
	 
	
	
	
	
	
	public static void main(String[] args) {
		new MainMenu();

	}

}
