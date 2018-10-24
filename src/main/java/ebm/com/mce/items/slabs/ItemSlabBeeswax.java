package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabBeeswax extends ItemSlab {
	public ItemSlabBeeswax(Block block) {
		super(block, (BlockSlab) mod_ebm.beeswaxSlab, (BlockSlab) mod_ebm.beeswaxSlabDouble, false);
	}
}
