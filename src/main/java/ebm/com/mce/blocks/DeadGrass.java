package ebm.com.mce.blocks;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ebm.com.mce.common.mod_ebm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class DeadGrass extends Block implements IGrowable {
	public static final Logger logger = LogManager.getLogger();
	@SideOnly(Side.CLIENT)
	public IIcon top;
	@SideOnly(Side.CLIENT)
	public IIcon sideSnow;
	@SideOnly(Side.CLIENT)
	public IIcon sideOver;
	public static final String __OBFID = "CL_00000251";

	public DeadGrass() {
		super(Material.grass);
		this.setTickRandomly(true);
		this.setHarvestLevel("pickaxe", 0);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 1 ? this.top : (side == 0 ? mod_ebm.deadDirt.getBlockTextureFromSide(side) : this.blockIcon);
	}
	
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction,
			IPlantable p) {
		if (p.getPlant(world, x, y, z) == Blocks.deadbush) {
			return true;
		} else {
			return false;
		}
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (!world.isRemote) {
			if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2) {
				world.setBlock(x, y, z, mod_ebm.deadDirt);
			} else if (world.getBlockLightValue(x, y + 1, z) >= 9) {
				for (int l = 0; l < 4; ++l) {
					int i1 = x + rand.nextInt(3) - 1;
					int j1 = y + rand.nextInt(5) - 3;
					int k1 = z + rand.nextInt(3) - 1;
					// Block block = world.getBlock(i1, j1 + 1, k1);

					if (world.getBlock(i1, j1, k1) == mod_ebm.deadDirt && world.getBlockMetadata(i1, j1, k1) == 0
							&& world.getBlockLightValue(i1, j1 + 1, k1) >= 4
							&& world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
						world.setBlock(i1, j1, k1, mod_ebm.deadGrass);
					}
				}
			}
		}
	}

	public Item getItemDropped(int id, Random rand, int meta) {
		return mod_ebm.dust;
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
			return mod_ebm.deadDirt.getBlockTextureFromSide(side);
		} else {
			Material material = blockacc.getBlock(x, y + 1, z).getMaterial();
			return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.sideSnow;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.blockIcon = icon.registerIcon("mod_ebm:dead_grass_side");
		this.top = icon.registerIcon("mod_ebm:dead_grass_top");
		this.sideSnow = icon.registerIcon("mod_ebm:dead_grass_side");
		this.sideOver = icon.registerIcon("mod_ebm:dead_grass_side_overlay");
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

					if (world.getBlock(i1, j1 - 1, k1) == mod_ebm.deadGrass
							&& !world.getBlock(i1, j1, k1).isNormalCube()) {
						++l1;
						continue;
					}
				} else if (world.getBlock(i1, j1, k1).getMaterial() == Material.air) {
					if (rand.nextInt(8) != 0) {
						if (Blocks.tallgrass.canBlockStay(world, i1, j1, k1)) {
							world.setBlock(i1, j1, k1, Blocks.tallgrass, 1, 3);
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