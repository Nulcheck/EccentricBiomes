package ebm.com.mce.blocks.dimensional.crimson;

import ebm.com.mce.blocks.portals.CrimsonPortal;
import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class CrimsonFire extends Block {
	public CrimsonFire(Material mat) {
		super(mat);
		this.setBlockTextureName("mod_ebm:invs");
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		return AxisAlignedBB.getBoundingBox(0, 0, 0, 0, 0, 0);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public int getRenderBlockPass() {
		return 1;
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		if (!((CrimsonPortal) mod_ebm.crimsonPortal).getPortalSize(world, x, y, z)) {
			world.setBlockToAir(x, y, z);
		}
	}
}