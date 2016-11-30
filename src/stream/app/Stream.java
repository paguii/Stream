package stream.app;

import java.awt.EventQueue;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import stream.views.SWGPrincipal;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class Stream {
	
	private static final String NATIVE_LIBRARY_SEARCH_PATH = "C:\\Program Files\\VideoLAN\\VLC";

	public static void main(String[] args) {
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), NATIVE_LIBRARY_SEARCH_PATH);
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		System.out.println(LibVlc.INSTANCE.libvlc_get_version());
		
		NativeDiscovery nd = new NativeDiscovery();
		
		if (!nd.discover()) {
			System.out.println("VLC not found!");
			System.exit(-1);
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SWGPrincipal window = new SWGPrincipal();
					window.getFrmPlaystreamRtp().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
