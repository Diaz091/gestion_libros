package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import resources.Image;


public class Prueba extends JFrame{

	private JPanel pn, pn2, pn3, pn4;
	private JButton bot1, bot2, bot3, bot4;
	private String operacion = "";
	
	Prueba(){
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		pn = new JPanel();
			pn.setBorder(BorderFactory.createLineBorder(Color.black));
			pn.setPreferredSize(new Dimension(1000, 400));
			pn.setVisible(false);
		JLabel lbl = new JLabel(new ImageIcon("img\\1.png"));
		pn.add(lbl);
		
		pn2 = new JPanel();
			pn2.setBorder(BorderFactory.createLineBorder(Color.black));
			pn2.setPreferredSize(new Dimension(1000, 400));
			pn2.setVisible(false);
		JLabel lb2 = new JLabel(new ImageIcon("img\\Interfaz 1.png"));
			pn2.add(lb2);
		
			pn3 = new JPanel();
			pn3.setBorder(BorderFactory.createLineBorder(Color.black));
			pn3.setPreferredSize(new Dimension(1000, 400));
			pn3.setVisible(false);
		JLabel lb3 = new JLabel(new ImageIcon("img\\Interfaz 2.0.png"));
			pn3.add(lb3);
			
			pn4 = new JPanel();
			pn4.setBorder(BorderFactory.createLineBorder(Color.black));
			pn4.setPreferredSize(new Dimension(1000, 400));
			pn4.setVisible(false);
		JLabel lb4 = new JLabel(new ImageIcon("img\\amp.png"));
			pn4.add(lb4);
		
			
			
			
			bot1 = new JButton("Altas");
				bot1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						pn.setVisible(true);					
						switch (operacion) {
						
							case "baja":
								pn2.setVisible(false);
								operacion = "alta";
								break;
							case "modificar":
								pn3.setVisible(false);
								operacion = "alta";
								break;
							case "consulta":
								pn4.setVisible(false);
								operacion = "alta";
								break;
							default:
								pn.setVisible(true);
								operacion = "alta";
								break;
						}
											
					}
				});
				
		 bot2 = new JButton("Bajas");
				bot2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						pn2.setVisible(true);
						switch (operacion) {
						
							case "alta":
								pn.setVisible(false);
								operacion = "baja";
								break;
							case "modificar":
								pn3.setVisible(false);
								operacion = "baja";
								break;
							case "consulta":
								pn4.setVisible(false);
								operacion = "baja";
								break;
							default:
								pn2.setVisible(true);
								operacion = "baja";
								break;
					}
				}
					
			});
				
		
		bot3 = new JButton("Modificaciones");
				bot3.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						pn3.setVisible(true);
						System.out.println(operacion);
						switch (operacion) {
						
							case "alta":
								pn.setVisible(false);
								operacion = "modificar";
								break;
							case "baja":
								pn2.setVisible(false);
								operacion = "modificar";
								break;
							case "consulta":
								pn4.setVisible(false);
								operacion = "modificar";
								break;
							default:
								pn3.setVisible(true);
								operacion = "modificar";
								break;
					}
						
					}
				});
		bot4 = new JButton("Consulta");
				bot4.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						pn4.setVisible(true);
						System.out.println(operacion);
						switch (operacion) {
						
							case "alta":
								pn.setVisible(false);
								operacion = "consulta";
								break;
							case "baja":
								pn2.setVisible(false);
								operacion = "consulta";
								break;
							case "modificar":
								pn3.setVisible(false);
								operacion = "consulta";
								break;
							default:
								pn4.setVisible(true);
								operacion = "consulta";
								break;
					}
						
					}
				});
		
		
			
		this.getContentPane().add(bot1);
		this.getContentPane().add(bot2);
		this.getContentPane().add(bot3);
		this.getContentPane().add(bot4);
		
		
		this.getContentPane().add(pn);
		this.getContentPane().add(pn2);
		this.getContentPane().add(pn3);
		this.getContentPane().add(pn4);
		
		
		
		
		this.setSize(1250,650);
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		new Prueba();
	}
	
	
}
