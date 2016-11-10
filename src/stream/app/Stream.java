package stream.app;

import java.awt.EventQueue;

import stream.views.SWGPrincipal;

public class Stream {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SWGPrincipal window = new SWGPrincipal();
					window.frmPlaystreamRtp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
