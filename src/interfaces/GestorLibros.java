package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import resources.Fonts;
/**
 * @since
 * @version 1.0
 * */
public class GestorLibros extends JFrame{
	
	private static final long serialVersionUID = -3702218765809391813L;
	
	private JButton botonAltas , botonBajas , botonModificar , botonConsultas;
	
	
	GestorLibros(){
		
		
		components();
		settings();
		
	}
	
	private void settings() {
		
		this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		this.setTitle( "Gestor de Alumnos" );
		this.setResizable( false );
		this.setSize( 1100, 650 );
		this.setLayout( new FlowLayout() );
		this.setLocationRelativeTo(null);
		this.setVisible( true );
	}
	
	private void components() {
		
		dibujarPanel();
			
	}
	
	
	private void dibujarPanel() {
		JPanel	panelTitulo = new JPanel( );
		JLabel	tituloPrincipal = new JLabel( "Gestión de Préstamos de Libros" );
				tituloPrincipal.setFont( Fonts.fontTitle );
				panelTitulo.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
				panelTitulo.setPreferredSize( new Dimension( 950 , 45 ) );
				panelTitulo.add( tituloPrincipal );
				
				this.getContentPane().add( panelTitulo );
	}
	
	public static void main(String[] args) {
		
		new GestorLibros();

	}

}
