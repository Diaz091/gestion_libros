package interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.alumnos.ControladorAlumnos;
import models.Alumno;
import resources.borders.Borders;
import resources.colors.Colors;
import resources.fonts.Fonts;
import resources.imageTest.ImageTest;

public class GestorAlumnos extends JFrame {

	private static final long serialVersionUID = 3788394061045167747L;
	private static GestorAlumnos instancia;
	
	private JButton botonAltas  , botonConsultas , botonVolver;
	private JPanel  panelInicio , panelAltas     , panelConsultas;
	
	// COMPONENTES  ALTAS | BAJAS | MODIFICAR \\
	private JTextField					textoNombre  , textoApellido , textoApellido_2, textoDNI ; 
	private JList 			 < Alumno >	listaAlumnos;
	private JPanel						panelListado;
	private JButton 					botonGuardar , botonListar , botonLimpiar , botonBorrar , botonModificar;
	
	
	
		public static GestorAlumnos instancia() {
			if(instancia == null)
				instancia = new GestorAlumnos();
			return instancia;
		}
		
		private  GestorAlumnos(){
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
			this.setLocationRelativeTo( null );
			this.setVisible( true );
		}
		
		private void components() {
			dibujarPanel();
			dibujar();
			botonVolver = new JButton( "Volver" );
				botonVolver.setFont( Fonts.fontButton );
				botonVolver.setFocusable(false);
				botonVolver.setPreferredSize( new Dimension( 100 , 30 ) );
								
			this.getContentPane().add( botonVolver );
			
			listeners();
		}
			
		private void dibujarPanel() {
			
			JPanel	panelTitulo = new JPanel( );
					panelTitulo.setBackground( Colors.transparentShy );
					
			JLabel	tituloPrincipal = new JLabel( "Gestión de Alumnos");
					tituloPrincipal.setFont( Fonts.fontTitle );
					panelTitulo.setBorder( Borders.border[5]  );
					panelTitulo.setPreferredSize( new Dimension( 900 , 45 ) );
					panelTitulo.add( tituloPrincipal );
					
					this.getContentPane().add( panelTitulo);
					
					botonAltas = new JButton( "Altas | Bajas | Modificaciones" );
						botonAltas.setFont( Fonts.fontButton );
						botonAltas.setFocusable(false);
					botonConsultas = new JButton( "Consulta" );	
						botonConsultas.setFont( Fonts.fontButton );
						botonConsultas.setFocusable(false);
				
			JPanel	panelBotones = new JPanel();
					panelBotones.setBackground( Colors.transparentShy );
					panelBotones.setPreferredSize( new Dimension ( 900 , 40 ) );
					panelBotones.add( botonAltas );
					panelBotones.add( botonConsultas );
					
					this.getContentPane().add( panelBotones ); 
				
					//  PANEL INICIO VENTANA GESTOR ALUMNOS  \\
					panelInicio = new JPanel();
					panelInicio.setBackground( Colors.transparentShy );
					panelInicio.setBorder( Borders.border[ 0 ] );
					panelInicio.setPreferredSize( new Dimension( 1000 , 480 ) );
			
						
						//  CONSULTAR ALUMNOS \\
						panelConsultas = new JPanel();
						panelConsultas.setBackground( Colors.backWhite);
						panelConsultas.setLayout(new GridBagLayout() );
						panelConsultas.setBorder( Borders.border[ 0 ] );
						panelConsultas.setPreferredSize( new Dimension( 1000 , 480 ) );
						panelConsultas.setVisible(false);
						
					this.getContentPane().add( panelInicio );  // PANEL INICIAL \\  
					this.getContentPane().add( panelConsultas );
				
				

					
		}
		
		private void listeners() {
				// ACTION LISTENER'S \\
				
				ControladorAlumnos st = ControladorAlumnos.instancia();
				ControladorAlumnos.setManager(this);
			/*	botonAltas.addActionListener( st ); 		// BotonAltas
				botonVolver.addActionListener( st ); 		// BotonVolver
				botonListar.addActionListener( st ); 		// BotonListar
				botonBorrar.addActionListener( st );		// BotonBorrar
				botonGuardar.addActionListener( st ); 		// BotonGuardar
				botonLimpiar.addActionListener( st ); 		// BotonLimpiar
				botonConsultas.addActionListener( st ); 	// BotonConsultas
				listaAlumnos.addMouseListener( coAlMo );   	// ListaAlumnosBBDD*/
		}
		
		
		private void dibujar() {
			
			//  ALTAS ALUMNOS \\	
								
					panelAltas = new JPanel();
					panelAltas.setBackground( Colors.backWhite);
					panelAltas.setBorder( Borders.border[ 0 ] );
					panelAltas.setPreferredSize( new Dimension( 1000 , 480 ) );
					panelAltas.setVisible(false);
						
					panelListado = new JPanel();
							panelListado.setLayout( new BorderLayout() );
							panelListado.setPreferredSize( new Dimension( 225 , 450 ) );
							panelListado.setBorder(Borders.border[ 3 ]);
					
			// LISTADO PARA VER ALUMNOS EN LA BASE DE DATOS \\
			
					JLabel	titulo = new JLabel( "Listado Alumnos" , JLabel.CENTER );	
							titulo.setFont( Fonts.fontTitleBorder );
							panelListado.add( "North" , titulo );
							listaAlumnos = new JList<Alumno>(  );
							panelListado.add( listaAlumnos );
				
					JLabel 	space = new JLabel(" ");
							space.setBorder( Borders.border[ 6 ] );
							panelAltas.add( panelListado );
							panelAltas.add( space );
		
			// PANEL PARA INTRODUCIR DATOS DE LOS ALUMNOS \\
							
					JPanel	panelDatosAlum = new JPanel();
							panelDatosAlum.setLayout( new GridBagLayout() );
							panelDatosAlum.setBorder( Borders.border[ 4 ] );
							panelDatosAlum.setPreferredSize( new Dimension( 460 , 310 ) );
							panelDatosAlum.setBackground( Colors.transparentShy );
											
								//  DNI ALUMNO \\
					GridBagConstraints c = new GridBagConstraints();
					JLabel	lblDni = new JLabel( "DNI: " );   
							lblDni.setFont( Fonts.fontText );
									
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					c.insets = new Insets (0 , 5 , 0 , 0 );
							panelDatosAlum.add( lblDni , c);
												
					textoDNI = new JTextField( 10 );
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 1;
					c.gridy = 0;
					c.weightx = 6;
								panelDatosAlum.add( textoDNI , c);
								
								// FIN DNI ALUMNO \\
								
								
								//  NOMBRE ALUMNO \\
					JLabel	lblApellido = new JLabel( "Apellido:  " );
							lblApellido.setFont( Fonts.fontText );		
					
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 1;
					c.weightx = 1;
					c.insets = new Insets (0 , 5 , 0 , 0 );
							panelDatosAlum.add( lblApellido , c );
					
					textoApellido = new JTextField( 10 );
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 1;
					c.gridy = 1;
					c.weightx = 6;
								panelDatosAlum.add( textoApellido , c);
								// FIN NOMBRE ALUMNO \\
								
								
								// APELLIDO ALUMNO \\
					JLabel	lblNombre = new JLabel( "Nombre: " );
							lblNombre.setFont( Fonts.fontText );			
								
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 2;
					c.gridy = 0;
					c.weightx = 1;
					c.insets = new Insets( 0 , 10 , 0 , 0 );
							panelDatosAlum.add( lblNombre , c );
							
					textoNombre = new JTextField( 10 );		
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 3;
					c.gridy = 0;
					c.weightx = 5;
					c.insets = new Insets( 0 , 0 , 0 , 5 );
								panelDatosAlum.add( textoNombre , c);
								// FIN APELLIDO ALUMNO \\
								
								
								// APELLIDO_2 ALUMNO \\
					JLabel	lblApellido2 = new JLabel( "Apellido 2: " );
							lblApellido2.setFont( Fonts.fontText );			
								
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 2;
					c.gridy = 1;
					c.weightx = 1;
					c.insets = new Insets( 0 , 10 , 0 , 0 );
							panelDatosAlum.add( lblApellido2 , c);
							
					textoApellido_2 = new JTextField( 10 ); 
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 3;
					c.gridy = 1;
					c.weightx = 5;
					c.insets = new Insets( 0 , 0 , 0 , 5 );
								panelDatosAlum.add( textoApellido_2 , c);
								// FIN APELLIDO_2 ALUMNO \\
								
								
								// BOTON GUARDAR & BOTON LISTAR ALUMNOS\\
					
					botonGuardar = new JButton( "Añadir Alumno" );	
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 4;
					c.weightx = 0;
					c.gridwidth = 2;
					c.insets = new Insets( 20 , 0 , 0 , 5 );
							panelDatosAlum.add( botonGuardar , c);
								// FIN BOTON AÑADIR ALUMNO \\
							
					botonBorrar = new JButton( "Borrar Alumno" );		
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 2;
					c.gridy = 4;
					c.weightx = 0;
					c.gridwidth = 2;
					c.insets = new Insets( 20 , 5 , 0 , 0 );
							panelDatosAlum.add( botonBorrar , c);		
								// FIN BOTON BORRAR  ALUMNO \\
							
					botonListar = new JButton( "Ver Alumnos" );			
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 6;
					c.weightx = 0;
					c.gridwidth = 2;
					c.insets = new Insets( 20 , 0 , 0 , 5 );
							panelDatosAlum.add( botonListar , c);
								// FIN BOTON VER ALUMNO \\
					
					botonModificar = new JButton( "Modificar Alumno" );		
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 2;
					c.gridy = 6;
					c.weightx = 0;
					c.gridwidth = 2;
					c.insets = new Insets( 20 , 5 , 0 , 0 );
							panelDatosAlum.add( botonModificar , c);		
								// FIN BOTON MODIFICAR ALUMNO \\
							
					botonLimpiar = new JButton( "Vaciar Lista" );		
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 1;
					c.gridy = 8;
					c.weightx = 0;
					c.gridwidth = 2;
					c.insets = new Insets( 20 , 0 , 0 , 0 );
							panelDatosAlum.add( botonLimpiar , c);		
								// FIN BOTON VACIAR LISTA \\
											
			// AÑADIMOS EL PANEL DE LOS DATOS AL PANEL DE ALTAS  \\
					panelAltas.add( panelDatosAlum ); 			
					
			// PANEL ALTAS  | LO AÑADIMOS A LA VENTANA GENERAL
					this.getContentPane().add( panelAltas );   
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

		public JPanel getPanelConsultas() {
			return panelConsultas;
		}

		public JButton getBotonListar() {
			return botonListar;
		}

		public JPanel getPanelListado() {
			return panelListado;
		}

		public JList<Alumno> getListaAlumnos() {
			return listaAlumnos;
		}

		public JButton getBotonLimpiar() {
			return botonLimpiar;
		}

		public JButton getBotonBorrar() {
			return botonBorrar;
		}
}