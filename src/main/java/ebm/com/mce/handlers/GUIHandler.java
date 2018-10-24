package ebm.com.mce.handlers;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.container.ModContainerWorkbench;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GUIHandler implements IGuiHandler {
	public GUIHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(mod_ebm.instance, this);
	}

	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null) {
			switch (id) {
			case mod_ebm.mCTableGUI:
				return (id == 0) && (world.getBlock(x, y, z) == mod_ebm.mCTable)
						? new ModContainerWorkbench(player.inventory, world, x, y, z) : null;

			case mod_ebm.deadCTableGUI:
				return (id == 1) && (world.getBlock(x, y, z) == mod_ebm.deadCTable)
						? new ModContainerWorkbench(player.inventory, world, x, y, z) : null;

			case mod_ebm.mauveCTableGUI:
				return (id == 2) && (world.getBlock(x, y, z) == mod_ebm.mauveCTable)
						? new ModContainerWorkbench(player.inventory, world, x, y, z) : null;
			}
		}
		return null;
	}

	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null) {
			switch (id) {
			case mod_ebm.mCTableGUI:
				return (id == 0) && (world.getBlock(x, y, z) == mod_ebm.mCTable)
						? new GuiCrafting(player.inventory, world, x, y, z) : null;

			case mod_ebm.deadCTableGUI:
				return (id == 1) && (world.getBlock(x, y, z) == mod_ebm.deadCTable)
						? new GuiCrafting(player.inventory, world, x, y, z) : null;

			case mod_ebm.mauveCTableGUI:
				return (id == 2) && (world.getBlock(x, y, z) == mod_ebm.mauveCTable)
						? new GuiCrafting(player.inventory, world, x, y, z) : null;
			}
		}

		return null;
	}
}
