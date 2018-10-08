package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaces.MainMenu;
import interfaces.StudentManager;

public class StudentController implements ActionListener{
		
	private MainMenu main;
	private StudentManager stManager;
		
	public StudentController(MainMenu mainM) {
	
		this.main = mainM;
	}

	public StudentController(StudentManager stuM) {
		
		this.stManager = stuM;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if( e.getSource() == main.getBotonAlumnos() ) {
			new StudentManager();
			main.dispose();
		}
		
		if ( e.getSource() == stManager.getBotonAltas() ) {
			
			
		}
		
		
	}
}
