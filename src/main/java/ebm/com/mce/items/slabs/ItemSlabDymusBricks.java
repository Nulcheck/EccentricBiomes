package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabDymusBricks extends ItemSlab {
	public ItemSlabDymusBricks(Block block) {
		super(block, (BlockSlab) mod_ebm.dymusBrickSlab, (BlockSlab) mod_ebm.dymusBrickSlabDouble, false);
	}
}
