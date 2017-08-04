package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabBeeswaxBricks extends ItemSlab {
	public ItemSlabBeeswaxBricks(Block block) {
		super(block, (BlockSlab) mod_ebm.beeswaxBrickSlab, (BlockSlab) mod_ebm.beeswaxBrickSlabDouble, false);
	}
}
