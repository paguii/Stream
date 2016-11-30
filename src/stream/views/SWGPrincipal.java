package stream.views;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Canvas;

import javax.swing.JLabel;

import stream.controllers.SWGPrincipalController;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class SWGPrincipal {

	private JFrame frmPlaystreamRtp;
	private JDesktopPane desktopPane;
	private JLabel lblTitulo;
	private JButton btnStart; //Play
	private JButton btnStop; //Stop
	private Canvas canvas; //Onde vai ser executado a stream
	
	private SWGPrincipalController controller;
	
	public SWGPrincipal() {
		this.controller = new SWGPrincipalController();
		
		frmPlaystreamRtp = new JFrame();
		frmPlaystreamRtp.setTitle("PlayStream - RTP Player");
		frmPlaystreamRtp.setName("framePrincipal");
		frmPlaystreamRtp.setResizable(false);
		frmPlaystreamRtp.setBounds(100, 100, 698, 531);
		frmPlaystreamRtp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlaystreamRtp.setVisible(true);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.DARK_GRAY);
		frmPlaystreamRtp.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		canvas = new Canvas();
		canvas.setBackground(Color.black);
		canvas.setBounds(0, 60, 692, 395);
		controller.addPlayer(canvas);

		lblTitulo = new JLabel("PlayStream");
		lblTitulo.setForeground(Color.LIGHT_GRAY);
		lblTitulo.setFont(new Font("Consolas", Font.PLAIN, 36));
		lblTitulo.setBounds(10, 11, 211, 59);

		btnStart = new JButton("Start");
		btnStart.setBounds(593, 468, 89, 23);
		btnStart.addActionListener(controller);

		btnStop = new JButton("Stop");
		btnStop.setBounds(494, 468, 89, 23);
		btnStop.addActionListener(controller);
		
		desktopPane.add(lblTitulo);
		desktopPane.add(btnStop);
		desktopPane.add(btnStart);
		desktopPane.add(canvas);
	}
	
	public JFrame getFrmPlaystreamRtp() {
		return frmPlaystreamRtp;
	}

	public void setFrmPlaystreamRtp(JFrame frmPlaystreamRtp) {
		this.frmPlaystreamRtp = frmPlaystreamRtp;
	}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public void setDesktopPane(JDesktopPane desktopPane) {
		this.desktopPane = desktopPane;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JButton getBtnStart() {
		return btnStart;
	}

	public void setBtnStart(JButton btnStart) {
		this.btnStart = btnStart;
	}

	public JButton getBtnStop() {
		return btnStop;
	}

	public void setBtnStop(JButton btnStop) {
		this.btnStop = btnStop;
	}

}
