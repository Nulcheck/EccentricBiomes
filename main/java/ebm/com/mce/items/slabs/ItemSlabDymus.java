package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabDymus extends ItemSlab {
	public ItemSlabDymus(Block block) {
		super(block, (BlockSlab) mod_ebm.dymusSlab, (BlockSlab) mod_ebm.dymusSlabDouble, false);
	}
}
