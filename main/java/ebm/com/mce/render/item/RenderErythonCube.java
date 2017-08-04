package ebm.com.mce.render.item;

import org.lwjgl.opengl.GL11;

import ebm.com.mce.models.items.ModelErythonCube;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderErythonCube extends TileEntitySpecialRenderer {
	public static final ResourceLocation texture = new ResourceLocation("mod_ebm",
			"/textures/entity/mob/erython.png".substring(1));
	public ModelErythonCube model;

	public RenderErythonCube() {
		this.model = new ModelErythonCube();
	}

	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + .3f, (float) y + 2f, (float) z + .3f);
		GL11.glRotatef(180f, 5f, 0f, 1f);

		this.bindTexture(texture);

		GL11.glPushMatrix();
		this.model.renderModel(.0625f);

		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
