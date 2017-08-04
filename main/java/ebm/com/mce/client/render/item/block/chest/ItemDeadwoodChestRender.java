package ebm.com.mce.client.render.item.block.chest;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.entity.tile.block.chest.TileEntityDeadwoodChest;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemDeadwoodChestRender implements IItemRenderer {
	public static ItemDeadwoodChestRender instance = new ItemDeadwoodChestRender();
	private TileEntityDeadwoodChest itemRender = new TileEntityDeadwoodChest();

	private ModelChest chestModel;

	public ItemDeadwoodChestRender() {
		chestModel = new ModelChest();
	}

	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityDeadwoodChest(), 0.0D, -0.1D, 0.0D,
				0.0F);

	}

	public void renderChest(Block var1, int var2, float var3) {
		if (var1 == mod_ebm.deadChest) {
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.itemRender, 0.0D, 0.0D, 0.0D, 0.0F);
		}

		if (var1 == mod_ebm.deadChestTrapped) {
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.itemRender, 0.0D, 0.0D, 0.0D, 0.0F);
		}
	}
}
