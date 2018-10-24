package ebm.com.mce.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.world.World;

public class ModContainerWorkbench extends ContainerWorkbench {
	public ModContainerWorkbench(InventoryPlayer inv, World world, int x, int y, int z) {
		super(inv, world, x, y, z);
	}

	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
}
