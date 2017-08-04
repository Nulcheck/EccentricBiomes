package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabDymusOrnate extends ItemSlab {
	public ItemSlabDymusOrnate(Block block) {
		super(block, (BlockSlab) mod_ebm.dymusOrnateSlab, (BlockSlab) mod_ebm.dymusOrnateSlabDouble, false);
	}
}
