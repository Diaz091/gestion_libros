package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import resources.Borders;
import resources.Colors;
import resources.Fonts;

public class StudentManager extends JFrame {

	private static final long serialVersionUID = 3788394061045167747L;

	private JButton botonAltas , botonBajas , botonModificar , botonConsultas, botonVolver;
	private JPanel  panelAltas , panelBajas , panelModificar , panelConsultas;
	private String  operacion = "";
	
		public StudentManager(){
	
			
			components();
			settings();
			
		}
		
		private void settings() {
			
			this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
			//this.setTitle( "Gestor de Alumnos" );
			this.setResizable( false );
			this.setSize( 1100, 650 );
			this.setLayout( new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS) );
			this.setLocationRelativeTo(null);
			this.setVisible( true );
		}
		
		private void components() {
			
			dibujarPanel();
				
		}
		
		
		private void dibujarPanel() {
					this.getContentPane().setPreferredSize(new Dimension(500,45));						
			JPanel	panelTitulo = new JPanel( );
					panelTitulo.setBackground( Colors.transparentShy );
			JLabel	tituloPrincipal = new JLabel( "Gestión de Alumnos");
					tituloPrincipal.setFont( Fonts.fontTitle );
					panelTitulo.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
					panelTitulo.setPreferredSize( new Dimension( 900 , 45 ) );
					panelTitulo.add( tituloPrincipal );
					
					
					this.getContentPane().add( panelTitulo);
					
					//Posible Metodo Externo
				
					botonAltas = new JButton( "Altas" );
					botonBajas = new JButton( "Bajas" );	
					botonModificar = new JButton( "Modificar");	
					botonConsultas = new JButton( "Consulta" );	
				
			JPanel	panelBotones = new JPanel();
					panelBotones.setBorder( Borders.border[1] );
					panelBotones.add( botonAltas );
					panelBotones.add( botonBajas );
					panelBotones.add( botonModificar );
					panelBotones.add( botonConsultas );
					
					this.getContentPane().add( panelBotones ); 
					
					panelAltas = new JPanel();
					panelAltas.setBorder( Borders.border[0] );
					panelAltas.setPreferredSize( new Dimension( 500 , 400 ) );
					
				
					this.getContentPane().add( panelAltas); 
					
					botonVolver = new JButton("Volver");
					this.getContentPane().add( botonVolver );
					
		}
		
		
		
		public JPanel getPanelAltas() {
			return panelAltas;
		}

		
		public JButton getBotonAltas() {
			return botonAltas;
		}

		public static void main(String[] args) {
			new StudentManager();
		}
}
