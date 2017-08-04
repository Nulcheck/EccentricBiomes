package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabAmethystOrnate extends ItemSlab {
	public ItemSlabAmethystOrnate(Block block) {
		super(block, (BlockSlab) mod_ebm.amethystOrnateSlab, (BlockSlab) mod_ebm.amethystOrnateSlabDouble, false);
	}
}
