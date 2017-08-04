package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabAutilOrnate extends ItemSlab {
	public ItemSlabAutilOrnate(Block block) {
		super(block, (BlockSlab) mod_ebm.autilOrnateSlab, (BlockSlab) mod_ebm.autilOrnateSlabDouble, false);
	}
}
