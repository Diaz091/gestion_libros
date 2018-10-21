package interfaces;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.EstadoLibro;
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
	
	private JTextField									txtISBN 	, txtTitulo 	, txtAutor , txtEditorial , txtAsignatura; 
	private JButton										botonAñadir , botonBorrar	, botonListar;
	private DefaultListModel 		< Libro > 			modeloListaLibros;
	private JList 					< Libro >			listaLibros;
	private JComboBox				< EstadoLibro > 	cmbEstados;
	
	GestorLibros(){
		components();
		settings();
	}
	
	private void settings() {
		this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		this.setTitle( "Gestor de Alumnos" );
		this.setResizable( false );
		this.setSize( 925, 745 );
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
				panelTitulo.setPreferredSize( new Dimension( 835 , 45 ) );
				panelTitulo.add( tituloPrincipal );
				panelTitulo.setBackground( Colors.transparentShy );
				this.getContentPane().add( panelTitulo );
	}
	
	private void dibujarInterior() {

		// LISTA PARA VISUALIZAR LIBROS, TANTO LOS QUE ESTÁN EN LA BBDD CÓMO LOS QUE SERÁN AÑADIDOS. //
			modeloListaLibros = new DefaultListModel<Libro>();
			listaLibros = new JList<Libro>( modeloListaLibros );
			listaLibros.setPreferredSize( new Dimension( 745 , 205));
			listaLibros.setBorder( Borders.border[ 8 ] );
			listaLibros.setBackground( Colors.transparentShy );
		// PANEL CON LOS DATOS DEL LIBRO //
			JPanel	panelGeneralLibro = new JPanel();
					panelGeneralLibro.setBorder( Borders.border[ 9 ]);
					panelGeneralLibro.setPreferredSize( new Dimension( 745 , 375 ) );
					panelGeneralLibro.setBackground( Colors.transparentShy );
		// PANEL DATOS LIBRO //
					
			JPanel	panelDatosLibro = new JPanel();
					panelDatosLibro.setLayout( new GridBagLayout());
					panelDatosLibro.setPreferredSize( new Dimension( 240 , 310 ) );
					panelDatosLibro.setBackground( Colors.transparentShy );
					
			GridBagConstraints c = new GridBagConstraints();		
			c.gridx = 0;
			c.gridy = 0;
			c.fill  = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets( 10 , 0 , 0 , 0 );
			JLabel	lblISBN = new JLabel( "ISBN: " );
					lblISBN.setFont( Fonts.fontTitleBorder );
			panelDatosLibro.add( lblISBN , c );
			c.gridx = 1;
			c.gridy = 0;
			c.fill  = GridBagConstraints.HORIZONTAL;
					txtISBN = new JTextField( 10 );
			panelDatosLibro.add( txtISBN , c );
				//	FIN ISBN //
			
			c.gridx = 0;
			c.gridy = 1;
			c.fill  = GridBagConstraints.HORIZONTAL;
			JLabel 	lblTitulo = new JLabel( "Título: " );
					lblTitulo.setFont( Fonts.fontTitleBorder );
			panelDatosLibro.add( lblTitulo , c );
			c.gridx = 1;	
			c.gridy = 1;
			c.fill  = GridBagConstraints.HORIZONTAL;
					txtTitulo = new JTextField( 10 );
			panelDatosLibro.add( txtTitulo , c );
				// FIN TITULO //
			
			c.gridx = 0;	
			c.gridy = 2;
			c.fill  = GridBagConstraints.HORIZONTAL;
			JLabel	lblAutor = new JLabel( "Autor: " );
					lblAutor.setFont( Fonts.fontTitleBorder );
			panelDatosLibro.add( lblAutor , c );
			c.gridx = 1;	
			c.gridy = 2;
			c.fill  = GridBagConstraints.HORIZONTAL;			
					txtAutor = new JTextField( 10 );
			panelDatosLibro.add( txtAutor , c );
				// FIN AUTOR //
			
			c.gridx = 0;	
			c.gridy = 3;
			c.fill  = GridBagConstraints.HORIZONTAL;
			JLabel	lblEditorial = new JLabel( "Editorial: " );
					lblEditorial.setFont( Fonts.fontTitleBorder );
			panelDatosLibro.add( lblEditorial , c );
			c.gridx = 1;	
			c.gridy = 3;
			c.fill  = GridBagConstraints.HORIZONTAL;
					txtEditorial = new JTextField( 10 );
			panelDatosLibro.add( txtEditorial , c );
				// FIN EDITORIAL //
			
			c.gridx = 0;	
			c.gridy = 4;
			c.fill  = GridBagConstraints.HORIZONTAL;
			JLabel	lblAsignatura = new JLabel( "Asignatura: " );
					lblAsignatura.setFont( Fonts.fontTitleBorder );
			panelDatosLibro.add( lblAsignatura , c );
			c.gridx = 1;	
			c.gridy = 4;
			c.fill  = GridBagConstraints.HORIZONTAL;
					txtAsignatura = new JTextField( 10 );
			panelDatosLibro.add( txtAsignatura , c );
				// FIN ASIGNATURA //
			c.gridx = 0;	
			c.gridy = 5;
			c.fill  = GridBagConstraints.HORIZONTAL;
			JLabel	lblEstadoLib = new JLabel( "Estado: " );
					lblEstadoLib.setFont( Fonts.fontTitleBorder );
			panelDatosLibro.add( lblEstadoLib , c );
			c.gridx = 1;	
			c.gridy = 5;
			c.fill  = GridBagConstraints.HORIZONTAL;
					cmbEstados = new JComboBox<EstadoLibro>( EstadoLibro.cargarModeloCombo() );
			panelDatosLibro.add( cmbEstados , c);
				// FIN ESTADO LIBRO //	
			
			panelGeneralLibro.add( panelDatosLibro );	
			
			// ================= FIN PANEL DATOS ================= //
		
		// PANEL BOTONES + IMAGEN  //
			JPanel	panelBotonesImagen = new JPanel();
					panelBotonesImagen.setLayout( new BoxLayout( panelBotonesImagen , BoxLayout.Y_AXIS ) );
			JPanel	panelBotones = new JPanel();	
					botonAñadir = new JButton( "Añadir" );
					botonAñadir.setFocusable( false );
					botonBorrar = new JButton( "Borrar" );
					botonBorrar.setFocusable( false ); 
					botonListar = new JButton( "Visualizar" );
					botonListar .setFocusable( false );
			
				panelBotones.add( botonAñadir );
				panelBotones.add( botonBorrar );
				panelBotones.add( botonListar );
				panelBotonesImagen.add( panelBotones );
				
				// FIN PANEL BOTONES //
				
			JLabel	lblImagen = new JLabel( new ImageIcon( "img/imgGestorLibros.png" ) );
					panelBotonesImagen.add( lblImagen );
			JPanel	panelVolver = new JPanel();	
					panelVolver.setPreferredSize( new Dimension( 200 , 75 ) );
			JButton	cerrar = new JButton("Volver");
					panelVolver.add( cerrar )	;
		panelGeneralLibro.add( panelBotonesImagen );	
		this.getContentPane().add( listaLibros );
		this.getContentPane().add( panelGeneralLibro );
		this.getContentPane().add( panelVolver );
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		new GestorLibros();

	}

}
