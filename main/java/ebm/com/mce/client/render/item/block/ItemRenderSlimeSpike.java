package ebm.com.mce.client.render.item.block;

import org.lwjgl.opengl.GL11;

import ebm.com.mce.models.blocks.ModelSlimeSpike;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderSlimeSpike implements IItemRenderer {
	public static final ResourceLocation texture = new ResourceLocation("mod_ebm",
			"/textures/models/slime_spike.png".substring(1));
	private ModelSlimeSpike model;

	public ItemRenderSlimeSpike() {
		this.model = new ModelSlimeSpike();
	}

	public boolean handleRenderType(ItemStack stack, IItemRenderer.ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack stack,
			IItemRenderer.ItemRendererHelper helper) {
		return true;
	}

	/*
	 * public void renderItem(IItemRenderer.ItemRenderType type, ItemStack
	 * stack, Object... data) {
	 * TileEntityRendererDispatcher.instance.renderTileEntityAt(new
	 * TileEntitySlimeSpike(), 0d, -.5d, 0d, 0f); }
	 */

	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack stack, Object... data) {
		switch (type) {
		case INVENTORY: {
			GL11.glPushMatrix();
			GL11.glTranslatef(.3f, 1.5f, .3f);
			GL11.glRotatef(180f, 0f, 0f, 1f);
			GL11.glScalef(.1f, .1f, .1f);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderModel(.625f);
			GL11.glPopMatrix();
			break;
		}

		case ENTITY: {
			GL11.glPushMatrix();
			GL11.glTranslatef(0f, 1.2f, 0f);
			GL11.glRotatef(180f, 0f, 0f, 1f);
			GL11.glScalef(.1f, .1f, .1f);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderModel(.625f);
			GL11.glPopMatrix();
			break;
		}

		case EQUIPPED: {
			GL11.glPushMatrix();
			GL11.glTranslatef(.7f, 1.7f, .7f);
			GL11.glRotatef(180f, 0f, 0f, 1f);
			GL11.glScalef(.1f, .1f, .1f);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderModel(.625f);
			GL11.glPopMatrix();
			break;
		}

		case EQUIPPED_FIRST_PERSON: {
			GL11.glPushMatrix();
			GL11.glTranslatef(1.5f, 1.8f, .6f);
			GL11.glRotatef(180f, 0f, 0f, 1f);
			GL11.glScalef(.1f, .1f, .1f);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderModel(.625f);
			GL11.glPopMatrix();
			break;
		}

		default: {
			GL11.glPushMatrix();
			GL11.glTranslatef(0f, 1.2f, 0f);
			GL11.glRotatef(180f, 0f, 0f, 1f);
			GL11.glScalef(.1f, .1f, .1f);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderModel(.0625f);
			GL11.glPopMatrix();
			break;
		}
		}
	}
}
