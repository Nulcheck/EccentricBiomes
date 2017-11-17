package ebm.com.mce.handlers;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.handlers.dimension.WorldProviderCrimson;
import net.minecraftforge.common.DimensionManager;

public class DimensionHandler {
	public static void mainRegistry() {
		dimensionRegistry();
	}

	public static void dimensionRegistry() {
		DimensionManager.registerProviderType(mod_ebm.crimsonId, WorldProviderCrimson.class, true);
		DimensionManager.registerDimension(mod_ebm.crimsonId, mod_ebm.crimsonId);
	}
}
