package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabDeadWood extends ItemSlab {
	public ItemSlabDeadWood(Block block) {
		super(block, (BlockSlab) mod_ebm.deadWoodSlab, (BlockSlab) mod_ebm.deadWoodSlabDouble, false);
	}
}
