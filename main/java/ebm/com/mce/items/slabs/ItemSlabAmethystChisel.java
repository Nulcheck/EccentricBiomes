package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabAmethystChisel extends ItemSlab {
	public ItemSlabAmethystChisel(Block block) {
		super(block, (BlockSlab) mod_ebm.amethystChiselSlab, (BlockSlab) mod_ebm.amethystChiselSlabDouble, false);
	}
}
