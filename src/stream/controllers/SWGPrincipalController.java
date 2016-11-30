package stream.controllers;

import java.awt.Canvas;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import stream.models.Validator;
import stream.models.VlcjLib;
import stream.views.TelaPrincipal;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;

public class SWGPrincipalController implements ActionListener {

	private MediaPlayerFactory mediaPlayerFactory;
	private EmbeddedMediaPlayer mediaPlayer;
	private Validator validator;

	public SWGPrincipalController() {
		// Inicializador das Models
		VlcjLib.initVlcj();

		// Inicializador das Bibliotecas do VLCj
		mediaPlayerFactory = new MediaPlayerFactory();
		mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();

		// Inicializador das Views
		try {
			TelaPrincipal window = new TelaPrincipal(this);
			window.getFrmPlaystreamRtp().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Adiciona uma VideoSurface no JPanel
	public void addPlayer(Canvas canvas) {
		CanvasVideoSurface videoSurface = mediaPlayerFactory.newVideoSurface(canvas);
		mediaPlayer.setVideoSurface(videoSurface);
	}

	// Ação do button Start
	public void btnStart() {
		validator = new Validator();

		String serverIP = JOptionPane.showInputDialog("Digite o IP do servidor de Stream.");
		if (!validator.validateIP(serverIP)) {
			JOptionPane.showMessageDialog(null, "Digite um IP Válido", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String serverPort = JOptionPane.showInputDialog("Digite a porta do servidor de Stream.");
		if (!validator.validatePort(serverPort)) {
			JOptionPane.showMessageDialog(null, "Digite uma porta Válida", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String rtpCode = "rtp://@" + serverIP + ":" + serverPort;
		if (mediaPlayer.playMedia(rtpCode)) {

			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {

				}

				if (!mediaPlayer.isPlaying()) {
					if (i == 4) {
						JOptionPane.showMessageDialog(null,
								"Falha ao tentar se conectar com servidor, verifique se digitou corretamente.");
					}

				}
			}

		}
	}

	// Ação do button Stop
	public void btnStop() {
		mediaPlayer.stop();
	}

	// Adição da ação dos botões
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Start") {
			btnStart();
		}

		if (e.getActionCommand() == "Stop") {
			if (mediaPlayer.isPlaying()) {
				btnStop();
			}
		}
	}
}
