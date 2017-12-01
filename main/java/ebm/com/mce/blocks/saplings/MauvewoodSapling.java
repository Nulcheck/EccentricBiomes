package ebm.com.mce.blocks.saplings;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.gen.trees.WorldGenAmethystTree;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class MauvewoodSapling extends BlockSapling implements IGrowable {
	private IIcon[] textures;
	public static final String[] SAPLINGNAMES = new String[] { "mauvewood" };
	private static final int TYPES = 1;

	private static WorldGenerator tree;

	public MauvewoodSapling() {
		tree = new WorldGenAmethystTree();
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		textures = new IIcon[SAPLINGNAMES.length];
		for (int i = 0; i < SAPLINGNAMES.length; ++i) {
			textures[i] = iconRegister.registerIcon("mod_ebm:sapling_mauvewood");
		}
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public int getRenderBlockPass() {
		return 0;
	}

	public boolean shouldSideBeRendered(IBlockAccess blockAcc, int x, int y, int z, int side) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (meta < 0 || meta >= SAPLINGNAMES.length) {
			meta = 0;
		}
		return textures[meta];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
		for (int i = 0; i < SAPLINGNAMES.length; ++i) {
			list.add(new ItemStack(block, 1, i));
		}
	}

	/**
	 * Is this position a valid spawn position. <br>
	 * Test block below placed sapling to see if it can sustain a plant?
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param metadata
	 * @return boolean
	 */
	public boolean isValidPosition(World world, int x, int y, int z, int metadata) {
		Block block = world.getBlock(x, y - 1, z);
		switch (metadata) {
		default:
			return block == mod_ebm.amethystCrust;
		}
	}

	public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side) {
		return isValidPosition(world, x, y, z, -1);
	}

	public boolean canBlockStay(World world, int x, int y, int z) {
		Block soil = world.getBlock(x, y - 1, z);
		if (world.getBlockMetadata(x, y, z) != 7)
			return (world.getFullBlockLightValue(x, y, z) >= 8 || world.canBlockSeeTheSky(x, y, z))
					&& (soil != null && soil == mod_ebm.amethystCrust);
		else
			return (world.getFullBlockLightValue(x, y, z) >= 8 || world.canBlockSeeTheSky(x, y, z))
					&& (soil != null && soil == mod_ebm.amethystCrust);
	}

	public void updateTick(World world, int x, int y, int z, Random random) {
		if (world.isRemote) {
			return;
		}
		if (world.getBlockLightValue(x, y + 1, z) >= 9 && random.nextInt(7) == 0) {
			this.func_149878_d(world, x, y, z, random);
		}
	}

	public void func_149878_d(World world, int x, int y, int z, Random random) {
		int meta = world.getBlockMetadata(x, y, z) & TYPES;
		Object obj = null;
		int rnd = random.nextInt(10);
		if (obj == null) {
			if (rnd < 5) {
				obj = tree;
			}
			if (rnd >= 5) {
				obj = tree;
			}
		}
		if (obj != null) {
			world.setBlockToAir(x, y, z);
			if (!((WorldGenerator) obj).generate(world, random, x, y, z)) {
				world.setBlock(x, y, z, this, meta, 2);
			}
		}
	}

	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction,
			IPlantable plantable) {
		if (world.getBlock(x, y, z) == mod_ebm.amethystCrust) {
			return true;
		} else {
			return false;
		}
	}

	public void onPlantGrow(World world, int x, int y, int z, int sourceX, int sourceY, int sourceZ) {
		if (this == mod_ebm.amethystCrust) {
			world.setBlock(x, y, z, mod_ebm.amethystCrust, 0, 0);
		}
	}

	public void growTree(World world, Random rand, int y, int z, int x) {
	}
}
