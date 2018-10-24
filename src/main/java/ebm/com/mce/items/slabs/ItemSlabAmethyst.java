package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabAmethyst extends ItemSlab {
	public ItemSlabAmethyst(Block block) {
		super(block, (BlockSlab) mod_ebm.amethystSlab, (BlockSlab) mod_ebm.amethystSlabDouble, false);
	}
}
