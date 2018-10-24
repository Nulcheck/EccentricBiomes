package ebm.com.mce.blocks;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.BlockButton;
import net.minecraft.util.IIcon;

public class ModButton {
	public static class ManchineelButton extends BlockButton {
		public ManchineelButton(boolean arrow) {
			super(arrow);
		}

		public IIcon getIcon(int meta, int side) {
			return mod_ebm.mPlanks.getIcon(side, 0);
		}
	}

	public static class DeadwoodButton extends BlockButton {
		public DeadwoodButton(boolean arrow) {
			super(arrow);
		}

		public IIcon getIcon(int meta, int side) {
			return mod_ebm.deadPlanks.getIcon(side, 0);
		}
	}

	public static class MauvewoodButton extends BlockButton {
		public MauvewoodButton(boolean arrow) {
			super(arrow);
		}

		public IIcon getIcon(int meta, int side) {
			return mod_ebm.mauvePlanks.getIcon(side, 0);
		}
	}
}
