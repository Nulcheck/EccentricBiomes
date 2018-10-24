package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabBeeswaxChisel extends ItemSlab {
	public ItemSlabBeeswaxChisel(Block block) {
		super(block, (BlockSlab) mod_ebm.beeswaxChiselSlab, (BlockSlab) mod_ebm.beeswaxChiselSlabDouble, false);
	}
}
