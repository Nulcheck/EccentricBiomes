package ebm.com.mce.client.render.item;

import org.lwjgl.opengl.GL11;

import ebm.com.mce.models.items.ModelErythonCube;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderErythonCube implements IItemRenderer {
	public static final ResourceLocation texture = new ResourceLocation("mod_ebm",
			"/textures/entity/mob/erython.png".substring(1));
	private ModelErythonCube model;

	public ItemRenderErythonCube() {
		this.model = new ModelErythonCube();
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
	 * TileEntityErythonCube(), 0d, -.1d, 0d, 0f); }
	 */

	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack stack, Object... data) {
		switch (type) {
		case INVENTORY: {
			GL11.glPushMatrix();
			GL11.glTranslatef(.3f, 1.2f, .3f);
			GL11.glRotatef(180f, 0f, 0f, 1f);
			GL11.glScalef(.1f, .1f, .1f);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderModel(.625f);
			GL11.glPopMatrix();
			break;
		}

		case ENTITY: {
			GL11.glPushMatrix();
			GL11.glTranslatef(.4005f, 1.2f, .4005f);
			GL11.glRotatef(180f, 0f, 0f, 1f);
			GL11.glScalef(.1f, .1f, .1f);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderModel(.625f);
			GL11.glPopMatrix();
			break;
		}

		case EQUIPPED: {
			GL11.glPushMatrix();
			GL11.glTranslatef(1.05f,1.8f,1.1f);
			GL11.glScalef(.1f, .1f, .1f);
			GL11.glRotatef(180f, 0f, 0f, 1f);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderModel(.625f);
			GL11.glPopMatrix();
			break;
		}

		case EQUIPPED_FIRST_PERSON: {
			GL11.glPushMatrix();
			GL11.glTranslatef(.9f,2.15f,1.05f);
			GL11.glScalef(.1f, .1f, .1f);
			GL11.glRotatef(180f, 0f, 0f, 1f);

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
