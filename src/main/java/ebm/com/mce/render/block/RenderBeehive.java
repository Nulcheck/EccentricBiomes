package ebm.com.mce.render.block;

import org.lwjgl.opengl.GL11;

import ebm.com.mce.models.blocks.ModelBeehive;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderBeehive extends TileEntitySpecialRenderer {
	public static final ResourceLocation texture = new ResourceLocation("mod_ebm",
			"/textures/models/beehive.png".substring(1));
	public ModelBeehive model;

	public RenderBeehive() {
		this.model = new ModelBeehive();
	}

	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + .5f, (float) y + 1.5f, (float) z + .5f);
		GL11.glRotatef(180f, 0f, 0f, 1f);

		this.bindTexture(texture);

		GL11.glPushMatrix();
		this.model.renderModel(.0625f);

		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
