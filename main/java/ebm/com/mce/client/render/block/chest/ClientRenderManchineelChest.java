package ebm.com.mce.client.render.block.chest;

import java.util.Calendar;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ebm.com.mce.blocks.chest.ManchineelChest;
import ebm.com.mce.entity.tile.block.chest.TileEntityManchineelChest;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class ClientRenderManchineelChest extends TileEntitySpecialRenderer {
	private static final ResourceLocation trap_double = new ResourceLocation("mod_ebm",
			"/textures/entity/chest/trapped_double_m.png".substring(1));

	private static final ResourceLocation trap_single = new ResourceLocation("mod_ebm",
			"/textures/entity/chest/trapped_m.png".substring(1));

	private static final ResourceLocation normal_double = new ResourceLocation("mod_ebm",
			"/textures/entity/chest/normal_double_m.png".substring(1));

	private static final ResourceLocation normal_single = new ResourceLocation("mod_ebm",
			"/textures/entity/chest/normal_m.png".substring(1));

	private static final ResourceLocation xmas_double = new ResourceLocation(
			"textures/entity/chest/christmas_double.png");

	private static final ResourceLocation xmas_single = new ResourceLocation("textures/entity/chest/christmas.png");

	private static final ResourceLocation bday_single = new ResourceLocation("mod_ebm",
			"/textures/entity/chest/bday.png".substring(1));

	private static final ResourceLocation bday_double = new ResourceLocation("mod_ebm",
			"/textures/entity/chest/bday_double.png".substring(1));

	private ModelChest chestModel = new ModelChest();
	private ModelChest largeChestModel = new ModelLargeChest();
	private boolean isChristmas;
	private boolean isBirthday;

	public ClientRenderManchineelChest() {
		Calendar calendar = Calendar.getInstance();
		if ((calendar.get(2) + 1 == 12) && (calendar.get(5) >= 24) && (calendar.get(5) <= 26)) {
			this.isChristmas = true;
		}
		if ((calendar.get(2) + 1 == 6) && (calendar.get(5) == 16)) {
			this.isBirthday = true;
		}
	}

	public void renderTileEntityChestAt(TileEntityManchineelChest par1TileEntityChest, double par2, double par4,
			double par6, float par8) {
		int i;

		if (!par1TileEntityChest.hasWorldObj()) {
			i = 0;
		} else {
			Block block = par1TileEntityChest.getBlockType();
			i = par1TileEntityChest.getBlockMetadata();

			if (block instanceof ManchineelChest && i == 0) {
				try {
					((ManchineelChest) block).unifyAdjacentChests(par1TileEntityChest.getWorldObj(),
							par1TileEntityChest.xCoord, par1TileEntityChest.yCoord, par1TileEntityChest.zCoord);
				} catch (ClassCastException e) {
					FMLLog.severe("Attempted to render a chest at %d,  %d, %d that was not a chest",
							par1TileEntityChest.xCoord, par1TileEntityChest.yCoord, par1TileEntityChest.zCoord);
				}
				i = par1TileEntityChest.getBlockMetadata();
			}

			par1TileEntityChest.checkForAdjacentChests();
		}

		if (par1TileEntityChest.adjacentChestZNeg == null && par1TileEntityChest.adjacentChestXNeg == null) {
			ModelChest modelchest;

			if (par1TileEntityChest.adjacentChestXPos == null && par1TileEntityChest.adjacentChestZPos == null) {
				modelchest = this.chestModel;

				if (par1TileEntityChest.getChestType() == 1) {
					this.bindTexture(trap_single);
				} else if (this.isChristmas) {
					this.bindTexture(xmas_single);
				} else if (this.isBirthday) {
					this.bindTexture(bday_single);
				} else {
					this.bindTexture(normal_single);
				}
			} else {
				modelchest = this.largeChestModel;

				if (par1TileEntityChest.getChestType() == 1) {
					this.bindTexture(trap_double);
				} else if (this.isChristmas) {
					this.bindTexture(xmas_double);
				} else if (this.isBirthday) {
					this.bindTexture(bday_double);
				} else {
					this.bindTexture(normal_double);
				}
			}

			GL11.glPushMatrix();
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) par2, (float) par4 + 1.0F, (float) par6 + 1.0F);
			GL11.glScalef(1.0F, -1.0F, -1.0F);
			GL11.glTranslatef(0.5F, 0.5F, 0.5F);
			short short1 = 0;

			if (i == 2) {
				short1 = 180;
			}

			if (i == 3) {
				short1 = 0;
			}

			if (i == 4) {
				short1 = 90;
			}

			if (i == 5) {
				short1 = -90;
			}

			if (i == 2 && par1TileEntityChest.adjacentChestXPos != null) {
				GL11.glTranslatef(1.0F, 0.0F, 0.0F);
			}

			if (i == 5 && par1TileEntityChest.adjacentChestZPos != null) {
				GL11.glTranslatef(0.0F, 0.0F, -1.0F);
			}

			GL11.glRotatef((float) short1, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			float f1 = par1TileEntityChest.prevLidAngle
					+ (par1TileEntityChest.lidAngle - par1TileEntityChest.prevLidAngle) * par8;
			float f2;

			if (par1TileEntityChest.adjacentChestZNeg != null) {
				f2 = par1TileEntityChest.adjacentChestZNeg.prevLidAngle
						+ (par1TileEntityChest.adjacentChestZNeg.lidAngle
								- par1TileEntityChest.adjacentChestZNeg.prevLidAngle) * par8;

				if (f2 > f1) {
					f1 = f2;
				}
			}

			if (par1TileEntityChest.adjacentChestXNeg != null) {
				f2 = par1TileEntityChest.adjacentChestXNeg.prevLidAngle
						+ (par1TileEntityChest.adjacentChestXNeg.lidAngle
								- par1TileEntityChest.adjacentChestXNeg.prevLidAngle) * par8;

				if (f2 > f1) {
					f1 = f2;
				}
			}

			f1 = 1.0F - f1;
			f1 = 1.0F - f1 * f1 * f1;
			modelchest.chestLid.rotateAngleX = -(f1 * (float) Math.PI / 2.0F);
			modelchest.renderAll();
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
			GL11.glPopMatrix();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}

	public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
		renderTileEntityChestAt((TileEntityManchineelChest) par1TileEntity, par2, par4, par6, par8);
	}
}
