package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.ControladorAlumnos;
import resources.Borders;
import resources.Colors;
import resources.Fonts;
import resources.ImageTest;

public class GestorAlumnos extends JFrame {

	private static final long serialVersionUID = 3788394061045167747L;

	private JButton botonAltas , botonBajas , botonModificar , botonConsultas, botonVolver;
	private JPanel  panelInicio, panelAltas , panelBajas , panelModificar , panelConsultas;
	
	// COMPONENTES PANEL ALTAS \\
	private JTextField	textoNombre , textoApellido , textoApellido_2, textoDNI ; 
	private JButton 	botonGuardar;
	private JTextArea	textoView;	
	
 	
		public GestorAlumnos(){
			ImageTest imgBack = new ImageTest( "img/fondoAlum.jpg" );
			this.setContentPane( imgBack );
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
					panelTitulo.setBorder( BorderFactory.createLineBorder( Color.WHITE , 2 ) );
					panelTitulo.setPreferredSize( new Dimension( 900 , 45 ) );
					panelTitulo.add( tituloPrincipal );
					
					
					this.getContentPane().add( panelTitulo);
					
					//  Posible Metodo Externo  \\
					botonAltas = new JButton( "Altas" );
						botonAltas.setFont( Fonts.fontButton );
						botonAltas.setFocusable(false);
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
					panelBotones.setBackground( Colors.transparentShy );
					panelBotones.setPreferredSize( new Dimension ( 900 , 40 ) );
					panelBotones.add( botonAltas );
					panelBotones.add( botonBajas );
					panelBotones.add( botonModificar );
					panelBotones.add( botonConsultas );
					
					this.getContentPane().add( panelBotones ); 
					
					//  PANEL INICIO VENTANA GESTOR ALUMNOS  \\
					panelInicio = new JPanel();
					panelInicio.setBackground( Colors.transparentShy );
					panelInicio.setBorder( Borders.border[ 0 ] );
					panelInicio.setPreferredSize( new Dimension( 1000 , 480 ) );
					
					//  ALTAS ALUMNOS \\
					
					panelAltas = new JPanel();
					panelAltas.setBackground( Colors.backWhite);
					panelAltas.setBorder( Borders.border[ 0 ] );
					panelAltas.setPreferredSize( new Dimension( 1000 , 480 ) );
					panelAltas.setVisible(false);
						
					JPanel	panelListado = new JPanel();
							panelListado.setLayout( new BorderLayout() );
							panelListado.setPreferredSize( new Dimension( 225 , 450 ) );
							panelListado.setBorder(Borders.border[ 3 ]);
					JLabel	titulo = new JLabel( "Listado Alumnos" ,JLabel.CENTER );	
							titulo.setFont( Fonts.fontTitleBorder );
							panelListado.add( "North" , titulo );
							panelAltas.add( panelListado ); 
					
					
					/*
						//  DNI ALUMNO \\
						JLabel	lblDni = new JLabel( "DNI: " );
								lblDni.setFont( Fonts.fontText );
								panelAltas.add( lblDni);
								textoDNI = new JTextField( 10 );
								panelAltas.add( textoDNI);
							
						//  NOMBRE ALUMNO \\
						JLabel	lblNombre = new JLabel( "Nombre: " );
								lblNombre.setFont( Fonts.fontText );
								panelAltas.add( lblNombre );
								textoNombre = new JTextField( 10 );
								panelAltas.add( textoNombre);
								
						// APELLIDO ALUMNO \\
						JLabel	lblApellido = new JLabel( "Apellido: " );
								lblApellido.setFont( Fonts.fontText );
								panelAltas.add( lblApellido );
								textoApellido = new JTextField( 10 ); 
								panelAltas.add( textoApellido );
								
						// APELLIDO_2 ALUMNO \\
					
						JLabel	lblApellido2 = new JLabel( "Apellido 2: " );
								lblApellido2.setFont( Fonts.fontText );
								panelAltas.add( lblApellido2 );
								textoApellido_2 = new JTextField( 10 ); 
								panelAltas.add( textoApellido_2 );
						*/ 					
						// BOTON GUARDAR Y TEXTVIEW \\
						
						textoView = new JTextArea( 10 , 70 );		
					//	panelAltas.add( textoView );
					
						
						botonGuardar = new JButton( "Añadir Alumno" );	
					//	panelAltas.add( botonGuardar );
				
							
						//  BAJAS ALUMNOS \\
						panelBajas = new JPanel();
						panelBajas.setBackground( Colors.backWhite);
						panelBajas.setLayout(new GridBagLayout() );
						panelBajas.setBorder( Borders.border[ 0 ] );
						panelBajas.setPreferredSize( new Dimension( 1000 , 480 ) );
						panelBajas.setVisible(false);
							
						
						
						//  MODIFICAR ALUMNOS \\
						panelModificar = new JPanel();
						panelModificar.setBackground( Colors.backWhite);
						panelModificar.setLayout(new GridBagLayout() );
						panelModificar.setBorder( Borders.border[ 0 ] );
						panelModificar.setPreferredSize( new Dimension( 1000 , 480 ) );
						panelModificar.setVisible(false);
						
						
						
						//  CONSULTAR ALUMNOS \\
						panelConsultas = new JPanel();
						panelConsultas.setBackground( Colors.backWhite);
						panelConsultas.setLayout(new GridBagLayout() );
						panelConsultas.setBorder( Borders.border[ 0 ] );
						panelConsultas.setPreferredSize( new Dimension( 1000 , 480 ) );
						panelConsultas.setVisible(false);
						
						
						
					this.getContentPane().add( panelInicio );  // Panel Inicial 
					this.getContentPane().add( panelAltas );   // Panel Altas | Componentes para dar de alta a un usuario
					this.getContentPane().add( panelBajas );
					this.getContentPane().add( panelModificar );
					this.getContentPane().add( panelConsultas );
				
				
					botonVolver = new JButton( "Volver" );
						botonVolver.setFont( Fonts.fontButton );
						botonVolver.setFocusable(false);
						botonVolver.setPreferredSize( new Dimension( 100 , 30 ) );
					
									
					this.getContentPane().add( botonVolver );

					// ACTION LISTENER BOTONES \\
					ControladorAlumnos st = ControladorAlumnos.instancia();
					st.setManager(this);
					botonAltas.addActionListener( st );
					botonBajas.addActionListener( st );
					botonVolver.addActionListener( st );
					botonGuardar.addActionListener( st );
		}
		
		// Getters & Setters \\
		
		public JPanel getPanelAltas() {
			return panelAltas;
		}
	
		public JButton getBotonAltas() {
			return botonAltas;
		}
		
		public JButton getBotonVolver() {
			return botonVolver;
		}

		public JPanel getPanelInicio() {
			return panelInicio;
		}

		public JButton getBotonGuardar() {
			return botonGuardar;
		}

		public JTextField getTextoNombre() {
			return textoNombre;
		}

		public JTextField getTextoApellido() {
			return textoApellido;
		}

		public JTextField getTextoApellido_2() {
			return textoApellido_2;
		}

		public JTextField getTextoDNI() {
			return textoDNI;
		}

		public JButton getBotonBajas() {
			return botonBajas;
		}

		public JPanel getPanelBajas() {
			return panelBajas;
		}

		public JButton getBotonModificar() {
			return botonModificar;
		}

		public JButton getBotonConsultas() {
			return botonConsultas;
		}

		public JPanel getPanelModificar() {
			return panelModificar;
		}

		public JPanel getPanelConsultas() {
			return panelConsultas;
		}
		
		
		
		

}
