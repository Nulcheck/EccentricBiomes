package ebm.com.mce.items.blocks.unbreak;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemunAutilBrickStairs extends ItemBlock {
	public ItemunAutilBrickStairs(Block block) {
		super(block);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
		list.add("Unbreakable");
	}
}
