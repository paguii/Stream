package stream.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class SWGbtnStart implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Start");
		
		String serverIP = JOptionPane.showInputDialog("Digite o IP do servidor de Stream.");
		System.out.println(serverIP);
		
		
	}

}
