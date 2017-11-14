package ebm.com.mce.render.block;

import org.lwjgl.opengl.GL11;

import ebm.com.mce.models.blocks.ModelSlimeSpike;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderSlimeSpike extends TileEntitySpecialRenderer {
	public static final ResourceLocation textureGreen = new ResourceLocation("mod_ebm",
			"/textures/models/slime_spike_green.png".substring(1));

	public static final ResourceLocation textureBlue = new ResourceLocation("mod_ebm",
			"/textures/models/slime_spike_blue.png".substring(1));
	public ModelSlimeSpike model;

	public RenderSlimeSpike() {
		this.model = new ModelSlimeSpike();
	}

	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
		int meta = te.getWorldObj().getBlockMetadata(te.xCoord, te.yCoord, te.zCoord);

		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + .5f, (float) y + 1.5f, (float) z + .5f);
		GL11.glRotatef(180f, 0f, 0f, 1f);

		// Adding Alpha Abilities
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glDepthMask(false);

		if (meta == 0) {
			GL11.glPushMatrix();
			this.bindTexture(textureGreen);
			this.model.renderModel(.0625f);
			GL11.glPopMatrix();
		}

		if (meta == 1) {
			GL11.glPushMatrix();
			this.bindTexture(textureBlue);
			this.model.renderModel(.0625f);
			GL11.glPopMatrix();
		}
		GL11.glPopMatrix();

		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
	}
}
