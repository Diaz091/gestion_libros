package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;


import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sources.Fonts;

public class MainMenu extends JFrame {
		
		private JButton botonAlumnos , botonLibros, botonPrestamos, botonDevoluciones, botonLista, botonOtros, botonSalir;	
		private JLabel	bienvenida;
	
	MainMenu(){
		
		components();
		settings();  //Ajustes Generales
		
	}
	
	
	private void settings() {
		
		this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		this.setTitle( "Gestor de Préstamos de Libros" );
		this.setLayout( new FlowLayout( ) );
		this.setResizable( false );
		this.setSize( 1300, 775 );
		this.setLocationRelativeTo(null);
		this.setVisible( true );
	}
	
	private void components() {
	
		JPanel	panelTitulo = new JPanel( );
		JLabel	tituloPrincipal = new JLabel( "Gestión de Préstamos de Libros" );
				tituloPrincipal.setFont( Fonts.fontTitle );
				panelTitulo.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
				panelTitulo.setPreferredSize( new Dimension( 1250 , 45 ) );
				panelTitulo.add( tituloPrincipal );
				
		this.getContentPane().add( panelTitulo );
		
		// - panelMenuSecundario | Borde más exterior del Menú Principal. 
		JPanel	panelMenuSecundario = new JPanel( );
				panelMenuSecundario.setPreferredSize( new Dimension( 550 , 663 ) );
				this.getContentPane().add( panelMenuSecundario );
			
		// - panelTituloOpciones | Borde del Titulo (Menú Principal).
		JPanel	panelTituloOpciones = new JPanel( );
		JLabel	tituloSecundario = new JLabel( "Menú Principal" , JLabel.CENTER );
				panelMenuSecundario.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
				tituloSecundario.setFont( Fonts.fontTitle );
				
				tituloSecundario.setPreferredSize( new Dimension( 490 , 36 ) );
				tituloSecundario.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
				panelTituloOpciones.setPreferredSize( new Dimension( 500 , 45 ) );
				panelMenuSecundario.add( tituloSecundario );
				
				
		// - panelOpciones | 1er Boton + Etiqueta para Alumnos
		JPanel	panelOpciones = new JPanel( );
				panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.Y_AXIS));
				panelOpciones.add(Box.createRigidArea( new Dimension( 0 , 20 ) ) );
				
				botonAlumnos = new JButton( new ImageIcon( "img\\alumIco.png" ) );
				botonAlumnos.setBackground( Color.lightGray );
				botonAlumnos.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
	
				JLabel	tituloAlumno = new JLabel( "  Gestión de Alumnos" );
						tituloAlumno.setFont( Fonts.fontTitle );
						tituloAlumno.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
						tituloAlumno.setPreferredSize( new Dimension( 425 , 36 ) );
				
				
				JPanel	opcion = new JPanel();
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
						opcion5.add( botonLista );
						opcion5.add( tituloListas );
						
				panelOpciones.add( opcion5 );	
				
		// - panelOpciones | 6to Boton + Etiqueta para Otros..
				botonOtros = new JButton( new ImageIcon( "img\\alumIco.png" ) );
				botonOtros.setBackground( Color.lightGray );
				botonOtros.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
				panelOpciones.add(Box.createRigidArea( new Dimension( 0 , 15 ) ) );
				
				JLabel	tituloOtros = new JLabel ( "  Otros.." );
						tituloOtros.setFont( Fonts.fontTitle );
						tituloOtros.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
						tituloOtros.setPreferredSize( new Dimension( 425 , 36 ) );
			
				JPanel	opcion6 = new JPanel();
					opcion6.add( botonOtros );
					opcion6.add( tituloOtros );
						
				panelOpciones.add( opcion6 );	
				panelMenuSecundario.add( panelOpciones );
				
		// - panelImagenTextoBoton |
				JPanel	pnSaludo = new JPanel();	
						pnSaludo.setLayout(new BoxLayout(pnSaludo, BoxLayout.Y_AXIS));
				JLabel	imagen  = new JLabel( new ImageIcon( "img\\book.png" ) );
						imagen.setBorder( BorderFactory.createEmptyBorder( 85 , 0 , 120 , 55 ) );
						
						bienvenida = new JLabel( "Bienvenido/a: ");
						bienvenida.setFont( Fonts.fontTitle );
						bienvenida.setBorder( BorderFactory.createEmptyBorder(0 , 10 , 0 , 30 ) );
					
				JPanel	panelSaludoBoton = new JPanel( );
						panelSaludoBoton.setLayout( new BoxLayout( panelSaludoBoton, BoxLayout.X_AXIS ) );
						botonSalir = new JButton( "Salir" );
						botonSalir.setFocusable( false );
						botonSalir.setBackground( Color.LIGHT_GRAY );
						
						pnSaludo.add( imagen );
						panelSaludoBoton.add( bienvenida );
						panelSaludoBoton.add( botonSalir );
						pnSaludo.add( panelSaludoBoton );
			
			this.getContentPane().add( panelMenuSecundario );
			this.getContentPane().add( pnSaludo );
			 
	}

}
