package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabAutilChisel extends ItemSlab {
	public ItemSlabAutilChisel(Block block) {
		super(block, (BlockSlab) mod_ebm.autilChiselSlab, (BlockSlab) mod_ebm.autilChiselSlabDouble, false);
	}
}
