package stream.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class SWGbtnStart implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String serverIP = JOptionPane.showInputDialog("Digite o IP do servidor de Stream.");
		System.out.println(serverIP);
		
		String serverPort = JOptionPane.showInputDialog("Digite a porta do servidor de Stream.");
		System.out.print(serverPort);
		
		System.out.println("Capturing from '" + null + "'");
	}

	public String formatRtpStream(String serverAddress, int serverPort) {
		StringBuilder sb = new StringBuilder(60);
		
		sb.append(":sout=#rtp{dst=");
		sb.append(serverAddress);
		sb.append(",port=");
		sb.append(serverPort);
		sb.append(",mux=ts}");
		return sb.toString();
	}

}
