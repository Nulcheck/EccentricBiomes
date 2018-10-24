package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabMauvewood extends ItemSlab {
	public ItemSlabMauvewood(Block block) {
		super(block, (BlockSlab) mod_ebm.mauvewoodSlab, (BlockSlab) mod_ebm.mauvewoodSlabDouble, false);
	}
}
