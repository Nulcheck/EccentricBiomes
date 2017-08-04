package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabAutilBricks extends ItemSlab {
	public ItemSlabAutilBricks(Block block) {
		super(block, (BlockSlab) mod_ebm.autilBrickSlab, (BlockSlab) mod_ebm.autilBrickSlabDouble, false);
	}
}
