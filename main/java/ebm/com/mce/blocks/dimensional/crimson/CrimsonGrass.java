package ebm.com.mce.blocks.dimensional.crimson;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class CrimsonGrass extends Block implements IGrowable {
	public static final Logger logger = LogManager.getLogger();
	@SideOnly(Side.CLIENT)
	public IIcon top;
	@SideOnly(Side.CLIENT)
	public IIcon sideSnow;
	@SideOnly(Side.CLIENT)
	public IIcon sideOver;
	public static final String __OBFID = "CL_00000251";

	public CrimsonGrass() {
		super(Material.grass);
		this.setTickRandomly(true);
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 1 ? this.top : (side == 0 ? mod_ebm.crimsonDirt.getBlockTextureFromSide(side) : this.blockIcon);
	}

	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction,
			IPlantable plantable) {
		Block plant = plantable.getPlant(world, x, y + 1, z);
		if (plant == mod_ebm.crimsonTallGrass || plant == mod_ebm.mSapling || plant == mod_ebm.crimsonBush) {
			return true;
		}
		return false;
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (!world.isRemote) {
			if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2) {
				world.setBlock(x, y, z, mod_ebm.crimsonDirt);
			} else if (world.getBlockLightValue(x, y + 1, z) >= 9) {
				for (int l = 0; l < 4; ++l) {
					int i1 = x + rand.nextInt(3) - 1;
					int j1 = y + rand.nextInt(5) - 3;
					int k1 = z + rand.nextInt(3) - 1;

					if (world.getBlock(i1, j1, k1) == mod_ebm.crimsonDirt && world.getBlockMetadata(i1, j1, k1) == 0
							&& world.getBlockLightValue(i1, j1 + 1, k1) >= 4
							&& world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
						world.setBlock(i1, j1, k1, mod_ebm.crimsonGrass);
					}
				}
			}
		}
	}

	public Item getItemDropped(int id, Random rand, int meta) {
		return mod_ebm.crimsonDirt.getItemDropped(0, rand, meta);
	}

	public boolean func_149851_a(World world, int x, int y, int z, boolean spread) {
		return true;
	}

	public boolean func_149852_a(World world, Random rand, int x, int y, int z) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess blockacc, int x, int y, int z, int side) {
		if (side == 1) {
			return this.top;
		} else if (side == 0) {
			return mod_ebm.crimsonDirt.getBlockTextureFromSide(side);
		} else {
			Material material = blockacc.getBlock(x, y + 1, z).getMaterial();
			return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.sideSnow;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.blockIcon = icon.registerIcon("mod_ebm:grass_crimson_side");
		this.top = icon.registerIcon("mod_ebm:grass_crimson_top");
		this.sideSnow = icon.registerIcon("mod_ebm:grass_crimson_side");
		this.sideOver = icon.registerIcon("mod_ebm:grass_crimson_side_overlay");
	}

	@SideOnly(Side.CLIENT)
	public int getBlockColor() {
		double d0 = 0.5D;
		double d1 = 1.0D;
		return ColorizerGrass.getGrassColor(d0, d1);
	}

	/**
	 * Returns the color this block should be rendered. Used by leaves.
	 */

	@SideOnly(Side.CLIENT)
	public int getRenderColor(int meta) {
		return this.getBlockColor();
	}

	/**
	 * Returns a integer with hex for 0xrrggbb with this color multiplied
	 * against the blocks color. Note only called when first determining what to
	 * render.
	 */

	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess blockacc, int x, int y, int z) {
		int l = 0;
		int i1 = 0;
		int j1 = 0;

		for (int k1 = -1; k1 <= 1; ++k1) {
			for (int l1 = -1; l1 <= 1; ++l1) {
				int i2 = blockacc.getBiomeGenForCoords(x + l1, z + k1).getBiomeGrassColor(x + l1, y, z + k1);
				l += (i2 & 16711680) >> 16;
				i1 += (i2 & 65280) >> 8;
				j1 += i2 & 255;
			}
		}

		return (l / 9 & 255) << 16 | (i1 / 9 & 255) << 8 | j1 / 9 & 255;
	}

	public void func_149853_b(World world, Random rand, int x, int y, int z) {
		int l = 0;

		while (l < 128) {
			int i1 = x;
			int j1 = y + 1;
			int k1 = z;
			int l1 = 0;

			while (true) {
				if (l1 < l / 16) {
					i1 += rand.nextInt(3) - 1;
					j1 += (rand.nextInt(3) - 1) * rand.nextInt(3) / 2;
					k1 += rand.nextInt(3) - 1;

					if (world.getBlock(i1, j1 - 1, k1) == mod_ebm.crimsonGrass
							&& !world.getBlock(i1, j1, k1).isNormalCube()) {
						++l1;
						continue;
					}
				} else if (world.getBlock(i1, j1, k1).getMaterial() == Material.air) {
					if (rand.nextInt(8) != 0) {
						if (mod_ebm.crimsonTallGrass.canBlockStay(world, i1, j1, k1)) {
							world.setBlock(i1, j1, k1, mod_ebm.crimsonTallGrass, 1, 0);
						}

						if (mod_ebm.crimsonBush.canBlockStay(world, i1, j1, k1)) {
							world.setBlock(i1, j1, k1, mod_ebm.crimsonBush, 1, 0);
						}
					} else {
						world.getBiomeGenForCoords(i1, k1).plantFlower(world, rand, i1, j1, k1);
					}
				}

				++l;
				break;
			}
		}
	}
}