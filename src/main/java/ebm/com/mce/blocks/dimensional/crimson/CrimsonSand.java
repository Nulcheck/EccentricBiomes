package ebm.com.mce.blocks.dimensional.crimson;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.BlockFalling;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class CrimsonSand extends BlockFalling {
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable p) {
		if (p.getPlant(world, x, y, z) == mod_ebm.crimsonCactus) {
			return true;
		} else {
			return false;
		}
	}
}