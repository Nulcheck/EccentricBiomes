package ebm.com.mce.handlers.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import ebm.com.mce.entity.tile.block.chest.TileEntityDeadwoodChest;
import ebm.com.mce.entity.tile.block.chest.TileEntityManchineelChest;
import ebm.com.mce.entity.tile.block.chest.TileEntityMauvewoodChest;

public class TileEntityRegistry {
	public static void tileEntityRegistry(){
		// Chests
		GameRegistry.registerTileEntity(TileEntityDeadwoodChest.class, "te_deadwoodchest");
		GameRegistry.registerTileEntity(TileEntityManchineelChest.class, "te_manchineelchest");
		GameRegistry.registerTileEntity(TileEntityMauvewoodChest.class, "te_mauvewoodchest");
	}
}
