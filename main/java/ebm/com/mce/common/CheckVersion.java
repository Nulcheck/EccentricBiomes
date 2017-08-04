package ebm.com.mce.common;

public class CheckVersion {
	public CheckVersion() {
		System.out.println("Eccentric Biomes is checking for updates. Getting high.");

		try {
			if (Integer.parseInt(UpdateInfo.getLatestVersion()) > UpdateInfo.thisVersion) {
				System.out.println("Eccentric Biomes Mod update found!");
			} else {
				System.out.println("No updates found for Eccentric Biomes Mod. Didn't get high enough.");
			}
		} catch (Exception e) {
			System.out.println("And error has occurred! Error ID: EBM-300");
			e.printStackTrace();
		}
	}
}
