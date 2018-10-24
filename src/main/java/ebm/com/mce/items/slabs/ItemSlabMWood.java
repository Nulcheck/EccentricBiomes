package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabMWood extends ItemSlab {
	public ItemSlabMWood(Block block) {
		super(block, (BlockSlab) mod_ebm.mWoodSlab, (BlockSlab) mod_ebm.mWoodSlabDouble, false);
	}
}
