package ebm.com.mce.items;

import ebm.com.mce.entity.tile.item.TileEntityErythonCube;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ModItems extends Item {
	public ModItems() {
		super();
	}

	public static class ErythonCube extends Item {
		public ErythonCube() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityErythonCube();
		}
	}
}
