package stream.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	private Pattern pattern;

	private static final String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	public Validator() {
		pattern = Pattern.compile(IPADDRESS_PATTERN);
	}

	public boolean validateIP(String ip) {
		return pattern.matcher(ip).matches();
	}

	public boolean validatePort(String port) {
		try {
			int porta = Integer.parseInt(port);
			return porta > 0 && porta < 65535;
		} catch (Exception e) {
			return false;
		}
	}
}
