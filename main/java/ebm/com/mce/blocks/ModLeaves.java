package ebm.com.mce.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ebm.com.mce.common.mod_ebm;
import ebm.com.mce.util.ModFoliageColor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModLeaves extends BlockLeaves {
	public ModLeaves() {
		super();
	}

	public IIcon getIcon(int side, int meta) {
		return null;
	}

	public String[] func_150125_e() {
		return null;
	}

	public static class GlassLeaves extends Block {
		public GlassLeaves(Material mat) {
			super(mat);
		}

		public static final String[][] leafType = new String[][] { { "mod_ebm:leaves_glass" } };
		public static final String[] logType = new String[] { "glass" };
		private static final String __OBFID = "CL_00000280";

		public int quantityDropped(Random rand) {
			return rand.nextInt(20) == 0 ? 1 : 0;
		}

		public void func_150124_c(World world, int x, int y, int z, int item, int meta) {
			if ((item & 10) == 0 && world.rand.nextInt(meta) == 0) {
				this.dropBlockAsItem(world, x, y, z, new ItemStack(mod_ebm.glassShard, 1, 0));
			}
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			int i = rand.nextInt(10);
			if (i >= 5 && i <= 10) {
				return mod_ebm.glassShard;
			} else {
				return Item.getItemFromBlock(mod_ebm.glassSapling);
			}
		}

		@SideOnly(Side.CLIENT)
		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public int getRenderBlockPass() {
			return 1;
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public String[] func_150125_e() {
			return logType;
		}

		public boolean shouldSideBeRendered(IBlockAccess blockAcc, int x, int y, int z, int side) {
			return true;
		}
	}

	public static class MLeaves extends BlockLeaves {
		public static final String[][] leafType = new String[][] { { "mod_ebm:leaves_m" },
				{ "mod_ebm:leaves_m_opaque" } };
		public static final String[] logType = new String[] { "m" };
		private static final String __OBFID = "CL_00000280";

		@SideOnly(Side.CLIENT)
		public int getRenderColor(int color) {
			return ModFoliageColor.getFoliageColorM();
		}

		@SideOnly(Side.CLIENT)
		public int colorMultiplier(IBlockAccess blockAcc, int x, int y, int z) {
			return ModFoliageColor.getFoliageColorM();
		}

		public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
			return null;
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			return Item.getItemFromBlock(mod_ebm.mSapling);
		}

		public void onEntityWalking(World world, int x, int y, int z, Entity e) {
			e.attackEntityFrom(DamageSource.generic, 3);
		}

		public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity e) {
			e.attackEntityFrom(DamageSource.generic, 3);
		}

		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			return (meta & 3) == 1 ? this.field_150129_M[this.field_150127_b][1]
					: ((meta & 3) == 3 ? this.field_150129_M[this.field_150127_b][3]
							: ((meta & 3) == 2 ? this.field_150129_M[this.field_150127_b][2]
									: this.field_150129_M[this.field_150127_b][0]));
		}

		@SideOnly(Side.CLIENT)
		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public int getRenderBlockPass() {
			return 1;
		}

		public boolean isOpaqueCube() {
			return false;
		}

		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister reg) {
			for (int i = 0; i < leafType.length; ++i) {
				this.field_150129_M[i] = new IIcon[leafType[i].length];

				for (int j = 0; j < leafType[i].length; ++j) {
					this.field_150129_M[i][j] = reg.registerIcon(leafType[i][j]);
				}
			}
		}

		public String[] func_150125_e() {
			return logType;
		}

		public boolean shouldSideBeRendered(IBlockAccess blockAcc, int x, int y, int z, int side) {
			return true;
		}
	}

	public static class MauvewoodLeaves extends BlockLeaves {
		public static final String[][] leafType = new String[][] { { "mod_ebm:leaves_mauvewood" },
				{ "mod_ebm:leaves_mauvewood_opaque" } };
		public static final String[] logType = new String[] { "mauvewood" };
		private static final String __OBFID = "CL_00000280";

		@SideOnly(Side.CLIENT)
		public int getRenderColor(int color) {
			return ModFoliageColor.getFoliageColorMauvewood();
		}

		@SideOnly(Side.CLIENT)
		public int colorMultiplier(IBlockAccess blockAcc, int x, int y, int z) {
			return ModFoliageColor.getFoliageColorMauvewood();
		}

		public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
			return null;
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			return Item.getItemFromBlock(mod_ebm.mauvewoodSapling);
		}

		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			return (meta & 3) == 1 ? this.field_150129_M[this.field_150127_b][1]
					: ((meta & 3) == 3 ? this.field_150129_M[this.field_150127_b][3]
							: ((meta & 3) == 2 ? this.field_150129_M[this.field_150127_b][2]
									: this.field_150129_M[this.field_150127_b][0]));
		}

		@SideOnly(Side.CLIENT)
		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public int getRenderBlockPass() {
			return 1;
		}

		public boolean isOpaqueCube() {
			return false;
		}

		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister reg) {
			for (int i = 0; i < leafType.length; ++i) {
				this.field_150129_M[i] = new IIcon[leafType[i].length];

				for (int j = 0; j < leafType[i].length; ++j) {
					this.field_150129_M[i][j] = reg.registerIcon(leafType[i][j]);
				}
			}
		}

		public String[] func_150125_e() {
			return logType;
		}

		public boolean shouldSideBeRendered(IBlockAccess blockAcc, int x, int y, int z, int side) {
			return true;
		}
	}
}
