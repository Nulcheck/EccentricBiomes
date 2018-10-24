package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabBeeswaxOrnate extends ItemSlab {
	public ItemSlabBeeswaxOrnate(Block block) {
		super(block, (BlockSlab) mod_ebm.beeswaxOrnateSlab, (BlockSlab) mod_ebm.beeswaxOrnateSlabDouble, false);
	}
}
