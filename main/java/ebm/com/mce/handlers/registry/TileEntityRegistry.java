package ebm.com.mce.handlers.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import ebm.com.mce.entity.tile.block.TileEntityBeehive;
import ebm.com.mce.entity.tile.block.TileEntitySlimeSpike;
import ebm.com.mce.entity.tile.block.chest.TileEntityDeadwoodChest;
import ebm.com.mce.entity.tile.block.chest.TileEntityManchineelChest;
import ebm.com.mce.entity.tile.block.chest.TileEntityMauvewoodChest;

public class TileEntityRegistry {
	public static void tileEntityRegistry() {
		GameRegistry.registerTileEntity(TileEntityBeehive.class, "te_beehive");
		GameRegistry.registerTileEntity(TileEntitySlimeSpike.class, "te_slimeSpike");

		// Chests
		GameRegistry.registerTileEntity(TileEntityDeadwoodChest.class, "te_deadwoodChest");
		GameRegistry.registerTileEntity(TileEntityManchineelChest.class, "te_manchineelChest");
		GameRegistry.registerTileEntity(TileEntityMauvewoodChest.class, "te_mauvewoodChest");
	}
}
