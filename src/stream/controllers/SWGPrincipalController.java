package stream.controllers;

import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;

public class SWGPrincipalController implements ActionListener{
	
	private MediaPlayerFactory mediaPlayerFactory;
	private EmbeddedMediaPlayer mediaPlayer;
	
	public SWGPrincipalController() {
		mediaPlayerFactory = new MediaPlayerFactory();
		mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
	}
	
	public void addPlayer(Canvas canvas){
		CanvasVideoSurface videoSurface = mediaPlayerFactory.newVideoSurface(canvas);
		mediaPlayer.setVideoSurface(videoSurface);
	}
	
	public void btnStart() {
		String serverIP = JOptionPane.showInputDialog("Digite o IP do servidor de Stream.");
		String serverPort = JOptionPane.showInputDialog("Digite a porta do servidor de Stream.");
		
		if((serverIP.length() < 8 || serverIP.length() > 16) || (serverPort.length() > 5 || serverPort.length() < 1)){
			JOptionPane.showMessageDialog(null, "Esse não é um servidor RTP válido");
		}else{
			String rtpCode = "rtp://@" + serverIP + ":" + serverPort;
			mediaPlayer.playMedia(rtpCode);
			
//			JOptionPane.showMessageDialog(null, "Falha ao tentar se conectar com servidor, verifique se digitou corretamente.");
		}
	}
	
	public void btnStop(){
		mediaPlayer.stop();
	}
	
    public void actionPerformed(ActionEvent e){
    	if(e.getActionCommand() == "Start"){
    		btnStart();
    	}
    	
    	if(e.getActionCommand() == "Stop"){
    		if(mediaPlayer.isPlaying()){
    			btnStop();
    		}
    	}
    }  
}
