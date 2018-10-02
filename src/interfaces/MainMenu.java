package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sources.Fonts;

public class MainMenu extends JFrame {
		
		private JButton botonAlumnos , botonLibros, botonPrestamos, botonDevoluciones, botonLista, botonOtros;	
	
	MainMenu(){
			
		
				
		components();
		settings();  //Ajustes Generales
	}
	
	
	
	
	private void settings() {
		
		this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		this.setTitle( "Gestor de Préstamos de Libros" );
		this.setLayout( new FlowLayout( ) );
		this.setResizable( false );
		this.setSize( 1300, 815 );
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
				panelMenuSecundario.setBorder( BorderFactory.createLineBorder( Color.BLACK , 2 ) );
				panelMenuSecundario.setPreferredSize( new Dimension( 550 , 700 ) );
	
		// - panelTituloOpciones | Borde del Titulo (Menú Principal).
		JPanel	panelTituloOpciones = new JPanel( );
		JLabel	tituloSecundario = new JLabel( "Menú Principal" );
				panelMenuSecundario.setBorder( BorderFactory.createLineBorder( Color.GREEN , 2 ) );
				tituloSecundario.setFont( Fonts.fontTitle );
				panelTituloOpciones.setBorder( BorderFactory.createLineBorder( Color.RED , 2 ) );
				panelTituloOpciones.add( tituloSecundario );
				panelTituloOpciones.setPreferredSize( new Dimension( 500 , 45 ) );
				panelMenuSecundario.add( panelTituloOpciones );
		
		// - panelOpciones | 1er Boton + Etiqueta para Alumnos
		JPanel	panelOpciones = new JPanel( );
				panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.Y_AXIS));
				//panelOpciones.setLayout(new GridLayout(6, 2, 10 , 10));
				botonAlumnos = new JButton( new ImageIcon( "img\\alumIco.png" ) );
				botonAlumnos.setBackground(Color.lightGray);
				botonAlumnos.setBorder( BorderFactory.createLineBorder( Color.ORANGE , 2 ) );
	
				JLabel	tituloAlumno = new JLabel( "  Gestionar Alumnos" );
						tituloAlumno.setFont( Fonts.fontTitle );
						tituloAlumno.setBorder( BorderFactory.createLineBorder( Color.ORANGE , 2 ) );
						tituloAlumno.setPreferredSize( new Dimension( 425 , 36 ) );
				
				// TIENEN QUE DESAPARECER :) 
				JPanel	noQuieroHacerlo = new JPanel();
						noQuieroHacerlo.add(botonAlumnos);
						noQuieroHacerlo.add(tituloAlumno);
				
						panelOpciones.add(noQuieroHacerlo);
						
						//panelOpciones.add( botonAlumnos );
						//panelOpciones.add( tituloAlumno );
				
			
				
		// - panelOpciones | 2do Boton + Etiqueta para Libros
				botonLibros = new JButton( new ImageIcon( "img\\alumIco.png" ) );
				botonLibros.setBackground(Color.lightGray);
				botonLibros.setBorder( BorderFactory.createLineBorder( Color.ORANGE , 2 ) );
				
				JLabel	tituloLibro = new JLabel ( "  Gestionar Libros" );
						tituloLibro.setFont( Fonts.fontTitle );
						tituloLibro.setBorder( BorderFactory.createLineBorder( Color.ORANGE , 2 ) );
						tituloLibro.setPreferredSize( new Dimension( 425 , 36 ) );
				// TIENEN QUE DESAPARECER :) 
				JPanel	noQuieroHacerlo2 = new JPanel();
						noQuieroHacerlo2.add(botonLibros);
						noQuieroHacerlo2.add(tituloLibro);
						
			 panelOpciones.add( noQuieroHacerlo2 );
				
		// - panelOpciones | 3er Boton + Etiqueta para Prestamos
				botonPrestamos = new JButton( new ImageIcon( "img\\alumIco.png" ) );
				botonPrestamos.setBackground(Color.lightGray);
				botonPrestamos.setBorder( BorderFactory.createLineBorder( Color.ORANGE , 2 ) );
				
				JLabel	tituloPrestamos = new JLabel ( "  Gestionar Prestamos" );
						tituloPrestamos.setFont( Fonts.fontTitle );
						tituloPrestamos.setBorder( BorderFactory.createLineBorder( Color.ORANGE , 2 ) );
						tituloPrestamos.setPreferredSize( new Dimension( 425 , 36 ) );
				// TIENEN QUE DESAPARECER :) 
				JPanel	noQuieroHacerlo3 = new JPanel();
						noQuieroHacerlo3.add(botonPrestamos);
						noQuieroHacerlo3.add(tituloPrestamos);
						
				panelOpciones.add( noQuieroHacerlo3 );		
					
				
				
		// - panelOpciones | 4to Boton + Etiqueta para Devoluciones
				botonDevoluciones = new JButton( new ImageIcon( "img\\alumIco.png" ) );
				botonDevoluciones.setBackground(Color.lightGray);
				botonDevoluciones.setBorder( BorderFactory.createLineBorder( Color.ORANGE , 2 ) );
				
				JLabel	tituloDevoluciones = new JLabel ( "  Gestionar Devoluciones" );
						tituloDevoluciones.setFont( Fonts.fontTitle );
						tituloDevoluciones.setBorder( BorderFactory.createLineBorder( Color.ORANGE , 2 ) );
						tituloDevoluciones.setPreferredSize( new Dimension( 425 , 36 ) );
				// TIENEN QUE DESAPARECER :) 
				JPanel	noQuieroHacerlo4 = new JPanel();
						noQuieroHacerlo4.add(botonDevoluciones);
						noQuieroHacerlo4.add(tituloDevoluciones);
						
				panelOpciones.add( noQuieroHacerlo4 );		
				
		// - panelOpciones | 5to Boton + Etiqueta para Listas
				botonLista = new JButton( new ImageIcon( "img\\alumIco.png" ) );
				botonLista.setBackground(Color.lightGray);
				botonLista.setBorder( BorderFactory.createLineBorder( Color.ORANGE , 2 ) );
				
				JLabel	tituloListas = new JLabel ( "  Listados" );
						tituloListas.setFont( Fonts.fontTitle );
						tituloListas.setBorder( BorderFactory.createLineBorder( Color.ORANGE , 2 ) );
						tituloListas.setPreferredSize( new Dimension( 425 , 36 ) );
				// TIENEN QUE DESAPARECER :) 
				JPanel	noQuieroHacerlo5 = new JPanel();
						noQuieroHacerlo5.add(botonLista);
						noQuieroHacerlo5.add(tituloListas);
						
				panelOpciones.add( noQuieroHacerlo5 );	
				
			
							
				
		// - panelOpciones | 5to Boton + Etiqueta para Listas
				botonOtros = new JButton( new ImageIcon( "img\\alumIco.png" ) );
				botonOtros.setBackground(Color.lightGray);
				botonOtros.setBorder( BorderFactory.createLineBorder( Color.ORANGE , 2 ) );
				
				JLabel	tituloOtros = new JLabel ( "  Otros.." );
						tituloOtros.setFont( Fonts.fontTitle );
						tituloOtros.setBorder( BorderFactory.createLineBorder( Color.ORANGE , 2 ) );
						tituloOtros.setPreferredSize( new Dimension( 425 , 36 ) );
				// TIENEN QUE DESAPARECER :) 
				JPanel	noQuieroHacerlo6 = new JPanel();
						noQuieroHacerlo6.add(botonOtros);
						noQuieroHacerlo6.add(tituloOtros);
						
				panelOpciones.add( noQuieroHacerlo6 );	
				panelMenuSecundario.add( panelOpciones );
		JLabel	imagen = new JLabel( new ImageIcon("img\\book.png") );
				imagen.setBorder(BorderFactory.createEmptyBorder(0, 120, 0, 0));
			//	imagen.setBorder( BorderFactory.createLineBorder( Color.ORANGE , 2 ) );
				
		//JPanel pnSaludo = new JPanel();	
		//JLabel saludo = new JLabel ("Bienvenido/a  ");
			//pnSaludo.add(saludo);
			//pnSaludo.setPreferredSize( new Dimension( 250 , 36 ) );
			//pnSaludo.setBorder( BorderFactory.createLineBorder( Color.ORANGE , 2 ) );
			
			
		this.getContentPane().add( panelMenuSecundario );
		this.getContentPane().add(imagen);
		//this.getContentPane().add(pnSaludo);
	}
	
	
	
	
	
	
	
	
	
	 
	
	
	
	
	
	public static void main(String[] args) {
		new MainMenu();

	}

}
