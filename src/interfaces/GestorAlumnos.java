package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.ControladorAlumnos;
import resources.Borders;
import resources.Colors;
import resources.Fonts;
import resources.ImageTest;

public class GestorAlumnos extends JFrame {

	private static final long serialVersionUID = 3788394061045167747L;

	private JButton botonAltas , botonBajas , botonModificar , botonConsultas, botonVolver;
	private JPanel  panelAltas , panelBajas , panelModificar , panelConsultas;
	
	//Componentes Altas
	private JTextField textoNombre , textoApellido , textoApellido_2, textoDNI; 
 
	
		public GestorAlumnos(){
			//ImageTest imgBack = new ImageTest( "" );
			components();
			settings();
		}
		
		private void settings() {
			this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
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
					panelTitulo.setBackground( Colors.transparentShy );
					
			JLabel	tituloPrincipal = new JLabel( "Gestión de Alumnos");
					tituloPrincipal.setFont( Fonts.fontTitle );
					panelTitulo.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
					panelTitulo.setPreferredSize( new Dimension( 900 , 40 ) );
					panelTitulo.add( tituloPrincipal );
					
					
					this.getContentPane().add( panelTitulo);
					
					//Posible Metodo Externo
					botonAltas = new JButton( "Altas" );
						botonAltas.setFont( Fonts.fontButton );
						botonAltas.setFocusable(false);
						botonAltas.setBorder( Borders.border[ 3 ] );
					botonBajas = new JButton( "Bajas" );
						botonBajas.setFont( Fonts.fontButton );
						botonBajas.setFocusable(false);
					botonModificar = new JButton( "Modificar" );
						botonModificar.setFont( Fonts.fontButton );
						botonModificar.setFocusable(false);
					botonConsultas = new JButton( "Consulta" );	
						botonConsultas.setFont( Fonts.fontButton );
						botonConsultas.setFocusable(false);
				
			JPanel	panelBotones = new JPanel();
					panelBotones.setPreferredSize( new Dimension ( 900 , 40 ) );
					panelBotones.add( botonAltas );
					panelBotones.add( botonBajas );
					panelBotones.add( botonModificar );
					panelBotones.add( botonConsultas );
					
					this.getContentPane().add( panelBotones ); 
					
					panelAltas = new JPanel();
					panelAltas.setLayout(new GridBagLayout() );
					panelAltas.setBorder( Borders.border[ 0 ] );
					panelAltas.setPreferredSize( new Dimension( 1000 , 480 ) );
					
					// NOMBRE ALUMNO
					JLabel	lblNombre = new JLabel( "Nombre: " );
							lblNombre.setFont( Fonts.fontText );
							textoNombre = new JTextField( 10 );
					
					// APELLIDO ALUMNO
					JLabel	lblApellido = new JLabel( "     Apellido: " );
							lblApellido.setFont( Fonts.fontText );
							textoApellido = new JTextField( 10 ); 
					
					// APELLIDO_2 ALUMNO
					JLabel	lblApellido2 = new JLabel( "     Apellido 2: " );
							lblApellido2.setFont( Fonts.fontText );
							textoApellido_2 = new JTextField( 10 ); 
					
					//DNI
					JLabel	lblDni = new JLabel( "   DNI: " );
							lblDni.setFont( Fonts.fontText );
							textoDNI = new JTextField( 10 ); 
								
				
								
					panelAltas.add( lblDni );
					panelAltas.add( textoDNI );
					
					panelAltas.add( lblNombre );
					panelAltas.add( textoNombre );
					
					panelAltas.add( lblApellido );
					panelAltas.add( textoApellido );
					
					panelAltas.add( lblApellido2 );
					panelAltas.add( textoApellido_2 );
					
					
					
					this.getContentPane().add( panelAltas ); 
					
					botonVolver = new JButton( "Volver" );
						botonVolver.setFont( Fonts.fontButton );
						botonVolver.setFocusable(false);
						botonVolver.setPreferredSize( new Dimension( 100 , 30 ) );
					
										
					this.getContentPane().add( botonVolver );

					// ACTION LISTENER BOTONES //
					ControladorAlumnos st = new ControladorAlumnos(this);
					botonAltas.addActionListener( st );
					//botonVolver.addActionListener( st );
		}
		
		// Getters //
		
		public JPanel getPanelAltas() {
			return panelAltas;
		}
	
		public JButton getBotonAltas() {
			return botonAltas;
		}
		
		public JButton getBotonVolver() {
			return botonVolver;
		}

		public static void main(String[] args) {
			new GestorAlumnos();
		}

}
