package ebm.com.mce.items.slabs;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabBone extends ItemSlab {
	public ItemSlabBone(Block block) {
		super(block, (BlockSlab) mod_ebm.boneSlab, (BlockSlab) mod_ebm.boneSlabDouble, false);
	}
}
