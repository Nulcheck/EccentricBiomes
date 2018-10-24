package ebm.com.mce.blocks;

import net.minecraft.block.BlockOre;

public class ModOre extends BlockOre {
	public ModOre() {
		super();
	}

	public static class CrimsoniteOre extends BlockOre {
		public CrimsoniteOre() {
			super();
			this.setHarvestLevel("pickaxe", 2);
		}
	}
}
