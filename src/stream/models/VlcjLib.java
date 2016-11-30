package stream.models;

import javax.swing.JOptionPane;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class VlcjLib {
	private static final String NATIVE_LIBRARY_SEARCH_PATH = "C:\\Program Files\\VideoLAN\\VLC";

	public static void initVlcj() {
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), NATIVE_LIBRARY_SEARCH_PATH);
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		System.out.println(LibVlc.INSTANCE.libvlc_get_version());

		NativeDiscovery nd = new NativeDiscovery();

		if (!nd.discover()) {
			JOptionPane.showMessageDialog(null,
					"VLC não foi encontrado, favor verificar se o mesmo está instalado no seu computador ou se a versão é compatível!",
					"VLC não encontrado!", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
}
