package ebm.com.mce.util.updater;

import java.io.InputStream;
import java.net.URL;

public class UpdateInfo {
	public static int thisVersion = 7;
	public static final String versionURL = "https://docs.google.com/document/d/1xS4GG41DY2Vrh5q7BOHgwNEWMCWj2IoCyUDODb9wn64/pub";

	public static String getLatestVersion() throws Exception {
		String data = getData("https://docs.google.com/document/d/1xS4GG41DY2Vrh5q7BOHgwNEWMCWj2IoCyUDODb9wn64/pub");
		return data.substring(data.indexOf("[version]") + 9, data.indexOf("[/version]"));
	}

	private static String getData(String address) throws Exception {
		URL url = new URL(address);
		InputStream html = null;
		html = url.openStream();

		int i = 0;
		StringBuffer buf = new StringBuffer("");
		while (i != -1) {
			i = html.read();
			buf.append((char) i);
		}

		return buf.toString();
	}
}
