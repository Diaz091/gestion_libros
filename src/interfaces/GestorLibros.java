package interfaces;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import models.DataResource;
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
	
	private JTextField									txtISBN , txtTitulo , txtAutor , txtEditorial , txtAsignatura; 
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
				
				this.getContentPane().add( panelTitulo );
	}
	
	private void dibujarInterior() {

		// LISTA PARA VISUALIZAR LIBROS, TANTO LOS QUE ESTÁN EN LA BBDD CÓMO LOS QUE SERÁN AÑADIDOS. //
			listaLibros = new JList<Libro>(  );
			listaLibros.setPreferredSize( new Dimension( 745 , 250));
			listaLibros.setBorder( Borders.border[ 8 ] );
			listaLibros.setBackground( Colors.transparentShy );
		// PANEL CON LOS DATOS DEL LIBRO //
			JPanel	panelGeneralLibro = new JPanel();
					panelGeneralLibro.setBorder( Borders.border[ 9 ]);
					panelGeneralLibro.setPreferredSize( new Dimension( 745 , 355 ) );
		// PANEL DATOS LIBRO //
			JPanel	panelDatosLibro = new JPanel();
					panelDatosLibro.setLayout( new GridBagLayout());
					panelDatosLibro.setPreferredSize( new Dimension( 200 , 290 ) );
			GridBagConstraints c = new GridBagConstraints();		
					
			JLabel	lblISBN = new JLabel( "ISBN: ");
					lblISBN.setFont( Fonts.fontTitleBorder );
					txtISBN = new JTextField(  );
			panelDatosLibro.add( lblISBN );
			panelDatosLibro.add( txtISBN );
				//	FIN ISBN //
			
			JLabel 	lblTitulo = new JLabel( "Título: " );
					lblTitulo.setFont( Fonts.fontTitleBorder );
					txtTitulo = new JTextField(  );
			panelDatosLibro.add( lblTitulo );
			panelDatosLibro.add( txtTitulo );
				// FIN TITULO //
		
			JLabel	lblAutor = new JLabel( "Autor: " );
					lblAutor.setFont( Fonts.fontTitleBorder );
					txtAutor = new JTextField(  );
			panelDatosLibro.add( lblAutor );
			panelDatosLibro.add( txtAutor );
				// FIN AUTOR //
			
			JLabel	lblEditorial = new JLabel( "Editorial: " );
					lblEditorial.setFont( Fonts.fontTitleBorder );
					txtEditorial = new JTextField(  );
			panelDatosLibro.add( lblEditorial );
			panelDatosLibro.add( txtEditorial );
				// FIN EDITORIAL //
			
			JLabel	lblAsignatura = new JLabel( "Asignatura: " );
					lblAsignatura.setFont( Fonts.fontTitleBorder );
					txtAsignatura = new JTextField(  );
			panelDatosLibro.add( lblAsignatura );
			panelDatosLibro.add( txtAsignatura );
				// FIN ASIGNATURA //
			
			JLabel	lblEstadoLib = new JLabel( "Estado: " );
					lblEstadoLib.setFont( Fonts.fontTitleBorder );
					cmbEstados = new JComboBox<EstadoLibro>( EstadoLibro.cargarModeloCombo() );
			panelDatosLibro.add( lblEstadoLib );
			panelDatosLibro.add( cmbEstados );
				// FIN ESTADO LIBRO //	
					
					
			panelGeneralLibro.add( panelDatosLibro );
		this.getContentPane().add( listaLibros );
		this.getContentPane().add( panelGeneralLibro );
		
	}
	
	public static void main(String[] args) {
		new GestorLibros();

	}

}
