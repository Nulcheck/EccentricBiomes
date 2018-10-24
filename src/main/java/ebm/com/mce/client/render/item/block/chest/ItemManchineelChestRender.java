package ebm.com.mce.client.render.item.block.chest;

import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.entity.tile.block.chest.TileEntityManchineelChest;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemManchineelChestRender implements IItemRenderer {
	public static ItemManchineelChestRender instance = new ItemManchineelChestRender();
	private TileEntityManchineelChest itemRender = new TileEntityManchineelChest();

	private ModelChest chestModel;

	public ItemManchineelChestRender() {
		chestModel = new ModelChest();
	}

	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityManchineelChest(), 0.0D, -0.1D, 0.0D,
				0.0F);

	}

	public void renderChest(Block var1, int var2, float var3) {
		if (var1 == mod_ebm.mChest) {
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.itemRender, 0.0D, 0.0D, 0.0D, 0.0F);
		}

		if (var1 == mod_ebm.mChestTrapped) {
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.itemRender, 0.0D, 0.0D, 0.0D, 0.0F);
		}
	}
}
