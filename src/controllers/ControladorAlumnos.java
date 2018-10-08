package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.MainMenu;
import interfaces.GestorAlumnos;

public class ControladorAlumnos implements ActionListener{
		
	private MainMenu main;
	private GestorAlumnos stManager;
		
	public ControladorAlumnos(MainMenu mainM) {
		this.main = mainM;
	}

	public ControladorAlumnos(GestorAlumnos stuM) {
		this.stManager = stuM;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if( (JButton) e.getSource() == main.getBotonAlumnos( ) ){
			new GestorAlumnos();
			main.dispose();
		}
		
		if( (JButton) e.getSource() == stManager.getBotonAltas() ) {
			System.out.println("Why you do this?");
			
						
		}
		
	}
}
