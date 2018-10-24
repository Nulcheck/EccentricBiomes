package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabAmethystBricks extends ItemSlab {
	public ItemSlabAmethystBricks(Block block) {
		super(block, (BlockSlab) mod_ebm.amethystBrickSlab, (BlockSlab) mod_ebm.amethystBrickSlabDouble, false);
	}
}
