package stream.views;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import stream.controllers.SWGbtnStart;
import stream.controllers.SWGbtnStop;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class SWGPrincipal {

	public JFrame frmPlaystreamRtp;

	/**
	 * Create the application.
	 */
	public SWGPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlaystreamRtp = new JFrame();
		frmPlaystreamRtp.setTitle("PlayStream - RTP Player");
		frmPlaystreamRtp.setName("framePrincipal");
		frmPlaystreamRtp.setResizable(false);
		frmPlaystreamRtp.setBounds(100, 100, 698, 531);
		frmPlaystreamRtp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.DARK_GRAY);
		frmPlaystreamRtp.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblTitulo = new JLabel("PlayStream");
		lblTitulo.setForeground(Color.LIGHT_GRAY);
		lblTitulo.setFont(new Font("Consolas", Font.PLAIN, 36));
		lblTitulo.setBounds(10, 11, 211, 59);
		desktopPane.add(lblTitulo);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new SWGbtnStart()); // Controller START
		btnStart.setBounds(582, 456, 89, 23);
		desktopPane.add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new SWGbtnStop()); // Controller STOP
		btnStop.setBounds(474, 456, 89, 23);
		desktopPane.add(btnStop);
	}
}
