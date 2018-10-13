package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.ControladorAlumnos;
import resources.Colors;
import resources.Fonts;
import resources.ImageTest;


public class MainMenu extends JFrame {
		private static final long serialVersionUID = 5190669415336856587L;
		
		private JButton botonAlumnos , botonLibros, botonPrestamos, botonDevoluciones, botonLista, botonSalir;	
		private JLabel	bienvenida;
	
		public MainMenu(){
			ImageTest img = new ImageTest("img/imagen.png");
			this.setContentPane(img);
		
			components(); 
			settings();  //Ajustes Generales
			
		}
				
		private void settings() {
			this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
			this.setTitle( "Gestor de Préstamos de Libros" );
			this.setLayout( new FlowLayout( ) );
			this.setResizable( false );
			this.setSize( 1300, 705 );
			this.setLocationRelativeTo(null);
			this.setVisible( true );
		}
		
		private void components() {
			dibujarPanel();
			dibujarPanelPrincipal();
			dibujarPanelSecundario();
			
				 
		}

		private void dibujarPanel() {
			JPanel	panelTitulo = new JPanel( );
					panelTitulo.setBackground( Colors.transparentShy );
			JLabel	tituloPrincipal = new JLabel( "Gestión de Préstamos de Libros" );
					tituloPrincipal.setFont( Fonts.fontTitle );
					tituloPrincipal.setForeground( Colors.textWhite );
					panelTitulo.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
					panelTitulo.setPreferredSize( new Dimension( 1250 , 45 ) );
					panelTitulo.add( tituloPrincipal );
					
					this.getContentPane().add( panelTitulo );
		}
	
		
		private void dibujarPanelPrincipal() {
			// - panelMenuSecundario | Borde más exterior del Menú Principal. 
				 
					JPanel	panelMenuSecundario = new JPanel( );
							panelMenuSecundario.setBackground( Colors.transparentShy );
							panelMenuSecundario.setPreferredSize( new Dimension( 550 , 584 ) );
							panelMenuSecundario.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
							this.getContentPane().add( panelMenuSecundario );
						
					// - panelTituloOpciones | Borde del Titulo (Menú Principal).
					JPanel	panelTituloOpciones = new JPanel( );
							panelTituloOpciones.setBackground( Colors.transparentShy );
					JLabel	tituloSecundario = new JLabel( "Menú Principal" , JLabel.CENTER );
							tituloSecundario.setFont( Fonts.fontTitle );
							tituloSecundario.setForeground( Colors.textWhite );
							tituloSecundario.setPreferredSize( new Dimension( 490 , 36 ) );
							tituloSecundario.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
							panelTituloOpciones.setPreferredSize( new Dimension( 500 , 45 ) );
							panelMenuSecundario.add( tituloSecundario );
							
							
					// - panelOpciones | 
					JPanel	panelOpciones = new JPanel( );
							panelOpciones.setBackground( Colors.transparentShy );
							panelOpciones.add(Box.createRigidArea( new Dimension( 0 , 20 ) ) );
							panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.Y_AXIS));
							
							
							botonAlumnos = new JButton( new ImageIcon( "img\\alumIco.png" ) );
							botonAlumnos.setBackground( Color.lightGray );
							botonAlumnos.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
				
							
							// Listener Para el BotonAlumnos, el cual abrira BookManager. 
							// El cual se encargade gestionar los alumnos.
							
								ControladorAlumnos stC = ControladorAlumnos.instancia();
								stC.setMain(this);
								botonAlumnos.addActionListener(stC);

							
					// - panelOpciones | 1er Boton + Etiqueta para Alumnos		
							JLabel	tituloAlumno = new JLabel( "  Gestión de Alumnos" );
									tituloAlumno.setFont( Fonts.fontTitle );
									tituloAlumno.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
									tituloAlumno.setPreferredSize( new Dimension( 425 , 36 ) );
							
							
							JPanel	opcion = new JPanel();
									opcion.setBackground( Colors.transparent );
									opcion.add( botonAlumnos );
									opcion.add( tituloAlumno );
							
									panelOpciones.add( opcion );
										
					// - panelOpciones | 2do Boton + Etiqueta para Libros
							botonLibros = new JButton( new ImageIcon( "img\\alumIco.png" ) );
							botonLibros.setBackground( Color.lightGray );
							botonLibros.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
							panelOpciones.add(Box.createRigidArea( new Dimension( 0 , 15 ) ) );
							
							JLabel	tituloLibro = new JLabel ( "  Gestión de Libros" );
									tituloLibro.setFont( Fonts.fontTitle );
									tituloLibro.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
									tituloLibro.setPreferredSize( new Dimension( 425 , 36 ) );
						
							JPanel	opcion2 = new JPanel();
									opcion2.setBackground( Colors.transparent );
									opcion2.add( botonLibros );
									opcion2.add( tituloLibro );
								
						 panelOpciones.add( opcion2 );
							
					// - panelOpciones | 3er Boton + Etiqueta para Prestamos
							botonPrestamos = new JButton( new ImageIcon( "img\\alumIco.png" ) );
							botonPrestamos.setBackground( Color.lightGray );
							botonPrestamos.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
							panelOpciones.add(Box.createRigidArea( new Dimension( 0 , 15 ) ) );
							
							JLabel	tituloPrestamos = new JLabel ( "  Gestión de Préstamos" );
									tituloPrestamos.setFont( Fonts.fontTitle );
									tituloPrestamos.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
									tituloPrestamos.setPreferredSize( new Dimension( 425 , 36 ) );
							
							JPanel	opcion3 = new JPanel();
									opcion3.setBackground( Colors.transparent );
									opcion3.add( botonPrestamos );
									opcion3.add( tituloPrestamos );
									
							panelOpciones.add( opcion3 );		
								
					// - panelOpciones | 4to Boton + Etiqueta para Devoluciones  
							botonDevoluciones = new JButton( new ImageIcon( "img\\alumIco.png" ) );
							botonDevoluciones.setBackground( Color.lightGray );
							botonDevoluciones.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
							panelOpciones.add(Box.createRigidArea( new Dimension( 0 , 15 ) ) );
							
							JLabel	tituloDevoluciones = new JLabel ( "  Gestión de Devoluciones" );
									tituloDevoluciones.setFont( Fonts.fontTitle );
									tituloDevoluciones.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
									tituloDevoluciones.setPreferredSize( new Dimension( 425 , 36 ) );
						
							JPanel	opcion4 = new JPanel();
									opcion4.setBackground( Colors.transparent );
									opcion4.add( botonDevoluciones );
									opcion4.add( tituloDevoluciones );
									
							panelOpciones.add( opcion4 );		
							
					// - panelOpciones | 5to Boton + Etiqueta para Listas
							botonLista = new JButton( new ImageIcon( "img\\alumIco.png" ) );
							botonLista.setBackground( Color.lightGray );
							botonLista.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
							panelOpciones.add(Box.createRigidArea( new Dimension( 0 , 15 ) ) );
							
							JLabel	tituloListas = new JLabel ( "  Listados" );
									tituloListas.setFont( Fonts.fontTitle );
									tituloListas.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
									tituloListas.setPreferredSize( new Dimension( 425 , 36 ) );
							
							JPanel	opcion5 = new JPanel();
									opcion5.setBackground( Colors.transparent );
									opcion5.add( botonLista );
									opcion5.add( tituloListas );
									
							panelOpciones.add( opcion5 );	
							
				panelMenuSecundario.add( panelOpciones );
				
			this.getContentPane().add( panelMenuSecundario );
		}
		
		private void dibujarPanelSecundario() {
			// - panelImagenTextoBoton |
			JPanel	pnSaludo = new JPanel();	
					pnSaludo.setLayout(new BoxLayout(pnSaludo, BoxLayout.Y_AXIS));
					pnSaludo.setBackground( Colors.transparentShy );
			JLabel	imagen  = new JLabel( new ImageIcon( "img\\book.png" ) );
					imagen.setBorder( BorderFactory.createEmptyBorder( 61 , 0 , 79 , 55 ) );
					
					bienvenida = new JLabel( "Bienvenido/a: ");
					bienvenida.setFont( Fonts.fontTextBold );
					bienvenida.setForeground( Colors.textWhite );
					bienvenida.setBorder( BorderFactory.createEmptyBorder(0 , 10 , 0 , 30 ) );
				
			JPanel	panelSaludoBoton = new JPanel( );
					panelSaludoBoton.setLayout( new BoxLayout( panelSaludoBoton, BoxLayout.X_AXIS ) );
					panelSaludoBoton.setBackground( new Color( 0 , 0 , 0 , 0 ) );
					botonSalir = new JButton( "Salir" );
					botonSalir.setFocusable( false );
					botonSalir.setBackground( Color.LIGHT_GRAY );
							// CAMBIAR DE SITIO \\
					botonSalir.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							dispose();
							
						}
					});
					pnSaludo.add( imagen );
					panelSaludoBoton.add( bienvenida );
					panelSaludoBoton.add( botonSalir );
					pnSaludo.add( panelSaludoBoton );
		
			this.getContentPane().add( pnSaludo );
		}
	
		
		public JLabel getBienvenida() {
			return bienvenida;
		}

		public JButton getBotonAlumnos() {
			return botonAlumnos;
		}

		public JButton getBotonSalir() {
			return botonSalir;
		}

		

	
	
	

}
