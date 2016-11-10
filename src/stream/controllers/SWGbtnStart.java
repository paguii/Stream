package stream.controllers;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import stream.models.VlcjTest;

public class SWGbtnStart implements ActionListener {
	private static final String NATIVE_LIBRARY_SEARCH_PATH = "C:\\Program Files\\VideoLAN\\VLC";

	@Override
	public void actionPerformed(ActionEvent e) {
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), NATIVE_LIBRARY_SEARCH_PATH);
		// Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		System.out.println(LibVlc.INSTANCE.libvlc_get_version());
		NativeDiscovery nd = new NativeDiscovery();
		if (!nd.discover()) {
			System.out.println("VLC not found!");
			System.exit(-1);
		}

		MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
		EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.black);
		CanvasVideoSurface videoSurface = mediaPlayerFactory.newVideoSurface(canvas);
		mediaPlayer.setVideoSurface(videoSurface);
		
		JFrame f = new JFrame();
		//f.setIconImage(new ImageIcon(Client.class.getResource("icons/vlcj-logo.png")).getImage());
		f.add(canvas);
		f.setSize(800, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		System.out.println("Start");

		String serverIP = JOptionPane.showInputDialog("Digite o IP do servidor de Stream.");
		System.out.println(serverIP);
		String serverPort = JOptionPane.showInputDialog("Digite a porta do servidor de Stream.");
		System.out.print(serverPort);
		String serverPublic = formatRtpStream(serverIP, Integer.parseInt(serverPort));

		System.out.println("Capturing from '" + serverPublic + "'");
		mediaPlayer.playMedia(serverPublic);
	}

	private String formatRtpStream(String serverAddress, int serverPort) {
		StringBuilder sb = new StringBuilder(60);
		sb.append(":sout=#rtp{dst=");
		sb.append(serverAddress);
		sb.append(",port=");
		sb.append(serverPort);
		sb.append(",mux=ts}");
		return sb.toString();
	}

}
