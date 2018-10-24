package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabDymusChisel extends ItemSlab {
	public ItemSlabDymusChisel(Block block) {
		super(block, (BlockSlab) mod_ebm.dymusChiselSlab, (BlockSlab) mod_ebm.dymusChiselSlabDouble, false);
	}
}
