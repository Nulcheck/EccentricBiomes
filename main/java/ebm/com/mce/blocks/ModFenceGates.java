package ebm.com.mce.blocks;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.util.IIcon;

public class ModFenceGates {
	public static class ManchineelFenceGate extends BlockFenceGate {
		public ManchineelFenceGate() {
			super();
		}

		public IIcon getIcon(int side, int meta) {
			return mod_ebm.mPlanks.getBlockTextureFromSide(side);
		}
	}

	public static class DeadwoodFenceGate extends BlockFenceGate {
		public DeadwoodFenceGate() {
			super();
		}

		public IIcon getIcon(int side, int meta) {
			return mod_ebm.deadPlanks.getBlockTextureFromSide(side);
		}
	}

	public static class MauvewoodFenceGate extends BlockFenceGate {
		public MauvewoodFenceGate() {
			super();
		}

		public IIcon getIcon(int side, int meta) {
			return mod_ebm.mauvePlanks.getBlockTextureFromSide(side);
		}
	}
}
