package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabAutil extends ItemSlab {
	public ItemSlabAutil(Block block) {
		super(block, (BlockSlab) mod_ebm.autilSlab, (BlockSlab) mod_ebm.autilSlabDouble, false);
	}
}
