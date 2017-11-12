package ebm.com.mce.render.block;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import ebm.com.mce.models.blocks.ModelSlimeSpike;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderSlimeSpike extends TileEntitySpecialRenderer {
	public static final ResourceLocation texture = new ResourceLocation("mod_ebm",
			"/textures/models/slime_spike.png".substring(1));
	public ModelSlimeSpike model;

	public RenderSlimeSpike() {
		this.model = new ModelSlimeSpike();
	}

	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
		double r = Math.random();
		double g = Math.random();
		double b = Math.random();

		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + .5f, (float) y + 1.5f, (float) z + .5f);
		GL11.glRotatef(180f, 0f, 0f, 1f);

		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glColor3d(r, g, b);
		GL11.glDepthMask(false);

		this.bindTexture(texture);

		GL11.glPushMatrix();
		this.model.renderModel(.0625f);
		GL11.glPopMatrix();
		GL11.glPopMatrix();

		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
	}
}
