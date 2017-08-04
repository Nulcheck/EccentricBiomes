package ebm.com.mce.items.slabs;

import java.util.List;

import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class ItemSlabunAutilBricks extends ItemSlab {
	public ItemSlabunAutilBricks(Block block) {
		super(block, (BlockSlab) mod_ebm.unAutilBrickSlab, (BlockSlab) mod_ebm.unAutilBrickSlabDouble, false);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
		list.add("Unbreakable");
	}
}
